package HomeManager.Controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOBinary {
    public static <T> List<T> read(String file){
        List<T> list = new ArrayList<>();
        try{
            ObjectInputStream a = new ObjectInputStream(new FileInputStream(file));
            list = (List<T>) a.readObject();
            a.close();
        } catch(Exception e){
            e.printStackTrace();
            System.err.println("Error: " + e.getMessage());
        }
        return list;
    }


    public static <T> void write(String file, List<T> list){
        try{
            ObjectOutputStream a = new ObjectOutputStream(new FileOutputStream(file));
            a.writeObject(list);
            a.close();
        } catch(Exception e){
            e.printStackTrace();
            System.err.println("Error: " + e.getMessage());
        }
    }
}
