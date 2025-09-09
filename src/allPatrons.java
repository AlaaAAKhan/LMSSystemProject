import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class allPatrons {
    Scanner input = new Scanner(System.in);
    ArrayList<patron> patronsList = new ArrayList<patron>();    //init arrayList to hold patron info
    public static int count = 0;

    public void addPatronManually(patron p){
        /*System.out.println("\nEnter Patron ID: ");
        String patronID = input.nextLine();
        boolean allInts = true;
        do {
            for (char c : patronID.toCharArray()) {
                if (!Character.isDigit(c)) {
                    System.out.println("ID can only be integers");
                    allInts = false;
                }
            }
            if (allInts) {
                p.setPatronID(patronID);
                break;
            }

        } while (patronID.length() == 7);
         */
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Please enter Patron ID: ");
            String patronID = input.nextLine();

            if (patronID.matches("\\d+") && patronID.length() == 7) {
                p.setPatronID(patronID);
                validInput = true;
            } else {
                System.out.println("Invalid. Please make sure Patron ID only contains numbers and/or is 7-digits only");
            }
        }
        scanner.close();

        System.out.println("\nEnter Patron Name: ");
        String patronName = input.nextLine();
        p.setPatronName(patronName);

        System.out.println("\nEnter Patron Address: ");
        String patronAddress = input.nextLine();
        p.setPatronAddress(patronAddress);

        System.out.println("\nEnter Patron Fines: ");
        double patronFines = input.nextDouble();
        p.setPatronFines(patronFines);

        patronsList.add(p);
    }

    public void addPatronFromTxtFile(patron p) throws IOException {
        //Connect textfile to the program
        System.out.println("\nEnter the filepath to the text file: ");
        String filepath = input.nextLine(); //Get the filepath from the user
        File file = new File(filepath);     //Use the obtained filepath to get the file

        Scanner readFile = new Scanner(file);   //create a scanner to read the file
        StringTokenizer token = null;
            //Detects the range from which a string should be accepted before moving on

        while (readFile.hasNextLine()) {
            token = new StringTokenizer(readFile.nextLine(),"-");
                //read each line one at a time, specify delimiter

            //Set the attributes based on the tokens specified from each line
            p.setPatronID(token.nextToken());
            p.setPatronName(token.nextToken());
            p.setPatronAddress(token.nextToken());
            p.setPatronFines(Double.parseDouble(token.nextToken()));

            patronsList.add(p);
        }

    }

    public void displayPatrons(){
        for (int i = 0; i < patronsList.size(); i++){
            System.out.println("ID: " + patronsList.get(i).patronID + " | " +
                    "Name: " + patronsList.get(i).patronName + " | " +
                    "Address:" + patronsList.get(i).patronAddress + " | " +
                    "Fines: " + patronsList.get(i).patronFines);
        }
        System.out.println("\n");
    }

    public void removePatron(String patronID){
        Iterator<patron> iterator = patronsList.iterator();
        if (iterator.hasNext()){
            if (iterator.next().getPatronID().equals(patronID)){
                iterator.remove();
                System.out.println("\nThe patron with ID: " + patronID + " has been removed");
            }
        } else {
            System.out.println("Patron ID " + patronID + " does not exist in the system");
        }
    }

}
