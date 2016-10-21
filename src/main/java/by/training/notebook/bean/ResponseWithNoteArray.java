package by.training.notebook.bean;

import by.training.notebook.bean.entity.Note;


public class ResponseWithNoteArray extends Response {

    private Note[] notes;


    public ResponseWithNoteArray(boolean status, Note[] notes){
        super(status);
        setNotes(notes);
    }


    public Note[] getNotes() {
        return notes;
    }

    public void setNotes(Note[] notes) {
        if (notes == null){
            throw new IllegalArgumentException("Notes is null");
        }
        this.notes = notes;
    }
}
