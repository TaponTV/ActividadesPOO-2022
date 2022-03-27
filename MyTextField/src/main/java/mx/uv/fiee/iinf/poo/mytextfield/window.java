package mx.uv.fiee.iinf.poo.mytextfield;

import java.awt.FlowLayout;
import javax.swing.JFrame;

public class window extends JFrame{
    public window(){
        super("Numero Telefonico");
        MyTextField phone = new MyTextField();
        phone.setColumns(20);
        setLocationRelativeTo(null);
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout (FlowLayout.CENTER, 10, 10));
        add(phone);
    }
}
