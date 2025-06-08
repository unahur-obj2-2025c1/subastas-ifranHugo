package ar.edu.unahur.obj2.observer.observables;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observadores.Observer;
import ar.edu.unahur.obj2.observer.observadores.Subastador;

public interface Observable {
    void addObserver(Subastador obs);
    void removeObserver(Subastador obs);
    void notifyObservers(Oferta evento);

}
