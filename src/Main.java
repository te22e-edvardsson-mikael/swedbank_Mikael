import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //skapa listor för kunder och jobb
        ArrayList<Kund> kunder = new ArrayList<>();
        ArrayList<Jobbare> jobbarelista = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Du visiterar Swedbank");


        boolean fortsatt = true;



        while(fortsatt) {

            try {
                //vad användaren vill göra
                System.out.println("Vill du registrera en kund eller ha ett jobb (kund/Jobb)");
                String typ = scanner.nextLine();

                //ifall jobb, registrera jobbansökande
                if (typ.equalsIgnoreCase("Jobb")){
                    System.out.println("ange ditt namn: ");
                    String namn = scanner.nextLine();

                    System.out.println("Ange personnummer: ");
                    String personnummer = scanner.nextLine();

                    //sparar och skapar en jobbare
                    Jobbare nyJobbare = new Jobbare(namn, personnummer);
                    jobbarelista.add(nyJobbare);

                    //hämtar dagens datum
                    LocalDate idag = LocalDate.now();
                    LocalDate start = idag.plusWeeks(1);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                    System.out.println("Välkommen till ditt nya jobb " + namn + "! Ditt startdatum: " + start.format(formatter));


                }

                //ifall kund, registrera ny kund
                else if (typ.equalsIgnoreCase("kund")) {

                    System.out.println("ange ditt namn: ");
                    String namn = scanner.nextLine();//tar bort radbyte


                    System.out.println("Ange ditt kund-ID; ");
                    int kundID = scanner.nextInt();
                    scanner.nextLine(); // behöver vara där annars blir det något loop typ(tömmer buffert)

                    System.out.println("Ange personnummer: ");
                    String personnummer = scanner.nextLine();



                    //skapar ny kund i listan
                    Kund nyKund = new Kund(namn, kundID, personnummer);
                    kunder.add(nyKund);
                    System.out.println("Kund registerad!");

                    //frågar om lån, om nej fortsätter till ny kund
                    System.out.println("vill du ta ett lån (ja/nej)");
                    String svar = scanner.nextLine();
                    if (svar.equalsIgnoreCase("ja")) {
                        System.out.println("ange lånbelopp: ");
                        float lanebelopp = scanner.nextFloat();
                        scanner.nextLine();
                        nyKund.laggTillLan(lanebelopp); //skapar lån
                        System.out.println("tagit lån: " + lanebelopp);
                    }

                    //visar lånebelopp
                    System.out.println("ditt lånebelopp: " + nyKund.getLaneBelopp());

                    //vilket typ av konto som skapas
                    System.out.println("1. Sparkonto");
                    System.out.println("2. Lånekonto");
                    int kontoTyp = scanner.nextInt();
                    scanner.nextLine();
                    //saldo defineras
                    System.out.println("hur mycket vill du lägga in?");
                    float saldo = scanner.nextFloat();
                    scanner.nextLine();


                    //skapar nytt konto med if else beroende på vad som valts
                    Konto nyttKonto;
                    String kontonummer = "ID" + kundID;

                    //skapar lånekonto med kreditgräns
                    if (kontoTyp == 1) {
                        nyttKonto = new SparKonto(kontonummer, saldo);
                    } else {
                        System.out.println("ange kreditgräns: ");
                        float kreditgrans = scanner.nextFloat();
                        scanner.nextLine();
                        nyttKonto = new LaneKonto(kontonummer, saldo, kreditgrans);

                    }


                    //kontot till kunden
                    nyKund.laggtillKonto(nyttKonto);

                    //visar info om kontot
                    nyKund.visaInfoKonto();


                    //frågar om taut funktionen ska användas om ja körs koden om nej loopar till start
                    System.out.println("Vill du ta ut pengar? (ja/nej)");

                    String svartaut = scanner.nextLine();
                    if (svartaut.equalsIgnoreCase("ja"))
                    {
                        System.out.println("Ange konto ID:t av det konto att ta ut från (ange endast ID numret): ");
                        String kontoID = "ID" + scanner.nextLine();

                        //hämtar kontot med matchande kontoID
                        Konto valtKonto = null;
                        for (Konto k : nyKund.getKonton()){
                            if (k.getKontonmr().equals(kontoID))
                            {
                                valtKonto = k;
                                break;
                            }
                        }
                        //frågar om beloppet som ska ut ur det specifika kontot
                        if (valtKonto != null){
                            System.out.println("Ange belopp att ta ut: ");
                            float belopp = scanner.nextFloat();
                            scanner.nextLine();
                            valtKonto.taUt(belopp);
                        }
                        else {
                            System.out.println("Konto med ID:t hittades inte");
                        }
                    }
                }


                //håller koll på fel inmattning ifall bokstav för siffra t.ex.
            } catch (InputMismatchException e) {
                System.out.println("fel inmattning");
                scanner.nextLine();//återställ scanner
            }


            //frågar om användaren ska fortsätta
            System.out.println("vill du lägga till ytterligare kund? (ja/nej)");
            String fortsattsvar = scanner.nextLine();
            if (!fortsattsvar.equalsIgnoreCase("ja")) {
                fortsatt = false;
            }
        }



        //visar info om första jobbaren om den finns, (hur många ska du ha)
        if (!jobbarelista.isEmpty())
        {
            System.out.println(jobbarelista.get(0));
        }

               scanner.close();



    }
}