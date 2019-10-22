package student;

public class Main {

    public static void main(String[] args) {

        Student s = new Student();

        s.setNume("Andrei");
        s.setPrenume("Vacariu");
        s.setNote(new int[] {2,3,4});

        Student s1= new Student();

        s1.setNume("Ion");
        s1.setPrenume("Adochitei");
        int[] v={2,2,5};
        s1.setNote(v);

        System.out.println(s.getNume()+ " "+ s.getPrenume());
        for(int i=0; i<s.getNote().length;i++){
            System.out.print(s.getNote()[i]+ " ");
        }
        System.out.println();
        System.out.println(s1.getNume()+ " "+ s1.getPrenume());
        for( int i=0; i<s1.getNote().length;i++){
            System.out.print( s1.getNote()[i] + " ");
        }

        System.out.println("de aici incepe");
        s.afisare();
        System.out.println();
        s1.afisare();

        System.out.println();

        System.out.println("De aici incepe afisarea din main");
        afisare(s);
        System.out.println("Note student1");
        afisare(s1);
        System.out.println("Note student2");
    }

    public static void afisare(Student ss){
        for( int i=0; i<ss.getNote().length;i++){
            System.out.print(ss.getNote()[i]+ " ");
        }
    }
}
