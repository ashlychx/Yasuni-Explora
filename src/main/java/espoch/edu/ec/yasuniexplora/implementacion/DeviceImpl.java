
package espoch.edu.ec.yasuniexplora.implementacion;

import espoch.edu.ec.yasuniexplora.interfaces.InterfazDevice;
import espoch.edu.ec.yasuniexplora.objetos.Device;

public class DeviceImpl implements InterfazDevice{
    
    private Device[] devices;
    private int count =0;
    
    public DeviceImpl(int capacity){
        devices = new Device[capacity];
    }
    @Override
    public boolean save (Device device ){
        
        if (count < devices.length) {
            devices[count]= device;
            count++;
            return true;
            
        }
        return false;
    }
    @Override
    public Device state(){
        for (int i = 0; i < count; i++) {
            if (devices[i].isState()) {
                return devices[i];
            }
            
        }
        return null;
    }
}
