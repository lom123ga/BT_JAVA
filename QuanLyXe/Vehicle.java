package QuanLyXe;

public class Vehicle {
    protected String id = new String();
    protected String firm = new String();
    protected int yop ; // year of produce
    protected int price;
    protected String color = new String();

    public Vehicle() {
    }

    public Vehicle(String id, String firm, int yop, int price, String color) {
        this.id = id;
        this.firm = firm;
        this.yop = yop;
        this.price = price;
        this.color = color;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setFrim(String firm) {
        this.firm = firm;
    }

    public void setYop(int yop) {
        this.yop = yop;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public String getFirm() {
        return firm;
    }

    public int getYop() {
        return yop;
    }

    public int getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }
}
