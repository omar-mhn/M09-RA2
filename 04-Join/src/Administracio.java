public class Administracio {

    private int num_poblacio_activa = 50;
   private Treballador[] poblacio_activa;

    
    public Administracio() {
        this.poblacio_activa = new Treballador[num_poblacio_activa];
        for (int i = 0; i < num_poblacio_activa; i++) {
            
            this.poblacio_activa[i] = new Treballador("Ciutadà-" + i, 25000.0f, 20, 65);
        }
    }

    public void executarSimulacio() {
        // 1. Démarrer tous les threads
        for (Treballador t : poblacio_activa) {
            t.start();
        }

        
        for (Treballador t : poblacio_activa) {
            try {
                t.join(); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        
        for (Treballador t : poblacio_activa) {
            
            System.out.printf("%s -> edat: %d / total: %.2f%n ", t.getName(),t.getEdat(), t.getCobrat());
        }
    }
    public static void main(String[] args) {
        Administracio adm = new Administracio();
        adm.executarSimulacio();

    
        
    }
}
