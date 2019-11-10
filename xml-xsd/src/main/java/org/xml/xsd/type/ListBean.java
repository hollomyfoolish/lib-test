package org.xml.xsd.type;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ListBean")
public class ListBean<T> {
 
    private String name;
    private List<T> list;
 
    @XmlElement(name = "Domain")
    public List<T> getList() {
        return list;
    }
 
    public void setList(List<T> list) {
        this.list = list;
    }
 
    @XmlAttribute
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
}
