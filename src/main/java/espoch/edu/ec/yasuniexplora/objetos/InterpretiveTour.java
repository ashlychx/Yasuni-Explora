
package espoch.edu.ec.yasuniexplora.objetos;

public class InterpretiveTour extends Tour{
    
    private float educationalTime;

    public InterpretiveTour(float educationalTime, String code, String name, Trail[] trails, Device device, Guide guide) {
        super(code, name, trails, device, guide);
        this.educationalTime = educationalTime;
    }
    
    @Override
    public float calculateTotalTime(){
        
        
        return 0;
    }
    
}