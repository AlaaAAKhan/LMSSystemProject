/*
* Alaa Khan
* CEN 3024C - 13950 - Software Development 1
* September 8, 2025
* HomePage.java
*
* This class contains the code to display the menu of options. Users pick a number to perform the
* tasks of adding, removing, or displaying patrons, as well as exiting the program. The number they
* chose is for the switch statement to call functions from the utility class.
* */

import java.util.Scanner;

public class HomePage {
    public static void main(String[] args) {
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
                        //Add patron manually
                        case 1:
                            patron p = new patron();
                            patronObject.addPatronManually(p);
                            break;

                        //Add patron(s) from a text file
                        case 2:
                            patronObject.addPatronFromTxtFile();
                            break;

                    }
                    break;

                //Display all patrons
                case 2:
                    patronObject.displayPatrons();
                    break;

                //Delete a patron
                case 3:
                    patronObject.removePatron();
                    break;

                //Exit the program
                case 0:
                    System.out.println("Goodbye!");
                    break;
            }
        }
        while (chosenOption != 0);
    }
}
