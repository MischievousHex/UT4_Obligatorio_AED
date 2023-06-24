
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // Instanciamos el árbol
        TArbolBB<String> ArbolBinario = new TArbolBB<>();

        // Creamos a Franco
        TElementoAB<String> franco = new TElementoAB<>("1", "Franco");

        // Franco en el árbol
        ArbolBinario.insertar(franco);

        // Test
        assert (ArbolBinario.ObtenerMayor().equals(franco));

        System.out.println("Todas las pruebas unitarias pasaron, que listo que sos Goku");

    }
}

