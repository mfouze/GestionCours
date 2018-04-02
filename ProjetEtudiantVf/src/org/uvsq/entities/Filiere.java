package org.uvsq.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Filiere implements Serializable{
	  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String libelle;
	
	@OneToMany(targetEntity=Etudiant.class, mappedBy="filiere",cascade= {CascadeType.ALL},fetch=FetchType.LAZY)
	private Collection<Etudiant> listEtudiants;
	
	@OneToMany(targetEntity=Cours.class, mappedBy="filiere",cascade= {CascadeType.ALL},fetch=FetchType.LAZY)
	private Collection<Cours> listCours;

	public Collection<Etudiant> getListEtudiants() {
		return listEtudiants;
	}

	public void setListEtudiants(Collection<Etudiant> listEtudiants) {
		this.listEtudiants = listEtudiants;
	}

	public Collection<Cours> getListCours() {
		return listCours;
	}

	public void setListCours(Collection<Cours> listCours) {
		this.listCours = listCours;
	}

	public Filiere() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getid() {
		return id;
	}


	public String getLibelle() {
		return libelle;
	}

	
	public Filiere(String libelle) {
		super();
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Filiere [id=" + id + ", libelle=" + libelle + "]";
	}
	
}
