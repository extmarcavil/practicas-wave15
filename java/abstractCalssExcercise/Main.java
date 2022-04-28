package abstractCalssExcercise;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Vehicle {
    private int num;

    public Vehicle(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String toString() {
        return "numero: " + this.num;
    }
}

public class Main {

    public static void main(String[] atgs) {
        HashMap<Integer, Vehicle> m = new HashMap<>();

        m.put(1, new Vehicle(5));
        m.put(2, new Vehicle(16));
        m.put(3, new Vehicle(7));
        m.put(4, new Vehicle(8));

        Map.Entry<Integer, Vehicle> rta = m.entrySet().stream()
                .max(Comparator.comparing(c -> c.getValue().getNum()))
                .get();


        System.out.println(rta.getValue());
        System.out.println(m.getClass());

    }
}
