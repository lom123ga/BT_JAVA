package QuanLyNhaThue.Controller;

import QuanLyNhaThue.Model.Customer;
import QuanLyNhaThue.Model.Room;
import QuanLyNhaThue.Model.Bill;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Date;
import java.text.ParseException;

class InvalidDataException extends Exception{
    InvalidDataException(String s){
        super(s);
    }
}
public class Input {
    public static Scanner sc = new Scanner(System.in);
    public static Output output = new Output();
    public Customer setCustomer() throws InvalidDataException{
        String name = "", address = "", phoneNumber = "", type = "";
        try{
            System.out.println("Enter name of customer : ");
            name = sc.nextLine();
            System.out.println("Enter address of customer : ");
            address = sc.nextLine();
            System.out.println("Enter phone number of customer (Viettel) : ");
            phoneNumber = sc.nextLine();
            System.out.println("Enter type of customer (| 1.STU | 2.FAM | 3.COM |) : ");
            type = sc.nextLine();
            if (Pattern.matches("[0-9]{10}",phoneNumber) == false){
                throw new InvalidDataException("Nhap sai so dien thoai");
            }else if (Pattern.matches("(STU)|(COM)|(FAM)", type) == false) {
                throw new InvalidDataException("Sai kieu khach hang");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return new Customer(name, address, phoneNumber, type);
    }
    public Room setRoom() throws InvalidDataException{
        String name = "", type = "";
        try{
            System.out.println("Enter name of room : ");
            name = sc.nextLine();
            System.out.println("Enter type of customer (| 1.VIP | 2.CLC | 3.Normal |) : ");
            type = sc.nextLine();
            if (Pattern.matches("(VIP)|(CLC)|(Normal)", type) == false) {
                throw new InvalidDataException("Sai kieu phong");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return new Room(name, type);
    }
    public Bill setBill(Customer customer, Room room, Date date){
        return new Bill(customer,room,date);
    }
    public Date getDate(String dateS){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        try {
            date = formatter.parse(dateS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    public int getChoice(){
        return Integer.parseInt(sc.nextLine());
    }
    public String setDate(){
        System.out.println("Enter date (dd/MM/yyyy): ");
        return sc.nextLine();
    }
}
