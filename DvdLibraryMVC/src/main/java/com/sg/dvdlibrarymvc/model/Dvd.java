/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrarymvc.model;

import java.util.Objects;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author benli
 */
public class Dvd {
    int dvdId;
    @NotEmpty(message = "You must supply a value for Title.")
    @Length(max = 50, message = "Title must be no more than 50 characters in length.")
    String title;
    @NotEmpty(message = "You must supply a value for Director.")
    @Length(max = 50, message = "Director must be no more than 50 characters in length.")
    String director;
    @NotEmpty(message = "You must supply a value for Release Date.")
    @Length(max = 10, message = "Release Date must be no more than 10 characters in length.")
    String releaseDate;
    @NotEmpty(message = "You must supply a value for Studio.")
    @Length(max = 20, message = "Studio must be no more than 20 characters in length.")
    String studio;
    @NotEmpty(message = "You must supply a value for Rating.")
@Length(max = 4, message = "Rating must be a percentage value.")
    String rating;
    @Length(max = 100, message = "First Name must be no more than 100 characters in length.")
    String comments;

    public int getDvdId() {
        return dvdId;
    }

    public void setDvdId(int dvdId) {
        this.dvdId = dvdId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
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
        hash = 29 * hash + this.dvdId;
        hash = 29 * hash + Objects.hashCode(this.title);
        hash = 29 * hash + Objects.hashCode(this.director);
        hash = 29 * hash + Objects.hashCode(this.releaseDate);
        hash = 29 * hash + Objects.hashCode(this.studio);
        hash = 29 * hash + Objects.hashCode(this.rating);
        hash = 29 * hash + Objects.hashCode(this.comments);
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
        final Dvd other = (Dvd) obj;
        if (this.dvdId != other.dvdId) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        if (!Objects.equals(this.studio, other.studio)) {
            return false;
        }
        if (!Objects.equals(this.rating, other.rating)) {
            return false;
        }
        if (!Objects.equals(this.comments, other.comments)) {
            return false;
        }
        return true;
    }
    
    
}
