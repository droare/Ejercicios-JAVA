// import java.awt.*;    
// import javax.swing.*;  
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JPanel;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.text.DecimalFormat;
// import java.text.DecimalFormatSymbols;
// import java.util.Locale;
// import java.awt.GraphicsEnvironment;
// import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.PLAIN;
public class calculadora extends JFrame{

//Variables
JLabel pantalla,celda,marca,operacion;

// JButton btn7,  btn8, btn9,     btnless,
//         btn4,  btn5, btn6,     btndiv,
//         btn1,  btn2, btn3,     btnmul,
//         btndot,btn0, btnequal, btnmore;

int numBotones = 19,al=50,an=50,size=17;
JButton boton[] = new JButton[numBotones];   
String textoBotones[] = {"C","<-","√","X","7","8","9","/","4","5","6","-","1","2","3","+",".","0","="};
int xBotones[] = {15, 80, 145, 210, 15, 80, 145, 210, 15, 80, 145, 210, 15, 80, 145, 210, 15, 80, 145};
int yBotones[] = {120, 120, 120, 120, 185, 185, 185, 185, 250, 250, 250, 250, 315, 315, 315, 315, 380, 380, 380};
int numerosBotones[] = {17, 12, 13, 14, 8, 9, 10, 4, 5, 6};
int operacionesBotones[] = {2, 3, 7, 11,15};

boolean puntoDecimal = false;
boolean nuevoNumero = true;

double num1=0,num2=0,resultado=0;
String Operacion="";

public calculadora(){

display();    
crearBotones();    
calculadoraFrame();
teclasNumeros();
puntoDecimal();
teclaC();
retroceder();
suma();
resta();
multiplicacion();
division();
raiz();
teclaResultado();
}

public void calculadoraFrame(){
    setLayout(null); //Layout absoluto
    setTitle("Calculadora"); //Título del JFrame
    setSize(285, 480); //Dimensiones del JFrame
    setResizable(false); //No redimensionable
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar proceso al cerrar ventana
    getContentPane().setBackground(new java.awt.Color(33,92,131)); //Color de fondo
    setVisible(true); //Mostrar JFrame
}
public void display(){

marca = new JLabel("CASIO");
marca.setBounds(185, 5, 90, 30); //Posición y dimensiones
marca.setForeground(Color.white); //Color de fuente
marca.setFont(new Font("Eurostile Ext Black", Font.BOLD, 20)); //Fuente
marca.setHorizontalAlignment(SwingConstants.CENTER); //Alineamiento horizontal derecha
add(marca);

celda = new JLabel("| | | |");
celda.setBounds(15, 5, 90, 30); //Posición y dimensiones
celda.setOpaque(true); //Para poder darle un color de fondo
celda.setBackground(Color.black); //Color de fondo
celda.setForeground(Color.white); //Color de fuente
celda.setBorder(new LineBorder(Color.white)); //Borde
celda.setFont(new Font("MONOSPACED", PLAIN, 15)); //Fuente
celda.setHorizontalAlignment(SwingConstants.CENTER); //Alineamiento horizontal derecha
add(celda);

pantalla = new JLabel("");
pantalla.setBounds(15, 45, 245, 60); //Posición y dimensiones
pantalla.setOpaque(true); //Para poder darle un color de fondo
pantalla.setBackground(new java.awt.Color(72,168,69)); //Color de fondo
pantalla.setForeground(Color.black); //Color de fuente
pantalla.setBorder(new LineBorder(Color.DARK_GRAY)); //Borde
pantalla.setFont(new Font("Consolas", Font.PLAIN, 24)); //Fuente
pantalla.setHorizontalAlignment(SwingConstants.RIGHT); //Alineamiento horizontal derecha
add(pantalla);
}
public void crearBotones(){

for(int i=0;i<boton.length;i++){

    boton[i] = new JButton(textoBotones[i]); //Inicializar Jbutton

    al = (i == 15) ? 115 : 50; //EL botón de mas+ sera mas alto

    boton[i].setBounds(xBotones[i],yBotones[i],an,al); //Posición y dimensiones
    boton[i].setFont(new Font("Arial",Font.BOLD,size)); //Fuente
    boton[i].setOpaque(true); //Para poder darle un color de fondo
    boton[i].setFocusPainted(false); //Para que no salga una recuadro azul cuando tenga el foco
    boton[i].setBackground(Color.DARK_GRAY); //Color de fondo
    boton[i].setForeground(Color.WHITE); //Color de fuente
    boton[i].setBorder(new LineBorder(Color.DARK_GRAY)); //Borde

    add(boton[i]); //Añado el JButton al JFrame



}
}
public void teclasNumeros(){
    for (int i = 0; i < 10; i++){

        int numBoton = numerosBotones[i];
        //System.out.print(numBoton+ " ");
        boton[numBoton].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (nuevoNumero){
                    if (!textoBotones[numBoton].equals("0")){
                        pantalla.setText(textoBotones[numBoton]);
                        nuevoNumero = false;
                    }
                }
                
                else{
                    pantalla.setText(pantalla.getText() + textoBotones[numBoton]);
                }
            }
        });
    }

}
public void puntoDecimal(){

    boton[16].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Si todavía no he añadido el punto decimal al número actual
            if (!puntoDecimal){
                pantalla.setText(pantalla.getText() + textoBotones[16]);
                puntoDecimal = true; //Ya no puedo añadir el punto decimal en este número
                nuevoNumero = false; //Por si empiezo el número con punto decimal (por ejemplo, .537)
            }
        }
    });
}
public void teclaC(){
    boton[0].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        clean();
        num1=0; num2=0; resultado=0;
        Operacion="";
        }
    });
}
public void retroceder(){

    boton[1].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        String str = pantalla.getText();
		str = str.substring(0, str.length()-1);
        pantalla.setText(str);
        }
    });
}
public void clean(){
    pantalla.setText("");
    puntoDecimal = false;
    nuevoNumero = true;
}
public void suma (){
    boton[15].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        num1 = Double.parseDouble(pantalla.getText());
        Operacion="+";
        clean();
        }
    });
}
public void resta (){
    boton[11].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        num1 = Double.parseDouble(pantalla.getText());
        Operacion="-";
        clean();
        }
    });
}
public void multiplicacion() {
    boton[3].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        num1 = Double.parseDouble(pantalla.getText());
        Operacion="X";
        clean();
        }
    });
}
public void division() {
    boton[7].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        num1 = Double.parseDouble(pantalla.getText());
        Operacion="/";
        clean();
        }
    });
}
public void raiz() {

    boton[2].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        num1 = Double.parseDouble(pantalla.getText());
        if(num1<0){
            pantalla.setText("Error");
        }else{
        // num1 = Double.parseDouble(pantalla.getText());
        clean();
        resultado = Math.sqrt(num1);
        pantalla.setText(String.format("%.4f",resultado));
        }}
    }); 
}
public void teclaResultado(){

    boton[18].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        num2 = Double.parseDouble(pantalla.getText());

        switch(Operacion){

        case "+":{
        resultado = Math.round(num1+num2);
        //pantalla.setText(String.valueOf(resultado));
        pantalla.setText(String.format("%.4f",resultado));

        break;  
        }

        case "-":{
        resultado = num1-num2;
        pantalla.setText(String.format("%.4f",resultado));
        break;  
        }

        case "X":{
        resultado = num1*num2;
        pantalla.setText(String.format("%.4f",resultado));
        break;  
        }

        case "/":{
        resultado = num1/num2;
        System.out.println(resultado);
        pantalla.setText(String.format("%.4f",resultado));

        break;  
        }

        }    


        
        }
    });



}

