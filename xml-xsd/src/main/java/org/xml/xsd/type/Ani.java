package org.xml.xsd.type;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Ani {
	@XmlElement(name = "name")
	public String name;
	@XmlElement(name = "type")
	public String type;
	@XmlAttribute(name = "id")
	public String id;
}
