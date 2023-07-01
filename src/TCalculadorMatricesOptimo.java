public class TCalculadorMatricesOptimo<T> implements ICalculadorMatricesOptimo
{

    int[][] C;
    int[][] R;
    int[][] W;

    @Override
    public void EncontrarOptimo(int cantidadElementos, int[] frecuenciaExito, int[] frecuenciaNoExito) {

        this.C = new int[cantidadElementos][cantidadElementos];
        this.W = new int[cantidadElementos][cantidadElementos];
        this.R = new int[cantidadElementos][cantidadElementos];

        // Calcular C y W de la primera "linea" (00, 11, 22, 33, ...), todos tienen C = 0, W = q y R = 0
        for(int i = 0; i < cantidadElementos; i++){
            C[i][i] = 0;
            W[i][i] = frecuenciaExito[i];
            R[i][i] = 0;
        }

        // Calcular W
        for(int m = 0; m <= cantidadElementos; m++){
            for(int i = 0; i < (cantidadElementos - m); i++){
                int j = i + m;
                if(j != 0)
                    // Calculo de W
                    W[i][j] = W[i][j-1] + frecuenciaExito[j] + frecuenciaNoExito[j];
        // Calcular C y R
                // Obtener todos los Cs necesarios
                int[] Cs = new int[j-i+1];
                int x = 0;
                for(int iii = i+1; iii <= j; iii++){
                    Cs[x] = C[i][iii-1] + C[iii][j];
                    x++;
                }
                // Obtener el minimo
                int minimo = Cs[0];
                int elegido = 0;
                for(int valor = 0; valor < Cs.length; valor++){
                    if(Cs[valor] < minimo) {
                        minimo = Cs[valor];
                        // el valor elegido es de i<k<=j, asi que sumamos i+1 para que sea un k valido
                        elegido = valor + 1 + i;
                    }
                }
                // Calculo de C
                C[i][j] = minimo + W[i][j];

                // Calculo de R
                R[i][j] = elegido;
            }
        }
    }

    @Override
    public void ArmarArbol(int i, int j, Comparable[] claves, TArbolBB elArbol) {

    }
}
