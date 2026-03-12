import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estanc extends Thread{

    private final List<Tabac> llistaTabac ;
    private final List<Paper> llistaPaper;
    private final List<Llumi> llistaLlumi;
    private boolean obert = true;
    private final Random random = new Random();
   
    public Estanc() {
        llistaTabac = new ArrayList<>();
        llistaPaper = new ArrayList<>();
        llistaLlumi = new ArrayList<>();
    }

    public void nouSubministrament(){
        int rnd = random.nextInt(3);
        if(rnd == 1) {
            addTabac(new Tabac());
        }else if(rnd == 2){
            addPaper(new Paper());
        }else{
            addLlumi(new Llumi());
        }
    }
    public void addTabac(Tabac t){
        synchronized(this){
        llistaTabac.add(t);
        System.out.println("Afegint tabac");
        notifyAll();
        }
    }
    public void addPaper(Paper p){
        synchronized(this){
            llistaPaper.add(p);
            System.out.println("Afegint Paper");
            notifyAll();
        }
    }
    
    public void addLlumi(Llumi l) {
        synchronized(this){
        llistaLlumi.add(l);
        System.out.println("Afegint Llumi");
        notifyAll();
        }
        
    }
    public Tabac venTabac() throws InterruptedException {
        synchronized(this){
            while (llistaTabac.isEmpty() && obert) {
            wait();
            }
            return llistaTabac.isEmpty() ? null : llistaTabac.remove(0);
        }
        
    }

    public Paper venPaper() throws InterruptedException {
         synchronized(this){
             while (llistaPaper.isEmpty() && obert) {
            wait();
            }
            return llistaPaper.isEmpty() ? null : llistaPaper.remove(0);
         }
       
    }

    public Llumi venLlumi() throws InterruptedException {
        synchronized(this){
            while (llistaLlumi.isEmpty() && obert) {
            wait();
            }
            return llistaLlumi.isEmpty() ? null : llistaLlumi.remove(0);
        }
    }
    public void tancarEstanc() {
        obert = false;
        synchronized (this) {
            notifyAll();
        }
        System.out.println("Estanc tancat");
    }

    @Override
    public void run() {
        System.out.println("Estanc obert");
        while (obert) {
            nouSubministrament();
            try {
                Thread.sleep(500 + random.nextInt(1001));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    
}
