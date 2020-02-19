package eu.ensup.demojpaweb.domaine;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Lieu {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private String adresse;
	// Collection de formations
	@OneToMany(mappedBy = "lieu", fetch = FetchType.LAZY)
	Collection<Formation> formations;

	public Lieu() {
		super();
	}

	public Lieu(String nom, String adresse) {
		super();
		this.nom = nom;
		this.adresse = adresse;
	}

	public String getAdresse() {
		return adresse;
	}

	public Collection<Formation> getFormations() {
		return formations;
	}

	public Long getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setFormations(Collection<Formation> formations) {
		this.formations = formations;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Lieu [id=" + id + ", nom=" + nom + ", adresse=" + adresse + "]";
	}

}
