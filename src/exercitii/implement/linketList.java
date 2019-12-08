package exercitii.implement;
import java.util.LinkedList;
public class linketList {

    public static void main(String[] args) {
        String word = "Imi place ciocolata, dar eu sunt la dieta, la fel si tatelul.";
        String wordString[] = word.split(" ");
        System.out.println(wordString[2]);
        LinkedList<String> wordList = new LinkedList<String>();

        System.out.println(wordList.size());

        for (int i = 0; i < wordString.length; i++){
            wordList.add(wordString[i]);
        }
        System.out.println(wordList.size());

        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).length() > 3){
                System.out.println("Lungimea e mai mare decat 3");
                wordList.remove(i);
                i--;
            }
        }

        System.out.println(wordList.size());

        for (int i = 0; i < wordList.size(); i++) {
            System.out.println(wordList.get(i));
        }
    }
}
