package application;

public class UIController {
	public static void showUI(String accountType) {
        switch (accountType) {
            case "DOCTOR":
            	OpenMainUI.openDocView();
            	break;
            case "NURSE":
            	OpenMainUI.openNursePort();
                break;
            case "PATIENT":
                OpenMainUI.openPatPort();
                break;
            default:
                WindowUtil.showAlert("Error", "Unrecognized account type: " + accountType);
        }
    }
}
