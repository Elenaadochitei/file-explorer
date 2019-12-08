package exercitii2;
import java.util.ArrayList;

public class SortatSauNu {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        boolean b = true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i)  >  list.get(i + 1)) {
                System.out.println("Lista nu este sortata.");
                b = false;
            }
        }
        if (b == true) {
            System.out.println("Lista este sortata");
        }
    }
}
