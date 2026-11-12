
package espoch.edu.ec.yasuniexplora.objetos;

 public class RegularTour extends Tour {
     
     public RegularTour(String code, String name, Trail[] trails) {
     
         super(code,name,trails);
     }
     @Override
     public float calculateTotalTime(){
         return calculateTotalTime() * getDifficulty();
     }  

}

    
   

