package org.intake;

public class UIController {
	public static void showUI(String accountType) {
        switch (accountType) {
            case "DOCTOR":
            	DoctorPortal.openDocView();
            	break;
            case "NURSE":
            	NursePortal.openNursePort();
                break;
            case "PATIENT":
                PatientPortal.openPatPort();
                break;
            default:
                WindowUtil.showAlert("Error", "Unrecognized account type: " + accountType);
        }
    }
}
