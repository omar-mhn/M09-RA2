public class Taula {
    private Filosof[] comensals;
    private Forquilla[] forquilles;

        public Taula(int numFilosofs) {
        comensals = new Filosof[numFilosofs];
        forquilles = new Forquilla[numFilosofs];

        
        for (int i = 0; i < numFilosofs; i++) {
            forquilles[i] = new Forquilla(i);
        }

        
        for (int i = 0; i < numFilosofs; i++) {
            Forquilla esq = forquilles[i];
            Forquilla dret = forquilles[(i + 1) % numFilosofs]; 
            comensals[i] = new Filosof(i, esq, dret);
        }
    }

    public void showTaula() {
        for (int i = 0; i < comensals.length; i++) {
            System.out.println("Comensal: " + i + 
                               " esq:" + forquilles[i].getNum() + 
                               " dret:" + forquilles[(i + 1) % forquilles.length].getNum());
        }
        System.out.println("-------------------------");
    }

    public void cridarATaula() {
        for (Filosof f : comensals) { f.start(); } 
    }

    public static void main(String[] args) {
        Taula taula = new Taula(5); 
        taula.showTaula();
        taula.cridarATaula();
    }
}
