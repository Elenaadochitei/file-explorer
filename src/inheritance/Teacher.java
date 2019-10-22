package inheritance;

public class Teacher extends Person {
    String [] classes;

    protected void setClasses(String [] note){
        this.classes=classes;
    }
    public String [] getClasses(){
        return classes;
    }
    @Override
    public void walk(){
        System.out.println("Teacher is walking");
    }

    public Teacher(){
        super();
        System.out.println("Teacher");
    }

    public void tralal(){
        System.out.println("Teacher");
        super.walk();
    }

    public Teacher(String []classes){
        super("ion");
        this.classes=classes;
        System.out.println("Teacher new");
    }

    public Teacher (String [] classes, String nume){
        super(nume);
        this.classes=classes;



    }
}
