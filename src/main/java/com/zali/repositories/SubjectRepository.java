package com.zali.repositories;

import com.zali.domain.Subject;
import org.springframework.data.repository.CrudRepository;

import java.util.concurrent.atomic.AtomicBoolean;


public interface SubjectRepository extends CrudRepository<Subject, Long> {

}
