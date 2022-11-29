import java.io.File;

public class URIpadrao {

    public String URI(){return "C:\\EscapeBank\\Login\\";}


    public String URICacheIdUser()
    {
        String uri ="C:\\EscapeBankCache\\id.txt";
        return verificar(uri,"C:\\EscapeBankCache\\","id.txt");
    }
    public String CacheIdUserName()
    {
       String uri = "C:\\EscapeBankCache\\username.txt";
       return verificar(uri,"C:EscapeBankCaches\\","username.txt");
    }
    public String URIIcons() {
        return "C:\\EscapeBank\\Icons\\";}
    public String URIusrdescript() {
        return "C:\\EscapeBank\\Users\\users.txt";}
    public String verificar(String uri, String mkdirs,String pasta)
    {
        File arquivo = new File(uri);
        if (!arquivo.exists())
        {
            File diretorio = new File(mkdirs);
            diretorio.mkdirs();
            File file = new File(diretorio.getAbsolutePath()+File.separator+pasta);
            return uri;
        }else return uri;
    }
}
