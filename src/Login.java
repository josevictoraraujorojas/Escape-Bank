
import java.io.*;


public class Login {

    public Login(String login, String senha) throws IOException {

        String id = String.valueOf(Cadastro.criptografia(login));
        String URI = "C:\\Users\\arian\\OneDrive - Instituto Federal de Educa��o, Ci�ncia e Tecnologia Goiano\\ScapeBank\\";
        String caminho = URI+id;

        File diretorio = new File(caminho);

        String[] pasta = diretorio.list();
        assert pasta != null;
        String arquivo = pasta[0];

        BufferedReader le = new BufferedReader(new FileReader(caminho+"\\"+arquivo));
        String line;
        boolean verificaLogin=false;
        boolean verificaSenha=false;
        while ((line = le.readLine())!=null){
            if (line.equals(login)){
                verificaLogin=true;
            }
            else if (line.equals(String.valueOf(Cadastro.criptografia(senha)))){
                verificaSenha=true;
            }
        }
        if (verificaLogin && verificaSenha){
            System.out.println("login valido");
        }}}