/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersspringmvc.service;

import com.sg.supersspringmvc.dao.HeroDao;
import com.sg.supersspringmvc.dao.HeroSearchTerm;
import com.sg.supersspringmvc.model.Hero;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author benli
 */
public class HeroServiceImpl implements HeroService {

    HeroDao dao;
    
    public HeroServiceImpl(HeroDao dao) {
        this.dao = dao;
    }
    
    public void validateHeroData(Hero hero) throws DataValidationException {
        if(hero.getName() == null || hero.getName().trim().length() == 0 ||
                hero.getDescription() == null || hero.getDescription().trim().length() == 0 ||
                hero.getPowers() == null || hero.getPowers().trim().length() == 0 ||
                hero.getLocationId() == 0 ||
                hero.getOrganizationId()== 0) {
            throw new DataValidationException("Error: All Fields Are Required!");
        }
    }
    
    @Override
    public Hero addHero(Hero hero) throws DataValidationException {
        validateHeroData(hero);
        Hero newHero = dao.addHero(hero);     
        return newHero;
    }

    @Override
    public void removeHero(int heroId) {
        dao.removeHero(heroId);
        
    }

    @Override
    public void updateHero(Hero hero) throws DataValidationException {
        dao.updateHero(hero);
        
    }

    @Override
    public List<Hero> getAllHeros() {
        return dao.getAllHeros();
    }

    @Override
    public Hero getHeroById(int heroId) {
        return dao.getHeroById(heroId);
    }

    @Override
    public List<Hero> searchHeros(Map<HeroSearchTerm, String> criteria) {
        List<Hero> heroList = dao.searchHeros(criteria);
        
        return heroList;
    }
    
}
