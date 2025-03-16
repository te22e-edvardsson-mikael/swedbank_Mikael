import java.util.ArrayList;

public class Kund extends Person {
    private int kundID;
    private ArrayList<Konto> konton;
    private Lan lan;


    public int getKundID(){
        return kundID;
    }

    public Kund(String name, int kundID, String personnummer){
        super(name, personnummer);
        this.kundID = kundID;
        this.konton = new ArrayList<>();

    }

    public void laggtillKonto(Konto konto){
        konton.add(konto);
    }

    public ArrayList<Konto> getKonton(){
        return konton;
    }

    public void laggTillLan(float belopp){
        this.lan = new Lan(belopp);
    }

    public float getLaneBelopp(){
        return lan != null ? lan.getBelopp() : 0;
    }






}
