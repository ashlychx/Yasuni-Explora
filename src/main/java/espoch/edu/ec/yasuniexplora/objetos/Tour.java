
package espoch.edu.ec.yasuniexplora.objetos;

public class Tour {
    private String ide;
    private String name;
    private float dificculd =1.0f;

    public Tour(String ide, String name) {
        this.ide = ide;
        this.name = name;
    }

    public String getIde() {
        return ide;
    }

    public void setIde(String ide) {
        this.ide = ide;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDificculd() {
        return dificculd;
    }

    public void setDificculd(float dificculd) {
        this.dificculd = dificculd;
    }
    
    
    
    
    
}
