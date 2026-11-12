package espoch.edu.ec.yasuniexplora.objetos;

public class Tour {

    //clase abstracta
    private String code;
    private String name;
    private float difficulty = 1.0f;
    private Trail[] trails;
    private Device device;
    private Guide guide;

    public Tour(String code, String name, Trail[] trails, Device device, Guide guide) {
        this.code = code;
        this.name = name;
        this.trails = trails;
        this.device = device;
        this.guide = guide;
    }

    public abstract float calculateTotalTime();

    public float calculateDistance() {
        float total = 0;

        for (int i = 0; i < trails.length; i++) {
            if (trails[i].getLength()) {
                total += trails[i].getLength();

            }

        }
        return total;

    }

    public float calculateBaseWalkingTime() {

        float total = 0;

        for (int i = 0; i < trails.length; i++) {

            if (trails[i].isEnabled()) {
                total += trails[i].getWalkingTime();
            }
        }

        return total;
    }

    public float getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(float difficulty) {
        this.difficulty = difficulty;
    }

    public Trail[] getTrails() {
        return trails;
    }

    public void setTrails(Trail[] trails) {
        this.trails = trails;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }
    
    

}
