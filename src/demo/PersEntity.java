package demo;

import java.io.Serializable;
import java.util.PriorityQueue;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 


@Entity
@Table(name = "Person")

public class PersEntity implements Serializable {
  /**
	 * 
	 */
	private static final long serialVersionUID = 3165182927305409683L;



@Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
 
 
  
  private String nachname;
  private String vorname;
  private String plz;
  private String ort;
  private String strasse;
  
  public String getNachname() {
	return nachname;
}

public void setNachname(String nachname) {
	this.nachname = nachname;
}
public String getVorname() {
	return vorname;
}

public void setVorname(String vorname) {
	this.vorname = vorname;
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


 
  
 
  public PersEntity() {
  }
 
  public PersEntity(String nachname,String vorname,String plz,String ort,String strasse) {
	  this.nachname = nachname;
	  this.vorname = vorname;
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
 
  public String getOrt() {
    return ort;
  }
 
  
  public void setOrt(String ort) {
    this.ort = ort;
  }
} 
  
