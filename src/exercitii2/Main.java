package exercitii2;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        int aux = 0; // aici aux e o variabila, se pune pe stack,
        // si poate lua orice valoare prin atribuire

        ArrayList<Integer> list = new ArrayList<>(); // list este o variabila, de tip lista. Ii poti atribui prin "="
        // doar o alta lista, nu valori separate ( gen 1 sau 2) ;
        list.get(1); // aici apelezi metoda "get" pentru lista. nu poti sa atribui valoare unei metode,
        //  ea doar ruleaza si iti returneaza ceva
        list.set(1, 22);// aici apelezi metoda "set", care primeste 2 parametrii "1, 22" -> adica va pune valoare
        // 22 pe pozitia 1.
        list.set(aux, 22); // la fel ca mai sus, dar va pune valoare 22 la pozitia "aux", in cazul nostru, 0

        list.set(1, aux); // va pune valoarea lui aux pe pozitia 1, in cazul de fata :  pune 0 pe pozitia 1 din lista
    }
}
