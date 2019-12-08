package exercitii2;
import java.util.ArrayList;

public class SortataSauNu {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(1);

        int a = 0;
        int b = 0;

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(0) < list.get(1)) {
                if (list.get(i) > list.get(i + 1)) {
                    break;
                }
                a++;
            } else {
                if (list.get(i) < list.get(i + 1)) {
                    break;
                }
                b++;
            }
        }
        if (a == list.size() - 1) {
            System.out.println("Lista sortata crescator.");
        } else {
            if (b == list.size() - 1) {
                System.out.println("Lista este sortata descrescator.");
            } else {
                System.out.println("Lista nu este sortata.");
            }
        }
    }
}
