package org.uvsq.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.uvsq.dao.HibernateUtil;
@Entity
public class Cours implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCours;
	private String libelleCours;
	@ManyToOne
	private Enseignant enseignant;
	@ManyToOne
	private Filiere filiere;
	
	public Cours(String libelleCours, Filiere filiere, Enseignant enseignant) {
		super();
		this.libelleCours = libelleCours;
		this.filiere = filiere;
		this.enseignant = enseignant;
	}


	public Cours() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cours(String libelleCours) {
		super();
		this.libelleCours = libelleCours;
	}

	public int getIdCours() {
		return idCours;
	}

	public void setIdCours(int idCours) {
		this.idCours = idCours;
	}

	public String getLibelleCours() {
		return libelleCours;
	}

	public void setLibelleCours(String libelleCours) {
		this.libelleCours = libelleCours;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}
	
}
