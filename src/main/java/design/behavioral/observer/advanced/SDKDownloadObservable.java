package design.behavioral.observer.advanced;

import java.util.Observable;

//被观察者
class SDKDownloadObservable extends Observable {
    private String mState;

    public String getState() {
        return mState;
    }

    public void netProcessChange(String data) {
        mState = data;
        this.setChanged();
        this.notifyObservers();
    }
}
