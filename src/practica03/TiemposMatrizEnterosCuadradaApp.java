package algoritmica;

public class TiemposMatrizEnterosCuadradaApp {
    public static void main(String[] args) {
        System.out.printf("%-10s  %-20s%n", "Tamaño (n)", "Tiempo Medio (ms)");

        for (int n = 32; n <= 8192; n *= 2) {
            MatrizEnterosCuadrada m = new MatrizEnterosCuadrada(n);
            long[] tiempos = new long[10];

            for (int i = 0; i < 10; i++) {
                long inicio = System.nanoTime();

                m.matrizOrdenadaPorFilas(); 
                
                long fin = System.nanoTime();
                tiempos[i] = fin - inicio;
            }

            double tiempoMedioNs = calcularMediaDescartandoMaximo(tiempos);

            double tiempoMedioMs = tiempoMedioNs / 1_000_000.0;
            
            System.out.printf("%-10d  %-20.4f%n", n, tiempoMedioMs);
        }
    }

    private static double calcularMediaDescartandoMaximo(long[] tiempos) {
        long max = tiempos[0];
        long suma = 0;
        
        for (long t : tiempos) {
            suma += t;
            if (t > max) {
                max = t;
            }
        }

        return (double) (suma - max) / (tiempos.length - 1);
    }
}
