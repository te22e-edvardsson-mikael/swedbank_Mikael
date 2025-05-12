import java.util.ArrayList;
//ärver från person och har kund specifik info
public class Kund extends Person {
    private int kundID;
    private ArrayList<Konto> konton;
    private Lan lan;


    public int getKundID(){
        return kundID;
    }
//konstruktor
    public Kund(String name, int kundID, String personnummer){
        super(name, personnummer);
        this.kundID = kundID;
        this.konton = new ArrayList<>();

    }
    //lista för konton, samt ett sätt att få ut objekt
    public void laggtillKonto(Konto konto){
        konton.add(konto);
    }


    public ArrayList<Konto> getKonton(){
        return konton;
    }
    //skapar ett nytt lån
    public void laggTillLan(float belopp){
        this.lan = new Lan(belopp);
    }
    //ifall beloppet inte anges, automatiskt 0
    public float getLaneBelopp(){
        return lan != null ? lan.getBelopp() : 0;
    }

    //skriver ut info om all kundens konton
    public void visaInfoKonto(){
        for (Konto k : konton){
            System.out.println("Konto skapad: " + k.getKontonmr() + " saldo: " + k.getSaldo());
        }
    }






}
