
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Almacen almacen = new Almacen("Almacen del GEANT");
        almacen.cargarArchivo("input/altasprueba.txt");

        almacen.PrintOrdenado(true);
        SistemaPOS sistemaPOS = new SistemaPOS(almacen);
        sistemaPOS.InteractiveCalcularImporte();

      // cargar los productos desde el archivo "altasprueba.txt"
      // listar los productos ordenados por codigo, junto con su cantidad existente
      //emitir el valor del stock
      // simular las ventas a partir del archivo "ventaspruebas.txt"
      // simular la eliminación de productos a partir del archivo "elimPrueba.txt"
      // listar los productos ordenados por codigo, junto con su cantidad existente

    }
}

