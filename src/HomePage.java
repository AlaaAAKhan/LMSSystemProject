import java.io.IOException;
import java.util.Scanner;

public class HomePage {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Library Management System!");
        allPatrons patronObject = new allPatrons();
        int chosenOption;
        int inputPref;

        do {
            System.out.println("Please select one of the following options:");
            System.out.println("1: Add Patron");
            System.out.println("2. Show All Patrons");
            System.out.println("3. Delete Patron");
            System.out.println("0. Quit");
            chosenOption = input.nextInt();
            System.out.println("\n");

            switch (chosenOption) {
                //Add a patron
                case 1:
                    System.out.println("Select how you would like to add a Patron");
                    System.out.println("1. Add Patron Manually");
                    System.out.println("2. Add Patron from a Text File (will prompt upload)");
                    inputPref = input.nextInt();
                    System.out.println("\n");

                    switch(inputPref) {
                        //Add user manually
                        case 1:
                            patron p1 = new patron();
                            patronObject.addPatronManually(p1);
                            break;

                        //Add user(s) from a text file
                        case 2:
                            patron p2 = new patron();
                            patronObject.addPatronFromTxtFile(p2);
                            break;

                    }
                    break;

                //Display all patrons
                case 2:
                    patronObject.displayPatrons();
                    break;

                //Delete a patron
                case 3:
                    System.out.println("\nEnter the ID of the Patron you would like to delete");
                    String patronIDToDelete = input.next();
                    patronObject.removePatron(patronIDToDelete);
                    break;

                //Exit the program
                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Please enter a valid integer between 0 and 3");
            }
        }
        while (chosenOption != 0);
    }
}
