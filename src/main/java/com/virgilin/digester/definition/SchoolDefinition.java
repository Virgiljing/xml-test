package com.virgilin.digester.definition;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class SchoolDefinition {
    private List<ClassDefinition> classDefinitions = new ArrayList();

    public void addClass(ClassDefinition classDefinition){
        classDefinitions.add(classDefinition);
    }

}
