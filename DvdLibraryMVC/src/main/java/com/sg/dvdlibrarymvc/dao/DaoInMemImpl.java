/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrarymvc.dao;

import com.sg.dvdlibrarymvc.model.Dvd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author benli
 */
public class DaoInMemImpl implements DvdDao {
    
    private Map<Integer, Dvd> dvdMap = new HashMap<>();
    
    private static int dvdIdCounter = 0;
    
    @Override
    public Dvd addDvd(Dvd dvd) {
        dvd.setDvdId(dvdIdCounter);
        dvdIdCounter++;
        
        dvdMap.put(dvd.getDvdId(), dvd);
        return dvd;
    }

    @Override
    public void removeDvd(int dvdId) {
        dvdMap.remove(dvdId);
    
    }

    @Override
    public void updateDvd(Dvd dvd) {
        dvdMap.put(dvd.getDvdId(), dvd);
    }

    @Override
    public List<Dvd> getAllDvds() {
        Collection<Dvd> d = dvdMap.values();
        return new ArrayList(d);
    }

    @Override
    public Dvd getDvdById(int dvdId) {
        return dvdMap.get(dvdId);
    }

    @Override
    public List<Dvd> searchDvd(Map<SearchTerm, String> criteria) {
        
        String titleSearchCriteria =
                criteria.get(SearchTerm.TITLE);
        String releaseDateCriteria = 
                criteria.get(SearchTerm.RELEASE_DATE);
        String directorCriteria = 
                criteria.get(SearchTerm.DIRECTOR);
        String studioCriteria =
                criteria.get(SearchTerm.STUDIO);
        String ratingCriteria =
                criteria.get(SearchTerm.RATING);
                
         Predicate<Dvd> titleMatchPredicate;
         Predicate<Dvd> releaseDateMatchPredcate;
         Predicate<Dvd> directorMatchPredicate;
         Predicate<Dvd> studioMatchPredicate;
         Predicate<Dvd> ratingMatchPredicate;
         
         Predicate<Dvd> truePredicate = (c) -> {
             return true;
         };
         
         if (titleSearchCriteria == null || 
                 titleSearchCriteria.isEmpty()) {
             titleMatchPredicate = truePredicate;
         } else {
             titleMatchPredicate = 
                     (c) -> c.getTitle().equals(titleSearchCriteria);
         }
         
         if (releaseDateCriteria == null ||
                 releaseDateCriteria.isEmpty()) {
             releaseDateMatchPredcate = truePredicate;
         }else {
             releaseDateMatchPredcate = 
                     (c) -> c.getReleaseDate().equals(releaseDateCriteria);
         }
         
         if (directorCriteria == null ||
                 directorCriteria.isEmpty()) {
             directorMatchPredicate = truePredicate;
         } else {
             directorMatchPredicate =
                     (c) -> c.getDirector().equals(directorCriteria);
         }
         
         if (studioCriteria == null ||
                 studioCriteria.isEmpty()) {
             studioMatchPredicate = truePredicate;
         } else {
             studioMatchPredicate =
                     (c) -> c.getStudio().equals(studioCriteria);
         }
         
          if (ratingCriteria == null ||
                 ratingCriteria.isEmpty()) {
             ratingMatchPredicate = truePredicate;
         } else {
             ratingMatchPredicate =
                     (c) -> c.getStudio().equals(ratingCriteria);
         }
          
         return dvdMap.values().stream()
                 .filter(titleMatchPredicate
                 .and(releaseDateMatchPredcate)
                 .and(directorMatchPredicate)
                 .and(studioMatchPredicate)
                 .and(ratingMatchPredicate))
                 .collect(Collectors.toList());
          
    }
    
}
