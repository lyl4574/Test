package design.observer;

import java.util.ArrayList;
import java.util.List;

//抽象观察者角色类
interface Observer {
    void update(String state);
}
//具体观察者角色类
class ProgramMonkeyObserver implements Observer {
    @Override
    public void update(String state) {
        System.out.println("Programer look the SDK download process is: "+state);
    }
}
//抽象主题角色类
abstract class Subject {
    private List<Observer> list = new ArrayList<>();

    public void attach(Observer observer) {
        list.add(observer);
    }

    public void detach(Observer observer) {
        list.remove(observer);
    }

    public void motifyObservers(String newState) {
        for (Observer observer : list) {
            observer.update(newState);
        }
    }
}
//具体主题角色类
class SDKDownloadSubject extends Subject {
    public void netProcessChange(String data) {
        this.motifyObservers(data);
    }
}
//客户端
public class Main {
    public static void main(String[] args) {
        SDKDownloadSubject sdkDownloadSubject = new SDKDownloadSubject();
        Observer observer = new ProgramMonkeyObserver();
        sdkDownloadSubject.attach(observer);
        sdkDownloadSubject.netProcessChange("1%");
        sdkDownloadSubject.netProcessChange("51%");
        sdkDownloadSubject.netProcessChange("100%");
    }
}
