public class Kontor {
    private String adress;
    private String oppettider;

    public Kontor(String adress, String oppettider){
        this.adress = adress;
        this.oppettider = oppettider;

    }

    public String getAdress(){
        return adress;
    }
    public String getOppettider(){
        return oppettider;
    }
}
