public class Barri {
    private Estanc estanc;
    private Fumador[] fumadors;

    public Barri() {
        estanc = new Estanc();
        fumadors = new Fumador[3];

        for (int i = 0; i < 3; i++) {
            fumadors[i] = new Fumador(i, estanc);
        }
    }

    public void execution() {
        for (Fumador f : fumadors) f.start();
        estanc.start();

        for (Fumador f : fumadors) {
            try {
                f.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        estanc.tancarEstanc();
    }

    public static void main(String[] args) {
        Barri barri = new Barri();
        barri.execution();
    }
}
