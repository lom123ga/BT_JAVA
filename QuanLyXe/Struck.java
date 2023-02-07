package QuanLyXe;

public class Struck extends Vehicle{
    private double weight;

    public Struck() {
    }

    public Struck(String id, String firm, int yop, int price, String color, double weight) {
        super(id, firm, yop, price, color);
        this.weight = weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}
