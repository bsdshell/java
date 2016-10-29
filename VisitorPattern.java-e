import java.util.*;
import java.io.*;
import classfile.*;

interface CarElement{
    public void accept(PartVistor visitor);
}

class Engine implements CarElement{
    public String name;
    public Engine(String name){
        this.name = name;
    }

    public void accept(PartVistor visit){
        visit.visit(this);
    }
}

class Body implements CarElement{
    public String name;
    public Body(String name){
        this.name = name;
    }

    public void accept(PartVistor visit){
        visit.visit(this);
    }
}

class Car implements CarElement{
    List<CarElement> list = new ArrayList<>();
    public String name;
    public Car(String name){
        this.name = name;
        list.add(new Body("body"));
        list.add(new Engine("engine"));
    }
    public void accept(PartVistor visit){
        for(CarElement e : list){
            e.accept(visit);
        }
        visit.visit(this);
    }
}

interface PartVistor{
    public void visit(Engine c);
    public void visit(Body c);
    public void visit(Car c);
}

class CarElementDoVisitor implements PartVistor{
    public void visit(Engine e){
        Print.p("From Visit Engine Object"); 
        Print.p("Ferrari Has the best Car Engine " + e.name);
    }
    public void visit(Body b){
        Print.p("This is body part");
        Print.p("Body part is body " + b.name);
    }

    public void visit(Car b){
        Print.p("This is main Car");
        Print.p("name=" + b.name);
    }
}

public class VisitorPattern{
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0(){
        Aron.beg();
        CarElement car = new Car("Car");
        car.accept(new CarElementDoVisitor());
        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        Aron.end();
    }
} 

