
package espoch.edu.ec.yasuniexplora.objetos;


public class RegularTour extends Tour {

    public RegularTour(String code, String name,
                       Trail[] trails, Device device,
                       Guide guide) {

        super(code, name, trails, device, guide);
    }

    // Constructor de tres parámetros
    public RegularTour(String code, String name,
                       Trail[] trails) {

        super(code, name, trails);
    }

    @Override
    public float calculateTotalTime() {

        return calculateBaseWalkingTime()
                * getDifficulty();
    }
}

