import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel {
    private JTextField cadena, exp,re;
    private JLabel res;
    private JButton but;
    private ReemplazadorCadenas remp;

    public Panel(){
        super();
        this.setPreferredSize(new Dimension(400,800));
        this.setLayout(null);
        cadena=new JTextField();
        exp=new JTextField();
        re=new JTextField();
        res=new JLabel();
        but=new JButton("Reemplazar");
        cadena.setBounds(50,100,300,50);
        exp.setBounds(50,300,300,50);
        re.setBounds(50,500,300,50);
        res.setBounds(50,600,700,50);
        but.setBounds(150,700,120,40);
        this.add(cadena);
        this.add(exp);
        this.add(re);
        this.add(res);
        this.add(but);
        remp=new ReemplazadorCadenas();
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                res.setText(remp.reemplazar(cadena.getText(),exp.getText(),re.getText()));
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Cadena a reemplazar:", 50, 97);
        g.drawString("Expresion regular:", 50, 297);
        g.drawString("Reemplazar por:", 50, 497);
        g.drawString("Cadena resultante:", 50, 597);
    }
}
