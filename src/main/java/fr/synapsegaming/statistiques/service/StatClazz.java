package fr.synapsegaming.statistiques.service;

import fr.synapsegaming.user.entity.Clazz;
import java.util.Comparator;

public class StatClazz implements Comparator<StatClazz> {


    private int occurences;
    private Clazz clazz;


    public int getOccurences() {
        return occurences;
    }

    public void setOccurences(int occurences) { this.occurences = occurences; }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public int compare(StatClazz o1, StatClazz o2) {
        Integer occurence1 = o1.getOccurences();
        Integer occurence2 = o2.getOccurences();
        return occurence1.compareTo(occurence2);
    }

}