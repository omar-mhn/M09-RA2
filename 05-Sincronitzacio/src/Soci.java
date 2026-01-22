import java.util.Random;

public class Soci extends Thread {
    
    Compte compte;
    private float aportacio = 10f;
    private int esperaMax = 100;
    Random rnd = new Random(); 
    private int maxAnys = 10;
    public Compte getCompte() {
        return compte;
    }
    public Soci(){
        this.compte = Compte.getInstance();
    }
    @Override
    public void run(){
        for (int any = 1; any <= maxAnys; any++) {
            for (int mes = 1; mes <= 12 ; mes++) {
                synchronized(compte){
                    float saldoActual = compte.getSaldo();
                    if(mes %2 == 0){
                        compte.setSaldo(saldoActual + aportacio);
                    }else{
                        compte.setSaldo(saldoActual - aportacio);
                    }
                     try {
                        Thread.sleep(rnd.nextInt(esperaMax));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
               
            }
        }
       
    }
}
