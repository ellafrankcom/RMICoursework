import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class ImpClass implements RemoteInt {
    Employee e = new Employee();
    public void serializable() {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime time = LocalDateTime.now();

        System.out.println("Type your name: ");
        e.name = scanner.nextLine();

        System.out.println("Type the product you need: ");
        e.product = scanner.nextLine();

        System.out.println("Type the name of the store you need them sent to: ");
        e.store = scanner.nextLine();

        e.SSN = 12345678;
        e.number = 101;
        System.out.println("Serialized data was saved in Serialize.ser");
        Employee.mailProduct();

        try {
            FileOutputStream file = new FileOutputStream("Serialize.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(e);
            out.writeObject(time);
            out.close();
            file.close();
            System.out.println("Serialized data was saved in Serialize.ser");
            Employee.mailProduct();
        } catch (IOException i) {
            i.printStackTrace();
        }



    }

    public class Employee implements java.io.Serializable{
        public transient String name;
        public static transient String product;
        public static transient String store;
        public transient int SSN;
        public int number;

        public static void mailProduct(){
            System.out.println("Sending " + product + " to " + store + "store");
        }
    }
}
