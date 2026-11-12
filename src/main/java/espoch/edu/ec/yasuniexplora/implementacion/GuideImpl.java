
package espoch.edu.ec.yasuniexplora.implementacion;

import espoch.edu.ec.yasuniexplora.interfaces.InterfazGuide;
import espoch.edu.ec.yasuniexplora.objetos.Guide;


public class GuideImpl implements InterfazGuide {
    
    private Guide[] guides;
    private int count =0;
    
    public GuideImpl(int capacity){
        guides =new Guide [capacity];
    }
    @Override
    public boolean save (Guide guide){
        if (count < guides.length) {
            guides[count]= guide;
            count++;
            return true;
            
        }
        return false;
    }
    @Override
    public Guide state(){
        for (int i = 0; i < count; i++) {
            if (guides[i].isStateGuide()) {
                return guides[i];
            }
            
        }
        return null;
    }
    
}
