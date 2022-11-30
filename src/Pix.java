import java.io.*;
import java.util.Scanner;

public class Pix {

    public static StringBuilder IdPaths = new StringBuilder(new SetPaths().
            GetPaths(new URIpadrao().URICacheIdUser()));
    public static StringBuilder URI = new StringBuilder(new URIpadrao().URI()+
            IdPaths +"\\dadosPix.txt");
    public static File dadosPix = new File(String.valueOf(URI));
    public static Scanner scan, scan2;
    public static String usuario, valor;
    public static StringBuilder usuarioPix;

    public static void main(String[] args) throws IOException {
        System.out.println("Usuario:");
        scan = new Scanner(System.in);
        usuario = scan.nextLine();
        if (verificaUsuario(usuario)){
            escrevePix(usuario);
        }
        else System.out.println("usuário não encontrado. tente novamente.");
    }
    public static boolean verificaUsuario(String usuario) throws FileNotFoundException {
        scan2 = new Scanner(new File (new URIpadrao().URILoginUser()));
        while (scan2.hasNextLine()){
            String user = scan2.nextLine();
            if (usuario.equals(user)){
                return true;
            }
        }
        return false;
    }
    public static void escrevePix(String usuario) throws IOException {
        System.out.println("usuário encontrado");
        BufferedWriter wr = new BufferedWriter(new FileWriter(dadosPix, true));
        valor = scan.nextLine();
        wr.write(usuario);
        wr.newLine();
        wr.write(valor);
        wr.close();
    }

}
