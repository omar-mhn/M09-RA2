public class FIL extends Thread {


    public FIL(String name) {
        super(name);
    } 
    
    @Override
    public void run(){
        for (int i = 1; i < 10 ; i++) {
            System.out.printf("%s %d%n",getName(),i);
            for (int j = 0; j < 1000; j++) {
                
            }
        }
        System.out.println("Acaba el fil "+getName());
    }
    
}
