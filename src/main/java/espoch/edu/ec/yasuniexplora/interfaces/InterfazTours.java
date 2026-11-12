
package espoch.edu.ec.yasuniexplora.interfaces;

import espoch.edu.ec.yasuniexplora.objetos.Device;
import espoch.edu.ec.yasuniexplora.objetos.Guide;
import espoch.edu.ec.yasuniexplora.objetos.Tour;


public interface InterfazTours {
    public boolean save(Tour tour);
    public void viewTours();
    public float distance(Tour tour);
    public float totalTime(Tour tour);
    public float simulation(float currentFactor);
    public float changefactor(Tour tour,float newFactor);
    public float ajustedTime(Tour tour);
    public boolean closeTrail(Tour tour, int position);
    public void orderTours(int criterion);
    public boolean assign(Tour tour,Device device,Guide guide);
    
}
