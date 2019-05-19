package design.behavioral.observer.advanced;

import java.util.Observable;
import java.util.Observer;

//观察者
class ProgramMonkeyObserver implements Observer {

    public ProgramMonkeyObserver(Observable obs) {
        obs.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Programer look the SDK download process is: "+((SDKDownloadObservable)o).getState());
    }
}
