// Alek Kariniemi
// Description: This class makes it easy to store and retrieve information from
// text files.

package org.intake;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class VisitFormDatabase {
    
    private final String folderPath;
    private final String folderName;

    public VisitFormDatabase(String folderPath) {
        this.folderPath = folderPath;
        this.folderName = Paths.get(folderPath).getFileName().toString();
    }

    // List all patient IDs
    public List<String> getAllIdentifiers() throws IOException {
        List<String> identifiers = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(folderPath), "*_" + folderName + ".txt")) {
            for (Path entry : stream) {
                String fileName = entry.getFileName().toString();
                String identifier = fileName.split("_")[0];
                identifiers.add(identifier);
            }
        }
        return identifiers;
    }

    // Retrieve patient information by ID
    public Map<String, String> getFileData(String identifier) throws IOException {
        File file = new File(folderPath, identifier + "_" + folderName + ".txt");
        Map<String, String> fileData = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":", 2); // Split on the first colon
                if (parts.length == 2) {
                    fileData.put(parts[0].trim(), parts[1].trim());
                }
            }
        }

        return fileData;
    }

    // Add or update patient information
    public void updateFileData(String identifier, Map<String, String> info) throws IOException {
        File file = new File(folderPath, identifier + "_" + folderName + ".txt");
        
        // Ensure directory exists
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        //System.out.println("Writing to: " + file.getAbsolutePath()); // Diagnostic message
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Map.Entry<String, String> entry : info.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
        }
    }
    
    // Remove patient information by ID
    public boolean removeFileData(String identifier) {
        Path file = Paths.get(folderPath, identifier + "_" + folderName + ".txt");
        try {
            return Files.deleteIfExists(file);
        } catch (IOException e) {
            System.err.println("Error removing file: " + e.getMessage());
            return false;
        }
    }

    // Search for a specific key within a patient's file
    public String searchByKey(String identifier, String key) throws IOException {
        Map<String, String> patientInfo = getFileData(identifier);
        return patientInfo.getOrDefault(key, "Not Found");
    }
}
