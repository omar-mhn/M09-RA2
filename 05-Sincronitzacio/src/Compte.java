public class Compte {
    private float saldo;
    private static Compte instance;

    public float getSaldo() {
        return saldo;
    }
    
    private Compte(float saldo) {
        if(instance != null){
            throw new RuntimeException("¡Error Use getInstance() para obtener la instancia.");
        }
        this.saldo = saldo;
    }


    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    public static Compte getInstance(){
        if(instance == null){
            instance = new Compte(0);
        }
        return instance;
    }



}
