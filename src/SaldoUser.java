import java.io.IOException;

public class SaldoUser {

    public double SaldoUsuario() {
        double a = 0;
        try {
            a = SaldoEExtrato.retornarExtrato();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return a;}}