public static void main(String[] args) {
    new calculadora();
}
}




// public class calculadora { 

//JPanel panel = new JPanel(null);

// public static void main(String args[]) {    

// 

// JLabel lblResultado = new JLabel("",SwingConstants.RIGHT);
// lblResultado.setBackground(Color.green);
// lblResultado.setBounds(0,20,240,30);
// lblResultado.setBorder(BorderFactory.createLineBorder(Color.blue));
// panel.add(lblResultado);


// JButton btn1 = new JButton("1");
// btn1.setBounds( 0, 70, 60, 30 );
// panel.add(btn1);

// JButton btn2 = new JButton("2");
// btn2.setBounds( 60, 70, 60, 30 );
// panel.add(btn2);

// JButton btn3 = new JButton("3");
// btn3.setBounds( 120, 70, 60, 30 );
// panel.add(btn3);

// JButton btnminus = new JButton("-");
// btnminus.setBounds( 180, 70, 60, 30 );
// panel.add(btnminus);

// JButton btn4 = new JButton("4");
// btn4.setBounds( 0, 100, 60, 30 );
// panel.add(btn4);

// JButton btn5 = new JButton("5");
// btn5.setBounds( 60, 100, 60, 30 );
// panel.add(btn5);

// JButton btn6 = new JButton("6");
// btn6.setBounds( 120, 100, 60, 30 );
// panel.add(btn6);

