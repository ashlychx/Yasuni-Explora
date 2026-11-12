
package espoch.edu.ec.yasuniexplora.implementacion;

import espoch.edu.ec.yasuniexplora.interfaces.InterfazTours;
import espoch.edu.ec.yasuniexplora.objetos.Device;
import espoch.edu.ec.yasuniexplora.objetos.Guide;
import espoch.edu.ec.yasuniexplora.objetos.Tour;
import espoch.edu.ec.yasuniexplora.objetos.Trail;
import java.util.Scanner;


public class TourImplDAO  implements InterfazTours{
    private Tour[] tours;
    private int count=0;
    
    public TourImplDAO (int capacity){
        tours = new Tour [capacity];
        
    }
    @Override
    public boolean save (Tour tour){
        if (count< tours.length) {
            tours[count]= tour;
            count++;
            
            return true;
            
        }
        return false;
    }
    @Override
    public void viewTours(){
        for (int i = 0; i < count; i++) {
            System.out.println(tours[i]);
            System.out.println("DISTANCIA: "+ distance(tours[i]));
            System.out.println("DURACION:"+ totalTime(tours[i]));
            
        }
    }
    
    @Override
    public float distance(Tour tour){
        
        return tour.calculateDistance();
    
    }
    @Override
    public float totalTime(Tour tour){
        return tour.calculateTotalTime();
    }
    
    @Override
    public float simulation (float currentFactor){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("INGRESE PORCENTAJE: ");
        float percentage = sc.nextFloat();
        
        return currentFactor *(1+ percentage/100);
        
    }
    public void changeFactor(Tour tour, float newFactor){
        tour.setDifficulty(newFactor);
    }
    
    public float adjustedTime(Tour tour){
        return tour.calculateBaseWalkingTime()*tour.getDifficulty();
    }
    
    @Override
    public boolean closeTrail(Tour tour,int position){
        
        Trail[] trails= tour.getTrails();
        if (position < 0 | position >= trails.length) {
            return false;
        }
        if (! trails[position].isEnabled()){
            return false;
            
        }
        trails[position].setEnabled(false);
        return true;
        
    }
    public void orderTours(int criterion){
        if (criterion !=1 && criterion !=2) {
            System.out.println("CRITERIO INVALIDO");
            return;
            
        }
        for (int i = 0; i < count -1; i++) {
            for (int j = 0; j < count -1 - i; j++) {
                float a;
                float b;
                if (criterion ==1) {
                    a= distance(tours[j]);
                    b=distance(tours[j+1]);
                    
                }else {
                    a=distance(tours[j]);
                    b=totalTime(tours[j+1]);
                }
                if (a>b) {
                    Tour temp = tours [j];
                    tours[j]= tours[j+1];
                    tours[j+1]=temp;
                    
                }
                
            }
            
        }
    }
    @Override
    public boolean assign(Tour tour, Device device, Guide guide){
        if (device == null || guide == null) {
            return false;
            
        }
        if (tour.getDevice()!=null || tour.getGuide()!=null) {
            return false;
            
        }
        tour.setDevice(device);
        tour.setGuide(guide);
        
        device.setState(false);
        guide.setStateGuide(false);
        
        return true;
        
        
    }

    @Override
    public float changefactor(Tour tour, float newFactor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public float ajustedTime(Tour tour) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
