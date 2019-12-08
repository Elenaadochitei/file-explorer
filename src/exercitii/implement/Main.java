package exercitii.implement;
import java.io.*;

public class Main {
}

    interface in1 {
        final int a = 10; // public, static and final
        void display();  // public and abstract
    }
    class testClass implements in1 {

        public void display() {
            System.out.println("Geek");
        }

        public static void main(String[] args) {
            testClass t = new testClass();
            t.display();
            System.out.println(a);
        }
    }

