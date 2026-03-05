import java.util.Random;

public class Filosof extends Thread {
    private long iniciGana;
    private long fiGana;
    private long gana;
    private Forquilla forquillaDreta;
    private Forquilla forquillaEsquerra;
    private Random random = new Random();

    public Filosof(String nom, Forquilla esquerra, Forquilla dreta) {
        super(nom); 
        this.forquillaEsquerra = esquerra;
        this.forquillaDreta = dreta;
    }
    @Override
    public void run() {
        while (true) {
            pensar();
            menjar();
        }
    }

    private void pensar() {
        System.out.println(getName() + " pensant");
        iniciGana = System.currentTimeMillis(); 
        try {
            
            Thread.sleep(random.nextInt(1000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void menjar() {
        agafarForquilles(); 
        
        calcularGana(); 
        System.out.println(getName() + " té forquilles esq (" + forquillaEsquerra.getNum() + ") dreta (" + forquillaDreta.getNum() + ")");
        System.out.println(getName() + " menja amb gana " + gana);
        
        try {
          
            Thread.sleep(random.nextInt(1000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println(getName() + " ha acabat de menjar");
        resetGana(); 
        deixarForquilles(); 
    }

    private void agafarForquilles(){
        agafarForquillaEsquerra();
        agafarForquillaDreta();
    }
    private void agafarForquillaEsquerra() {
        forquillaEsquerra.agafar(); 
    }

    private void agafarForquillaDreta() {
        forquillaDreta.agafar(); 
    }

    private void deixarForquilles() {
        System.out.println(getName() + " deixa les forquilles");
        forquillaDreta.deixar();
        forquillaEsquerra.deixar();
    }

    private void calcularGana() {
        fiGana = System.currentTimeMillis();
        gana = (fiGana - iniciGana) / 1000;
    }
    private void resetGana() {
        iniciGana = System.currentTimeMillis();
        gana = 0;
    }
}
