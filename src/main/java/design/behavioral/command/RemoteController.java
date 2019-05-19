package design.behavioral.command;

public class RemoteController{

    public void execute(Command command){
        command.execute();
    }

}
