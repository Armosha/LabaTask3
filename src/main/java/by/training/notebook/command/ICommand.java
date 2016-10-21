package by.training.notebook.command;

import by.training.notebook.bean.Request;
import by.training.notebook.bean.Response;
import by.training.notebook.command.exception.CommandException;


public interface ICommand {
    Response execute(Request request) throws CommandException;
}
