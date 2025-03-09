import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        ArrayList<Kund> kunder = new ArrayList<>();
        ArrayList<Konto> konton = new ArrayList<>();



        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Välkommen till swedbank AB?");

            System.out.println("Ange namn för konto: ");

            String namn = scanner.nextLine();

            System.out.println("Ange ditt kund-ID; ");

            int kundID = scanner.nextInt();

            System.out.println("Ange personnummer: ");

            String personnummer = scanner.nextLine();


            //ny kund i listan med sin egna unikheter
            Kund nyKund = new Kund(namn, kundID, personnummer);
            kunder.add(nyKund);

            System.out.println("hur mycket saldo vill du lägga till i konto med kundID" + kundID + "?");
            float saldo = scanner.nextFloat();

            String kontonummer = "konto" + kundID;
            Konto nyttkonto = new Konto(kontonummer, saldo);
            konton.add(nyttkonto);

            System.out.println("Namn: " + nyKund.getName());
            System.out.println("Saldo: " + nyttkonto.getSaldo());






        }
    }
}