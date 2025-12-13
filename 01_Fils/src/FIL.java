public class FIL extends Thread {

    private int delay;
    public FIL(String name,int priority, int delay) {
        super(name);
        this.delay = delay;
        setPriority(priority);
    } 
    
    @Override
    public void run(){
        for (int i = 1; i < 10 ; i++) {
            System.out.printf("%s %d%n",getName(),i);

        
            
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            
        }
        
        System.out.println("Acaba el fil "+getName());
    }
    
}
