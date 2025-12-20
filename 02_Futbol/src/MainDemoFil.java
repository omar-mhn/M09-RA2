package src;

public class MainDemoFil {

    public static void main(String[] args) {
        Thread filAct = Thread.currentThread();

        System.out.println("MainDemoFil.main:");

        System.out.printf("Prioritat -> %d, Nom -> %s%n", filAct.getPriority(), filAct.getName());

        System.out.println("toString() -> " + filAct.toString());   
    }
}
