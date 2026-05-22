package algoritmica;

import java.util.Random;
import java.util.Arrays;

public class MatrizEnterosCuadrada {
    private int[][] matriz;

    public MatrizEnterosCuadrada(int numeroFilasCol) {
        this.matriz = new int[numeroFilasCol][numeroFilasCol];
        Random rand = new Random();
        for (int i = 0; i < numeroFilasCol; i++) {
            for (int j = 0; j < numeroFilasCol; j++) {
                this.matriz[i][j] = rand.nextInt(100); 
            }
        }
    }

    public MatrizEnterosCuadrada(int[][] m) {
        int n = m.length;
        this.matriz = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(m[i],0,matriz[i],0,n);
        }
    }


    public static void ordenaSeleccion(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = array[minIdx];
            array[minIdx] = array[i];
            array[i] = temp;
        }
    }

    public MatrizEnterosCuadrada matrizOrdenadaPorFilas() {
        int n = this.matriz.length;
        int[][] nuevaMatriz = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            nuevaMatriz[i] = new int[n];
            System.arraycopy(matriz[i], 0, nuevaMatriz[i], 0, n);          
            ordenaSeleccion(nuevaMatriz[i]);
        }
        
        return new MatrizEnterosCuadrada(nuevaMatriz);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] fila : matriz) {
            sb.append(Arrays.toString(fila)).append("\n");
        }
        return sb.toString();
    }
    
    // Getter opcional por si necesitas acceder a la matriz interna en el futuro
    public int[][] getMatriz() {
        return matriz;
    }
}
