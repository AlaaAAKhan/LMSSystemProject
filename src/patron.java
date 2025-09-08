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
        do {
            for (char c : patronID.toCharArray()) {
                if (!Character.isDigit(c)) {
                    System.out.println("ID can only be integers");
                    allInts = false;
                }
            }

            if (allInts) {
                this.patronID = patronID;
            } else {
                System.out.println("ID must be 7 characters");
            }

        } while (patronID.length() == 7);
    }

    public void setPatronAddress (String patronAddress){
        this.patronAddress = patronAddress;
    }

    public void setPatronFines ( double patronFines){
        try {
            Double.parseDouble(String.valueOf(patronFines));
            this.patronFines = patronFines;
            ;
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

    /*public patron() {
        System.out.println("Enter Patron ID: ");
        this.patronID = input.nextInt(); //possibly make this a string, tell the user to make it 7 characters long

        input.nextLine(); //Java seems to skip over these two sequences. You can add 'input.nextLine()' here to have Java recognize these separately.

        System.out.println("Enter Patron Name: ");
        this.patronName = input.nextLine();

        System.out.println("Enter Patron Address: ");
        this.patronAddress = input.nextLine();

        System.out.println("Enter Patron Fine: ");
        this.patronFines = input.nextDouble();
    }
     */
    }



