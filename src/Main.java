import java.io.IOException;

public class Main {

    static boolean a = false;
    public static void main(String[] args) throws IOException {
        new Custom();

        if (!a){
            new TelaDeLogin();
        }else System.out.println("aguardar Proxima tela");
    }
    public static void VerificarLogin(Boolean B){a=B;}
}
