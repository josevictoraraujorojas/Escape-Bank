public class Main {
    static boolean a = false;
    public static void main(String[] args) {

        new TelaDeLogin();
        if (a){
            new TelaDeCadastroCliente();
        }
    }
    public static void verificarcadastrodecliente(Boolean B){a=B;}
}
