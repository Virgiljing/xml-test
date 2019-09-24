package com.virgilin.digester.annotation;

import lombok.Data;
import lombok.ToString;
import org.apache.commons.digester3.annotations.rules.BeanPropertySetter;
import org.apache.commons.digester3.annotations.rules.ObjectCreate;

@Data
@ToString
@ObjectCreate(pattern = "school/classes/class/student")
public class StudentDefinition {
    @BeanPropertySetter(pattern = "school/classes/class/student/no")
    private Integer no;
    @BeanPropertySetter(pattern = "school/classes/class/student/name")
    private String name;
    @BeanPropertySetter(pattern = "school/classes/class/student/age")
    private Integer age;
}
