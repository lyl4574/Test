package design.command;

public class OffCommand implements Command {
    private Tv tv;
    public OffCommand(Tv tv){
        this.tv = tv;
    }
    @Override
    public void execute() {
        tv.off();
    }
}
