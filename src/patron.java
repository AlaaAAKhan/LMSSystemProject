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
        this.patronID = patronID;
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



