package Swing;

//Swing es una biblioteca de clases que permite crear interfaces graficas en Java

/* Contenedores y componentes
Existen dos elementos básicos para la creacion de interfaces graficas de usuario usando Swing

-Contenedores: Elementos capaces de alberg

*/
import javax.swing.*; //Importacion de la clase swing
import java.awt.*;
import java.awt.event.*;

public class Swing extends JFrame implements ActionListener{ 
//Variables de funcion   
JTextField texto1;
JTextArea texto2;
JComboBox <String> comboBox;
JLabel etiqueta;
JList<String> lista;
String semana[]={"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
JMenuBar menuBar;
JMenu menu1, menu2, menu3;
JMenuItem menuItem21, menuItem22, menuItem31, menuItem32;
JPanel panel;
JScrollBar scrollbar;
AbstractButton abstractbutton;
//Constructor de clase
public Swing(){

Text();
ComboBox();
Label();    
List();
MenuBar();
OptionPanel();
Panel();
ScrollBar();
AbstractButton();

Frame();
}

public void Frame(){

setLayout(null); //Layout absoluto
setTitle("Frame"); //Título del JFrame
setSize(800, 600); //Dimensiones del JFrame
setResizable(true); //Dimensionable
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar proceso al cerrar ventana
//getContentPane().setBackground(new Color(255,0,0));
getContentPane().setBackground(new java.awt.Color(0,255,255)); //Color de fondo
setVisible(true); //Mostrar JFrame

}

public void Text(){

texto1=new JTextField();//Una linea
texto1.setBounds(10,100,100,20);
add(texto1);

texto2=new JTextArea();//Varias Lineas
texto2.setBounds(160,100,100,40);
add(texto2);


}

public void ComboBox(){
comboBox = new JComboBox<String>();
comboBox.setBounds(300, 100, 100, 20);
add(comboBox);

comboBox.addItem("Opcion 1");
comboBox.addItem("Opcion 2");

}

public void Label(){
etiqueta = new JLabel("Label");
etiqueta.setBounds(400, 100, 100, 20); //Posición y tamaño
etiqueta.setHorizontalAlignment(SwingConstants.CENTER); //Alineamiento horizontal derecha
add(etiqueta);//Añadir el JLabel al Frame

}

public void List(){
lista = new JList<>(semana);
lista.setBounds(550, 100, 100, 140);
lista.setVisible(true);
add(lista);
}

public void MenuBar(){
/* Creamos el JMenuBar y lo asociamos con el JFrame */
menuBar=new JMenuBar();
setJMenuBar(menuBar);

/* Creamos el primer JMenu y lo pasamos como parámetro al JMenuBar mediante el método add */
menu1=new JMenu("Opciones");
menuBar.add(menu1);

/* Creamos el segundo y tercer objetos de la clase JMenu y los asociamos con el primer JMenu creado */
menu2=new JMenu("Tamaño de la ventana");
menu1.add(menu2);
menu3=new JMenu("Color de fondo");
menu1.add(menu3);

/* Creamos los dos primeros objetos de la clase JMenuItem y los asociamos con el segundo JMenu */
menuItem21=new JMenuItem("640*480");
menu2.add(menuItem21);
menuItem21.addActionListener(this);
menuItem22=new JMenuItem("1024*768");
menu2.add(menuItem22);
menuItem22.addActionListener(this);

/* Creamos los otros dos objetos de la clase JMenuItem y los  asociamos con el tercer JMenu */
menuItem31=new JMenuItem("Rojo");
menu3.add(menuItem31);
menuItem31.addActionListener(this);
menuItem32=new JMenuItem("Verde");
menu3.add(menuItem32);
menuItem32.addActionListener(this);
}

public void OptionPanel(){

JOptionPane.showMessageDialog(null, "Hola Mundo");
JOptionPane.showInputDialog("Alola");

}

public void Panel(){
panel = new JPanel();
panel.setBounds(0, 250, 150, 150);
panel.setBackground(Color.black);
add(panel);

}

public void ScrollBar(){
scrollbar = new JScrollBar();
scrollbar.setBounds(250, 250, 30, 150);
add(scrollbar);

    
}

public void AbstractButton(){
abstractbutton = new JButton("Presioname");
abstractbutton.setBounds(350, 250, 150, 60);
abstractbutton.addActionListener(this);
add(abstractbutton);

}

public void actionPerformed(ActionEvent e) {
    if (e.getSource()==menuItem21) {
        setSize(640,480);
    }
    if (e.getSource()==menuItem22) {
        setSize(1024,768);
    }
    if (e.getSource()==menuItem31) {
        getContentPane().setBackground(new Color(255,0,0));
    }
    if (e.getSource()==menuItem32) {
        getContentPane().setBackground(new Color(0,255,0));
    }
    if(e.getSource()==abstractbutton){
        getContentPane().setBackground(new Color(200,255,255)); 
    }
}

public static void main(String[] args) {

new Swing();

}
    
}
