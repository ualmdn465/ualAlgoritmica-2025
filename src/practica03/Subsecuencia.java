public class Subsecuencia {
    private int[] array;
    private int primer;
    private int ultimo;
    private int suma;

    public Subsecuencia(int numeroElementos) {
        array = new int[numeroElementos];
        for (int i = 0; i < numeroElementos; i++) {
            array[i] = (int) (Math.random() * 199) - 99;
        }
    }

    public Subsecuencia(int[] arrayEnteros) {
        array = arrayEnteros.clone();
    }

    public int getPrimer() { return primer; }
    public int getUltimo() { return ultimo; }
    public int getSuma()   { return suma;   }

    public void SubsecuenciaFuerzaBruta() {
        suma = 0; primer = 0; ultimo = -1;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                int thisSuma = 0;
                for (int k = i; k <= j; k++) {
                    thisSuma += array[k];
                }
                if (thisSuma > suma) {
                    suma = thisSuma; primer = i; ultimo = j;
                }
            }
        }
    }

    public void SubsecuenciaMejorado() {
        suma = 0; primer = 0; ultimo = -1;
        for (int i = 0; i < array.length; i++) {
            int thisSuma = 0;
            for (int j = i; j < array.length; j++) {
                thisSuma += array[j];
                if (thisSuma > suma) {
                    suma = thisSuma; primer = i; ultimo = j;
                }
            }
        }
    }

    public void SubsecuenciaLineal() {
        suma = 0; primer = 0; ultimo = -1;
        int thisSuma = 0;
        int tempInicio = 0;
        for (int j = 0; j < array.length; j++) {
            thisSuma += array[j];
            if (thisSuma > suma) {
                suma = thisSuma;
                primer = tempInicio;
                ultimo = j;
            } else if (thisSuma < 0) {
                thisSuma = 0;
                tempInicio = j + 1;
            }
        }
    }
}