package nb.command.impl;

import nb.bean.AddNoteRequest;
import nb.bean.Request;
import nb.bean.Response;
import nb.bean.entity.Note;
import nb.bean.entity.NoteBook;
import nb.command.Command;
import nb.command.exception.CommandException;
import nb.source.NoteBookProvider;

public class AddNewNote implements Command {

    @Override
    public Response execute(Request request) throws CommandException {

        AddNoteRequest req = null;

        if (request instanceof AddNoteRequest) {
            req = (AddNoteRequest) request;
        } else {
            throw new CommandException("Wrong request");
        }

        String note = req.getNote();
        Note newNote = new Note(note);

        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
        noteBook.addNote(newNote);
        Response response = new Response();
        response.setErrorStatus(true);
        response.setResultMessage("Note \"" + newNote + "\" is added!");

        return response;
    }

}

