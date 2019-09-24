package com.virgilin.xml.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;

public class TestXml2 {
    public static void main(String[] args) throws IOException {
        /**
         * 通过DocumentHelper生成一个document对象
         */
        Document doc = DocumentHelper.createDocument();
        //添加得到根元素
        Element books = doc.addElement("books");
        //为根元素添加子元素
        Element book = books.addElement("book");
        book.addAttribute("id","b01");
        //为book添加子元素
        Element name = book.addElement("name");
        Element author = book.addElement("author");
        Element price = book.addElement("price");
        //为子元素添加文本
        name.addText("Thinking in Java");
        author.addText("小伟");
        price.addText("88");

        //将doc输出到xml文件中即可
//        FileWriter writer = new FileWriter("src/main/resources/book2.xml");
//        doc.write(writer);
//        writer.close();
        //格式良好的输出
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        XMLWriter xmlWriter = new XMLWriter(new FileWriter("src/main/resources/book2.xml"),outputFormat);
        xmlWriter.write(doc);
        xmlWriter.close();

    }
}
