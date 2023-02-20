package QuanLyNhaThue.Model;

import java.io.Serializable;
import java.util.Date;

public class Bill implements Serializable {
    private Customer customer;
    private Room room;
    private Date date;

    public Bill() {
    }

    public Bill(Customer customer, Room room, Date date) {
        this.customer = customer;
        this.room = room;
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return this.customer.toString() + " " + this.room.toString();
    }
}
