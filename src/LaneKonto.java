public class LaneKonto extends Konto {
    private float kreditgrans;

    public LaneKonto(String kontonmr, float saldo, float kreditgrans){
        super(kontonmr, saldo);
        this.kreditgrans = kreditgrans;

    }

    @Override
    public void taUt(float belopp){
        if (getSaldo() - belopp < - kreditgrans){
            System.out.println("du har inte tillräckligt med kreditgräns");
        }
        else {
            setterIn(-belopp);
            System.out.println("uttagningen lyckades, nytt saldo: " + getSaldo());
        }
    }
}
