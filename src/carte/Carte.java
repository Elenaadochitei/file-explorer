package carte;

public class Carte {
    private String autor;
    private String titlu;
    private int[] noteRev;

    public void setAutor(String autor){
        this.autor=autor;
    }
    public String getAutor(){
        return autor;
    }

    public void setTitlu(String titlu){
        this.titlu=titlu;
    }
    public String getTitlu(){
        return titlu;
    }

    public void setNoteRev(int[]noteRev){
        this.noteRev=noteRev;
    }
    public int[] getNoteRev(){
        return noteRev;
    }

}
