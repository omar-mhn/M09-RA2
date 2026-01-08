public class Coet {
    private Motor[] motors = new Motor[4];
    
    public Coet() {
        for (int i = 0; i < 4; i++) {
            motors[i] = new Motor(i);
        }
    }
    public void arranca() {
        for (Motor m : motors) {
            m.start(); 
        }
    }

    public static void main(String[] args) {
        
    }

}
