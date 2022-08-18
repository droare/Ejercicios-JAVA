import java.util.Scanner;

public class SumaEnteros{

int tamSumatoria;
// int resultado;

public SumaEnteros(){
LongitudSumatoria();
Sumatoria();
}

public void LongitudSumatoria(){
    
System.out.print ("Hasta que numero deseas realizar la sumatoria de numeros enteros: ");
Scanner extensionSuma = new Scanner (System.in);
tamSumatoria = extensionSuma.nextInt();   
extensionSuma.close();

}
public void Sumatoria(){

// for(int i=0;i <= tamSumatoria;i++){
// resultado += i;
//}
// resultado = ((tamSumatoria)*(tamSumatoria+1))/2;
// System.out.println("La sumatoria del 0 hasta "+tamSumatoria+" es: "+ resultado);

System.out.println("La sumatoria del 0 hasta "+tamSumatoria+" es: "+ ((tamSumatoria)*(tamSumatoria+1))/2);

}

public static void main(String args[]){
new SumaEnteros();
}


}