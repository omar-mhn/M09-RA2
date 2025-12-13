public class PRINCIPALIGUALS {

    public static void main(String[] args) {
        FIL pepe = new FIL("Pepe",Thread.MAX_PRIORITY,0);
        FIL juan = new FIL("Juan",Thread.MAX_PRIORITY,0);
        
        pepe.start();
        juan.start();
        for (int i = 0; i < 1000; i++) {
        
        }

        System.out.println("Acaba thread main");
    }
}
