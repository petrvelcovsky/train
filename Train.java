import java.util.ArrayList;

public class Train {

    private Locomotive locomotive;
    private ArrayList<IConnect> wagons = new ArrayList<IConnect>();



    public Train(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    public ArrayList<IConnect> getWagons() {
        return wagons;
    }

    public Locomotive getLocomotive() {
        return locomotive;
    }


    public void ReservePlace(int wagon, int sit) {
        if (isTheWagonHopper(wagon)) {
            System.out.println("Nelze rezervovat misto v nakladaku.");
        } else if (doesExistsTheWagon(wagon)) {
            System.out.println("Tento vagon ve vlaku neni.");
        } else if (checkAmountChairsInTheWagon(wagon, sit)) {
            System.out.println("V tomto vagonu neni tolik mist.");
        } else if (isPlaceAlreadyReserved(wagon, sit)) {
            System.out.println("Toto misto uz je bohuzel rezervovano.");
        } else { makingReservation(wagon, sit);
            System.out.println("Rezervace ve vagonu " + wagon + " na miste " + sit + " probehla v poradku.");
        }
    }

    public boolean isTheWagonHopper (int wagon){
        boolean result = false;
        if (wagons.get(wagon) instanceof Hopper){
            result = true;
        }
        return result;
    }

    public boolean doesExistsTheWagon (int wagon){
        boolean result = false;
        if (wagon > wagons.size()){
            result = true;
        }
        return result;
    }

    public boolean checkAmountChairsInTheWagon(int wagon, int seat){
        boolean result = false;
        if (wagons.get(wagon) instanceof PersonalWagon){
            PersonalWagon personalWagon = (PersonalWagon) wagons.get(wagon);
            if (personalWagon.getNumberOfChairs() < seat){
                result = true;
            }
        }
        return result;
    }

    public boolean isPlaceAlreadyReserved (int wagon, int seat){
        boolean result = false;
        if (wagons.get(wagon) instanceof PersonalWagon) {
            PersonalWagon personalWagon = (PersonalWagon) wagons.get(wagon);
            if (personalWagon.getSits().get(seat).isReserved()){
                result = true;
            }
        }
        return result;
    }

    public void makingReservation (int wagon, int seat){
        if (wagons.get(wagon) instanceof PersonalWagon) {
            PersonalWagon personalWagon = (PersonalWagon) wagons.get(wagon);
            personalWagon.getSits().get(seat).setReserved(true);
        }
    }

  //  public void printOutReservations(){
  //      int count = 1;
  //      for (IConnect wagon: wagons) {
  //          if (wagon instanceof PersonalWagon){
  //              PersonalWagon personalWagon = (PersonalWagon) wagon;
  //              for (Chair sit: personalWagon.getSits()) {
  //                  if (sit.isReserved()){
  //                      System.out.println("Rezervace " + count + ": vagon " + personalWagon.getSits().get() + ", sedadlo ");
  //                      count++;
  //                  }
  //              }
  //          }
  //      }
  //  }

    public void printOutReservations() {
        int count = 1;
        for (int i = 0; i < wagons.size(); i++) {
            if (wagons.get(i) instanceof PersonalWagon) {
                PersonalWagon personalWagon = (PersonalWagon) wagons.get(i);
                for (int j = 0; j < personalWagon.getNumberOfChairs(); j++){
                    if (personalWagon.getSits().get(j).isReserved()){
                        System.out.println("Rezervace " + count + ": vagon " + i + ", sedadlo " + j);
                        count++;
                    }
                }
            }
        }
    }


    @Override
    public String toString() {
        String printOutWagons = "";
        for (IConnect wagon: wagons) {
            printOutWagons = printOutWagons + wagon.getClass() + " | ";
        }
        return "VLAK s lokomotivou: " + locomotive.getEngine() +
                ", vypis vagonu: " + printOutWagons ;
    }
}
