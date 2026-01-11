
public class Motor extends Thread {
    private int PotObjectiu = 0;
    private int potActual = 0;
    private String estat;
    private boolean running = true; 

    public Motor(String name) {
        super(name);
    }

    public void setPotencia(int p) {
        this.PotObjectiu = p;
    }

    @Override
    public void run() {
        while (running) {
            while (potActual != PotObjectiu) {
                try {
                    
                    Thread.sleep((int) (Math.random() * 1000) + 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (PotObjectiu < potActual) {
                    potActual--;
                    estat = "Decre.";
                } else {
                    potActual++;
                    estat = "Incre.";
                }

                System.out.println(String.format("%s: %s Objectiu: %d Actual: %d", 
                    getName(), estat, PotObjectiu, potActual));
            }

            if (PotObjectiu == 0 && potActual == 0) {
                running = false;
            } else {
                System.out.println(String.format("%s: FerRes Objectiu: %d Actual: %d", 
                    getName(), PotObjectiu, potActual));
                
                while (potActual == PotObjectiu && PotObjectiu != 0) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}