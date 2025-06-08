package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observables.ProductoSubatado;

import java.util.Optional;

public class Subastador implements Observer {
    String nombreDeUsuario;
    Oferta ultimaOferta;
    private ProductoSubatado productoSubatado;

    public Subastador(String nombreDeUsuario, ProductoSubatado productoSubatado) {
        this.nombreDeUsuario = nombreDeUsuario;
        this.productoSubatado =productoSubatado;
    }
    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }
    public Oferta getUltimaOferta(){
        return ultimaOferta;
    }
    @Override
    public void update(Oferta observe) {
        ultimaOferta =observe;
    }
    public void agregarOferta(Oferta oferta){

        if(ultimaOferta==null){
            ultimaOferta =oferta;
            productoSubatado.notifyObservers(oferta);
        }else if( 10 != oferta.getValorOfertado()-ultimaOferta.getValorOfertado() ){
            throw  new OfertaSubastadorException("La oferta debe ser 10 mas que la anterior");
        }
        System.out.println("ultima oferta: "+ultimaOferta.getValorOfertado());
        System.out.println("oferta:" +oferta.getValorOfertado());
        ultimaOferta =oferta;
        productoSubatado.notifyObservers(oferta);
    }

}
