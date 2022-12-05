import java.io.IOException;

public class Main {

    static boolean a = false;
    public static void main(String[] args) throws IOException {
        new Custom();

        if (!a){
            new LoginScreen();
        }else new HomeScreen();
    }
    public static void VerificarLogin(Boolean B){a=B;}
}
