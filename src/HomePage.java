import java.util.Scanner;

public class HomePage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Library Management System!");
        allPatrons patronObject = new allPatrons();
        int chosenOption;

        do {
            System.out.println("Please select one of the following options:");
            System.out.println("1: Add Patron");
            System.out.println("2. Show All Patrons");
            System.out.println("3. Delete Patron");
            System.out.println("0. Quit");
            chosenOption = input.nextInt();

            switch (chosenOption) {
                //Add a patron
                case 1:
                    patron p = new patron();
                    patronObject.addPatronManually(p);
                    break;

                //Display all patrons
                case 2:
                    patronObject.displayPatrons();
                    break;

                //Delete a patron
                case 3:
                    patronObject.removePatron(patronObject);
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
