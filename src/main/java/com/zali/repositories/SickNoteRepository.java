package com.zali.repositories;

import com.zali.domain.SickNote;
import org.springframework.data.repository.CrudRepository;


public interface SickNoteRepository extends CrudRepository<SickNote, Long> {

}
