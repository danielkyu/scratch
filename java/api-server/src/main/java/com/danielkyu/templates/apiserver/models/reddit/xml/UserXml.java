package com.danielkyu.templates.apiserver.models.reddit.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import java.util.List;
import lombok.Data;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@Data
@jakarta.xml.bind.annotation.XmlRootElement(name = "feed")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserXml {
  @Data
  @XmlAccessorType(XmlAccessType.FIELD)
  public static class Entry {
    @XmlElement(name = "title")
    private String title;

    @XmlPath("author/name/text()")
    private String author;
  }

  @XmlElement(name = "entry")
  private List<Entry> entries;
}
