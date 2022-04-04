package uv.agendatelefonica;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main (String [] args) throws IOException{
        new Agenda().setVisible (true);
    }
}

class Agenda extends JFrame{
    
    private JTextField tfName; // campos de datos
    private JButton btnAdd, btnDelete, btnSave; // acciones
    private MyTextField tfPhone; //JTextfield personalizado
    // JTable nos sirve para almacenar el listado de datos que deseamos mostrar al usuario
    private JTable table;
    private DefaultTableModel model; // JTable utiliza un modelo para mantener referencia a los datos
    

    public Agenda () throws IOException{
        super ("Agenda Telefónica");
        String line,name,number;
        File tmp = new File (".");
        String path = tmp.getCanonicalPath ()+File.separator + "src" + File.separator + "main" + File.separator +  "java" + File.separator
                + "uv" +File.separator+"agendatelefonica"+File.separator;
        String fullPath = path + "Main.java";        
        File file = new File (fullPath);
        FileInputStream FileInput = new FileInputStream (file);
        InputStreamReader reader = new InputStreamReader (FileInput);
        BufferedReader bufferedReader = new BufferedReader (reader);
        //instancia el archivo txt de la agenda
        File txtFile = new File (path + "agendatelefonica.txt");
        //Si el archivo no existe, lo crea
        if(!txtFile.exists()){
            txtFile.createNewFile();
        }
        FileReader txtReader = new FileReader(txtFile);
        BufferedReader readerFile = new BufferedReader (txtReader);
        //Crea un reader sencillo para el txtreader
        
        StringBuilder builder = new StringBuilder ();
        tfName = new JTextField (); // instanciamos al JTextField nombre
        tfPhone = new MyTextField (); // instanciamos al JTextField teléfono
        tfPhone.setToolTipText ("Format: (###) #######"); // establecemos un mensaje de ayuda al usuario

        btnAdd = new JButton ("Add"); // instanciamos al botón ADD
        // manejador del evento clic del botón ADD
        btnAdd.addActionListener (new ActionListener () {
            /**
             * cada vez que el usuario hace clic se ejecuta el método actionPerformed
             *
             * @param e parámetro con información de la fuente del evento
             */
            @Override
            public void actionPerformed (ActionEvent e) {
                // validamos que los campos no estén vacíos
                if (tfPhone.getText ().length () > 0 && tfName.getText ().length () > 0) {
                    // anexamos los valores de los campos al modelo
                    model.addRow (new String [] {tfName.getText (), tfPhone.getText ()});
                }

                // si alguno de los campos está vacío, pasamos el foco a él
                if (tfName.getText ().length () == 0)
                    tfName.grabFocus ();
                else if (tfPhone.getText ().length () == 0)
                    tfPhone.grabFocus ();
            }
        });

        btnDelete = new JButton ("Delete"); // instanaciamos al botón ELIMINAR
        // manejador del evento clic del botón ELIMINAR
        btnDelete.addActionListener (new ActionListener () {
            /**
             * cada vez que el usuario hace clic se ejecuta el método actionPerformed
             *
             * @param e parámetro con información de la fuente del evento
             */
            @Override
            public void actionPerformed (ActionEvent e) {
                if (table.getSelectedRow () > -1){ // validamos si existe algún elemento seleccionado
                    model.removeRow (table.getSelectedRow ()); // si existe, se elimina del modelo
                }
            }
        });
        
        btnSave = new JButton ("Save");
        btnSave.addActionListener (new ActionListener(){
             @Override
             public void actionPerformed (ActionEvent e){
                for(int i=0;i<table.getRowCount();i++){
                    String name = table.getValueAt(i,0).toString();
                    String number = table.getValueAt(i,1).toString();
                    builder.append (String.format ("%s:%s\n",name,number));
                }
                String result = builder.toString();
                try {
                    FileOutputStream FileOutput = new FileOutputStream (txtFile);
                    FileWriter fileWriter = new FileWriter (txtFile);
                    fileWriter.write(result);
                    fileWriter.flush ();
                    fileWriter.close ();
                }catch (IOException ex) {
                    Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
        });

        // definimos la estructura del modelo que será utilizado por el JTable
        model = new DefaultTableModel ();
        model.addColumn ("Nombre"); // constará de dos columnas, nombre
        model.addColumn ("Teléfono"); // y teléfono

        // creamos al JTable y definimos algunas características
        table = new JTable (model);
        table.setGridColor (Color.LIGHT_GRAY);
        table.setShowHorizontalLines (true);
        table.setShowVerticalLines (true);

        // como contenedor para los campos de datos usamos un JPanel
        // con un layout tipo GridLayout de 2 x 2
        JPanel pnlFields = new JPanel ();
        pnlFields.setLayout (new GridLayout(2, 2));

        // agreamos los controles al panel de campos de datos
        pnlFields.add (new JLabel ("Nombre: ")); // la etiqueta no requiere más que instanciación con el texto correspodiente
        pnlFields.add (tfName);
        pnlFields.add (new JLabel ("Teléfono: "));
        pnlFields.add (tfPhone);

        // para organizar al panel de campos + el botón de acción ADD, utilizamos un BoxLayout
        // con alineación vertical
        JPanel pnlTOP = new JPanel ();
        BoxLayout boxLayout = new BoxLayout (pnlTOP, BoxLayout.Y_AXIS);
        pnlTOP.setLayout (boxLayout);
        pnlTOP.add (pnlFields);
        pnlTOP.add (btnAdd);
        pnlTOP.add (btnSave);

        // al botón ELIMINAR lo colocamos en un contenedor JPanel, con el objetivo de agegar más controles
        // en esa sección posteriormente
        JPanel pnlBOTTOM = new JPanel ();
        pnlBOTTOM.add (btnDelete);

        // establecemos las dimensiones iniciales
        setSize (new Dimension(300, 400));
        setLayout (new BorderLayout ()); // y definimos al BorderLayout como layout principal

        // colocamos cada uno de los páneles y controles que corresponden a las secciones,
        // arriba, centro, abajo
        // pnlTOP -> pnlFields + botón ADD
        // table -> JTable para el listado
        // pnlBOTTOM -> botón ELIMINAR
        add (BorderLayout.NORTH, pnlTOP);
        add (BorderLayout.CENTER, table);
        add (BorderLayout.SOUTH, pnlBOTTOM);

        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); // establece el comportamiento de cierre
        while ((line = readerFile.readLine ()) != null){
            String[] splits;
            splits = line.split(":");
            model.addRow (new String [] {splits[0],splits[1]});
        }
        readerFile.close ();
        txtReader.close ();
    }
    
}
