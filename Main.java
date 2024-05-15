
public class Main {
    public static void main(String[] args) {

    Person person1 = new Person("Alenka", "Pruvodci");
    Person person2 = new Person ("Vasek", "Masinfira");
    Locomotive parni = new Locomotive(person1, Engine.PARNI);
    BusinessWagon byznys1 = new BusinessWagon(70, person2);
    EconomyWagon ekonomy1 = new EconomyWagon(100);
    EconomyWagon ekonomy2 = new EconomyWagon(100);
    NightWagon nocnik1 = new NightWagon(30,20);
    Hopper nakladak1 = new Hopper(2000);
    Hopper nakladak2 = new Hopper(4000);

    byznys1.AddChairs();
    ekonomy1.AddChairs();
    nocnik1.AddChairs();
    ekonomy2.AddChairs();

    Train vlak1 = new Train(parni);

    System.out.println();
    System.out.println("-----------------");
    byznys1.ConnectToTrain(vlak1);
    ekonomy1.ConnectToTrain(vlak1);
    nocnik1.ConnectToTrain(vlak1);
    nakladak1.ConnectToTrain(vlak1);
    nakladak2.ConnectToTrain(vlak1);
    ekonomy2.ConnectToTrain(vlak1);
   // nakladak1.DisconnectFromTrain(vlak1);
   // nakladak1.DisconnectFromTrain(vlak1);

    System.out.println();

    vlak1.ReservePlace(0, 35);
    vlak1.ReservePlace(1, 27);
    vlak1.ReservePlace(1, 18);
    vlak1.ReservePlace(2, 12);
    vlak1.ReservePlace(2,15);
    System.out.println();
    System.out.println(vlak1);
    System.out.println();
    System.out.println("vypis rezervaci");
    vlak1.printOutReservations();
    }
}