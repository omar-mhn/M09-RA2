import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class BanyUnisex {
    private static final int BANY_BUIT =0;
    private static final int BANY_AMB_HOMES=1;
    private static final int BANY_AMB_DONES =2;
    private int estatActual = BANY_BUIT;
    private int ocupants = 0;
    private static final int CAPACITAT_MAX = 3;

    private Semaphore capacitat = new Semaphore(CAPACITAT_MAX,true);
    private ReentrantLock lockEstat = new ReentrantLock(true);

    public void entraHome(String nom){
        boolean haEntrat = false;
        while(!haEntrat){
            lockEstat.lock();
            try {
                if(estatActual == BANY_BUIT || estatActual ==BANY_AMB_HOMES){
                    if(capacitat.tryAcquire()){
                        ocupants++;
                        estatActual = BANY_AMB_HOMES;
                        System.out.println("Home entra al bany. Ocupants: " + ocupants);
                        haEntrat = true;
                    }
                }
            } finally {
                lockEstat.unlock();
            }
        }
    }
    public void entraDona(String nom){
        boolean haEntrat = false;
        while(!haEntrat){
            lockEstat.lock();
            try{
                if(estatActual == BANY_BUIT || estatActual == BANY_AMB_DONES){
                    if(capacitat.tryAcquire()){
                        ocupants ++;
                        estatActual = BANY_AMB_DONES;
                        System.out.println("Dona entra al bany. Ocupants: " + ocupants);
                        haEntrat = true;
                    }
                }
            }finally{
                lockEstat.unlock();
            }
        }
    }
    public void surtHome(String nom){
        lockEstat.lock();
        try{
            ocupants --;
            System.out.println("Home surt del bany. Ocupants: " + ocupants);
            capacitat.release();
            if(ocupants == 0){
                estatActual = BANY_BUIT;
            }
        }finally{
            lockEstat.unlock();
        }

    }
    public void surtDone(String nom){

    }

    public static void main(String[] args) {
        
    }
}
