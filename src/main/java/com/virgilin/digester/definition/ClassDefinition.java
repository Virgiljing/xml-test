package com.virgilin.digester.definition;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class ClassDefinition {
    private String className;

    private List<StudentDefinition> studentDefinitionList = new ArrayList();

    public void addStudent(StudentDefinition studentDefinition){
        studentDefinitionList.add(studentDefinition);
    }

}
