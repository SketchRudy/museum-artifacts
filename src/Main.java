/**
 * @Author: Rudolf Sirbu
 * Command-line interface for the Museum Inventory Management System
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Museum museum = new Museum();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to the Museum Inventory Management System!");

        while (!exit) {
            System.out.println("\nAvailable commands:");
            System.out.println("1. Add Exhibit");
            System.out.println("2. Remove Exhibit");
            System.out.println("3. Add Artifact");
            System.out.println("4. Remove Artifact");
            System.out.println("5. Transfer Artifact");
            System.out.println("6. Display Exhibit");
            System.out.println("7. Display All Exhibits");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the new exhibit: ");
                    String exhibitName = scanner.nextLine();
                    museum.addExhibit(exhibitName);
                    System.out.println("Exhibit \"" + exhibitName + "\" added successfully.");
                    break;

                case 2:
                    System.out.print("Enter the name of the exhibit to remove: ");
                    exhibitName = scanner.nextLine();
                    museum.removeExhibit(exhibitName);
                    System.out.println("Exhibit \"" + exhibitName + "\" removed successfully.");
                    break;

                case 3:
                    System.out.print("Enter the exhibit name where you want to add the artifact: ");
                    exhibitName = scanner.nextLine();
                    System.out.print("Enter the artifact ID: ");
                    String artifactId = scanner.nextLine();
                    System.out.print("Enter the artifact name: ");
                    String artifactName = scanner.nextLine();
                    System.out.print("Enter the artifact description: ");
                    String artifactDescription = scanner.nextLine();
                    System.out.print("Enter the year acquired: ");
                    int yearAcquired = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    Artifact artifact = new Artifact(artifactId, artifactName, artifactDescription, yearAcquired);
                    museum.getExhibit(exhibitName).addArtifact(artifact);
                    System.out.println("Artifact \"" + artifactName + "\" added to the \"" + exhibitName + "\" exhibit.");
                    break;

                case 4:
                    System.out.print("Enter the exhibit name where you want to remove the artifact: ");
                    exhibitName = scanner.nextLine();
                    System.out.print("Enter the artifact ID: ");
                    artifactId = scanner.nextLine();
                    museum.getExhibit(exhibitName).removeArtifact(artifactId);
                    System.out.println("Artifact with ID \"" + artifactId + "\" removed from the \"" + exhibitName + "\" exhibit.");
                    break;

                case 5:
                    System.out.print("Enter the artifact ID: ");
                    artifactId = scanner.nextLine();
                    System.out.print("Enter the name of the exhibit to transfer from: ");
                    String fromExhibit = scanner.nextLine();
                    System.out.print("Enter the name of the exhibit to transfer to: ");
                    String toExhibit = scanner.nextLine();
                    museum.transferArtifact(artifactId, fromExhibit, toExhibit);
                    System.out.println("Artifact \"" + artifactId + "\" transferred from \"" + fromExhibit + "\" to \"" + toExhibit + "\".");
                    break;

                case 6:
                    System.out.print("Enter the exhibit name: ");
                    exhibitName = scanner.nextLine();
                    System.out.println(museum.getExhibit(exhibitName));
                    break;

                case 7:
                    System.out.println(museum);
                    break;

                case 8:
                    exit = true;
                    System.out.println("Thank you for using the Museum Inventory Management System!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
