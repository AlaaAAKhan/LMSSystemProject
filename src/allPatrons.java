import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class allPatrons {
    Scanner input = new Scanner(System.in);
    ArrayList<patron> patronsList = new ArrayList<patron>();
    public static int count = 0;

    public void addPatronManually(patron p){
        System.out.println("Enter Patron ID: ");
        String patronID = input.nextLine();     //do-while
        p.setPatronID(patronID);

        System.out.println("Enter Patron Name: ");
        String patronName = input.nextLine();
        p.setPatronName(patronName);

        System.out.println("Enter Patron Address: ");
        String patronAddress = input.nextLine();
        p.setPatronAddress(patronAddress);

        System.out.println("Enter Patron Fines: ");
        double patronFines = input.nextDouble();
        p.setPatronFines(patronFines);

        patronsList.add(p);
    }

    /*public void addPatronFromTxtFile(patron p){
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                List<String> patronText = Files.readAllLines(fileChooser.getSelectedFile().toPath());
                for (String s : patronText) {
                    patronsList.add();
                }

            } catch (IOException e) {
                System.err.println("Error reading the file: " + e.getMessage());
            }

        } else {
            System.out.println("Error selecting a file");
            }
        }

     */


     public void displayPatrons(){
        for (int i = 0; i < patronsList.size(); i++){
            System.out.println("ID: " + patronsList.get(i).patronID + " | " +
                    "Name: " + patronsList.get(i).patronName + " | " +
                    "Address:" + patronsList.get(i).patronAddress + " | " +
                    "Fines: " + patronsList.get(i).patronFines);
        }
    }

    public void removePatron(String patronID){
        Iterator<patron> iterator = patronsList.iterator();
        if (iterator.hasNext()){
            if (iterator.next().getPatronID().equals(patronID)){
                iterator.remove();
            }
        } else {
            System.out.println("Patron ID " + patronID + " does not exist in the system");
        }
    }

}
