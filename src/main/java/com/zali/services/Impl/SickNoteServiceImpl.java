package com.zali.services.Impl;

import com.zali.domain.SickNote;
import com.zali.factories.SickNoteFactory;
import com.zali.repositories.SickNoteRepository;
import com.zali.services.SickNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
@Transactional
public class SickNoteServiceImpl implements SickNoteService {

    @Autowired
    private SickNoteRepository sickNoteRepository;

    @Override
    public List<SickNote> getAllSickNotes() {
        return (List<SickNote>) sickNoteRepository.findAll();
    }

    @Override
    public SickNote getSickNoteBySickNoteId(long id) {

        return  sickNoteRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(SickNote sickNote) {
        sickNoteRepository.save(sickNote);

    }

    @Override
    public void deleteSickNote(long sickNoteId) {
        sickNoteRepository.deleteById(sickNoteId);

    }
}
