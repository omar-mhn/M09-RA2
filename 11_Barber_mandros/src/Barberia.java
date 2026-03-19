import java.util.LinkedList;
import java.util.Queue;

public class Barberia extends Thread {
   private Queue<Client> salaEspera;  
    private int maxCadires; 
    private Object condBarber = new Object(); 
    private static Barberia barberia;

    public Barberia(int cadires) {
        this.maxCadires = cadires;
        this.salaEspera = new LinkedList<>();
        barberia = this;
    }
    public static Barberia getBarberia(){
        return barberia;
    }

    public Client seguentClient() throws InterruptedException {
        synchronized (condBarber) {
            while (salaEspera.isEmpty()) {
                System.out.println("Ningú en espera");
                System.out.println("Barber Pepe dormint");
                condBarber.wait();  
            }
            return salaEspera.poll(); 
        }
    }

    public void entrarClient(Client client) {
        synchronized (condBarber) {
            if (salaEspera.size() < maxCadires) {
                salaEspera.add(client);
                System.out.println("Client " + client.getNom() + " en espera");
                condBarber.notifyAll();
            } else {
                System.out.println("No queden cadires, client " + client.getNom() + " se'n va"); 
            }
        }
    }
    @Override
    public void run() { 
        try {
           
            for (int i = 1; i <= 10; i++) {
                entrarClient(new Client(i));
                Thread.sleep(500); 
            }
            
            Thread.sleep(10000); 
            
            for (int i = 11; i <= 20; i++) {
                entrarClient(new Client(i));
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) { 
        Barberia b = new Barberia(3); 
        Barber barber = new Barber("Pepe");
        
        barber.start(); 
        b.start(); 
    }
    
}

