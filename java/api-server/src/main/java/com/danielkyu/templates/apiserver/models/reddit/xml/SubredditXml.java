package com.danielkyu.templates.apiserver.models.reddit.xml;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import lombok.Data;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@Data
@XmlRootElement(name = "feed")
@XmlAccessorType(XmlAccessType.FIELD)
public class SubredditXml {
  @XmlPath("id/text()")
  private String id;

  @XmlPath("updated/text()")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
  private Date updated;
}
