package com.virgilin.digester.annotation;

import lombok.Data;
import lombok.ToString;
import org.apache.commons.digester3.annotations.rules.ObjectCreate;
import org.apache.commons.digester3.annotations.rules.SetNext;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@ObjectCreate(pattern = "school/classes")
public class SchoolDefinition {
    private List<ClassDefinition> classDefinitions = new ArrayList();

    @SetNext
    public void addClass(ClassDefinition classDefinition){
        System.out.println("执行了addClass");
        classDefinitions.add(classDefinition);
    }

}
