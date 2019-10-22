package inheritance;

public class Mamifer {
    private String specie;

     public void setSpecie(String specie){
         this.specie=specie;
     }
     public String getSpecie(){
         return specie;
     }

     public Mamifer(){
         System.out.println("Mamifer");
     }

     public void w(){
         System.out.println("Mamifer are great");
     }

     public Mamifer(String specie){
         System.out.println("Mamifer cu specie");
     }

}
