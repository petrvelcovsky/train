public class Hopper implements IConnect{

    private double loadingCapacity;

    public Hopper(double loadingCapacity) {
        this.loadingCapacity = loadingCapacity;
    }

    @Override
    public void ConnectToTrain(Train train) {
        if(train.getLocomotive().getEngine().equals(Engine.PARNI) && train.getWagons().size() > 4){
            System.out.println("Dalsi vagon nelze pridat.");
        }else {
            train.getWagons().add(this);
            System.out.println("Vagon " + this.getClass() + " byl uspesne pridan." );
        }
    }

    @Override
    public void DisconnectFromTrain(Train train) {
        if(train.getWagons().contains(this)){
            train.getWagons().remove(this);
            System.out.println("Vagon byl uspesne odebran.");
        } else {
            System.out.println("Tento vlak pozadovany vagon nema.");
        }
    }
}
