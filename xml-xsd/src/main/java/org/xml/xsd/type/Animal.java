package org.xml.xsd.type;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Animal")
public class Animal implements Domain{
	private static final long serialVersionUID = 1L;
	@XmlElement
	public String name;
	@XmlElement
	public String voice;
}
