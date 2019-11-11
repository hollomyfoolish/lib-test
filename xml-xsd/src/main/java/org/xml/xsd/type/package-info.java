@XmlSchema(
		namespace = "http://www.example.org/m.t",
		xmlns = {
			@XmlNs(prefix = "mt", namespaceURI = "http://www.example.org/m.t"),
			@XmlNs(prefix = "tt", namespaceURI = "http://www.tt.org/listbean.schema")	
		},
		elementFormDefault=XmlNsForm.QUALIFIED)
package org.xml.xsd.type;

import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
