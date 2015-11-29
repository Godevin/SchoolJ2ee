package fr.synapsegaming.statistiques.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fr.synapsegaming.user.entity.Clazz;

public interface StatistiquesService {

	/**
	 * Liste les 5 classes les plus jouées
	 * @return Liste de classes
	 */
	 Map listFiveClassesMostPlayed();

	 Map listFiveRacesMostPlayed();

	 Map listFiveSpecializationsMostPlayed();
	 
	 ArrayList listUserWithoutAvatar();

}