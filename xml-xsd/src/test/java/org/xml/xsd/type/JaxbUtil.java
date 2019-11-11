package org.xml.xsd.type;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JaxbUtil {

	public static Unmarshaller createUnmarshaller(Class<?>... clazz) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(clazz);
        return context.createUnmarshaller();
	}
}
