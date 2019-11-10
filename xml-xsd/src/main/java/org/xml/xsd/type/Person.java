package org.xml.xsd.type;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Person")
public class Person implements Domain {
	private static final long serialVersionUID = 1L;
	@XmlElement(required = true)
    protected String aac001;
    @XmlElement(required = true)
    protected String aac002;
    @XmlElement(required = true)
    protected String aac003;
}