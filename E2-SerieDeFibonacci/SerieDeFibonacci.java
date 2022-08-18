//package E2-SerieDeFibonacci;
import java.util.Scanner;
import java.util.Arrays;

public class SerieDeFibonacci {
int tamSerie;

public SerieDeFibonacci(){

TamanioSerie();
Fibonacci();
}

public void TamanioSerie(){

System.out.print ("Cuantos elementos de la serie deseas que se muestren: ");
Scanner Scannum = new Scanner (System.in);
tamSerie = Scannum.nextInt();   
Scannum.close();

}

public void Fibonacci() {
//0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ....
int seriefibonacci [] = new int[tamSerie];
for(int i=0;i<tamSerie;i++){
if(i==0){
seriefibonacci[i]=i;
}else if(i==1){
seriefibonacci[i]=i;
}else{
seriefibonacci[i]=seriefibonacci[i-1]+seriefibonacci[i-2];
}
//System.out.println(seriefibonacci[tamSerie]);
}
System.out.println(Arrays.toString(seriefibonacci));  
}

public static void main(String args[]) {
new SerieDeFibonacci();
}

    
}
