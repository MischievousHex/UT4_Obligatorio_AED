import java.util.Scanner;

public class SistemaPOS
{
    private Almacen catalogue;
    private static Scanner scanner;

    public Almacen getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(Almacen catalogue) {
        this.catalogue = catalogue;
    }

    public SistemaPOS(Almacen catalogue) {
        this.catalogue = catalogue;
        SistemaPOS.scanner = new Scanner(System.in);
    }

    public Producto ObtenerProducto(String codigo, boolean log){
        Producto prod = this.catalogue.buscarPorCodigo(codigo);
        if(prod == null){
            if(log)
                System.out.println("Producto con código " + codigo + " no encontrado.");
        }
        return prod;
    }

    public double ObtenerPrecio(String codigo, boolean log){
        Producto prod = ObtenerProducto(codigo, log);
        if(prod == null)
            return 0;
        if(log)
            System.out.println("Producto " + prod.getEtiqueta() + ": " + prod.getNombre() + ": $" + prod.getPrecio());
        return prod.getPrecio();
    }

    public int ObtenerStock(String codigo, boolean log){
        Producto prod = ObtenerProducto(codigo, log);
        if(prod == null)
            return 0;
        int stock = prod.getStock();
        if(stock == 0)
            System.out.println("Producto " + prod.getEtiqueta() + ": " + prod.getNombre() + " fuera de stock.");
        else
            System.out.println("Stock disponible.");
        return stock;
    }

    public double InteractiveCalcularImporte(){
        String codigo = "un codigo";
        double importe = 0;
        while(!codigo.strip().equalsIgnoreCase("finalizar")) {
            System.out.print("Ingrese el código del producto (escriba 'finalizar' para terminar): ");
            codigo = scanner.nextLine();
            System.out.println();
            if(catalogue.buscarPorCodigo(codigo) == null)
                System.out.println("El producto no existe");
            else {
                int stock = ObtenerStock(codigo, true);
                if (stock > 0) {
                    importe += ObtenerPrecio(codigo, true);
                    catalogue.restarStock(codigo, 1);
                    System.out.println("Operación completada.");
                }
            }
            System.out.println("Total: " + importe + "\n");
        }
        System.out.println("\nImporte total: " + importe + "\n");
        return importe;
    }


    public double CalcularImporte(String[] codigos){
        double importe = 0;
        for (String cod :
                codigos) {
            importe += ObtenerPrecio(cod, false);
        }
        return importe;
    }
}
