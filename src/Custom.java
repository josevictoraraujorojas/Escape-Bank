import java.awt.*;

public class Custom {
}
class LigthMode {
    public Color cor1() { return new Color(98, 0, 158); }

    public Color cor2() { return new Color(255, 0, 255); }

    public Color cor3() { return new Color(255, 255, 255); }
    public Color cor4() { return new Color(144, 32, 213); }
    public Color cor5() { return new Color(0, 0, 0); }
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
    URIpadrao URI = new URIpadrao();
    public Image icon1() {
        return Toolkit.getDefaultToolkit().getImage(URI.URIIcons()+"bank_78392.png");
    }
    public Image icon2() {
        return Toolkit.getDefaultToolkit().getImage(URI.URIIcons()+"logo-pix-png-icone-520x520.png");
    }
    public Image icon3(){
        return Toolkit.getDefaultToolkit().getImage(URI.URIIcons()+"emprestimo.png");
    }
    public Image icon4(){
        return Toolkit.getDefaultToolkit().getImage(URI.URIIcons()+"cartaodecredito.png");
    }
    public Image icon5(){
        return Toolkit.getDefaultToolkit().getImage(URI.URIIcons()+"avatar.png");
    }
    public Image icon6(){
        return Toolkit.getDefaultToolkit().getImage(URI.URIIcons()+"hamburger.png");
    }
}


