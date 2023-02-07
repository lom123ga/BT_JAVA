package QuanLyXe;

public class MotoBike extends Vehicle{
    protected int wP;

    public MotoBike() {
    }

    public MotoBike(String id, String firm, int yop, int price, String color, int wP) {
        super(id, firm, yop, price, color);
        this.wP = wP;
    }

    public void setwP(int wP) {
        this.wP = wP;
    }

    public int getwP() {
        return wP;
    }
}
