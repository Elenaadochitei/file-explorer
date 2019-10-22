package student;

public class Student {

    private String nume;
    private String prenume;
    private int[] note;

    public void setNume(String nume){
        this.nume=nume;
    }

    public String getNume(){
        return nume;
    }

    public void setPrenume(String prenume){
        this.prenume=prenume;
    }
    public String getPrenume(){
        return prenume;
    }

    public void setNote(int[] note){
        this.note=note;
    }
    public int[] getNote(){
        return this.note;
    }

    public Student(){}

    public void afisare(){
        for(int i=0; i<this.note.length;i++){
            System.out.print(this.note[i]+" ");
        }
    }


}
