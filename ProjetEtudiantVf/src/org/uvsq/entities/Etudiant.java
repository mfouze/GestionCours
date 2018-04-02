package org.uvsq.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;
@Entity
public class Etudiant  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long identifiant;
	@Column(name="username")
	private String username;
	private String nom;
	private String prenom;
	private String email;
	private String diplome;
	private String password;
	@ManyToOne
	private Filiere filiere;
	
	public Etudiant(String username, String nom, String prenom, String email, String diplome, String password,
			Filiere filiere) {
		super();
		this.username = username;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.diplome = diplome;
		this.password = password;
		this.filiere = filiere;
	}
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Liste des cours d'un étudiant sachant qu'il est dans une filiere donnee
	public Collection<Cours> listCoursByEtudiant() {
		return this.filiere.getListCours();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getDiplome() {
		return diplome;
	}
	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	public Filiere getFiliere() {
		return filiere;
	}
	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
	public Long getIdentifiant() {
		return identifiant;
	}
	@Override
	public String toString() {
		return "Etudiant [identifiant=" + identifiant + ", username=" + username + ", nom=" + nom + ", prenom=" + prenom
				+ ", email=" + email + ", diplome=" + diplome + ", password=" + password + ", filiere=" + filiere + "]";
	}
	
	
		
	
	

}
