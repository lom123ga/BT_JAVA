package HomeManager.Model;

import java.io.Serializable;

class InvalidDataException extends Exception{
    InvalidDataException(String s){
        super(s);
    }
}

public class Customer implements Serializable {
    public static int numID = 0;
    private String  name, address, phoneNumber, type;
    private int id;

    public Customer() {
    }

    public Customer(String name, String address, String phoneNumber, String type) {
        numID += 1;
        this.id = numID;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    
    public static void checkName(String name) throws InvalidDataException {
        if (!name.matches("^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ"
                + "ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ"
                + "ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$")) {
            throw new InvalidDataException("Wrong name, pls try again!");
        }
    }
    
    public static void checkPhoneNumber (String phoneNumber) throws InvalidDataException {
        if (!phoneNumber.matches("[0-9]{10}")) {
            throw new InvalidDataException("Wrong phone number, pls try again!");
        }
    }
}
