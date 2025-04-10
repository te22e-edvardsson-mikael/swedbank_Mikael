import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        ArrayList<Kund> kunder = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Du visiterar Swedbank");


        boolean fortsatt = true;



        while(fortsatt) {

            try {


                System.out.println("Ange ditt namn: ");

                String namn = scanner.nextLine();

                System.out.println("Ange ditt kund-ID; ");
                int kundID = scanner.nextInt();
                scanner.nextLine(); // behöver vara där annars blir det något loop typ

                System.out.println("Ange personnummer: ");
                String personnummer = scanner.nextLine();

                System.out.println("Vill du ansöka för jobb eller bli kund?");
                String typ = scanner.nextLine();

                if (typ.equalsIgnoreCase("jobb")){
                    System.out.println("Ange namn ");

                    Jobbare NyJobbare = new Jobbare(namn, personnummer);
                    System.out.println("");


                }

                else if (typ.equalsIgnoreCase("kund")) {


                    //ny kund i listan med sin egna unikheter
                    Kund nyKund = new Kund(namn, kundID, personnummer);
                    kunder.add(nyKund);
                    System.out.println("Kund registerad!");

                    System.out.println("vill du ta ett lån (ja/nej)");
                    String svar = scanner.nextLine();
                    if (svar.equalsIgnoreCase("ja")) {
                        System.out.println("ange lånbelopp: ");
                        float lanebelopp = scanner.nextFloat();
                        scanner.nextLine();
                        nyKund.laggTillLan(lanebelopp);
                        System.out.println("tagit lån: " + lanebelopp);
                    }

                    System.out.println("ditt lånebelopp: " + nyKund.getLaneBelopp());
                    System.out.println("1. Sparkonto");
                    System.out.println("2. Lånekonto");
                    int kontoTyp = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("hur mycket vill du lägga in?");
                    float saldo = scanner.nextFloat();
                    scanner.nextLine();


                    Konto nyttKonto;
                    String kontonummer = "ID" + kundID;

                    if (kontoTyp == 1) {
                        nyttKonto = new SparKonto(kontonummer, saldo);
                    } else {
                        System.out.println("ange kreditgräns: ");
                        float kreditgrans = scanner.nextFloat();
                        scanner.nextLine();
                        nyttKonto = new LaneKonto(kontonummer, saldo, kreditgrans);

                    }


                    nyKund.laggtillKonto(nyttKonto);

                    nyKund.visaInfoKonto();
                }



            } catch (InputMismatchException e) {
                System.out.println("fel inmattning");
                scanner.nextLine();
            }


            System.out.println("vill du lägga till ytterligare kund? (ja/nej)");
            String fortsattsvar = scanner.nextLine();
            if (!fortsattsvar.equalsIgnoreCase("ja")) {
                fortsatt = false;
            }
        }

               scanner.close();


    }
}