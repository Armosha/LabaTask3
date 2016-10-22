package nb.command.impl;


import nb.bean.Request;
import nb.bean.Response;
import nb.bean.entity.Note;
import nb.bean.entity.NoteBook;
import nb.command.Command;
import nb.command.exception.CommandException;
import nb.source.NoteBookProvider;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFile implements Command {

    @Override
    public Response execute(Request request) throws CommandException {

        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
        Response response = new Response();

        try (FileWriter writer = new FileWriter("notebook.txt")) {
            for (Note note : noteBook.getNotes()) {
                String string = note.getNote() + "-" + note.getDate().getTime() + "\n";
                writer.write(string);
            }
        } catch (IOException e) {
            throw new CommandException("Error output/input!");
        }
        response.setErrorStatus(true);
        response.setResultMessage("Saving was successful!");
        return response;
    }
}
