package design.observer.advanced;

public class Main {
    public static void main(String[] args) {
        SDKDownloadObservable sdkDownloadObservable = new SDKDownloadObservable();
        new ProgramMonkeyObserver(sdkDownloadObservable);
        sdkDownloadObservable.netProcessChange("1%");
        sdkDownloadObservable.netProcessChange("51%");
        sdkDownloadObservable.netProcessChange("100%");
    }
}
