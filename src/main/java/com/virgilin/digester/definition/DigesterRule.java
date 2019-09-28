package com.virgilin.digester.definition;

import org.apache.commons.digester3.Digester;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.URL;

public class DigesterRule {

    public SchoolDefinition execute(String filePath) throws IOException, SAXException {
        Digester digester = new Digester();
        digester.setValidating(false);
        digester.addObjectCreate("school/classes",SchoolDefinition.class);
        digester.addSetProperties("school/classes/class");
        digester.addObjectCreate("school/classes/class",ClassDefinition.class);
        digester.addObjectCreate("school/classes/class/student",StudentDefinition.class);
        digester.addBeanPropertySetter("school/classes/class/student/no");
        digester.addBeanPropertySetter("school/classes/class/student/name");
        digester.addBeanPropertySetter("school/classes/class/student/age");
        digester.addSetNext("school/classes/class/student","addStudent");
        digester.addSetNext("school/classes/class","addClass");
        URL url = this.getClass().getClassLoader().getResource(filePath);
        System.out.println("url=" + url.toString());
        return digester.parse(url);
    }

    /**
     * tomcat中Catalina初始化server的方法
     * @param filePath
     * @return
     * @throws IOException
     * @throws SAXException
     */
    public SchoolDefinition execute2(String filePath) throws IOException, SAXException {
        Digester digester = new Digester();
        digester.setValidating(false);
        //digester.addObjectCreate("school/classes",SchoolDefinition.class);
        //digester.addSetProperties("school/classes/class");
        digester.addObjectCreate("school/classes/class",ClassDefinition.class);
        digester.addObjectCreate("school/classes/class/student",StudentDefinition.class);
        digester.addBeanPropertySetter("school/classes/class/student/no");
        digester.addBeanPropertySetter("school/classes/class/student/name");
        digester.addBeanPropertySetter("school/classes/class/student/age");
        digester.addSetNext("school/classes/class/student","addStudent");
        digester.addSetNext("school/classes/class","addClass");
        URL url = this.getClass().getClassLoader().getResource(filePath);
        System.out.println("url=" + url.toString());
        SchoolDefinition schoolDefinition = new SchoolDefinition();
        digester.push(schoolDefinition);
        return digester.parse(url);
    }

    public static void main(String[] args) throws IOException, SAXException {
        SchoolDefinition schoolDefinition = new DigesterRule().execute2("school.xml");
        System.out.println(schoolDefinition);
    }
}
