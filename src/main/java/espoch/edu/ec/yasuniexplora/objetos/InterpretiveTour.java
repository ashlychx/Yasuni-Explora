
package espoch.edu.ec.yasuniexplora.objetos;

public class InterpretiveTour extends Tour{
    
    private float educationalTime;

    public InterpretiveTour(float educationalTime, String code, String name, Trail[] trails, Device device, Guide guide) {
        super(code, name, trails, device, guide);
        this.educationalTime = educationalTime;
    }
    
    @Override
    public float calculateTotalTime(){
        
        
        return (calculateBaseWalkingTime()* getDifficulty()+educationalTime);
    }

    public float getEducationalTime() {
        return educationalTime;
    }

    public void setEducationalTime(float educationalTime) {
        this.educationalTime = educationalTime;
    }
    
    
}