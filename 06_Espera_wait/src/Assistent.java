import java.util.Random;

public class Assistent extends Thread{
    private Esdeveniment esdeveniment;
    private Random random;

    public Assistent(String name, Esdeveniment e){
        super(name);
        this.esdeveniment = e;
        this.random = new Random();
    }
   @Override
    public void run() {
        while (true) {
           
            synchronized (esdeveniment) {
                if (random.nextBoolean()) { 
                    esdeveniment.ferReserva(this);
                } else {
                    esdeveniment.cancelaReserva(this);
                }
            } 

            try {
                Thread.sleep(random.nextInt(1001));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
