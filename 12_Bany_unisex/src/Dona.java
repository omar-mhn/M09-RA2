import java.util.Random;

public class Dona extends Thread{
    private String nom;
    private BanyUnisex lavabo;
    Random rd = new Random();

    public Dona(String nom, BanyUnisex lavabo){
        this.nom = nom;
        this.lavabo =lavabo;
    }
    @Override
    public void run(){
        try {
        System.out.println(nom + " vol entrar al bany");
        lavabo.entraDona(nom);

        int tempsUs = 2000 + rd.nextInt(1001); 
        Thread.sleep(tempsUs);

        System.out.println(nom + " ha acabat d'usar el bany");
        lavabo.surtDone(nom);
        // surtDone

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
    }
}
