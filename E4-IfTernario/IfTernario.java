import java.util.Scanner;

public class IfTernario {

public static void main(String[] args) {

Scanner num = new Scanner(System.in);
String valor;
System.out.println("Introduzca un numero entero");
int condicion = num.nextInt();
num.close();

//Uso de if ternario
valor = (condicion >= 10) ? "Es mayor/igual que 10":"Es menor que 10";

System.out.println(valor);

//Uso de if ternario anidado

valor = (condicion >= 10) ? "Es mayor/igual que 10":(condicion <= 0) ? "Es menor/igual que 0":(condicion > 0) ? "Esta entre el 0 y el 9":"No es un numerp";
System.out.println(valor);

}
}