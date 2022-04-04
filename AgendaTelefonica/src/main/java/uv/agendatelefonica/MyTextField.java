package uv.agendatelefonica;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
}
