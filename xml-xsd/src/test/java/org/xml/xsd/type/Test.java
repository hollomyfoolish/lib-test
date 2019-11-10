package org.xml.xsd.type;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Test {
	public static void main(String[] args) {
		testXml();
		testXml2();
		generate();
	}

	private static void testXml2() {
		try {
            JAXBContext context = JAXBContext.newInstance(ListBean.class, Person.class, Animal.class);
            Unmarshaller um = context.createUnmarshaller();
            ListBean<Domain> list = (ListBean<Domain>) um.unmarshal(new FileInputStream("C:\\dev\\workspaces\\eclipse-workspace\\lib.test\\xml-xsd\\src\\main\\resources\\xsd\\test.xml"));
            System.out.println(list.getList().size());
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
	}

	private static void testXml() {
		Person person = new Person();
        person.aac001="aac001";
        person.aac002="aac002";
        person.aac003="aac003";
 
        List<Domain> personList = new ArrayList<Domain>();
        personList.add(person);
 
        Animal a = new Animal();
        a.name = "tiger";
        a.voice = "ow..";
        personList.add(a);
 
        ListBean<Domain> listBean = new ListBean<Domain>();
        listBean.setList(personList);
        
        try {
            JAXBContext context = JAXBContext.newInstance(ListBean.class, Person.class, Animal.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            m.marshal(listBean,outputStream);
            System.out.println(outputStream);
            
            Unmarshaller um = context.createUnmarshaller();
            ListBean<Domain> list = (ListBean<Domain>) um.unmarshal(new ByteArrayInputStream(outputStream.toByteArray()));
            System.out.println(list.getList().size());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
	}
	
	public static void generate() {
		try {
			CustomSchemaOutputResolver resolver = new CustomSchemaOutputResolver("c:", "test.xsd");
			JAXBContext context = JAXBContext.newInstance(ListBean.class, Person.class, Animal.class);
			context.generateSchema(resolver);
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
