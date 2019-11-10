package org.xml.test.type.ns;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "menu")
@XmlAccessorType(XmlAccessType.FIELD)
public class Menu{
	@XmlElement(name = "id")
	private String id;
	@XmlElement(name = "text")
	private String text;
//	@XmlElements(value = { @XmlElement(name = "menu", type = Menu.class) })
	@XmlElement(name = "menu")
	private List<Menu> subMenus;
//	@XmlElements(value = { @XmlElement(name = "button", type = Button.class) })
	@XmlElement(name = "button")
	private List<Button> buttons;
	
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
	public List<Menu> getSubMenus() {
		return subMenus;
	}
	public void setSubMenus(List<Menu> subMenus) {
		this.subMenus = subMenus;
	}
	public List<Button> getButtons() {
		return buttons;
	}
	public void setButtons(List<Button> buttons) {
		this.buttons = buttons;
	}
}
