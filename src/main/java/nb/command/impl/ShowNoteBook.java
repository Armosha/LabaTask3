package nb.command.impl;


import nb.bean.Request;
import nb.bean.Response;
import nb.bean.ShowAllNotesResponse;
import nb.bean.entity.NoteBook;
import nb.command.Command;
import nb.command.exception.CommandException;
import nb.source.NoteBookProvider;

public class ShowNoteBook implements Command {

    @Override
    public Response execute(Request request) throws CommandException {
        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
        Response response = new ShowAllNotesResponse();
        ShowAllNotesResponse res;

        if (response instanceof ShowAllNotesResponse) {
            res = (ShowAllNotesResponse) response;

        } else {
            throw new CommandException("Wrong response");
        }
        res.setAllNotes(noteBook.getNotes());
        res.setErrorStatus(true);
        if (res.getAllNotes().isEmpty()) {
            res.setResultMessage("Notebook is empty!");
        } else {
            res.setResultMessage("All OK!");
        }
        return res;
    }
}
