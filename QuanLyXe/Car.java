package QuanLyXe;

public class Car extends Vehicle{
    protected String typeOfEngine = new String();
    protected int numOfSeat;

    public Car() {
    }

    public Car(String id, String firm, int yop, int price, String color, String typeOfEngine, int numOfSeat) {
        super(id, firm, yop, price, color);
        this.typeOfEngine = typeOfEngine;
        this.numOfSeat = numOfSeat;
    }

    public String getTypeOfEngine() {
        return typeOfEngine;
    }

    public int getNumOfSeat() {
        return numOfSeat;
    }

    public void setTypeOfEngine(String typeOfEngine) {
        this.typeOfEngine = typeOfEngine;
    }
    public void setNumOfSeat(int numOfSeat) {
        this.numOfSeat = numOfSeat;
    }
}
