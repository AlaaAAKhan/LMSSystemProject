/*
* Alaa Khan
* CEN 3024C - 13950 - Software Development 1
* September 8, 2025
* allPatrons.java
*
* This is a utility class; it contains all the functions used in the program such as to add, remove, or display the patrons.
* */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class allPatrons {
    Scanner input = new Scanner(System.in);
    ArrayList<patron> patronsList = new ArrayList<patron>();


    /* When adding a patron manually, the user will be asked to enter the ID, name, address, and amount of fines due of
    the patron. For each field, the user is prompted and whatever they enter is set to that field. This is the case for
    all the fields except ID because it needs to meet certain requirements. After setting all the fields of that patron,
    it adds that patron to the list.
    */
    public void addPatronManually(patron p){
        //creating a scanner object for this specifically prevented some errors I was running into
        Scanner in = new Scanner(System.in);
        IDChecker(p);

        System.out.println("\nEnter Patron Name: ");
        p.setPatronName(in.nextLine());

        System.out.println("\nEnter Patron Address: ");
        p.setPatronAddress(in.nextLine());

        System.out.println("\nEnter Patron Fines: ");
        p.setPatronFines(in.nextDouble());

        patronsList.add(p);
    }

    /*
     This method takes in the inputted ID and checks it to make sure it can be set as the patron's ID. First, it checks
     if the length requirement is met, and only then will it check if the input is all integers. If both of these
     requirements are met, it will check to see if an ID like that already exists in the system. Only then will it set
     the patronID field to whatever was inputted. Failure to meet the requirements restarts the loops and asks them to
     enter an ID again.
     */
    public void IDChecker(patron p){
        do {
            System.out.println("Enter Patron ID: ");
            String patronID = input.nextLine();
            if (patronID.length() == 7) {
                if (checkIfAllInts(patronID)) {
                    if(!checkIfExists(patronID)){
                        p.setPatronID(patronID);
                        break;
                    } else {
                        System.out.println("Patron ID already exists");
                    }
                } else {
                    System.out.println("\nPatron ID must only be integers");
                }
            } else {
                System.out.println("\nPatron ID must be 7 digits");
            }
        } while (true);
    }

    /*
     Takes in the inputted ID and loops through each character to ensure it they are all integers. If they are, it
     returns a "true" statement to the IDChecker, allowing for the code to continue. Else, it will return "false" and
     cause the ID Checker to restart and ask for a different ID.
    */
    public boolean checkIfAllInts(String patronID) {
        for (char c : patronID.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    /*
     Takes in the inputted ID and loops through each character to ensure it does not already exist in the system. If
     it does, it returns a "true" statement to the IDChecker, cause the ID Checker to restart and ask for a different ID.
     Else, it will return "false" and allow for the code to continue.
    */
    public boolean checkIfExists(String patronID) {
        for (int i = 0; i < patronsList.size(); i++) {
            if (patronsList.get(i).getPatronID().equals(patronID)) {
                return true;
            }
        }
        return false;
    }

    /*
    This method allows the user to enter a filepath. It takes in that filepath to find a file with patron data. Assuming
    the data is in the following format "ID-Name-Address-FineAmount", it will set the inputted data to its associating
    fields of ID, Name, Address, and fines, before adding it all to the list of patrons. The tokenizer is to recognize
    the split between field and detect the range of information to take in per field. It specifies that the divider it
    is looking for is going to be the "-" dash.

    Should the inputted filepath not work, an error is thrown.
     */
    public void addPatronFromTxtFile(){
        try {
            System.out.println("\nEnter the filepath to the text file: ");
            ///Users/alaa/Downloads/Patron Info.txt

            String filepath = input.nextLine();
            File file = new File(filepath);

            Scanner readFile = new Scanner(file);
            StringTokenizer token = null;

            while (readFile.hasNextLine()) {
                patron p1 = new patron();
                token = new StringTokenizer(readFile.nextLine(), "-");

                p1.setPatronID(token.nextToken());
                p1.setPatronName(token.nextToken());
                p1.setPatronAddress(token.nextToken());
                p1.setPatronFines(Double.parseDouble(token.nextToken()));

                patronsList.add(p1);
            }
        } catch(FileNotFoundException e) {
            System.out.println("File Not Found");
        }

    }

    /*
    Loop to display patrons from patronsList
     */
    public void displayPatrons(){
         for (int i = 0; i < patronsList.size(); i++){
            System.out.println("ID: " + patronsList.get(i).patronID + " | " +
                    "Name: " + patronsList.get(i).patronName + " | " +
                    "Address: " + patronsList.get(i).patronAddress + " | " +
                    "Fines: " + patronsList.get(i).patronFines);
        }
        System.out.println("\n");
    }

    /*
    This class removes a patron based on their ID. It prompts the user to enter their ID and searches the list with a
    simple for-loop. I created a copy of the patron's list and made the remove-changes on there, and then updated the
    original list with the content of our changed list. Having a copy of the list ensured the program doesn't break or
    run into errors if I had simply stayed with the for-loop and edited the patron's list directly.
     */
    public void removePatron() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter the ID of the Patron you would like to delete");
        String inputtedPatronID = in.nextLine();

        ArrayList<patron> copyOfPatronsList = new ArrayList<>(patronsList);
        for (patron p : patronsList) {
            if (p.getPatronID().equals(inputtedPatronID)) {
                copyOfPatronsList.remove(p);
                System.out.println("\nPatron ID: " + inputtedPatronID + " removed");
            }
        }
        patronsList = copyOfPatronsList;
    }

}
