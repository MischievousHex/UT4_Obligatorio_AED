public class Almacen implements IAlmacen {

    private String nombre;
    private String direccion;
    private String telefono;

    private TArbolBB<Producto> productos;

    public Almacen(String nombre) {
        this.nombre = nombre;
        this.productos = new TArbolBB<Producto>();
    }

    @Override
    public void insertarProducto(Producto unProducto) {
        this.productos.insertar(new TElementoAB<>(unProducto.getEtiqueta(), unProducto));
    }

  

    @Override
    public String imprimirProductos() {
        Lista<Producto> prods = productos.inorden();
        prods.imprimir();
        return prods.toString();
    }

    @Override
    public Boolean agregarStock(Comparable clave, Integer cantidad) {
        Producto prod = productos.buscar(clave).getDatos();
        Integer pre = prod.getStock();
        prod.agregarStock(cantidad);
        return(prod.getStock().equals(pre + cantidad));
    }

    @Override
    public Integer restarStock(Comparable clave, Integer cantidad) {
        Producto prod = productos.buscar(clave).getDatos();
        prod.agregarStock(-cantidad);
        return prod.getStock();
    }

    @Override
    public Producto buscarPorCodigo(Comparable clave) {
        TElementoAB<Producto> prod = productos.buscar(clave);
        if (prod == null)
            return null;
        return prod.getDatos();
    }

    @Override
    public boolean eliminarProducto(Comparable clave) {
        productos.eliminar(clave);
        return productos.buscar(clave) == null;
    }

    public void cargarArchivo(String nombreArchivo){
        String[] archivo = ManejadorArchivosGenerico.leerArchivo(nombreArchivo);
        for (String linea :
                archivo) {
            String[] datos = linea.split(",");
            Producto prod = new Producto(datos[0], datos[1]);
            prod.setPrecio(Integer.parseInt(datos[2]));
            prod.setStock(Integer.parseInt(datos[3]));
            this.insertarProducto(prod);
        }
    }
 
    public void PrintOrdenado(boolean stock){
        Lista<Producto> lista = this.productos.inorden();
        if(!stock)
            lista.imprimir();
        else{
            Nodo<Producto> aux = lista.getPrimero();
            while(aux != null){
                System.out.println(aux.getDato().getEtiqueta() + " " + aux.getDato().getStock());
                aux = aux.getSiguiente();
            }
        }
    }


  

   

   

   

}
