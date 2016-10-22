package nb.command.impl;


import nb.bean.Request;
import nb.bean.Response;
import nb.bean.entity.Note;
import nb.bean.entity.NoteBook;
import nb.command.Command;
import nb.command.exception.CommandException;
import nb.source.NoteBookProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class ReadFile implements Command {

    @Override
    public Response execute(Request request) throws CommandException, IOException {

        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
        Response response = new Response();
        noteBook.cleanNoteBook();

        BufferedReader reader;
        String line;
        String cvsSplitBy = "-";

        try {
            reader = new BufferedReader(new FileReader("notebook.txt"));
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                String note = data[0];
                long time = Long.parseLong(data[1]);
                Note file = new Note(note, new Date(time));
                noteBook.addNote(file);
            }

            response.setErrorStatus(true);
            response.setResultMessage("Notebook has been written!");
        } catch (FileNotFoundException e) {
            throw new CommandException("File not found!");
        } catch (IOException e) {
            throw new CommandException("Error output/input!");
        }

        reader.close();
        return response;
    }
}