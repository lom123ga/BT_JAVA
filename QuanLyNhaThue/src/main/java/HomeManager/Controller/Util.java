package HomeManager.Controller;

import HomeManager.Model.Room;

import java.util.ArrayList;

public class Util {
    public static String customerFile = "Customer.DAT";
    public static String roomFile = "Room.DAT";
    public static String billFile = "Bill.DAT";
    public static boolean hasEmptyRoom(ArrayList<Room> rooms){
        for (Room room : rooms){
            if (room.getEmpty() == true) return true;
        }
        return false;
    }

    public static boolean hasEmptyVipRoom(ArrayList<Room> rooms){
        for (Room room : rooms){
            if (room.getEmpty() == true && room.getType().equals("VIP")) return true;
        }
        return false;
    }
    public static boolean hasEmptyCLCRoom(ArrayList<Room> rooms){
        for (Room room : rooms){
            if (room.getEmpty() == true && room.getType().equals("CLC")) return true;
        }
        return false;
    }
    public static boolean hasEmptyNormalRoom(ArrayList<Room> rooms) {
        for (Room room : rooms) {
            if (room.getEmpty() == true && room.getType().equals("Normal")) return true;
        }
        return false;
    }
    public static void loadFile(){
        Application.customerList = IOBinary.read(customerFile);
        Application.roomList = IOBinary.read(roomFile);
        Application.billList = IOBinary.read(billFile);
    }

    public static void writeFile(){
        IOBinary.write(customerFile,Application.customerList);
        IOBinary.write(roomFile, Application.roomList);
        IOBinary.write(billFile, Application.billList);
    }
}
