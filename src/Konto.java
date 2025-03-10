public class Konto {
    private String kontonmr;
    private float saldo;



    public Konto(String kontonmr, float saldo){
        this.kontonmr = kontonmr;
        this.saldo = saldo;
    }

    public void setterIn(float belopp){
        saldo += belopp;

    }


    //"getter" som i de andra
    public float getSaldo(){
        return saldo;
    }

    public String getKontonmr(){
        return kontonmr;
    }
}


