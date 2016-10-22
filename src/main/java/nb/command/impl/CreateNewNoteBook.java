package nb.command.impl;

import nb.bean.Request;
import nb.bean.Response;
import nb.bean.entity.NoteBook;
import nb.command.Command;
import nb.command.exception.CommandException;
import nb.source.NoteBookProvider;

public class CreateNewNoteBook implements Command {

    @Override
    public Response execute(Request request) throws CommandException {

        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
        noteBook.cleanNoteBook();
        Response response = new Response();
        response.setErrorStatus(true);
        response.setResultMessage("Notebook has been created!");
        return response;
    }
}