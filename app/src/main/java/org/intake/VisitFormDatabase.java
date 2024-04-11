package org.intake;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class VisitFormDatabase {
    
    private final String folderPath;

    public VisitFormDatabase(String folderPath) {
        this.folderPath = folderPath;
    }

    // List all subdirectories
    public List<String> getAllSubdirectories() throws IOException {
        List<String> subdirectories = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(folderPath))) {
            for (Path entry : stream) {
                if (Files.isDirectory(entry)) {
                    subdirectories.add(entry.getFileName().toString());
                }
            }
        }
        return subdirectories;
    }

    // List all files within a specific subdirectory
    public List<String> getAllFilesInSubdirectory(String subdirectory) throws IOException {
        List<String> files = new ArrayList<>();
        Path subdirectoryPath = Paths.get(folderPath, subdirectory);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(subdirectoryPath, "*.txt")) {
            for (Path entry : stream) {
                files.add(entry.getFileName().toString());
            }
        }
        return files;
    }

    // Retrieve file data
    public Map<String, String> getFileData(String subdirectory, String identifier) throws IOException {
        Path filePath = Paths.get(folderPath, subdirectory, identifier + ".txt");
        Map<String, String> fileData = new HashMap<>();

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
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
    
    // Retrieve all the file data in a subdirectory
    public List<Map<String, String>> getAllFileDataInSubdirectory(String subdirectory) throws IOException {
        List<Map<String, String>> allFileData = new ArrayList<>();
        Path subdirectoryPath = Paths.get(folderPath, subdirectory);

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(subdirectoryPath, "*.txt")) {
            for (Path filePath : stream) {
                Map<String, String> fileData = new HashMap<>();
                try (BufferedReader reader = Files.newBufferedReader(filePath)) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(":", 2); // Split on the first colon
                        if (parts.length == 2) {
                            fileData.put(parts[0].trim(), parts[1].trim());
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Error reading file: " + filePath.getFileName());
                    // Depending on your error handling policy, you might want to log the error,
                    // throw the exception, return the partially completed list, or continue to the next file.
                }
                allFileData.add(fileData);
            }
        }

        return allFileData;
    }

    // Add or update file data
    public void updateFileData(String subdirectory, String identifier, Map<String, String> info) throws IOException {
        Path subdirectoryPath = Paths.get(folderPath, subdirectory);
        if (!Files.exists(subdirectoryPath)) {
            Files.createDirectories(subdirectoryPath);
        }

        Path filePath = subdirectoryPath.resolve(identifier + ".txt");
        
        try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
            for (Map.Entry<String, String> entry : info.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
        }
    }
    
    // Remove file data
    public boolean removeFileData(String subdirectory, String identifier) throws IOException {
        Path filePath = Paths.get(folderPath, subdirectory, identifier + ".txt");
        return Files.deleteIfExists(filePath);
    }

    // Search for a specific key within a file
    public String searchByKey(String subdirectory, String identifier, String key) throws IOException {
        Map<String, String> fileData = getFileData(subdirectory, identifier);
        return fileData.getOrDefault(key, "Not Found");
    }
}
