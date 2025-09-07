import java.util.Scanner;
import java.util.ArrayList;

public class allPatrons {
    Scanner input = new Scanner(System.in);
    ArrayList<patron> patronsList = new ArrayList<patron>();

    public static int count = 0;

    public void addPatronManually(patron p){
        System.out.println("Enter Patron ID: ");
        String patronID = input.nextLine();
        p.setPatronID(patronID);

        System.out.println("Enter Patron Name: ");
        String patronName = input.nextLine();
        p.setPatronName(patronName);

        System.out.println("Enter Patron Address: ");
        String patronAddress = input.nextLine();
        p.setPatronAddress(patronAddress);

        System.out.println("Enter Patron Fines: ");
        String patronFines = input.nextLine();
        p.setPatronFines(patronFines);

        patronsList.add(p);
    }


    public void addPatron(patron p){
        for (int i = 0; i < patronsList.size(); i++){
            if (p.patronID == (patronsList.get(i).patronID
            )) {
                System.out.println(
                        "A patron with the following ID already exists."
                );
                return;
            }
        }
        patronsList.add(p);
    }

    public void displayPatrons(){
        for (int i = 0; i < patronsList.size(); i++){
            System.out.println(patronsList.getPatronID() + "-" +
                    patronsList.getPatronName() + "-" +
                    patronsList.getPatronAddress() + "-" +
                    patronsList.getPatronFines());
        }
    }

    /* public void displayPatrons(){
        for (int i = 0; i < patronsList.size(); i++){
            System.out.println(patronsList.get(i).patronID + "-" +
                    patronsList.get(i).patronName + "-" +
                    patronsList.get(i).patronAddress + "-" +
                    patronsList.get(i).patronFines);
        }
    }
     */


    public void removePatron(allPatrons patron){
        // ?
    }

}
