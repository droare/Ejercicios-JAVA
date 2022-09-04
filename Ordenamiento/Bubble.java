package Ordenamiento;
public class Bubble {

public static void main(String[] args) {

    int[] A = new int[]{60,22,31,45,5,16,27,88,99,410}; 
    // int[] A = new int;
      int i, j, aux;
      for (i = 0; i < A.length - 1; i++) {
          for (j = 0; j < A.length - i - 1; j++) {       
              if (A[j + 1] < A[j]) {
                  aux = A[j + 1];
                  A[j + 1] = A[j];
                  A[j] = aux;
              }
          }
      }

      for(int k=0;i<A.length;k++)
      {
          System.out.println(A[k]);
      }

}
    
}

// //BURBUJA CON SORT

// //public class Main {
// //    public static void main(String[] args) {


//     int[] A = new int[]{60,22,31,45,5,16,27,88,99,410,955}; 
//     // int[] A = new int;
      
//     Arrays.sort(A);

//       for(int k=0;i<A.length;k++)
//       {
//           System.out.println(A[k]);
//       }
// //}