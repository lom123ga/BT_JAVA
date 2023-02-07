package QuanLyXe;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VehicleManager {
    public ArrayList<Vehicle> vehicles  = new ArrayList<Vehicle>();
    private static Scanner sc = new Scanner(System.in);
    public static Matcher matcher;
    public static Pattern pid = Pattern.compile("[a-zA-Z]{2}[0-9]{3}");
    public static Pattern pf = Pattern.compile("[a-zA-Z0-9]+");
    public static Pattern py = Pattern.compile("[0-9]{4}");
    public VehicleManager() {
    }
    public static void clrscr(){
        //Clears Screen in java
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {System.out.println(e);}
    }
    public static void delay(){
        System.out.println("Press Enter key to continue...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }
    public void Menu() {
        clrscr();
        System.out.println("+--------------------MENU--------------------+");
        System.out.println("| 1. Nhap them phuong tien.                  |");
        System.out.println("| 2. In danh sach phuong tien.               |");
        System.out.println("| 3. Tim kien phuong tien (1)                |");
        System.out.println("| 4. Tim kien phuong tien (2)                |");
        System.out.println("| 5. Tim kien phuong tien theo truong (3)    |");
        System.out.println("| 6. Sap xep phuong tien                     |");
        System.out.println("| 7. Thong ke (4)                            |");
        System.out.println("| 8. Exit                                    |");
        System.out.println("+--------------------------------------------+");
        System.out.println("Nhap lua chon");
    }
    public void Menu3(){
        clrscr();
        System.out.println("+--------------------------------------------+");
        System.out.println("| 1. Tim theo ma                             |");
        System.out.println("| 2. Tim theo hang                           |");
        System.out.println("| 3. Tim theo nam san xuat                   |");
        System.out.println("| 4. Tim theo gia                            |");
        System.out.println("| 5. Tim theo mau sac                        |");
        System.out.println("| 6. Exit                                    |");
        System.out.println("+--------------------------------------------+");
        System.out.println("Nhap lua chon");
    }
    public void Menu2(){
        clrscr();
        System.out.println("+--------------------------------------------+");
        System.out.println("| 1. Tim theo nam san xuat                   |");
        System.out.println("| 2. Tim theo gia                            |");
        System.out.println("| 3. Exit                                    |");
        System.out.println("+--------------------------------------------+");
        System.out.println("Nhap lua chon");
    }
    public void Menu1(){
        clrscr();
        System.out.println("+--------------------------------------------+");
        System.out.println("| 1. nhap ma                                 |");
        System.out.println("| 2. nhap hang                               |");
        System.out.println("| 3. nhap nam san xuat                       |");
        System.out.println("| 4. nhap gia                                |");
        System.out.println("| 5. nhap mau sac                            |");
        System.out.println("| 6. Tim kiem                                |");
        System.out.println("+--------------------------------------------+");
        System.out.println("Nhap lua chon");
    }
    public void Menu4(){
        clrscr();
        System.out.println("+--------------------------------------------+");
        System.out.println("| 1. Thong ke theo so loai  xe               |");
        System.out.println("| 2. Thong ke theo so mau sac                |");
        System.out.println("| 3. Thong ke theo so hang xe                |");
        System.out.println("| 4. Exit                                    |");
        System.out.println("+--------------------------------------------+");
        System.out.println("Nhap lua chon");
    }
    public void addVehicle(){
        clrscr();
        String id ;
        String firm;
        int yop;
        int price;
        String color;
        while (true){
            System.out.println("Nhap ma xe : ");
            id = sc.nextLine();
            if (pid.matcher(id).matches()){
                break;
            }
        }
        while (true){
            System.out.println("Nhap hang xe : ");
            firm = sc.nextLine();
            if (pf.matcher(firm).matches()){
                break;
            }
        }
        while (true){
            System.out.println("Nhap nam san xuat : ");
            yop = sc.nextInt();
            if (py.matcher(String.valueOf(yop)).matches()){
                break;
            }
        }
        System.out.println("Nhap gia thanh : ");
        price = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap mau xe");
        color = sc.nextLine();
        switch (id.charAt(0)){
            case 'C':
                System.out.println("Nhap kieu dong co :");
                String typeEngine = sc.nextLine();
                System.out.println("Nhap so cho ngoi :");
                int num = sc.nextInt();
                Vehicle tmp = new Car(id,firm,yop,price,color,typeEngine,num);
                vehicles.add(tmp);
                break;
            case 'B':
                System.out.println("Nhap cong suat :");
                int wP = sc.nextInt();
                Vehicle tmp1 = new MotoBike(id,firm,yop,price,color,wP);
                vehicles.add(tmp1);
                break;
            case 'S':
                System.out.println("Nhap trong tai :");
                double weigh = sc.nextDouble();
                Vehicle tmp2 = new Struck(id,firm,yop,price,color,weigh);
                vehicles.add(tmp2);
                break;
        }
        delay();
        return ;
    }
    public void showListVehicle(){
        clrscr();
        System.out.println("+----------------------------------------------------------+");
        System.out.printf("|%6s%-3s|%10s%-5s|%5s%-2s|%10s%-5s|%6s%-2s|\n","ID","","FIRM","","YEAR","","PRICE","","COLOR","");
        System.out.println("+----------------------------------------------------------+");
        int n = vehicles.size();
        for (int i = 0; i < n; i++){
            System.out.printf("|%6s%-3s|%10s%-5s|%5d%-2s|%10d%-5s|%6s%-2s|\n",vehicles.get(i).getId(),"",vehicles.get(i).getFirm(),"",vehicles.get(i).getYop(),"",vehicles.get(i).getPrice(),"",vehicles.get(i).getColor(),"");
            System.out.println("+----------------------------------------------------------+");
        }
        System.out.printf("| Tong so xe: |%34d%-10s|\n",n,"");
        System.out.println("+----------------------------------------------------------+");
        delay();
    }
    public void appRun(){
        int stop = 0;
        while (true){
            if (stop == 1) break;
            Menu();
            int choice = sc.nextInt();
            clrscr();
            switch (choice){
                case 1 :
                    addVehicle();
                    break;
                case 2 :
                    showListVehicle();
                    break;
                case 3:
                    SearchVehicle();
                    break;
                case 4:
                    System.out.println("Chua lam");
                    break;
                case 5:
                    System.out.println("Chua lam");
                    break;
                case 6:
                    sortVehicle();
                    break;
                case 7:
                    thongke();
                    break;
                case 8 :
                    System.out.println("Xin chao");
                    stop = 1;
                    break;
            }
        }
    }
    public void SearchVehicle(){
        clrscr();
        String id = "";
        String firm = "";
        int yop = 0;
        int price = -1;
        String color = "";
        int stop = 0;
        int cont = 0;
        while (true){
            if (stop == 1) break;
            Menu1();
            int choice = sc.nextInt();
            sc.nextLine();
            clrscr();
            switch (choice){
                case 1 :
                    System.out.println("Nhap ma :");
                    id = sc.nextLine();
                    break;
                case 2 :
                    System.out.println("Nhap hang:");
                    firm = sc.nextLine();
                    break;
                case 3:
                    System.out.println("Nhap nam san xuat:");
                    yop = sc.nextInt();
                    sc.nextLine();
                    break;
                case 4:
                    System.out.println("Nhap gia:");
                    price = sc.nextInt();
                    sc.nextLine();
                    break;
                case 5:
                    System.out.println("Nhap mau:");
                    color = sc.nextLine();
                    break;
                case 6:
                    stop = 1;
                    break;
            }
        }
        System.out.println();
        int n = vehicles.size();
        System.out.println("+-----------------------------------------------------------------------+");
        for (int i = 0; i < n; i++){
            if (!(id.equals("")) && !(id.equals(vehicles.get(i).getId()))) continue;
            if (!(firm.equals("")) && !(firm.equals(vehicles.get(i).getFirm()))) continue;
            if (!(yop == 0) && !(yop == vehicles.get(i).getYop())) continue;
            if (!(price == -1) && !(price == vehicles.get(i).getPrice())) continue;
            if (!(color.equals("")) && !(color.equals(vehicles.get(i).getColor()))) continue;
            if (vehicles.get(i) instanceof Car){
                System.out.printf("|%6s%-3s|%10s%-5s|%5d%-2s|%10d%-5s|%6s%-2s|%4s%-2s|%3d%-1s|\n",vehicles.get(i).getId(),"",vehicles.get(i).getFirm(),"",vehicles.get(i).getYop(),"",vehicles.get(i).getPrice(),"",vehicles.get(i).getColor(),"",((Car) vehicles.get(i)).getTypeOfEngine(),"",((Car) vehicles.get(i)).getNumOfSeat(),"");
                System.out.println("+-----------------------------------------------------------------------+");
            } else if (vehicles.get(i) instanceof MotoBike) {
                System.out.printf("|%6s%-3s|%10s%-5s|%5d%-2s|%10d%-5s|%6s%-2s|%3d%-9s|\n",vehicles.get(i).getId(),"",vehicles.get(i).getFirm(),"",vehicles.get(i).getYop(),"",vehicles.get(i).getPrice(),"",vehicles.get(i).getColor(),"",((MotoBike) vehicles.get(i)).getwP(),"","");
                System.out.println("+-----------------------------------------------------------------------+");
            }else{
                System.out.printf("|%6s%-3s|%10s%-5s|%5d%-2s|%10d%-5s|%6s%-2s|%3.0f%-9s|\n",vehicles.get(i).getId(),"",vehicles.get(i).getFirm(),"",vehicles.get(i).getYop(),"",vehicles.get(i).getPrice(),"",vehicles.get(i).getColor(),"",((Struck) vehicles.get(i)).getWeight(),"","");
                System.out.println("+-----------------------------------------------------------------------+");
            }
        }
        delay();
    }
    public void sortVehicle(){
        Collections.sort(vehicles, new Comparator<Vehicle>(){
            @Override
            public int compare(Vehicle a, Vehicle b){
                if (a.getFirm().equals(b.getFirm()) == true){
                    if (a.getPrice() == b.getPrice()){
                        if (a.getYop() <= b.getYop()) return 1;
                        else return -1;
                    }else{
                        if (a.getPrice() <= b.getPrice()) return 1;
                        else return -1;
                    }
                }else return (a.getFirm().compareTo(b.getFirm()));
            }
        });
    }
    public void thongke(){
        clrscr();
        int stop = 0;
        while (true){
            if (stop == 1) break;
            Menu4();
            int choice = sc.nextInt();
            sc.nextLine();
            clrscr();
            switch (choice){
                case 1:
                    Set<String> s = new HashSet<String>();
                    for (int i = 0; i < vehicles.size(); i++){
                        s.add(String.valueOf(vehicles.get(i).getId().charAt(0)));
                    }
                    System.out.printf("So loai xe la : %d\n",s.size());
                    delay();
                    break;
                case 2:
                    Set<String> co = new HashSet<String>();
                    for (int i = 0; i < vehicles.size(); i++){
                        co.add(vehicles.get(i).getColor());
                    }
                    System.out.printf("So loai mau la : %d\n",co.size());
                    delay();
                    break;
                case 3:
                    Set<String> sh = new HashSet<String>();
                    for (int i = 0; i < vehicles.size(); i++){
                        sh.add(vehicles.get(i).getFirm());
                    }
                    System.out.printf("So hang xe la : %d\n",sh.size());
                    delay();
                    break;
                case 4:
                    stop  = 1;
                    break;
            }
        }
    }
}
