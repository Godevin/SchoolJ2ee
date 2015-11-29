package fr.synapsegaming.utils;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import java.util.Comparator;

public class Comparateur implements Comparator{
	
	 private Map base;

	public Comparateur(Map base) {
	        this.base = base;
	    }
	
	public TreeMap sortAndResize(int taille){
		TreeMap sorted_map = new TreeMap(this);
		sorted_map.putAll(base);
		while(sorted_map.size()>taille){
			sorted_map.pollLastEntry();
		}
		
		return sorted_map;
	}

	@Override
	public int compare(Object a, Object b) {
		if ((Integer)base.get(a) >= (Integer)base.get(b)) {
            return -1;
        } else {
            return 1;
        } 
	}

}
