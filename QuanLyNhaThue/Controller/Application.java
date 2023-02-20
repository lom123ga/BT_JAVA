package QuanLyNhaThue.Controller;

import QuanLyNhaThue.Model.Bill;
import QuanLyNhaThue.Model.Customer;
import QuanLyNhaThue.Model.Room;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Application{
    private String customerFile = "Customer.DAT";
    private String roomFile = "Room.DAT";
    private String billFile = "Bill.DAT";
    private List<Customer> customerList = new ArrayList<Customer>();
    private List<Room> roomList = new ArrayList<Room>();
    private List<Bill> billList = new ArrayList<Bill>();

    Input input = new Input();
    Output output = new Output();
    Util util = new Util();
    IOBinary IOFile = new IOBinary();

    public void loadData(){
        customerList = IOFile.read(customerFile);
        roomList = IOFile.read(roomFile);
        billList = IOFile.read(billFile);
    }

    public void writeData(){
        IOFile.write(customerFile,customerList);
        IOFile.write(roomFile,roomList);
        IOFile.write(billFile,billList);
    }

    public void run() throws Exception{
        Customer customer;
        Room room = null;
        Bill bill;
        boolean stop = false;
        while (true){
            if (stop == true) break;
            output.showMenu();
            switch (input.getChoice()){
                case 1 :
                    customer = input.setCustomer();
                    if (util.hasEmptyRoom((ArrayList<Room>) roomList) == false){
                        System.out.println("Het phong");
                        break;
                    }
                    room = null;
                    while (true){
                        if (room != null) break;
                        output.showTypeRoom();
                        switch (input.getChoice()){
                            case 1 :
                                if (util.hasEmptyVipRoom((ArrayList<Room>) roomList) == false){
                                    System.out.println("Het phong VIP, chon loai phong khac");
                                }else{
                                    for (int i = 0; i < roomList.size(); i++){
                                        if (roomList.get(i).getType().equals("VIP") && roomList.get(i).getEmpty() == true){
                                            roomList.get(i).setEmpty(false);
                                            room = roomList.get(i);
                                            break;
                                        }
                                    }
                                }
                                break;
                            case 2:
                                if (util.hasEmptyCLCRoom((ArrayList<Room>) roomList) == false){
                                    System.out.println("Het phong CLC, chon loai phong khac");
                                }else{
                                    for (int i = 0; i < roomList.size(); i++){
                                        if (roomList.get(i).getType().equals("CLC") && roomList.get(i).getEmpty() == true){
                                            roomList.get(i).setEmpty(false);
                                            room = roomList.get(i);
                                            break;
                                        }
                                    }
                                }
                                break;
                            case 3:
                                if (util.hasEmptyNormalRoom((ArrayList<Room>) roomList) == false){
                                    System.out.println("Het phong Normal, chon loai phong khac");
                                }else{
                                    for (int i = 0; i < roomList.size(); i++){
                                        if (roomList.get(i).getType().equals("Normal") && roomList.get(i).getEmpty() == true){
                                            roomList.get(i).setEmpty(false);
                                            room = roomList.get(i);
                                            break;
                                        }
                                    }
                                }
                                break;
                        }
                    }
                    String date = input.setDate();
                    bill = input.setBill(customer,room,input.getDate(date));
                    customerList.add(customer);
                    billList.add(bill);
                    break;
                case 2 :
                    room = input.setRoom();
                    roomList.add(room);
                    break;
                case 3:
                    output.showListCustomer((ArrayList<Customer>) customerList);
                    break;
                case 4:
                    output.showListRoomEmpty((ArrayList<Room>) roomList);
                    break;
                case 5:
                    output.showStatistic((ArrayList<Bill>) billList);
                    break;
                case 6:
                    output.showBill((ArrayList<Bill>) billList);
                    break;
                case 7:
                    Collections.sort((ArrayList<Customer>) customerList, new Comparator<Customer>() {
                        @Override
                        public int compare(Customer o1, Customer o2) {
                            return o1.getName().compareTo(o2.getName());
                        }
                    });
                    break;
                case 8:
                    stop = true;
                    break;
            }
        }
    }
}
