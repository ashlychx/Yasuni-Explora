
package espoch.edu.ec.yasuniexplora.objetos;

public class Assignment {
    private boolean newPerson;
    private boolean timeLimited;

    public Assignment(boolean newPerson, boolean timeLimited) {
        this.newPerson = newPerson;
        this.timeLimited = timeLimited;
    }

    public boolean isNewPerson() {
        return newPerson;
    }

    public void setNewPerson(boolean newPerson) {
        this.newPerson = newPerson;
    }

    public boolean isTimeLimited() {
        return timeLimited;
    }

    public void setTimeLimited(boolean timeLimited) {
        this.timeLimited = timeLimited;
    }
    
    
    
}
