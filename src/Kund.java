public class Kund {
    private String name;
    private int kundID;
    private String personnummer;


    //varje kund ska ha ett namn, sin id och personnummer
    public Kund(String name, int kundID, String personnummer){
        this.name = name;
        this.kundID = kundID;
        this.personnummer = personnummer;
    }


    //kallas för getter och används för att kunna komma åt name eftersom den är private
    public String getName() {
        return name;
    }

    public String getPersonnummer(){
        return personnummer;
    }

    public int getKundID(){
        return kundID;
    }


}
