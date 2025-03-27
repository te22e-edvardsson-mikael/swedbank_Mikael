import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        ArrayList<Kund> kunder = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Du visiterar Swedbank");



        while(true){

            System.out.println("Ange namn för konto: ");
            String namn = scanner.nextLine();

            System.out.println("Ange ditt kund-ID; ");
            int kundID = scanner.nextInt();
            scanner.nextLine(); // behöver vara där annars blir det något loop typ

            System.out.println("Ange personnummer: ");
            String personnummer = scanner.nextLine();


            //ny kund i listan med sin egna unikheter
            Kund nyKund = new Kund(namn, kundID, personnummer);
            kunder.add(nyKund);
            System.out.println("Kund registerad!");

            System.out.println("vill du ta ett lån (ja/nej)");
            String svar = scanner.nextLine();
            if (svar.equalsIgnoreCase("ja")){
                System.out.println("ange lånbelopp: ");
                float lanebelopp = scanner.nextFloat();
                scanner.nextLine();
                nyKund.laggTillLan(lanebelopp);
                System.out.println("tagit lån: " + lanebelopp);
            }




            break; //avsluta while loopen






        }
    }
}