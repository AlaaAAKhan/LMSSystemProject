public class patron {
    String patronID;
    String patronName;
    String patronAddress;
    double patronFines;

    public patron() {
        this.patronName = patronName;
        this.patronID = patronID;
        this.patronAddress = patronAddress;
        this.patronFines = patronFines;
    }

    //  GETTERS
    public String getPatronID() {
        return patronID;
    }

    public String getPatronName() {
        return patronName;
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

    public void setPatronFines (double patronFines){
        try {
            Double.parseDouble(String.valueOf(patronFines));
            this.patronFines = patronFines;

        } catch (NumberFormatException e) {
            System.out.println("Patron fines must be in decimal 0.0 format");
        }

    }

    }



