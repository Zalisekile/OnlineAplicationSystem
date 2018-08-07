package com.zali.services;

import com.zali.domain.SickNote;


import java.util.List;

public interface SickNoteService {
    public List<SickNote> getAllSickNotes();
    public SickNote getSickNoteBySickNoteId(long id);
    public void saveOrUpdate(SickNote student);
    public void deleteSickNote(long studentId);
}
