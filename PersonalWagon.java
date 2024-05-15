import java.util.ArrayList;

public abstract class PersonalWagon implements IConnect{

    private ArrayList<Door> doors = new ArrayList<Door>();
    private ArrayList<Chair> sits = new ArrayList<Chair>();
    private int numberOfChairs;

    public PersonalWagon(int numberOfChairs) {
        this.numberOfChairs = numberOfChairs;
    }

    public int getNumberOfChairs() {
        return numberOfChairs;
    }

    public ArrayList<Chair> getSits() {
        return sits;
    }



    public void AddChairs(){
        for (int i = 0; i < numberOfChairs; i++) {
            sits.add(new Chair(i));
        }
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
