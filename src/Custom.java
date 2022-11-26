import java.awt.*;

public class Custom {
}
class LigthMode {
    public Color cor1() {
        return new Color(98, 0, 158);
    }

    public Color cor2() {
        return new Color(255, 0, 255);
    }

    public Color cor3() {
        return new Color(255, 255, 255);
    }
}

class DarkMode {
    public Color cor1() {
        return new Color(0, 0, 158);
    }

    public Color cor2() {
        return new Color(255, 0, 0);
    }

    public Color cor3() {
        return new Color(0, 0, 0);
    }


}
class Icons {
    public Image icon1() {
        return Toolkit.getDefaultToolkit().getImage("C:\\Users\\pedro\\OneDrive\\Área de Trabalho\\2º periodo\\TGA\\bank_78392.png");
    }
    public Image icon2() {
        return Toolkit.getDefaultToolkit().getImage("C:\\Users\\pedro\\Downloads\\logo-pix-png-icone-520x520.png");
    }
}


