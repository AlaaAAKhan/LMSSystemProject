import java.util.Scanner;

public class patrons {
    Scanner input = new Scanner(System.in);
    patron patronsList[] = new patron[];

    public static int count = 0;

    public void addPatron(patron p){
        for (int i = 0; i < count; i++){
            if (p.IDNum.equalsIgnoreCase (patronsList[i].IDNum
            )) {
                System.out.println(
                        "A patron with the following ID already exists."
                );
                return;
            }
        }

        if (count <= patronsList.length){
            patronsList[count] = p;
            count++;
        }
    }

    public void displayPatrons(){
        for (int i = 0; i < count; i++){
            System.out.println(patronsList[i].patronID + "-" +
                    patronsList[i].patronName + "-" +
                    patronsList[i].patronAddress + "-" +
                    patronsList[i].patronFines);
        }
    }

    public void removePatron(){
        //int patronIndex = this.isP
    }

}
