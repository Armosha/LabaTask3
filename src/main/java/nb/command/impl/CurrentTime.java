package nb.command.impl;


import nb.bean.entity.Note;
import nb.bean.entity.NoteBook;
import nb.source.NoteBookProvider;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CurrentTime {

    NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
    List<Note> list = new ArrayList<Note>();
    Calendar calendar = Calendar.getInstance();
    int day;
    int month;
    int year;

    public CurrentTime(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public List<Note> getCurrentDate() {

        for (Note note : noteBook.getNotes()) {
            Date date = note.getDate();
            calendar.setTime(date);

            int dayNote = calendar.get(Calendar.DAY_OF_MONTH);
            int monthNote = calendar.get(Calendar.MONTH);
            int yearNote = calendar.get(Calendar.YEAR);

            if (day != 0 && month != 0 && year != 0) {
                if (day == dayNote && month == monthNote && year == yearNote) {
                    list.add(note);
                }
            } else if (day != 0 && month == 0 && year == 0) {
                if (day == dayNote) {
                    list.add(note);
                }
            } else if (day == 0 && month != 0 && year == 0) {
                if (month == monthNote) {
                    list.add(note);
                }
            } else if (day == 0 && month == 0 && year != 0) {
                if (year == yearNote) {
                    list.add(note);
                }
            } else if (day != 0 && month != 0 && year == 0) {
                if (day == dayNote && month == monthNote) {
                    list.add(note);
                }
            } else if (day != 0 && month == 0 && year != 0) {
                if (day == dayNote && year == yearNote) {
                    list.add(note);
                }
            } else if (day == 0 && month != 0 && year != 0) {
                if (month == monthNote && year == yearNote) {
                    list.add(note);
                }
            }
        }

        return list;
    }
}
