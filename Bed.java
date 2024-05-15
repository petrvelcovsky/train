public class Bed {

    private int number;
    private boolean reserved;


    public Bed(int number, boolean reserved) {
        this.number = number;
        this.reserved = reserved;
    }

    @Override
    public String toString() {
        return "Bed{" +
                "number=" + number +
                ", reserved=" + reserved +
                '}';
    }


}
