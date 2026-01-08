import java.util.Random;

public class DormAleatori extends Thread{

    private long creationTime;
    public DormAleatori (String name) {
        super(name);
        creationTime = System.currentTimeMillis();
    }

    @Override
    public void run (){
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            // genera un interval aleatori 
           int intervalAleatori = random.nextInt(1000);

           long time = System.currentTimeMillis() - creationTime;

            System.out.printf("%10s(%d) a dormir %dms total %dms%n", 
                  getName(), i, intervalAleatori, time);

            try{
                Thread.sleep(intervalAleatori);
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
          
        }
    }
    public static void main(String[] args) {
        DormAleatori pep = new DormAleatori("Pep");
        DormAleatori joan = new DormAleatori("Joan");

        pep.start();
        joan.start();
        System.out.println("----------------Fi main---------------");
    }
 
}
