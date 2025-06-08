package ar.edu.unahur.obj2.observer;

import ar.edu.unahur.obj2.observer.observadores.Subastador;

public class Oferta {
    Subastador infoSubastador;
    Integer valorOfertado;

    public Oferta(Subastador infoSubastador, Integer valorOfertado) {
        this.infoSubastador = infoSubastador;
        this.valorOfertado = valorOfertado;
    }

    public Subastador getInfoSubastador() {
        return infoSubastador;
    }

    public void setInfoSubastador(Subastador infoSubastador) {
        this.infoSubastador = infoSubastador;
    }

    public Integer getValorOfertado() {
        return valorOfertado;
    }

    public void setValorOfertado(Integer valorOfertado) {
        this.valorOfertado = valorOfertado;
    }
}
