
public class Forquilla {
    private int num ;
    private int propietari;
    public static final int LLIURE = -1;
    public Forquilla(int num) {
        this.num = num;
        this.propietari = LLIURE;
    }
    public int getNum() {
        return num;
    }
    public int getPropietari() {
        return propietari;
    }
    public void setPropietari(int propietari) {
        this.propietari = propietari;
    }
    

    
    
}
