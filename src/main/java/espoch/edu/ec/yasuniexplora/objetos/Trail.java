
package espoch.edu.ec.yasuniexplora.objetos;


public class Trail {
    
    private String name;
    private float length;    //km
    private float walkingTime;   //minutos
    private boolean enabled;

    public Trail(String name, float length, float walkingTime, boolean enabled) {
        this.name = name;
        this.length = length;
        this.walkingTime = walkingTime;
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWalkingTime() {
        return walkingTime;
    }

    public void setWalkingTime(float walkingTime) {
        this.walkingTime = walkingTime;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    
    

  

    
   
    
}
