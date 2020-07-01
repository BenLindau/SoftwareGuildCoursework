/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersspringmvc.dao;

import com.sg.supersspringmvc.model.Hero;
import java.util.List;
import java.util.Map;

/**
 *
 * @author benli
 */
public interface HeroDao {
    
    
    public Hero addHero(Hero hero);
    
    public void removeHero(int heroId);
    
    public void updateHero(Hero hero);
    
    public List<Hero> getAllHeros();
    
    public Hero getHeroById(int heroId);
    
    public List<Hero> searchHeros(Map<HeroSearchTerm, String> criteria);
    
    
}
