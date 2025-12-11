public class PRINCIPALIGUALS {

    public static void main(String[] args) {
        FIL pepe = new FIL("Pepe");
        FIL juan = new FIL("Juan");
        
        pepe.setPriority(Thread.MAX_PRIORITY);
        juan.setPriority(Thread.MAX_PRIORITY);

        pepe.start();
        juan.start();

        System.out.println("Acaba thread main");
    }
}
