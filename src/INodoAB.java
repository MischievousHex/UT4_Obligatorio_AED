public interface INodoAB<T>
{
    /**
     * Obtener el hijo izquierdo del nodo.
     * @return El nodo correspondiente el hijo izquierdo de este nodo.
     */

    public INodoAB<T> GetHijoIzquierdo();
    /**
     * Obtener el hijo derecho del nodo.
     * @return El nodo correspondiente el hijo derecho de este nodo.
     */
    public INodoAB<T> GetHijoDerecho();

    /**
     * Obtener la etiqueta de este nodo.
     * @return La etiqueta de este nodo.
     */
    public Comparable<T> GetEtiqueta();

    /**
     * Establecer el nodo que será hijo izquierdo de este nodo.
     */
    public void SetHijoIzquierdo(INodoAB<T> nodoAB);

    /**
     * Establecer el nodo que será hijo derecho de este nodo.
     */
    public void SetHijoDerecho(INodoAB<T> nodoAB);

}
