public class PRINCIPALDIFERENTS {
    public static void main(String[] args) {
    FIL pepe = new FIL("Pepe");
    FIL juan = new FIL("Juan");

    pepe.setPriority(Thread.MAX_PRIORITY);
    juan.setPriority(Thread.MIN_PRIORITY);

    pepe.start();
    juan.start();

    for (int i = 0; i < 1000; i++) {
        
    }
    pepe.setPriority(Thread.MIN_PRIORITY);
    juan.setPriority(Thread.MAX_PRIORITY);

   

    System.out.println("Acaba thread main");
    }


}
