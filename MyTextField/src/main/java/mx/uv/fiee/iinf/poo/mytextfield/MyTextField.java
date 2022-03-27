package mx.uv.fiee.iinf.poo.mytextfield;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.JTextField;

public class MyTextField extends JTextField implements KeyListener{
    
    Pattern pattern = Pattern.compile ("\\(\\d{3}\\)\\s{0,1}\\d{7}");

    public MyTextField () {
        this.addKeyListener (this);
    }
    
    @Override
    public void keyTyped (KeyEvent e) {
        char c = e.getKeyChar();
        String text = this.getText();
        if((!Character.isDigit(c) && c != '(' && c != ')' && c != ' ')
                ||(c == '(' && text.contains("("))|| (c == ')' && text.contains(")"))|| (c == ' ' && text.contains(" ")))
            e.consume();
        if(text.length()>12)
                e.consume();    
    }
    
    @Override
    public void keyPressed (KeyEvent e) {
    }

    @Override
    public void keyReleased (KeyEvent e) {
         ValidateFormatText();
    }
    
    public void ValidateFormatText(){
        Matcher matcher = pattern.matcher(this.getText());
         if(!matcher.find ()) {
             this.setBackground(Color.RED);
             this.setForeground(Color.WHITE);
        }else{
             this.setBackground(Color.WHITE);
             this.setForeground(Color.RED);
        }
    }

    @Override
    public void paint (Graphics g) {
        super.paint (g);
        this.setSize(250, 30);
//        g.setColor (Color.red);
//        g.drawRect (getSize ().width - 25, getSize ().height - 30, 20, 20);
//
//        g.setColor(Color.red);
//        g.fillRect (getSize ().width - 25, getSize ().height - 30, 20, 20);
//
//        g.dispose ();

        try {
            URL url = getClass ().getResource ("/images/ico.png");
            File file = new File (url.getPath ());
            BufferedImage img = ImageIO.read (file);
            g.drawImage (img, getSize ().width - 28, getSize ().height - 28, null);
        }
        catch (IOException ex) {
            System.out.println (ex.getMessage ());
        }
    }   
}
