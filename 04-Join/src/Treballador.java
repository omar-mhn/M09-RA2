import java.util.Random;

public class Treballador extends Thread {

    private float sou_anual_brut;
    private int edat_inici_treball;
    private int edat_fi_treball;
    private int edat_actual;
    private float cobrat;
    private Random rdn = new Random();

    

    public Treballador(String name, float sou_anual_brut, int edat_inici_treball, int  edat_fi_treball) {
        super(name);
        this.sou_anual_brut = sou_anual_brut;
        this.edat_inici_treball = edat_inici_treball;
        this.edat_fi_treball = edat_fi_treball;
        this.cobrat = 0.0f;
        edat_actual = 0;
    }
    public int getEdat() {
        return edat_actual;
    }
    public float getCobrat() {
        return cobrat;
    }

    public void cobra(){
        this.cobrat += (this.sou_anual_brut / 12.0f);

    }
    public void pagaImpostos(){
        float mensualitat = this.sou_anual_brut/ 12.0f;
        float impostos = mensualitat * 0.24f;
        this.cobrat -= impostos;
    }
    @Override
    public void run(){
        for (int i = 0; i <= edat_fi_treball; i++) {
                int intervalAleatori = rdn.nextInt(10);
                edat_actual = i;
                if(edat_actual>= edat_inici_treball && edat_actual< edat_fi_treball ){
                    for (int j = 0; j < 12; j++) {
                        cobra();
                        pagaImpostos();
                        try{
                            Thread.sleep(intervalAleatori);
                        }catch(InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            
        }
    }
}


