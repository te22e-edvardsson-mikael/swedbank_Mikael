public class Kund {
    private String name;
    private int kundID;
    private String personnummer;

    public Kund(String name, int kundID, String personnummer){
        this.name = name;
        this.kundID = kundID;
        this.personnummer = personnummer;
    }

    public String getName() {
        return name;
    }
}
