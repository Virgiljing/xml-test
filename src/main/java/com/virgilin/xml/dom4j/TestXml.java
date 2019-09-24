package com.virgilin.xml.dom4j;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.annotation.Resources;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;

public class TestXml {
    public static void main(String[] args) throws DocumentException {
        InputStream resourceAsStream = Resources.class.getResourceAsStream("/score.xml");


        SAXReader reader = new SAXReader();
        //Document document = reader.read(resourceAsStream);
        Document document = reader.read(new File("src/main/resources/scores.xml"));
        Element root = document.getRootElement();
        Iterator<Element> iterator = root.elementIterator();
        while (iterator.hasNext()) {
            Element next = iterator.next();
            System.out.println(next.getName());
            Attribute id = next.attribute("id");
            System.out.println(id.getName()+"="+id.getValue());
            Element name = next.element("name");
            Element course = next.element("course");
            Element score = next.element("score");
            System.out.println(name.getName() + ":" + name.getStringValue());
            System.out.println(course.getName() + ":" + course.getText());
            System.out.println(score.getName() + ":" + score.getStringValue());
        }

    }
}
