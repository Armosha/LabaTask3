package by.training.notebook.bean;

import by.training.notebook.CommandEnum;


public class Request {

    private CommandEnum commandName;


    public Request(CommandEnum commandName){
        setCommandName(commandName);
    }


    public CommandEnum getCommandName() {
        return commandName;
    }

    public void setCommandName(CommandEnum commandName) {
        if (commandName == null){
            throw new IllegalArgumentException("CommandName is null");
        }
        this.commandName = commandName;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Request{commandName=")
                .append(commandName).append("}").toString();
    }
}
