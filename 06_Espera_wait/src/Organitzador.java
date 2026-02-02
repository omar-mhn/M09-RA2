public class Organitzador {

    public static void main(String[] args) {
        Esdeveniment e = new Esdeveniment(5);

        for(int i = 1; i <= 10; i++){
            Assistent a = new Assistent("Assistent-" + i, e);
            a.start();
        }
    }
}
