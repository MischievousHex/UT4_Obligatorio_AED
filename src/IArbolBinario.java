public interface IArbolBinario<T>
{
    /**
     * Obtener la altura de este nodo.
     * @return La altura de este nodo.
     */
    public int GetAltura();

    /**
     * Obtener el nivel de este nodo.
     * @return El nivel de este nodo.
     */
    public int GetNivel();

    /**
     * Obtener la cantidad de hojas de este nodo.
     * @return La cantidad de hojas de este nodo.
     */
    public int GetHojas();

    /**
     * Insertar un nodo en este árbol.
     */
    public void Insertar(INodoAB<T> nodoAB);

    /**
     * Obtener un nodo del árbol según su etiqueta.
     * @return El nodo si es encontrado, o null si no pertenece al árbol.
     */
    public INodoAB<T> GetNodo(Comparable<T> etiqueta);
}
