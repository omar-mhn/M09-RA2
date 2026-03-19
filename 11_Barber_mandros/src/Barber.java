import java.util.Random;

public class Barber extends Thread{
    Random rd = new Random();
    public Barber(String nom){
        super(nom);
    }

    @Override
    public void run(){
        while(true){
            try{
                Client client = Barberia.getBarberia().seguentClient();
                if(client != null){
                    System.out.println("Li toca al client " + client.getNom());
                    System.out.println("Tallant cabell a " + client.getNom());
                    Thread.sleep(900+rd.nextInt(100));
                }
            }catch(InterruptedException e){
                break;
        }
    }
    }
}
