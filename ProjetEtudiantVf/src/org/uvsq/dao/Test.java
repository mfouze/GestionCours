package org.uvsq.dao;

import org.uvsq.entities.Cours;
import org.uvsq.entities.Enseignant;
import org.uvsq.entities.Etudiant;
import org.uvsq.entities.Filiere;

public class Test {

	public static void main(String[] args) {
		//Création des differentes entités
		Enseignant e = new Enseignant("pucheral", "philippe","p.pucheral@email.com", true);
		Filiere f = new Filiere("Sercret");
		Etudiant etudiant = new Etudiant("e1", "nom", "prenom", "email", "diplome", "password", f);
		Cours c = new Cours("Archi",f,e);
		FiliereDao fdao = new FiliereDao();
		EnseignantDao edao = new EnseignantDao();
		EtudiantDao etuDao = new EtudiantDao();
		CoursDao cdao = new CoursDao();
		edao.create(e);
		fdao.create(f);
		cdao.create(c);
		etuDao.create(etudiant);
		//-----------------------------------------------------------------------------------------------------
		//-----------------------------------------------------------------------------------------------------

	}

}
