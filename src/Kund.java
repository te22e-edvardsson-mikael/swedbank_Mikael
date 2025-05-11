import java.util.ArrayList;

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

    public float getLaneBelopp(){
        return lan != null ? lan.getBelopp() : 0;
    }

    //skriver ut info om all kundens konton
    public void visaInfoKonto(){
        for (Konto k : konton){
            System.out.println("Konto skappad: " + k.getKontonmr() + " saldo: " + k.getSaldo());
        }
    }






}
