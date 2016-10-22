package nb.command.impl;

import nb.bean.FindByNoteRequest;
import nb.bean.FindByNoteResponse;
import nb.bean.Request;
import nb.bean.Response;
import nb.bean.entity.Note;
import nb.bean.entity.NoteBook;
import nb.command.Command;
import nb.command.exception.CommandException;
import nb.source.NoteBookProvider;

import java.util.ArrayList;
import java.util.List;

public class FindNotes implements Command{

	@Override
	public Response execute(Request request) throws CommandException {

		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
		Response response = new FindByNoteResponse();
		FindByNoteResponse res;
		FindByNoteRequest req;


		if (response instanceof FindByNoteResponse) {
			res = (FindByNoteResponse) response;
		} else {
			throw new CommandException("Wrong response");
		}
		if (request instanceof FindByNoteRequest) {
			req = (FindByNoteRequest) request;
		} else {
			throw new CommandException("Wrong request");
		}

		List<Note> list = new ArrayList<Note>();

		for (Note note : noteBook.getNotes()) {
			if (note.getNote().contains(req.getFindingString())) {
				list.add(note);
			}
		}
		res.setErrorStatus(true);
		if (list.isEmpty()) {
			res.setResultMessage("There isn't any notes!");
		} else {
			res.setFindBook(list);
			res.setResultMessage("All OK!");
		}
		return res;
	}
}

