public class Associacio {
    private int numSocis = 1000;
    private Soci [] socis ;

    public Associacio() {
        socis = new Soci[numSocis];
        for (int i = 0; i < numSocis; i++) {
            socis[i] = new Soci();
        }
    }

    public void iniciaCompteTempsSocis() {
        for (int i = 0; i < numSocis; i++) {
            socis[i].start(); 
        }
    }
    public void esperaPeriodeSocis() {
        for (int i = 0; i < numSocis; i++) {
            try {
                socis[i].join(); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void mostraBalancComptes() {
        Compte compte = Compte.getInstance();
        System.out.println("--- Informe Final de l'Associació ---");
        System.out.println("Saldo final: " + compte.getSaldo() );
    }

    public static void main(String[] args) {
        Associacio associacio = new Associacio();
        
        associacio.iniciaCompteTempsSocis();
        associacio.esperaPeriodeSocis();    
        associacio.mostraBalancComptes();   
    }
}
