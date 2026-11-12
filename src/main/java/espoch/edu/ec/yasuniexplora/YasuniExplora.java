
package espoch.edu.ec.yasuniexplora;

import espoch.edu.ec.yasuniexplora.implementacion.TourImplDAO;
import espoch.edu.ec.yasuniexplora.objetos.Device;
import espoch.edu.ec.yasuniexplora.objetos.Guide;
import espoch.edu.ec.yasuniexplora.objetos.RegularTour;
import espoch.edu.ec.yasuniexplora.objetos.Tour;
import espoch.edu.ec.yasuniexplora.objetos.Trail;

public class YasuniExplora {

    public static void main(String[] args) {

        // 1. Crear senderos
        Trail t1 = new Trail("Sendero A", 3, 40);
        Trail t2 = new Trail("Sendero B", 2, 30);

        Trail[] senderos = {t1, t2};

        // 2. Crear recorrido
        Tour tour = new RegularTour(
            "T01", "Recorrido Amazonas", senderos);

        // 3. Crear dispositivo
        Device d1 = new Device("D01", "Radio", true);

        // 4. Crear guia
        Guide g1 = new Guide("1234567890", "Carlos", true);

        // 5. Crear DAO
        TourImplDAO dao = new TourImplDAO(10);
        
        dao.save(tour);
        dao.viewTours();
        
        System.out.println("ASIGNACION: "+ dao.assign(tour, d1, g1));
        

    }  
}
