package src;
public class FUTBOLISTA extends Thread{

    public static final int NUM_JUGADORS = 11;
    public static final int NUM_TIRADES = 20;
    public static final float PROBABILITAT = 0.5f;

    private int ngols;
    private int ntirades;
    

    public int getNgols() {
        return ngols;
    }
    public int getNtirades() {
        return ntirades;
    }
    public FUTBOLISTA(String nom){
        super(nom);
        this.ngols = 0;
        this.ntirades = 0;

    }
    @Override
    public void run(){
        for (int i = 0; i < NUM_TIRADES; i++) {
            ntirades++;
            if(Math.random() < PROBABILITAT){
                ngols++;
            }
        }
    }

    public static void main(String[] args) {
        String [] noms = {"Piqué","Vinicius","Torres","Ramos","Ronaldo","Lewan","Belli","Arnau","Aspas","Messi","MBapé"};

        FUTBOLISTA [] equip = new FUTBOLISTA[FUTBOLISTA.NUM_JUGADORS];

        System.out.println("Inici dels xuts --------------------");

        for (int i = 0; i < FUTBOLISTA.NUM_JUGADORS; i++) {
            
            equip[i] = new FUTBOLISTA(noms[i]);
            equip[i].start();
        }
        

        for (int i = 0; i < FUTBOLISTA.NUM_JUGADORS; i++) {
        try {
            equip[i].join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final dels xuts --------------------");
        System.out.println("Estadístiques:");
        
        for (int j = 0; j < FUTBOLISTA.NUM_JUGADORS; j++) {
            System.out.printf("%-10s -> %d%n", equip[j].getName(), equip[j].getNgols());
        }
    }
    }
}
