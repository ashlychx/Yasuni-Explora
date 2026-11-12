package espoch.edu.ec.yasuniexplora.implementacion;

import espoch.edu.ec.yasuniexplora.interfaces.InterfazTours;
import espoch.edu.ec.yasuniexplora.objetos.Device;
import espoch.edu.ec.yasuniexplora.objetos.Guide;
import espoch.edu.ec.yasuniexplora.objetos.Tour;
import espoch.edu.ec.yasuniexplora.objetos.Trail;
import java.util.Scanner;

public class TourImplDAO implements InterfazTours {

    private Tour[] tours;
    private int count = 0;

    // Constructor
    public TourImplDAO(int capacity) {
        tours = new Tour[capacity];
    }

    // Guardar recorridos
    @Override
    public boolean save(Tour tour) {

        if (tour == null || count >= tours.length) {
            return false;
        }

        tours[count] = tour;
        count++;

        return true;
    }

    // Mostrar recorridos
    @Override
    public void viewTours() {

        for (int i = 0; i < count; i++) {

            System.out.println("CODIGO: " + tours[i].getCode());
            System.out.println("NOMBRE: " + tours[i].getName());

            System.out.println("DISTANCIA: "
                    + distance(tours[i]) + " km");

            System.out.println("DURACION: "
                    + totalTime(tours[i]) + " minutos");
        }
    }

    // Calcular distancia
    @Override
    public float distance(Tour tour) {

        return tour.calculateDistance();
    }

    // Calcular duración total
    @Override
    public float totalTime(Tour tour) {

        return tour.calculateTotalTime();
    }

    // Simular incremento del factor
    @Override
    public float simulation(float currentFactor) {

        Scanner sc = new Scanner(System.in);

        System.out.println("INGRESE PORCENTAJE: ");
        float percentage = sc.nextFloat();

        return currentFactor * (1 + percentage / 100);
    }

    // Aceptar y guardar el nuevo factor
    @Override
    public float changefactor(Tour tour, float newFactor) {

        tour.setDifficulty(newFactor);

        return tour.getDifficulty();
    }

    // Calcular tiempo total ajustado
    @Override
    public float ajustedTime(Tour tour) {

        return tour.calculateBaseWalkingTime()*tour.getDifficulty();
    }

    // Cerrar sendero
    @Override
    public boolean closeTrail(Tour tour, int position) {

        if (tour == null) {
            return false;
        }

        Trail[] trails = tour.getTrails();

        if (trails == null || position < 0
                || position >= trails.length) {
            return false;
        }

        if (!trails[position].isEnabled()) {
            return false;
        }

        trails[position].setEnabled(false);

        return true;
    }

    // Ordenar recorridos
    @Override
    public void orderTours(int criterion) {

        if (criterion != 1 && criterion != 2) {

            System.out.println("CRITERIO INVALIDO");
            return;
        }

        for (int i = 0; i < count - 1; i++) {

            for (int j = 0; j < count - 1 - i; j++) {

                float a;
                float b;

                if (criterion == 1) {

                    // Ordenar por distancia
                    a = distance(tours[j]);
                    b = distance(tours[j + 1]);

                } else {

                    // Ordenar por duración
                    a = totalTime(tours[j]);
                    b = totalTime(tours[j + 1]);
                }

                if (a > b) {

                    Tour temp = tours[j];
                    tours[j] = tours[j + 1];
                    tours[j + 1] = temp;
                }
            }
        }
    }

    // Asignar dispositivo y guía
    @Override
    public boolean assign(Tour tour, Device device, Guide guide) {

        // Comprobar que los objetos existan
        if (tour == null || device == null || guide == null) {
            return false;
        }

        // Comprobar que el recorrido no tenga recursos asignados
        if (tour.getDevice() != null || tour.getGuide() != null) {
            return false;
        }

        // Comprobar disponibilidad de ambos recursos
        if (!device.isState() || !guide.isStateGuide()) {
            return false;
        }

        // Si todas las condiciones se cumplen, asignar
        tour.setDevice(device);
        tour.setGuide(guide);

        // Cambiar estados a ocupados
        device.setState(false);
        guide.setStateGuide(false);

        return true;
    }
}
