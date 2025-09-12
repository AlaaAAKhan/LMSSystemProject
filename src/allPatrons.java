import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class allPatrons {
    Scanner input = new Scanner(System.in);
    ArrayList<patron> patronsList = new ArrayList<patron>();    //init arrayList to hold patron info

    public void addPatronManually(patron p){
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

    public boolean checkIfAllInts(String patronID) {
        for (char c : patronID.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkIfExists(String patronID) {
        for (int i = 0; i < patronsList.size(); i++) {
            if (patronsList.get(i).getPatronID().equals(patronID)) {
                return true;
            }
        }
        return false;
    }

    public void addPatronFromTxtFile(){
        //Connect textfile to the program
        try {
            System.out.println("\nEnter the filepath to the text file: ");
            ///Users/alaa/Downloads/Patron Info.txt

            String filepath = input.nextLine(); //Get the filepath from the user
            File file = new File(filepath);     //Use the obtained filepath to get the file

            Scanner readFile = new Scanner(file);   //create a scanner to read the file
            StringTokenizer token = null;       //Detects the range from which a string should be accepted before moving on

            while (readFile.hasNextLine()) {
                patron p1 = new patron();
                token = new StringTokenizer(readFile.nextLine(), "-");
                //read each line one at a time, specify delimiter

                //Set the attributes based on the tokens specified from each line
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

    public void displayPatrons(){
         for (int i = 0; i < patronsList.size(); i++){
            System.out.println("ID: " + patronsList.get(i).patronID + " | " +
                    "Name: " + patronsList.get(i).patronName + " | " +
                    "Address: " + patronsList.get(i).patronAddress + " | " +
                    "Fines: " + patronsList.get(i).patronFines);
        }
         System.out.println(patronsList);
        System.out.println("\n");
    }

    public void removePatron() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter the ID of the Patron you would like to delete");
        String inputtedPatronID = in.nextLine();
        /*Iterator<patron> iterator = patronsList.iterator();
        if (iterator.hasNext()){
            if (iterator.next().getPatronID().equals(patronID)){
                iterator.remove();
                System.out.println("\nThe patron with ID: " + patronID + " has been removed");
            } else {
                System.out.println("\nPatron ID " + patronID + " does not exist in the system");
                }
        } */

        //patronsList.removeIf(p -> p.getPatronID().equals(inputtedPatronID));
        //System.out.println("\nPatron ID: " + inputtedPatronID + " removed");

        /*for (patron p : patronsList) {
            if (p.patronID.equals(inputtedPatronID)) {
                patronsList.remove(p);
                System.out.println("\nPatron ID: " + inputtedPatronID + " removed");
            }
        } */

        ArrayList<patron> copyOfPatronsList = new ArrayList<>(patronsList);
        for (patron p : copyOfPatronsList) {
            if (p.getPatronID().equals(inputtedPatronID)) {
                patronsList.remove(p);
                System.out.println("\nPatron ID: " + inputtedPatronID + " removed");
            }
        }
    }

}
