package org.xml.xsd.type;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "zoo")
@XmlAccessorType(XmlAccessType.FIELD)
public class Zoo {
	@XmlElementWrapper(name = "animals")
	@XmlElementRefs({
		@XmlElementRef(type = Dog.class),
		@XmlElementRef(type = Cat.class),
		@XmlElementRef(type = Tiger.class)
	})
	private List<Ani> animals;

	public List<Ani> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Ani> animals) {
		this.animals = animals;
	}
}
