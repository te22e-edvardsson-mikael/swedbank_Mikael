public class LaneKonto extends Konto {
    private float kreditgrans;

    public LaneKonto(String kontonmr, float saldo, float kreditgrans){
        super(kontonmr, saldo);
        this.kreditgrans = kreditgrans;

    }

    @Override
    public float taut(float belopp){
        if (saldo - belopp <- kreditgrans){
            System.out.println("Du har inte tillräckligt med kreditgräns");
        }
        else {
            saldo -= belopp;
            System.out.println("uttag lyckades! Nytt saldo: " + saldo);
        }

    }
}
