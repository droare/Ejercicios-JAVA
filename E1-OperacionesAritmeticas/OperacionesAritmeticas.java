import java.util.Scanner;

public class OperacionesAritmeticas{

Double num1,num2;

public OperacionesAritmeticas(){
pedirNumero();
operaciones();
}

private void pedirNumero(){
    System.out.print ("Introduce el primer numero: ");
    Scanner Scannum = new Scanner (System.in);
    num1 = Scannum.nextDouble();
    System.out.print ("Introduce el primer numero: ");
    num2 = Scannum.nextDouble();
    Scannum.close();
}

private void operaciones(){
    System.out.print ("El valor de la suma es: "+(num1+num2)+ "\n");
    System.out.print ("El valor de la resta es: "+(num1-num2)+ "\n");
    System.out.print ("El valor de la multiplicacion es: "+(num1*num2)+ "\n");
    System.out.print ("El valor de la division es: "+(num1/num2)+ "\n");
}
    public static void main(String args[]){
    new OperacionesAritmeticas();
    }
}
