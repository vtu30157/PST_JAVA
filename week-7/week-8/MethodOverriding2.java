class Vehicle {
    String type = "vehicle";

    void print() {
        System.out.println(type + " with pedals.");
    }
}

class Cycle extends Vehicle {
    String type = "cycle";

    @Override
    void print() {
        System.out.print("My ancestor is a " + type + " who is a ");
        super.print();
    }
}

class Motorcycle extends Cycle {
    String type = "motorcycle";

    @Override
    void print() {
        System.out.println("Hello I am a " + type + ", I am a cycle with an engine.");
        super.print();
    }
}

public class Solution {
    public static void main(String[] args) {
        Motorcycle m = new Motorcycle();
        m.print();
    }
}