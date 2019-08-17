package demo;



import java.io.Serializable;



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
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import demo.PersEntity;



 
@ManagedBean
@SessionScoped

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
       
  }
  
  
  public List<PersEntity> getMembers() {
		return members;
	}

	public void setMembers(List<PersEntity> members) {
		this.members = members;
	}

public PersBack() {
  }
      
public String submit() {
    String redirect = "/error?faces-redirect=true";
 
    String template = "Nachname: {0}, Vorname: {1}, PLZ:{2},Ort: {3}, Strasse{4}";
    Object[] values = new Object[]{
      this.nachname,
      this.vorname,
      this.plz,
      this.ort,
      this.strasse
    };
    LOGGER.log(Level.INFO, template, values);
 
    boolean isValid = validate();
    if (isValid) {
      PersEntity entity = new PersEntity(nachname,vorname,plz,ort,strasse);
      persRepository.save(entity);
      LOGGER.log(Level.INFO, "Saved user.");
      retrieveAllMembersOrderedByName();
      redirect = "/success?faces-redirect=true";
      
    }
 
    return redirect;
  }
 
  public boolean validate() {
    //*return nachname.length() > 1 && vorname.length() > 1 && plz.length() > 1 && ort.length() > 1 && strasse.length() > 1;
	  return true;
  } 
    public String getString() {
    	return "Hie12r";
    }
  }

