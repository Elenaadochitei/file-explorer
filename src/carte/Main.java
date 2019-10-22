package carte;

public class Main {
    public static void main(String[] args) {
        System.out.println("Aici incepe");

        Carte c= new Carte();

        c.setAutor("Eminescu");
        c.setTitlu("Dorinta");
        c.setNoteRev(new int[] {2,3});

        Carte c1= new Carte();

        c1.setAutor("Creanga");
        c1.setTitlu("Amintiri");
        c1.setNoteRev(new int[]{3,1});

        System.out.println(c.getAutor() + " " + c.getTitlu());
        System.out.println(c1.getAutor() + " " + c1.getTitlu());

        afisare(c);
        System.out.println("Note evaluare ");
        afisare(c1);
        System.out.println("Note evaluare ");

    }

    public static void afisare(Carte cc){
        for( int i=0; i<cc.getNoteRev().length;i++){
            System.out.print(cc.getNoteRev()[i]+ " ");
        }
    }


}
