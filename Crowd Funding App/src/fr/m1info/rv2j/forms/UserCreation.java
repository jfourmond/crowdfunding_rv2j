package fr.m1info.rv2j.forms;

import javax.servlet.http.HttpServletRequest;

import fr.m1info.rv2j.beans.User;
import fr.m1info.rv2j.dao.DAOException;
import fr.m1info.rv2j.dao.UserDAO;

public class UserCreation extends Forms {
	public final static String USERNAME_FIELD = "username";
	public final static String EMAIL_FIELD = "email";
	public final static String PW_FIELD = "password";
	public final static String PW_CONF_FIELD = "password_conf";
	
	private UserDAO userDAO;
	
	/**	CONSTRUCTEURS	**/
	public UserCreation() {
		super();
	}
	
	public UserCreation(UserDAO userDAO) {
		super();
		this.userDAO = userDAO;
	}
	
	public User createUser(HttpServletRequest request) {
		User user = new User();
		
		String name = getFieldValue(request, USERNAME_FIELD);
		String email = getFieldValue(request, EMAIL_FIELD);
		String pw = getFieldValue(request, PW_FIELD);
		String pwConf = getFieldValue(request, PW_CONF_FIELD);
		
		try {
			nameProcessing(name, user);
			emailProcessing(email, user);
			passwordProcessing(pw, pwConf, user);
			
			user.setRightLevel(1);
			
			if (errors.isEmpty()) {
				userDAO.create(user);
				result = "Succès de la création du client.";
			} else
				result = "Échec de la création du client.";
		} catch(DAOException E) {
			result = "Échec de l'inscription : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
			E.printStackTrace();
		}

		
		
		return user;
	}
	
	private void nameProcessing(String name, User user) {
		try {
			checkName(name);
			user.setName(name);
		} catch (FormValidationException E) {
			addErrors(USERNAME_FIELD, E.getMessage());
		}
	}
	
	private void checkName(String name) throws FormValidationException {
		if(name != null) {
			if(name.length() < 5)
				throw new FormValidationException("Le nom d'utilisateur doit contenir au moins 5 caractères.");
			else if(userDAO.findByName(name) != null)
				throw new FormValidationException("Le nom d'utilisateur est déjà utilisé.");
		} else
			throw new FormValidationException("Merci d'entrer un nom d'utilisateur.");
	}
	
	private void emailProcessing(String email, User user) {
		try {
			checkEmail(email);
			user.setEmail(email);
		} catch (FormValidationException E) {
			addErrors(EMAIL_FIELD, E.getMessage());
		}
	}
	
	private void checkEmail(String email) throws FormValidationException {
		if(email != null) {
			if(!email.matches("(\\w)+@(\\w)+\\.(\\w)+"))
				throw new FormValidationException("Merci d'entrer une adresse email valide.");
			else if(userDAO.findByEmail(email) != null)
				throw new FormValidationException("L'adresse email est déjà utilisée.");
		}	else
			throw new FormValidationException("Merci d'entrer une adresse email.");
	}
	
	private void passwordProcessing(String pw, String pwConf, User user) {
		try {
			checkPassword(pw, pwConf);
			user.setPassword(pw);
		} catch (FormValidationException E) {
			addErrors(PW_FIELD, E.getMessage());
		}
	}
	
	private void checkPassword(String pw, String pwConf) throws FormValidationException {
		if(pw != null && pwConf != null) {
			if(!pw.equals(pwConf))
				throw new FormValidationException("Les mots de passe sont différentes");
		} else throw new FormValidationException("Merci d'entrer un mot de passe.");
	}
}
