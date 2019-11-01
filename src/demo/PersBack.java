package demo;



import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import demo.PersEntity;



 
@ManagedBean
@ViewScoped

public class PersBack implements Serializable {
 
	


	 @EJB
	 private PersRepository persRepository;
 
  private final static Logger LOGGER = Logger.getLogger(PersBack.class.getSimpleName());
  
  @Produces
  private List<PersEntity> members;
  @NotNull
 
  private String nachname;
  private String vorname;
  private String plz;
  private String ort;
  private String strasse;
  public PersEntity selectedrow;
  
 
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

public String getOrt() {
    return ort;
  }
 
  public void setOrt(String ort) {
    this.ort = ort;
  }
  
  public void retrieveAllMembersOrderedByName() {
      this.members = persRepository.findAllOrderedByName();
      System.out.println("in retere");
       
  }
  public void retrieveAllMembersOrderedByVorName() {
      this.members = persRepository.findAllOrderedByVorName();
      System.out.println("in retere");
       
  }
  
  public List<PersEntity> getMembers() {
		return members;
	}

	public void setMembers(List<PersEntity> members) {
		this.members = members;
		
	}


      
public String submit() {
  
 
    boolean isValid = validate();
    if (isValid) {
      PersEntity entitypers = new PersEntity(nachname,vorname);
      AdrEntity entityadr = new AdrEntity(plz,ort,strasse);
      
      entitypers.getAdr().add(entityadr);
      entityadr.setPerson(entitypers);
     
      persRepository.save(entitypers);
           
      retrieveAllMembersOrderedByName();
               
    }
      return "/success?faces-redirect=true";
   
  }
 
  public boolean validate() {
    //*return nachname.length() > 1 && vorname.length() > 1 && plz.length() > 1 && ort.length() > 1 && strasse.length() > 1;
	  return true;
  } 
    public void LoadPerson() {
    	
    	List<PersEntity> l = new ArrayList<>();
    	
    	l.add(persRepository.findById(this.selectedrow.getId()));
    	PersEntity  name =(PersEntity) l.get(0);
    	this.setNachname(name.getNachname());
    	this.setVorname(name.getVorname());
    
    	System.out.println("in Persback LoadPerson");
    	this.setOrt(l.get(0).getAdr().get(0).getOrt());
    	for(final AdrEntity adr: name.getAdr()) {
    		this.setStrasse(adr.getStrasse());
    		this.setPlz(adr.getPlz());
    		this.setOrt(adr.getOrt());
    		
    	}
    }
    
 public void deletePerson() {
    	
	 
    	List<PersEntity> l = new ArrayList<>();
    	
    	l.add(persRepository.findById(this.selectedrow.getId()));
    	persRepository.deleteById(l.get(0));
    }

	public PersEntity getSelectedrow() {
		return selectedrow;
	}

	public void setSelectedrow(PersEntity selectedrow) {
		this.selectedrow = selectedrow;
	}
    	
    	
    
  }
