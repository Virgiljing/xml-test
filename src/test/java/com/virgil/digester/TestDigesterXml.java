package com.virgil.digester;

import com.virgilin.digester.definition.SchoolDefinition;
import org.apache.commons.digester3.Digester;
import org.apache.commons.digester3.binder.DigesterLoader;
import org.apache.commons.digester3.xmlrules.FromXmlRulesModule;

import java.net.URL;

public class TestDigesterXml {
    @org.junit.Test
    public void testXmlRule() throws Exception {
        Digester digester = DigesterLoader.newLoader(new XmlRulesModule()).newDigester();
        URL url = this.getClass().getClassLoader().getResource("school.xml");
        System.out.println("url=" + url);
        SchoolDefinition schoolDefinition = digester.parse(url);
        System.out.println(schoolDefinition);
    }


    class XmlRulesModule extends FromXmlRulesModule {

        @Override
        protected void loadRules() {
            loadXMLRules(this.getClass().getClassLoader().getResourceAsStream("rule.xml"));
        }
    }
}
