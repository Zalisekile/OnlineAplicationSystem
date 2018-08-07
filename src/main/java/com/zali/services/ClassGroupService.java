package com.zali.services;

import com.zali.domain.ClassGroup;
import java.util.List;

public interface ClassGroupService {
    public List<ClassGroup> getAllClassGroups();
    public ClassGroup getClassGroupByClassGroupCode(long classGroupCode);
    public void saveOrUpdate(ClassGroup classGroup);
    public void deleteClassGroup(long classGroupCode);
}
