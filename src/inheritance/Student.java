package inheritance;

public class Student extends Person {

     int [] note;
     protected void setNote(int[] note){
         this.note=note;
     }
     protected int[] getNote(){
         return note;
     }
    @Override
    public void walk(){
        System.out.println("Student is walking");
    }

    public Student(){
        System.out.println("Student");
    }
}
