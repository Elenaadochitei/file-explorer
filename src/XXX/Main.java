package XXX;

import inheritance.Teacher;

public class Main {
    public static void main(String[] args) {
        String [] classes= {"a", "b"};
        Teacher t  =new Teacher(classes);
        t.setNume("Costel");
        Teacher t2=new Teacher(classes,"Ionut");

        afisareTeacher(t);
        afisareTeacher(t2);



        /*t.setNume("Ionut");
        t.walk();*/

        /*Person p=new Teacher();
        p.walk();

        p=new Student();
        p.walk();
*/
    }

    private static void afisareTeacher(Teacher t) {
        for(int i=0; i < t.getClasses().length;i++){
            System.out.println(t.getClasses()[i]);
        }

        System.out.println(t.getNume());
    }
}
