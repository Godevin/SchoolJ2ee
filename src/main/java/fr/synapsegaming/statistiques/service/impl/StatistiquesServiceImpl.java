package fr.synapsegaming.statistiques.service.impl;

import fr.synapsegaming.statistiques.service.StatClazz;
import fr.synapsegaming.statistiques.service.StatRaces;
import fr.synapsegaming.statistiques.service.StatSpecialization;
import fr.synapsegaming.statistiques.service.StatistiquesService;
import fr.synapsegaming.user.dao.UserDao;
import fr.synapsegaming.user.entity.Specialization;
import fr.synapsegaming.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service("StatistiquesService")
public class StatistiquesServiceImpl implements StatistiquesService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<StatClazz> listFiveClassesMostPlayed() {

        List<User> users = userDao.list(User.class);
        List<StatClazz> classes = new ArrayList<>();

        for(int i = 0; i<users.size(); i++){
            boolean contains = false;
            for (int j = 0; j<classes.size(); j++){
                if (classes.get(j).getClazz().getId() == users.get(i).getClazz().getId()) {
                    contains = true;
                    classes.get(j).setOccurences(classes.get(j).getOccurences() + 1);
                }
            }
            if (!contains) {
                StatClazz stat = new StatClazz();
                stat.setClazz(users.get(i).getClazz());
                stat.setOccurences(1);
                classes.add(stat);
            }
        }

        Collections.sort(classes, new StatClazz().reversed());

        return classes.subList(0, 5);

    }

    @Override
    public List<StatRaces> listFiveRacesMostPlayed() {

        List<User> users = userDao.list(User.class);
        List<StatRaces> races = new ArrayList<>();

        for(int i = 0; i<users.size(); i++){
            boolean contains = false;
            for (int j = 0; j<races.size(); j++){
                if (races.get(j).getRace().getId() == users.get(i).getRace().getId()) {
                    contains = true;
                    races.get(j).setOccurences(races.get(j).getOccurences() + 1);
                }
            }
            if (!contains) {
                StatRaces stat = new StatRaces();
                stat.setRace(users.get(i).getRace());
                stat.setOccurences(1);
                races.add(stat);
            }
        }

        Collections.sort(races, new StatRaces().reversed());

        return races.subList(0, 5);

    }

    @Override
    public List<StatSpecialization> listFiveSpecializationsMostPlayed() {

        List<User> users = userDao.list(User.class);
        List<StatSpecialization> specializations = new ArrayList<>();

        for(int i = 0; i<users.size(); i++){
            boolean contains = false;
            for (int j = 0; j<specializations.size(); j++){
                if (specializations.get(j).getSpecialization().getId() == users.get(i).getSpec().getId()) {
                    contains = true;
                    specializations.get(j).setOccurences(specializations.get(j).getOccurences() + 1);
                }
            }
            if (!contains) {
                StatSpecialization stat = new StatSpecialization();
                stat.setSpecialization(users.get(i).getSpec());
                stat.setOccurences(1);
                specializations.add(stat);
            }
        }

        Collections.sort(specializations, new StatSpecialization().reversed());

        return specializations.subList(0, 5);

    }
}