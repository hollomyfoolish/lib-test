package org.xml.test.type.ns;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "button")
@XmlAccessorType(XmlAccessType.FIELD)
public class Button{
	@XmlElement(name = "id")
	private String id;
	@XmlElement(name = "text")
	private String text;
	@XmlElement(name = "action")
	private String action;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
}
