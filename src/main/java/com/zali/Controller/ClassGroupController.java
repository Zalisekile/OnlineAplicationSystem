package com.zali.Controller;

import com.zali.domain.ClassGroup;
import com.zali.factories.ClassGroupFactory;
import com.zali.services.ClassGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value="/ClassGroup")
public class ClassGroupController
{

    @Autowired
    ClassGroupService classGroupService;

    @GetMapping(value="/list")
    public @ResponseBody
    List<ClassGroup> list() {
        List<ClassGroup> classGroupList = classGroupService.getAllClassGroups();
        return classGroupList;
    }



    @GetMapping(path="/add/")
    public @ResponseBody
    String addClassGroup(@RequestParam String classGroupCode,@RequestParam int year) {
        ClassGroup classGroup =  ClassGroupFactory.getClassGroup();
        classGroup.setClassGroupCode(classGroupCode);
        classGroup.setYear(year);
        classGroupService.saveOrUpdate(classGroup);

        return "Saved";
    }

    @GetMapping(path="/update/{classGroupCode}")
    public @ResponseBody
    String UpdateClassGroup(@PathVariable String classGroupCode,@RequestParam int year) {

        ClassGroup classG = classGroupService.getClassGroupByClassGroupCode(classGroupCode.hashCode());

        ClassGroup classGroup = ClassGroupFactory.getClassGroup();
        classGroup.setClassGroupCode(classG.getClassGroupCode());
        classGroup.setYear(year);

        classGroupService.saveOrUpdate(classGroup);

        return "Updated";
    }

    @GetMapping(value="/read/{classGroupCode}")
    public @ResponseBody
    String read(@PathVariable String classGroupCode) {
        ClassGroup stud =classGroupService.getClassGroupByClassGroupCode(classGroupCode.hashCode());
        return stud.toString();
    }

    @GetMapping(path="/delete/{classGroupCode}")
    public @ResponseBody
    String delete(@PathVariable String classGroupCode) {
        classGroupService.deleteClassGroup(classGroupCode.hashCode());
        return "Deleted";
    }


}
