import java.util.Scanner;
import java.util.Iterator;

public class patron {
    String patronName;
    String patronID;
    String patronAddress;
    double patronFines;
    Scanner input = new Scanner(System.in);

    //  GETTERS
    public String getPatronName() {
        return patronName;
    }

    public String getPatronID() {
        return patronID;
    }

    public String getPatronAddress() {
        return patronAddress;
    }

    public double getPatronFines() {
        return patronFines;
    }

    //  SETTERS
    public void setPatronName(String patronName) {
        this.patronName = patronName;
    }

    public void setPatronID(String patronID) {
        boolean allInts = true;
        if (patronID.length() == 7) {
            for (char c : patronID.toCharArray()) {
                if (!Character.isDigit(c)) {
                    System.out.println("ID can only be integers");
                    allInts = false;
                }
            }
            if (allInts) {
                this.patronID = patronID;
            }
        } else {
            System.out.println("ID must be 7 characters");
        }
    }

    public void setPatronAddress (String patronAddress){
        this.patronAddress = patronAddress;
    }

    public void setPatronFines ( double patronFines){
        try {
            Double.parseDouble(String.valueOf(patronFines));
            this.patronFines = patronFines;

        } catch (NumberFormatException e) {
            System.out.println("Patron fines must be in decimal 0.0 format");
        }

    }

    public patron() {
            this.patronName = patronName;
            this.patronID = patronID;
            this.patronAddress = patronAddress;
            this.patronFines = patronFines;
        }

    }



