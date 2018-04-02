package org.uvsq.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Enseignant  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long identifiant;
	private String nom;
	private String prenom;
	private String email;
	private boolean isResp;

	@OneToMany(targetEntity=Cours.class,cascade= {CascadeType.ALL}, mappedBy="enseignant",fetch=FetchType.LAZY)
	private Collection<Cours> listCours;


	public Enseignant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isResp() {
		return isResp;
	}
	public void setResp(boolean isResp) {
		this.isResp = isResp;
	}
	public Collection<Cours> getListCours() {
		return listCours;
	}
	public void setListCours(Collection<Cours> listCours) {
		this.listCours = listCours;
	}
	public Long getIdentifiant() {
		return identifiant;
	}
	public Enseignant(String nom, String prenom, String email, boolean isResp) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.isResp = isResp;
	}
}
