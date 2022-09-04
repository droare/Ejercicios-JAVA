package Ordenamiento;

class BusquedaAlgoritmo {
    public static int buscar( int [] arreglo, int dato) {
 int inicio = 0;
 int fin = arreglo.length - 1;
 int pos;
 while (inicio <= fin) {
     pos = (inicio+fin) / 2;
     if ( arreglo[pos] == dato )
       return pos;
     else if ( arreglo[pos] < dato ) {
  inicio = pos+1;
     } else {
  fin = pos-1;
     }
 }
 return -1;
    }
}

public class Binary{
    public static void  main (String args[]) {
 // Llenar arreglo
 int [] edades = new int [35];
 for (int i = 0; i < edades.length ; i++)
     edades[i] = i*i ;

 // Mostrar arreglo.
 for (int i = 0; i < edades.length ; i++)
     System.out.println ( "edades["+i+"]: "+  edades[i]);

 int resultado = BusquedaAlgoritmo.buscar(edades, 9);

 if (resultado != -1) {
     System.out.println ( "Encontrado en: "+  resultado);
 } else {
     System.out.println ( "El dato no se encuentra en el arreglo, o el arreglo no estÃ¡ ordenado."  );
 }
 
    }
}

// // BUSQUEDA BINARIA con metodo .binarySearch

// //public static void burbuja() {


//     int[] A = new int[]{60,22,31,45,5,16,27,88,99,410,955}; 
//     // int[] A = new int;
      
// //Imprime posicion del array donde esta el valor
//   System.out.println(Arrays.binarySearch(A,410));
      
// //}