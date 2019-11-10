package org.xml.test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.xml.test.type.Menu;

public class JaxbTest {

	public static void main(String[] args) {
		testWithoutNS();
		testWithNS();
	}

	private static void testWithNS() {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(org.xml.test.type.ns.Menu.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			org.xml.test.type.ns.Menu data = (org.xml.test.type.ns.Menu) unmarshaller.unmarshal(JaxbTest.class.getResourceAsStream("/menu.test.xml"));
			System.out.println(data.getId());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	private static void testWithoutNS() {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Menu.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Menu data = (Menu) unmarshaller.unmarshal(JaxbTest.class.getResourceAsStream("/menu.test2.xml"));
			System.out.println(data.getId());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
