package eu.ensup.demojpaweb.service;

import eu.ensup.demojpaweb.dao.FormationDao;
import eu.ensup.demojpaweb.domaine.Formation;

public class FormationService implements IFormationService {
	FormationDao dao = new FormationDao();

	public boolean creerFormation(Formation formation) {
		// TODO Auto-generated method stub
		return dao.createFormation(formation);
	}

}
