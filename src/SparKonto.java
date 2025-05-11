public class SparKonto extends Konto{
    public SparKonto(String kontonmr, float saldo){
    super(kontonmr, saldo);

    }
@Override
    public void taUt(float belopp){
        if (belopp>getSaldo()){
            System.out.println("du har inte tillräckligt med pengar");
        }
        else {
            setterIn(-belopp);
             System.out.println("uttagningen lyckades, nytt saldo:: " + getSaldo());
        }
    }
}
