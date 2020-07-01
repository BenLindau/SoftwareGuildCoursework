/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author benli
 */
public class DVD {
    
    private Long releaseDate;
    private String rating;
    private String director;
    private String studio;
    private String comments;
    private String title;
        
    
    public DVD(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }
   
    
    public Long getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Long releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String Studio) {
        this.studio = studio;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.releaseDate);
        hash = 67 * hash + Objects.hashCode(this.rating);
        hash = 67 * hash + Objects.hashCode(this.director);
        hash = 67 * hash + Objects.hashCode(this.studio);
        hash = 67 * hash + Objects.hashCode(this.comments);
        hash = 67 * hash + Objects.hashCode(this.title);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DVD other = (DVD) obj;
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        if (!Objects.equals(this.rating, other.rating)) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        if (!Objects.equals(this.studio, other.studio)) {
            return false;
        }
        if (!Objects.equals(this.comments, other.comments)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Title: " + title + "Release Date: " + releaseDate + "Rating: " + rating + "Director: " + director + "Studio: " + studio + "Comments: " + comments;
    }
    
}
