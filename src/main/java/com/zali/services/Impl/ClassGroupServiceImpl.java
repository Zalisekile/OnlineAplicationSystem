package com.zali.services.Impl;

import com.zali.domain.ClassGroup;
import com.zali.repositories.ClassGroupRepository;
import com.zali.services.ClassGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClassGroupServiceImpl implements ClassGroupService {

    @Autowired
    private ClassGroupRepository classGroupRepository;

    @Override
    public List<ClassGroup> getAllClassGroups() {
        return (List<ClassGroup>) classGroupRepository.findAll();
    }

    @Override
    public ClassGroup getClassGroupByClassGroupCode(long classGroupCode) {

        return  classGroupRepository.findById(classGroupCode).get();
    }

    @Override
    public void saveOrUpdate(ClassGroup student) {
        classGroupRepository.save(student);

    }

    @Override
    public void deleteClassGroup(long classGroupCode) {
        classGroupRepository.deleteById(classGroupCode);

    }
}
