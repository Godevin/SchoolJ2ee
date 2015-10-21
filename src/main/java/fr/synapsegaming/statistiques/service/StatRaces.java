package fr.synapsegaming.statistiques.service;

import fr.synapsegaming.user.entity.Race;

import java.util.Comparator;

public class StatRaces implements Comparator<StatRaces> {


    private int occurences;
    private Race race;


    public int getOccurences() {
        return occurences;
    }

    public void setOccurences(int occurences) { this.occurences = occurences; }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    @Override
    public int compare(StatRaces o1, StatRaces o2) {
        Integer occurence1 = o1.getOccurences();
        Integer occurence2 = o2.getOccurences();
        return occurence1.compareTo(occurence2);
    }

}