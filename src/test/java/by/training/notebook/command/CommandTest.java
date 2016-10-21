package by.training.notebook.command;

import by.training.notebook.command.exception.CommandException;
import by.training.notebook.source.NoteBookProvider;
import org.junit.After;
import org.junit.Assert;

import java.io.IOException;


public abstract class CommandTest extends Assert {

    private ICommand command;


    public abstract void checkOnIncorrectRequestType() throws CommandException;
    public abstract void checkResponse() throws CommandException, IOException;


    public CommandTest(ICommand command){
        this.command = command;
    }


    public ICommand getCommand() {
        return command;
    }

    public void setCommand(ICommand command) {
        this.command = command;
    }


    @After
    public void afterTest(){
        NoteBookProvider.getInstance().getNoteBook().clear();
    }
}
