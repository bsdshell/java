import java.util.*;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import classfile.*;

enum Type{
    MOTORCYCLE,
    COMPACT,
    BUS,
}

class Ticket{
    int id;
    double price;
    
    LocalDateTime startTime;
    LocalDateTime endTime;
    public Ticket(int id, int price,  LocalDateTime startTime, LocalDateTime endTime){
        this.id = id;
        this.price = price;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

class Parking{
    public Vehicle vehicle;
    public Parking(Vehicle v){
        vehicle = v;
    }
}

interface Vehicle{
    public Type getType();
}

class Motorcycle implements Vehicle{
    public Type type;
    public Motorcycle(Type type){
        this.type = type;
    }
    public Type getType(){
        return type;
    }
}

class Compact implements Vehicle{
    public Type type;
    public Compact(Type type){
        this.type = type;
    }
    public Type getType(){
        return type;
    }
}

class Bus implements Vehicle{
    public Type type;
    public Bus(Type type){
        this.type = type;
    }
    public Type getType(){
        return type;
    }
}

class ParkingLot{
    double total;
    Map<Ticket, Parking>  parkMap = new HashMap<Ticket, Parking>();
    int compactMax;
    int compactCount;
    int motorcycleMax;
    int motocycleCount;
    int busMax;
    int busCount;

    public ParkingLot(int cm, int mm, int bm){
        total = 0;
        compactMax = cm;
        motorcycleMax = mm;
        busMax = bm;
    }

    public int getTicket(LocalDateTime st, LocalDateTime et){
        int count = 0;
        for(Map.Entry<Ticket, Parking> entry : parkMap.entrySet()){
            count++;
        }
        return count;
    }

    public double ticketPrice(){
        return 1;
    }
    public void add(Ticket t, Parking p){
        if(!isFull()){
            if(p.vehicle.getType() == Type.COMPACT && compactCount < compactMax)
                compactCount++;
            else if(p.vehicle.getType() == Type.MOTORCYCLE && motocycleCount < motorcycleMax)
                motocycleCount++;
            else if(p.vehicle.getType() == Type.BUS && busCount < busMax)
                busCount++;

            parkMap.put(t, p);
        }
    }
    public void remove(Ticket t){
        Parking p = parkMap.get(t);
        if(p != null){
            if(p.vehicle.getType() == Type.COMPACT)
                compactCount--;

            if(p.vehicle.getType() == Type.MOTORCYCLE)
                motocycleCount--;

            if(p.vehicle.getType() == Type.BUS)
                busCount--;
            
            parkMap.remove(t);

            t.endTime = LocalDateTime.now();
            parkMap.put(t, p);
        }
    }
    public boolean isFullCompact(){
        return compactCount < compactMax;
    }
    public boolean isFullMotorcycle(){
        return motocycleCount < motorcycleMax;
    }
    public boolean isFullBus(){
        return busCount < busMax;
    }
    public boolean isFull(){
        return (compactCount + motocycleCount + busCount) < (compactMax + motorcycleMax + busMax) ? false : true;
    }
}


public class MyParking{
    public static void main(String[] args) {
        test0();
    }
    static void test0(){
        Aron.beg();

        ParkingLot pl = new ParkingLot(4, 5, 6);
        LocalDateTime time1 = LocalDateTime.parse("2007-12-03T10:15:30", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        Ticket t1 = new Ticket(1, 100, time1, null);
        Parking park1 = new Parking(new Compact(Type.COMPACT));
        pl.add(t1, park1);
        System.out.println("compactCount[" + pl.compactCount + "]"); 
        System.out.println("motocycleCount[" + pl.motocycleCount+ "]"); 
        System.out.println("busCount[" + pl.busCount+ "]"); 
        
        pl.remove(t1);
        
        System.out.println("\n---------------------------------"); 

        System.out.println("compactCount[" + pl.compactCount + "]"); 
        System.out.println("motocycleCount[" + pl.motocycleCount+ "]"); 
        System.out.println("busCount[" + pl.busCount+ "]"); 

        Aron.end();
    }
} 
