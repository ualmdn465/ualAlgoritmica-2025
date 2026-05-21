public class TiemposSubsecuenciaApp {

    private static final int REPETICIONES = 10;

    public static void main(String[] args) {
        System.out.println("Análisis de Tiempos — Subsecuencia de Suma Máxima");
        System.out.printf("%-6s | %-18s | %-18s | %-18s%n", "n", "FB (ns)", "Mejorado (ns)", "Lineal (ns)");
        System.out.println("-".repeat(65));

        int n = 64;
        while (n <= 8192) {

            Subsecuencia sub = new Subsecuencia(n);

            // FUERZA BRUTA
            long tTotalFB = 0, tMaxFB = 0;
            for (int i = 0; i < REPETICIONES; i++) {
                long inicio = System.nanoTime();
                sub.SubsecuenciaFuerzaBruta();
                long t = System.nanoTime() - inicio;
                tTotalFB += t;
                if (t > tMaxFB) tMaxFB = t;
            }
            double mediaFB = (tTotalFB - tMaxFB) / 9.0;

            // MEJORADO
            long tTotalMej = 0, tMaxMej = 0;
            for (int i = 0; i < REPETICIONES; i++) {
                long inicio = System.nanoTime();
                sub.SubsecuenciaMejorado();
                long t = System.nanoTime() - inicio;
                tTotalMej += t;
                if (t > tMaxMej) tMaxMej = t;
            }
            double mediaMej = (tTotalMej - tMaxMej) / 9.0;

            // LINEAL
            long tTotalLin = 0, tMaxLin = 0;
            for (int i = 0; i < REPETICIONES; i++) {
                long inicio = System.nanoTime();
                sub.SubsecuenciaLineal();
                long t = System.nanoTime() - inicio;
                tTotalLin += t;
                if (t > tMaxLin) tMaxLin = t;
            }
            double mediaLin = (tTotalLin - tMaxLin) / 9.0;

            // Resultados
            System.out.printf("%-6d | %-18.2f | %-18.2f | %-18.2f%n", n, mediaFB, mediaMej, mediaLin);

            n *= 2;
        }
    }
}
