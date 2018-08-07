package com.zali.repositories;

import com.zali.domain.ClassGroup;
import org.springframework.data.repository.CrudRepository;

import java.util.concurrent.atomic.AtomicBoolean;


public interface ClassGroupRepository extends CrudRepository<ClassGroup, Long> {


}
