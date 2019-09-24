package com.virgilin.digester.annotation;

import lombok.Data;
import lombok.ToString;
import org.apache.commons.digester3.annotations.rules.ObjectCreate;
import org.apache.commons.digester3.annotations.rules.SetNext;
import org.apache.commons.digester3.annotations.rules.SetProperty;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@ObjectCreate(pattern = "school/classes/class")
public class ClassDefinition {
    @SetProperty(pattern = "school/classes/class")
    private String className;

    private List<StudentDefinition> studentDefinitionList = new ArrayList();

    @SetNext
    public void addStudent(StudentDefinition studentDefinition){
        System.out.println("执行了addStudent");
        studentDefinitionList.add(studentDefinition);
    }

}
