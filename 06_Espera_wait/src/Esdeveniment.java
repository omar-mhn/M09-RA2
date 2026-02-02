import java.util.ArrayList;
import java.util.List;

public class Esdeveniment {
    private List<Assistent> assistents;
    private int placesDisponibles;

    public Esdeveniment(int maxPlaces){
        this.placesDisponibles = maxPlaces;
        this.assistents = new ArrayList<>();
    }

    public void ferReserva(Assistent a){
        while (placesDisponibles == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        assistents.add(a);
        placesDisponibles --;
        System.out.println(a.getName() + " ha fet una reserva. Places disponibles: " +placesDisponibles);
        notifyAll();

    }

    public void cancelaReserva(Assistent a ){
        if(assistents.contains(a)){
            assistents.remove(a);
            placesDisponibles ++;
            System.out.println(a.getName() + " ha cancel·lat una reserva. Places disponibles: " + placesDisponibles);
            notifyAll();
        } else {
            System.out.println(a.getName() + " no ha pogut cancel·lar una reserva inexistent. Places disponibles: " + placesDisponibles);
        }
    }





}