// JButton btnentrus = new JButton("/");
// btnentrus.setBounds( 180, 100, 60, 30 );
// panel.add(btnentrus);

// JButton btn7 = new JButton("7");
// btn7.setBounds( 0, 130, 60, 30 );
// panel.add(btn7);

// JButton btn8 = new JButton("8");
// btn8.setBounds( 60, 130, 60, 30 );
// panel.add(btn8);

// JButton btn9 = new JButton("9");
// btn9.setBounds( 120, 130, 60, 30 );
// panel.add(btn9);

// JButton btnporus = new JButton("x");
// btnporus.setBounds( 180, 130, 60, 30 );
// panel.add(btnporus);

// JButton btn0 = new JButton("0");
// btn0.setBounds( 0, 160, 60, 30 );
// panel.add(btn0);

// JButton btnpoint = new JButton(".");
// btnpoint.setBounds( 60, 160, 60, 30 );
// panel.add(btnpoint);

// JButton btnequal = new JButton("=");
// btnequal.setBounds( 120, 160, 60, 30 );
// panel.add(btnequal);

// JButton btnplus = new JButton("+");
// btnplus.setBounds( 180, 160, 60, 30 );
// panel.add(btnplus);

// JFrame frame = new JFrame();
// frame.add(panel);
// frame.setPreferredSize( new Dimension(260,260));
// frame.pack();
// frame.setVisible(true);




// btn1.addActionListener(new ActionListener() {
// @Override
// public void actionPerformed(ActionEvent e) {
// lblResultado.setText(lblResultado.getText()+"1");
// }});

// btn2.addActionListener(new ActionListener() {
// @Override
// public void actionPerformed(ActionEvent e) {
// lblResultado.setText(lblResultado.getText()+"2");
// }});

// btn3.addActionListener(new ActionListener() {
// @Override
// public void actionPerformed(ActionEvent e) {
// lblResultado.setText(lblResultado.getText()+"3");
// }});      

// btn4.addActionListener(new ActionListener() {
// @Override
// public void actionPerformed(ActionEvent e) {
// lblResultado.setText(lblResultado.getText()+"4");
// }}); 

// btn5.addActionListener(new ActionListener() {
// @Override
//  public void actionPerformed(ActionEvent e) {
// lblResultado.setText(lblResultado.getText()+"5");
// }}); 

// btn6.addActionListener(new ActionListener() {
// @Override
// public void actionPerformed(ActionEvent e) {
// lblResultado.setText(lblResultado.getText()+"6");
// }}); 

// btn7.addActionListener(new ActionListener() {
// @Override
// public void actionPerformed(ActionEvent e) {
// lblResultado.setText(lblResultado.getText()+"7");
// }}); 

// btn8.addActionListener(new ActionListener() {
// @Override
// public void actionPerformed(ActionEvent e) {
// lblResultado.setText(lblResultado.getText()+"8");
// }}); 

// btn9.addActionListener(new ActionListener() {
// @Override
// public void actionPerformed(ActionEvent e) {
// lblResultado.setText(lblResultado.getText()+"9");
//  }}); 

// btn0.addActionListener(new ActionListener() {
// @Override
// public void actionPerformed(ActionEvent e) {
// lblResultado.setText(lblResultado.getText()+"0");
// }}); 

// btnpoint.addActionListener(new ActionListener() {
//     @Override
//     public void actionPerformed(ActionEvent e){
//     lblResultado.setText(lblResultado.getText()+".");

// }}); 

// btnminus.addActionListener(new ActionListener() {
// @Override
// public void actionPerformed(ActionEvent e) {
// String a = lblResultado.getText();
// lblResultado.setText("");
// }}); 

// btnequal.addActionListener(new ActionListener() {
// @Override
// public void actionPerformed(ActionEvent e) {
// }}); 






// }

// }

 