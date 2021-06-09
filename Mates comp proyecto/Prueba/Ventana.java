import javax.swing.*;

public class Ventana extends JFrame {
    private Panel p;

    public Ventana(){
        super("Reemplazador de cadenas A01635597");
        p=new Panel();
        this.add(p);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Ventana v=new Ventana();
    }
}
