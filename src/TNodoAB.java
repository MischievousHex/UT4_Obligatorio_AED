public class TNodoAB<T> implements INodoAB<T>
{

    private TNodoAB<T> hijoIzquierdo;
    private TNodoAB<T> hijoDerecho;
    private final Comparable<T> etiqueta;

    public TNodoAB(INodoAB<T> nodoAB){
        this.etiqueta = nodoAB.GetEtiqueta();
        if(nodoAB.GetHijoIzquierdo() != null)
            this.hijoIzquierdo = new TNodoAB<>(nodoAB.GetHijoIzquierdo());
        if(nodoAB.GetHijoDerecho() != null)
            this.hijoDerecho = new TNodoAB<>(nodoAB.GetHijoDerecho());
    }

    public TNodoAB(TNodoAB<T> nodoAB){
        this.hijoDerecho = nodoAB.GetHijoIzquierdo();
        this.hijoIzquierdo = nodoAB.GetHijoDerecho();
        this.etiqueta = nodoAB.GetEtiqueta();
    }

    public TNodoAB(Comparable<T> etiqueta, TNodoAB<T> hijoIzquierdo, TNodoAB<T> hijoDerecho){
        this.etiqueta = etiqueta;
        this.hijoIzquierdo = hijoIzquierdo;
        this.hijoDerecho = hijoDerecho;
    }

    @Override
    public TNodoAB<T> GetHijoIzquierdo() {
        return this.hijoIzquierdo;
    }

    @Override
    public TNodoAB<T> GetHijoDerecho() {
        return this.hijoDerecho;
    }

    @Override
    public Comparable<T> GetEtiqueta() {
        return this.etiqueta;
    }

    public void SetHijoIzquierdo(TNodoAB<T> nodoAB){
        this.hijoIzquierdo = nodoAB;
    }

    public void SetHijoDerecho(TNodoAB<T> nodoAB){
        this.hijoDerecho = nodoAB;
    }

    @Override
    public void SetHijoIzquierdo(INodoAB<T> nodoAB) {
        TNodoAB<T> tNodoAB = new TNodoAB<>(nodoAB);
        this.SetHijoIzquierdo(tNodoAB);
    }

    @Override
    public void SetHijoDerecho(INodoAB<T> nodoAB) {
        TNodoAB<T> tNodoAB = new TNodoAB<>(nodoAB);
        this.SetHijoDerecho(tNodoAB);
    }

}
