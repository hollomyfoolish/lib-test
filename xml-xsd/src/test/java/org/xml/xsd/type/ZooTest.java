package org.xml.xsd.type;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ZooTest {

	public static void main(String[] args) {
		try {
			Unmarshaller unmarshaller = JaxbUtil.createUnmarshaller(Zoo.class);
			Zoo zoo = (Zoo) unmarshaller.unmarshal(ZooTest.class.getResourceAsStream("/ext-xsd/zoo.xml"));
			System.out.println(zoo.getAnimals().size());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}
	
}
