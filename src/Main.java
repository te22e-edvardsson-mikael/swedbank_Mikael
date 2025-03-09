import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        ArrayList<Kund> kunder = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Välkommen till swedbank AB?");

            System.out.println("Ange namn för konto: ");

            String namn = scanner.nextLine();

            System.out.println("Ange ditt kund-ID; ");

            int kundID = scanner.nextInt();

            System.out.println("Ange personnummer: ");

            String personnummer = scanner.nextLine();

            kunder.add(new Kund(namn, kundID, personnummer));



        }
    }
}