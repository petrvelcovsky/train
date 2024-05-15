public class Locomotive {

    private Person driver;
    private Engine engine;

    public Locomotive(Person driver, Engine engine) {
        this.driver = driver;
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }
}
