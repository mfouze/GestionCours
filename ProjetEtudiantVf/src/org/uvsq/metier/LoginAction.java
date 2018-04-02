package org.uvsq.metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.uvsq.dao.EtudiantDao;
import org.uvsq.entities.Etudiant;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware,ServletRequestAware{
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private List filiere ;

	private Map<String, Object> session;
	private HttpServletRequest request;

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	private EtudiantDao etudiantDao = new EtudiantDao();

	private List<Etudiant> lstEtudiants;

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public HttpServletRequest getRequest() {
		return request;
	}


	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}


	public List<Etudiant> getLstEtudiants() {
		return lstEtudiants;
	}


	public void setLstEtudiants(List<Etudiant> lstEtudiants) {
		this.lstEtudiants = lstEtudiants;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public String execute() throws Exception {

		ActionContext ctx = ActionContext.getContext();
		System.out.println("je suis la "+username+password);
		Etudiant a =etudiantDao.getEtudiantByUsername(this.username);
		System.out.println(a);
		
		if(a!=null) {
			if(a.getpassword().equals(this.password)) {
				filiere=(List) a.getFiliere().getListCours();
				ctx.put(this.username, "Login Success");
				return SUCCESS;
				
			}else
				request.setAttribute("message", "Utilisateur ou mot de passe invalide !");
		}
		
		ctx.put(this.username, "Login Failed");
		return ERROR;
}


@Override
public void setServletRequest(HttpServletRequest request) {
	this.request = request;
}

@Override
public void setSession(Map<String, Object> session) {
	this.session = session;
}


}
