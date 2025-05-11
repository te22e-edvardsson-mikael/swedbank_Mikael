abstract class Person {
    protected String name;
    protected String personnummer;

    //gemensam abstrakt klass för kund och jobbare
    public Person(String name, String personnummer){
        this.personnummer = personnummer;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPersonnummer(){
        return personnummer;
    }
}
