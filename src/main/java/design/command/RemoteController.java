package design.command;

import java.util.ArrayList;
import java.util.List;

public class RemoteController{

    public void execute(Command command){
        command.execute();
    }

}
