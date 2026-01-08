import java.util.Random;

public class Motor extends Thread {
    private int potenciaAct ;
    private int potenciaObj ; 
    private int numMotor ;
    private Random random = new Random();
    public Motor(int numMotor ){
        this.numMotor = numMotor;
        this.potenciaAct = 0;
        this.potenciaObj = 0;
    }
    public void setPotencia(int p){
        this.potenciaObj = p;
    }
    @Override
    public void run(){
        while (potenciaAct != 0 || potenciaObj != 0) {
                try{
                    if(potenciaAct!= potenciaObj){
                        int intervalAleatori = random.nextInt(1001)+1000;
                        Thread.sleep(intervalAleatori);
                        if(potenciaAct < potenciaObj){
                            potenciaAct ++;
                            System.out.println("Motor " + numMotor + ": Incre. Objectiu: " + potenciaObj + " Actual: " + potenciaAct);
                        }else{
                            potenciaAct --;
                            System.out.println("Motor " + numMotor + ": Decre. Objectiu: " + potenciaObj + " Actual: " + potenciaAct);
                        }
                    }else{
                        Thread.sleep(100);
                    }

                }catch(InterruptedException e) {
                    e.printStackTrace();
            }
            
        }
    }
}
