package QuanLyNhaThue.Model;

import java.io.Serializable;

public class Customer implements Serializable {
    public static int numID = 0;
    private String id, name, address, phoneNumber, type;

    public Customer() {
    }

    public Customer(String name, String address, String phoneNumber, String type) {
        numID += 1;
        String id = String.valueOf(numID);
        while (id.length() < 5) id = "0" + id;
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.name + " " + this.address + " " + this.phoneNumber + " " + this.type;
    }
}
