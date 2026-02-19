
public class Filosof extends Thread {

    private String nom;
    private Forquilla forquillaEsquerra;
    private Forquilla forquillaDreta;
    private int gana;

    public Filosof(String nom, Forquilla esquerra, Forquilla dreta) {
        this.nom = nom;
        this.forquillaEsquerra = esquerra;
        this.forquillaDreta = dreta;
        this.gana = 0;
    }

    private void pensar() {
        System.out.println("Filòsof: " + nom + " pensant");
        try {
            long temps = (long) (Math.random() * 1000 + 1000);
            Thread.sleep(temps);
        } catch (InterruptedException e) {

        }
    }

    private void menjar() {
        System.out.println("Filòsof: " + nom + " menja");
        try {
            long temps = (long) (Math.random() * 1000 + 1000);
            Thread.sleep(temps);
        } catch (InterruptedException e) {

        }
    }

    private void esperar() {
        try {
            long temps = (long) (Math.random() * 500 + 500);
            Thread.sleep(temps);
        } catch (InterruptedException e) {

        }
    }

    @Override
    public void run() {
        while (true) {
            pensar();
            while (true) {
                gana++;
                System.out.println("Filòsof: " + nom + " gana=" + gana);

                boolean teEsquerra = false;

                if (!forquillaEsquerra.getEnUs()) {
                    forquillaEsquerra.setEnUs(true);
                    teEsquerra = true;
                }
                if(teEsquerra) {
                        System.out.println("Filòsof: " + nom + " agafa la forquilla esquerra " + forquillaEsquerra.getNum());
                        boolean teDreta = false;
                    
                    if(!forquillaDreta.getEnUs()){
                        forquillaDreta.setEnUs(true);
                        teDreta = true;
                    }
                    if(teDreta) {
                        System.out.println("Filòsof: " + nom + " agafa la forquilla dreta " + forquillaDreta.getNum());
                        menjar();

                        forquillaDreta.setEnUs(false);
                        forquillaEsquerra.setEnUs(false);
                        System.out.println("Filòsof: " + nom + " ha acabat de menjar");
                        gana = 0;
                        break;
                    }else{
                        forquillaEsquerra.setEnUs(false);
                        System.out.println("Filòsof: " + nom + " deixa l'esquerra(" + forquillaEsquerra.getNum() + ") i espera (dreta ocupada)");
                        esperar();
                    }
                 }else{
                    esperar();
                 }
            }
        }
    }

}
