package design.behavioral.command;

public class OpenCommand implements Command {
    private Tv tv;
    public OpenCommand(Tv tv){
        this.tv = tv;
    }
    @Override
    public void execute() {
        tv.open();
    }
}
