public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;
    private T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos 
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    /**
     * @param unElemento
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().insertar(unElemento);
            } else {
                hijoIzq = unElemento;
                return true;
            }
        } else if (unElemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                return getHijoDer().insertar(unElemento);
            } else {
                hijoDer = unElemento;
                return true;
            }
        } else {
            // ya existe un elemento con la misma etiqueta.-
            return false;
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {

        if (unaEtiqueta.equals(etiqueta)) {
            return this;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().buscar(unaEtiqueta);
            } else {
                return null;
            }
        } else if (hijoDer != null) {
            return getHijoDer().buscar(unaEtiqueta);
        } else {
            return null;
        }
    }

    public TElementoAB<T> buscarInmediatoAnterior(Comparable claveBuscada){
        TElementoAB<T> aux = this;
        int comparativa = claveBuscada.compareTo(aux.getEtiqueta());
        while( aux != null) {
            if (comparativa == 0) { // si estamos en el buscado
                return this.getHijoIzq(); // retornamos su izquierdo
            } else if (comparativa > 0) { // si es mayor
                if ((claveBuscada.equals(aux.getHijoDer().getEtiqueta())) || // si el derecho es el que estamos buscando
                        (claveBuscada.compareTo(getHijoDer().getEtiqueta()) < 0) || // si el derecho es menor del que estamos buscando
                        (aux.getHijoDer() == null)) { // si el derecho no existe
                    return aux; // estamos en el anterior del que buscamos
                }
                aux = aux.getHijoDer(); // de lo contrario pasamos al derecho
            } else { // si es menor
                aux = aux.getHijoIzq();
            }
        }
        return null;
    }

    /**
     * @return recorrida en inorden del subArbol que cuelga del elemento actual
     */
    @Override
    public String inOrden() {
        Lista<T> unaLista = null;
        this.inOrden(unaLista);
        return unaLista.toString();
    }

   @Override
    public void inOrden(Lista<T> unaLista) {
        if(unaLista == null)
            unaLista = new Lista<>();
        if(hijoIzq != null)
            hijoIzq.inOrden(unaLista);
        unaLista.insertar(new Nodo<>(this.etiqueta, this.datos));
        if(hijoDer != null)
            hijoDer.inOrden(unaLista);
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    /**
     * @return
     */
    public String imprimir() {
        return (etiqueta.toString());
    }

    @Override
    public T getDatos() {
        return datos;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;

    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }

    

    @Override
    public int obtenerAltura() {
        int altIzq = 0;
        int altDer = 0;
        if(hijoIzq != null){
            altIzq = hijoIzq.obtenerAltura();
        }
        if(hijoDer != null){
            altDer = hijoDer.obtenerAltura();
        }
        return (Math.max(altIzq, altDer) + 1);
    }

    @Override
    public int obtenerTamanio() {
        int size = 1;
        if(hijoIzq != null)
            size += hijoIzq.obtenerTamanio();
        if(hijoDer != null)
            size += hijoDer.obtenerTamanio();
        return size;    }

    @Override
    public int obtenerNivel(Comparable unaEtiqueta) {
        if(this.etiqueta.compareTo(unaEtiqueta) == 0)
            return 0;
        int nivIzq = -1;
        int nivDer = -1;
        if(hijoIzq != null) {
            nivIzq = hijoIzq.obtenerNivel(unaEtiqueta);
            if(nivIzq != -1)
                return nivIzq + 1;
        }
        if(hijoDer != null) {
            nivDer = hijoDer.obtenerNivel(unaEtiqueta);
            if(nivDer != -1)
                return nivDer + 1;
        }
        return -1;
    }

    @Override
    public int obtenerCantidadHojas() {
        if (hijoIzq == null){
            if (hijoDer == null){
                // si los dos no existen
                return 1;
            } else {
                // si el izquierdo no existe pero el derecho si
                return hijoDer.obtenerCantidadHojas();
            }
        } else {
            if(hijoDer == null){
                // si el izquierdo existe pero el derecho no
                return hijoIzq.obtenerCantidadHojas();
            } else {
                // si ambos existen
                return (hijoIzq.obtenerCantidadHojas() + hijoDer.obtenerCantidadHojas());
            }
        }
    }

    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                this.hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }

        else if (unaEtiqueta.compareTo(etiqueta) > 0) { //por descarte >0
            if (hijoDer != null) {
                this.hijoDer = hijoDer.eliminar(unaEtiqueta);
            }
            return this;
        }

        else
        {
            return this.quitaElNodo();
        }
    }

    private TElementoAB quitaElNodo() {
        if (hijoIzq == null) { //solo tiene un hijo
            return hijoDer;
        }

        else if (hijoDer == null) {
            return hijoIzq;
        }
        else {
            TElementoAB<T> elHijo = hijoIzq;
            TElementoAB<T> elPadre = this;

            while (elHijo.hijoDer != null) {
                elPadre = elHijo;
                elHijo = elHijo.hijoDer;
            }
            if (elPadre != this) {
                elPadre.setHijoDer(elHijo.getHijoIzq());
                elHijo.setHijoIzq(hijoIzq);
            }
            elHijo.setHijoDer(hijoDer);
            setHijoIzq(null); // para mantener el órden, sino se nos rompe el árbol. la raíz fue para abajo y ahora la acomodamos arriba
            setHijoDer(null);
            return elHijo;
        }
    }


}
