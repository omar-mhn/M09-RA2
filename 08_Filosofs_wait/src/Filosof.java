import java.util.Random;

public class Filosof extends Thread {
    private int numComensal;
    private Forquilla forquillaDreta;
    private Forquilla forquillaEsquerra;
    private int gana = 0;
    private Random rd = new Random();

    public Filosof(int comensal, Forquilla esq, Forquilla dre) {
        this.numComensal = comensal;
        this.forquillaEsquerra = esq;
        this.forquillaDreta = dre;
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filòsof " + numComensal + " pensant...");
        Thread.sleep(rd.nextInt(1000) + 1000); 
    }
    private void menjar() throws InterruptedException {
        System.out.println("Filòsof " + numComensal + " MENJANT");
        Thread.sleep(rd.nextInt(1000) + 1000); 
    }
    public void agafarForquillaEsquerra()throws InterruptedException{
        synchronized(forquillaEsquerra){
            while (forquillaEsquerra.getPropietari() != Forquilla.LLIURE) {
                forquillaEsquerra.wait(rd.nextInt(500)+500);
            }
            forquillaEsquerra.setPropietari(numComensal);
        }
    }
    public void agafarForquillaDreta()throws InterruptedException{
        synchronized(forquillaDreta){
            while (forquillaDreta.getPropietari() != Forquilla.LLIURE) {
                forquillaDreta.wait(rd.nextInt(500) + 500);
            }
            forquillaDreta.setPropietari(numComensal);
        }
    }
    public void deixarForquilles(){
        synchronized(forquillaEsquerra) {
            forquillaEsquerra.setPropietari(Forquilla.LLIURE);
            forquillaEsquerra.notifyAll();
        }
        synchronized(forquillaDreta) {
            forquillaDreta.setPropietari(Forquilla.LLIURE);
            forquillaDreta.notifyAll();
        }

        
    }
    @Override
        public void run() {
        try {
            while (true) {
                pensar();
                agafarForquillaEsquerra();
                agafarForquillaDreta();
                menjar();
                deixarForquilles();
            }
        } catch (InterruptedException e) {
             e.printStackTrace(); 
        }

    }



}
