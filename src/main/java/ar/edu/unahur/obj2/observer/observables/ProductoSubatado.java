package ar.edu.unahur.obj2.observer.observables;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observadores.Observer;
import ar.edu.unahur.obj2.observer.observadores.Subastador;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProductoSubatado implements Observable{
    List<Subastador> observers = new LinkedList<>();
    @Override
    public void addObserver(Subastador obs) {
        observers.add(obs);
    }

    @Override
    public void removeObserver(Subastador obs) {
        observers.remove(obs);
    }

    public void limpiarLista() {
       observers = new ArrayList<>();
    }

    @Override
    public void notifyObservers(Oferta evento) {

        if(observers.stream().noneMatch(
                subastador -> subastador ==evento.getInfoSubastador()
        )){
            throw new OfertaSubastadorException("El subastador no participa en la subasta");
        };
        for (Observer obs : observers){
            obs.update(evento);
        }
    }
}
