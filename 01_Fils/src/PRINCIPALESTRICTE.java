public class PRINCIPALESTRICTE {
    public static void main(String[] args) {
        FIL juan = new FIL("Juan",Thread.MIN_PRIORITY,100);
        FIL pepe = new FIL("Pepe",Thread.MIN_PRIORITY,100);

        System.out.println("Acaba thread main");
        juan.start();
        pepe.start();
    }
    

    
}
