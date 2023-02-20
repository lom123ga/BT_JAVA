package QuanLyNhaThue.Controller;

import QuanLyNhaThue.Model.Room;

import java.util.ArrayList;

public class Util {
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
}
