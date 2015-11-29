package fr.synapsegaming.statistiques.service.impl;

import fr.synapsegaming.statistiques.service.StatClazz;
import fr.synapsegaming.statistiques.service.StatRaces;
import fr.synapsegaming.statistiques.service.StatSpecialization;
import fr.synapsegaming.statistiques.service.StatistiquesService;
import fr.synapsegaming.user.entity.Clazz;
import fr.synapsegaming.user.entity.Race;
import fr.synapsegaming.user.dao.UserDao;
import fr.synapsegaming.user.entity.Specialization;
import fr.synapsegaming.user.entity.User;
import fr.synapsegaming.user.service.UserService;
import fr.synapsegaming.utils.Comparateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("StatistiquesService")
public class StatistiquesServiceImpl implements StatistiquesService {
    
    @Autowired
    UserService userService;

    @Override
    public Map listFiveClassesMostPlayed() {

    HashMap<Clazz, Integer> Statsclazz = new HashMap <Clazz, Integer>();

    for(User u : userService.getAllUsers()){
		if(Statsclazz.containsKey(u.getClazz())){
			Statsclazz.put(u.getClazz(), Statsclazz.get(u.getClazz())+1);
		} else{
			Statsclazz.put(u.getClazz(), 1);
		}
	}
    
    Comparateur Comp5Classes = new Comparateur(Statsclazz);
    
       return Comp5Classes.sortAndResize(5);

    }

    @Override
    public Map listFiveRacesMostPlayed() {

    	 HashMap<Race, Integer> StatsRace = new HashMap <Race, Integer>();

    	    for(User u : userService.getAllUsers()){
    			if(StatsRace.containsKey(u.getRace())){
    				StatsRace.put(u.getRace(), StatsRace.get(u.getRace())+1);
    			} else{
    				StatsRace.put(u.getRace(), 1);
    			}
    		}
    	    
    	    Comparateur Comp5Race = new Comparateur(StatsRace);
    	    
    	       return Comp5Race.sortAndResize(5);
    }

    @Override
    public Map listFiveSpecializationsMostPlayed() {

    	 HashMap<Specialization, Integer> StatsSpecialization = new HashMap <Specialization, Integer>();

 	    for(User u : userService.getAllUsers()){
 			if(StatsSpecialization.containsKey(u.getSpec())){
 				StatsSpecialization.put(u.getSpec(), StatsSpecialization.get(u.getSpec())+1);
 			} else{
 				StatsSpecialization.put(u.getSpec(), 1);
 			}
 		}
 	    
 	    Comparateur Comp5Specialization = new Comparateur(StatsSpecialization);
 	    
 	       return Comp5Specialization.sortAndResize(5);

    }

	@Override
	public ArrayList listUserWithoutAvatar() {

		ArrayList<String> arrList = new ArrayList<String>();
	 	    for(User u : userService.getAllUsers()){
	 			if(u.getForumAvatar().equals("/resources/img/default_avatar.png")){
	 				arrList.add(u.getNickname());
	 			} 
	 		}
	 	   return arrList;
	}
}