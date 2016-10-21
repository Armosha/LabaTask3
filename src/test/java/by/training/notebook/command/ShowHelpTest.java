package by.training.notebook.command;

import by.training.notebook.CommandEnum;
import by.training.notebook.bean.*;
import by.training.notebook.command.impl.ShowHelp;
import by.training.notebook.command.exception.CommandException;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;


public class ShowHelpTest extends CommandTest {

    public ShowHelpTest(){
        super(new ShowHelp());
    }


    @Override
    @Test(expected = CommandException.class)
    public void checkOnIncorrectRequestType() throws CommandException {
        getCommand().execute(new RequestWithCreatedDate(CommandEnum.HELP, new Date()));
    }

    @Override
    @Test
    public void checkResponse() throws CommandException, IOException {
        Response response = getCommand().execute(new Request(CommandEnum.HELP));
        assertEquals("Incorrect response status", response.isStatus(), true);
        assertEquals("Incorrect response type", response.getClass(), ResponseWithMessage.class);
    }
}
