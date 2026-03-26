import java.util.Random;

public class Home extends Thread {
    private String nom;
    private BanyUnisex lavabo;
    Random rd = new Random();

    public Home(String nom, BanyUnisex lavabo){
        super(nom);
        this.lavabo = lavabo;
    }
    @Override
    public void run(){
        try {
            System.out.println(nom + " vol entrar al bany");
            lavabo.entraHome(nom);

            int tempsUs = 1000 + rd.nextInt(1001);
            Thread.sleep(tempsUs);

            lavabo.surtHome(nom);
            System.out.println(nom + " ha acabat d'usar el bany");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
