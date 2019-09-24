package com.virgil.digester;

import com.virgilin.digester.annotation.SchoolDefinition;
import org.apache.commons.digester3.Digester;
import org.apache.commons.digester3.annotations.FromAnnotationsRuleModule;
import org.apache.commons.digester3.binder.DigesterLoader;
import org.apache.commons.digester3.xmlrules.FromXmlRulesModule;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.URL;

public class Test {


    @org.junit.Test
    public void testAnnotationRule() throws IOException, SAXException {
        Digester digester = DigesterLoader.newLoader(new FromAnnotationsRuleModule() {
            @Override
            protected void configureRules() {
                bindRulesFrom(SchoolDefinition.class);
            }
        }).newDigester();
        URL url = this.getClass().getClassLoader().getResource("school.xml");
        System.out.println("url="+ url);
        SchoolDefinition schoolDefinition = digester.parse(url);
        System.out.println(schoolDefinition);
    }
}
