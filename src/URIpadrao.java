import java.io.File;
import java.io.IOException;

public class URIpadrao {

    public String URI(){return "H:\\Meu Drive\\ScapeBank\\Login\\";}/*caminho padrão de dados no One-Drive*/
    public String URIIcons() {return "H:\\Meu Drive\\ScapeBank\\Icons\\";}/*caminho padrão de pacote de icons e imagens no One-Drive*/


    public String URICacheIdUser()
    {
        String uri ="C:\\EscapeBankCache\\id.txt";
        return ExistsURI(uri,"C:\\EscapeBankCache\\","id.txt");/*salva um arquivo no momento do cadastro com o ‘id’ do usuario temporariamente*/
    }

    public String URICacheUserName()
    {
       String uri = "C:\\EscapeBankCache\\username.txt";
       return ExistsURI(uri,"C:EscapeBankCache\\","username.txt");/*salva um arquivo no momento do Login com o nome de usuario temporariamente*/
    }

    public String URILoginUser() {return "H:\\Meu Drive\\ScapeBank\\Users\\users.txt";}/*arquivo padrão com o nome de todos os usuários*/
    public String ExistsURI(String uri, String diretorio, String pasta)
    {
        try
        {
            File URI = new File(uri);

            if (!URI.exists()) {
                File Diretorio = new File(diretorio);
                Diretorio.mkdirs();
                File file = new File(Diretorio.getAbsolutePath() + File.separator + pasta);
                file.createNewFile();
            }
            return uri;
        }catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
