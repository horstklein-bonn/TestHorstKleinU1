package demo;

import java.io.Serializable;

import java.util.PriorityQueue;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 


@Entity
@Table(name = "Adresse")
 
public class AdrEntity implements Serializable {
  /**
	 * 
	 */
	private static final long serialVersionUID = 3265182927305409683L;

 

@Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
 
  private String plz;
  private String ort;
  private String strasse;
  @ManyToOne
  @JoinColumn(name = "person_id")
  private PersEntity person;
  
  
  
public PersEntity getPerson() {
	return person;
}

public void setPerson(PersEntity person) {
	this.person = person;
}

public String getPlz() {
	return plz;
}

public void setPlz(String plz) {
	this.plz = plz;
}

public String getStrasse() {
	return strasse;
}

public void setStrasse(String strasse) {
	this.strasse = strasse;
}
public String getOrt() {
    return ort;
  }
 
  
  public void setOrt(String ort) {
    this.ort = ort;
  }
  
 
  public AdrEntity(String plz,String ort,String strasse) {
	  
	  this.plz = plz;
	  this.ort = ort;
	  this.strasse = strasse;
    
  }
 
  public Integer getId() {
    return id;
  }
 
  public void setId(Integer id) {
    this.id = id;
  }
 
  

public AdrEntity() {
	super();
}
  
} 
  
