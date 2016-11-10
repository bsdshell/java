import java.util.*;
import java.io.*;
import classfile.*;
import java.time.LocalDateTime;
import java.time.Duration;

interface ICar{
    public double getPrice();
}

class SmallCar implements ICar {
    String name;
    public SmallCar(String name) {
        this.name = name;
    }
    public double getSize() {
        return 114;
    }
}

class MiddleCar implements ICar {
    String name;
    public MiddleCar(String name) {
        this.name = name;
    }
    public double getSize() {
        return 314;
    }
}

class Ticket {
    double price;
    String id;
    LocalDateTime start;
    LocalDateTime end;
    public Ticket(String id, double price) {
        this.id = id;
        this.price = price;
        this.start = LocalDateTime.now();
    }
    public LocalDateTime diff() {
        return LocalDateTime.now();
    }
}

class ParkingSpace {
    Ticket ticket;
    ICar car;
    public ParkingSpace(Ticket ticket, ICar car) {
        this.ticket = ticket;
        this.car = car;
    }
}

class ParkSystem {
    Map<String, ParkingSpace> map = new HashMap<>();
    public ParkSystem(int max) {
    }
    public void add(ParkingSpace parkingSpace) {
        map.put(parkingSpace.ticket.id, parkingSpace);
    }
    public void remove(parkingSpace parkingSpace) {
        map.remove(ParkingSpace.ticket.id);
    }
}


public class TryPark {
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0() {
        Aron.beg();

        ParkSystem ps = new ParkSystem(10);
        Ticket t1 = new Ticket("1", LocalDateTime.now());
        Ticket t2 = new Ticket("2", LocalDateTime.now());
        Ticket t3 = new Ticket("3", LocalDateTime.now());

        ps.add(t1, new ParkingSpace(t1, new SmallCar("2323", 345.3)));

        Aron.end();
    }
    public static void test1() {
        Aron.beg();
        LocalDateTime from = LocalDateTime.now();
        LocalDateTime to = LocalDateTime.now();
        Duration duration = Duration.between(from, to);
        Print.pbl(duration.toString());
        Aron.end();
    }
}

