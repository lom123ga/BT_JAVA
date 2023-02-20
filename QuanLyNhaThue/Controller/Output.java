package QuanLyNhaThue.Controller;

import QuanLyNhaThue.Model.Bill;
import QuanLyNhaThue.Model.Customer;
import QuanLyNhaThue.Model.Room;

import java.util.ArrayList;

public class Output {
    public void showMenu() {
        System.out.println("============== Menu ==============");
        System.out.println("1. Add customer");
        System.out.println("2. Add room");
        System.out.println("3. Show list customer");
        System.out.println("4. Show list room empty");
        System.out.println("5. Statistic");
        System.out.println("6. Show bill");
        System.out.println("7. Sort by name");
        System.out.println("8. Exit");
    }

    public void showListCustomer(ArrayList<Customer> customerList){
        for (Customer customer : customerList){
            System.out.println(customer.toString());
        }
    }

    public void showListRoomEmpty(ArrayList<Room> rooms){
        for (Room room : rooms){
            if (room.getEmpty() == true){
                System.out.println(room.toString());
            }
        }
    }

    public void showBill(ArrayList<Bill> bills){
        for (Bill bill : bills){
            System.out.println(bill.toString());
        }
    }
    public void showStatistic(ArrayList<Bill> bills){
        int[] statistic = {0,0,0};
        String[] typeRoom = {"VIP", "CLC", "Normal"};
        for (Bill bill : bills){
            for (int i = 0; i < 3; i++){
                if (bill.getRoom().getType().equals(typeRoom[i])){
                    statistic[i] += 1;
                    break;
                }
            }
        }
        int sumRoom = bills.size();
        for (int i = 0; i < 3; i++){
            System.out.println(typeRoom[i] + ": " + (float)statistic[i] * 100 / sumRoom);
        }
    }
    public void showTypeRoom(){
        System.out.println("1.VIP   2.CLC   3.Normal");
    }
}
