public class Chair {

    private boolean nearWindow;
    private int number;
    private boolean reserved;

    public Chair(int number){
        this.nearWindow = true;
        this.number = number;
        this.reserved = false;
    }

    public Chair(boolean nearWindow, int number) {
        this.nearWindow = nearWindow;
        this.number = number;
        this.reserved = false;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
}
