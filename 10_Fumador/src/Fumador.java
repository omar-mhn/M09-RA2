import java.util.Random;

public class Fumador extends Thread{

    private Estanc estanc;
    private long id ;
    private Tabac tabac;
    private Llumi llumi;
    private Paper paper;
    private int fumades;

    public Fumador(int id, Estanc estanc) {
        this.id = id;
        this.estanc = estanc;
    }  
    public void fuma() throws InterruptedException{
        if(tabac != null && llumi != null && paper != null){
            tabac = null;
            paper = null;
            llumi = null; 
            System.out.println("Fumador " + id + " fumant");
            Thread.sleep(500 + new Random().nextInt(501));
            fumades++;
            System.out.println("Fumador " + id + " ha fumat " + fumades + " vegades");
        }
    }
    public void compraTabac() throws InterruptedException {
        System.out.println("Fumador " + id + " comprant Tabac");
        tabac = estanc.venTabac();
    }

    public void compraPaper() throws InterruptedException {
        System.out.println("Fumador " + id + " comprant Paper");
        paper = estanc.venPaper();
    }

    public void compraLlumi() throws InterruptedException {
        System.out.println("Fumador " + id + " comprant Llumi");
        llumi = estanc.venLlumi();
    }
    @Override
    public void run() {
        try {
            while (fumades < 3) {
                compraTabac();
                compraPaper();
                compraLlumi();
                fuma();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
