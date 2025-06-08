package ar.edu.unahur.obj2.observer.observables;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observadores.Subastador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductoSubatadoTest {

    ProductoSubatado productoSubatado = new ProductoSubatado();
    Subastador gonzager = new Subastador("gonzager",productoSubatado);
    Subastador martomau = new Subastador("martomau",productoSubatado);
    Subastador diazdan = new Subastador("diazdan",productoSubatado);
    Oferta ultimaOferta= new Oferta(martomau,30);
    @BeforeEach
    void main(){
        productoSubatado.limpiarLista();
        productoSubatado.addObserver(gonzager);
        productoSubatado.addObserver(martomau);


        martomau.agregarOferta(new Oferta(martomau,10));
        gonzager.agregarOferta(new Oferta(gonzager,20));
        martomau.agregarOferta(ultimaOferta);
    }
    @Test
    public void martomauYgonzaRecibenUltimaOferta(){
        assertEquals(ultimaOferta,martomau.getUltimaOferta())  ;
        assertEquals(ultimaOferta,gonzager.getUltimaOferta())  ;
    }
    @Test
    public void ultimaOfertaEsDeMartomau(){
        assertEquals(ultimaOferta.getInfoSubastador(),martomau)  ;
    }

}
