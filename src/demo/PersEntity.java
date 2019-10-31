package demo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
 
 @OneToMany(mappedBy="person",cascade=CascadeType.ALL,fetch=FetchType.EAGER) 
 
 List<AdrEntity> adr;
  
  private String nachname;
  private String vorname;
  
  
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



   
  
  public PersEntity(String nachname,String vorname) {
	  this.nachname = nachname;
	  this.vorname = vorname;
	  
	  
    
  }
  
 
  public PersEntity() {
		
}

public List<AdrEntity> getAdr() {
	if (adr == null)
			this.adr = new ArrayList<>();
	return adr;
}

public void setAdr(List<AdrEntity> adr) {
	this.adr = adr;
}

public Integer getId() {
    return id;
  }
 
  public void setId(Integer id) {
    this.id = id;
  }
 
  
} 
  
