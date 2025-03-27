public class SparKonto extends Konto{
    public SparKonto(String kontonmr, float saldo){
    super(kontonmr, saldo);

    }
@Override
    public void taUt(float belopp, float saldo){
        if (belopp>saldo){
            System.out.println("du har inte tillräckligt med pengar");
        }
        else {
            saldo-= belopp;
             System.out.println("uttagningen lyckades: " + saldo);
        }
    }
}
