package fr.synapsegaming.statistiques.service;

import fr.synapsegaming.user.entity.Specialization;

import java.util.Comparator;

public class StatSpecialization implements Comparator<StatSpecialization> {


    private int occurences;
    private Specialization specialization;


    public int getOccurences() {
        return occurences;
    }

    public void setOccurences(int occurences) { this.occurences = occurences; }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    @Override
    public int compare(StatSpecialization o1, StatSpecialization o2) {
        Integer occurence1 = o1.getOccurences();
        Integer occurence2 = o2.getOccurences();
        return occurence1.compareTo(occurence2);
    }

}