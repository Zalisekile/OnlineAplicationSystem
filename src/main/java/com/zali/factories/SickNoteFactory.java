package com.zali.factories;

import com.zali.domain.SickNote;


public class SickNoteFactory {

    public static SickNote getSickNote() {

        return SickNote.getInstance();
    }
}
