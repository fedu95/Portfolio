package entity;
// Generated 29.08.2016 16:09:18 by Hibernate Tools 4.3.1

import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;



@ManagedBean
@RequestScoped
public class Film  implements java.io.Serializable {


    
     private long idfilm;

    public void setIdfilm(long idfilm) {
        this.idfilm = idfilm;
    }

    public long getIdfilm() {
        return idfilm;
    }
     private String title;
     private Genre genre;
     private int year;
     private String country;
     private int time;
     private byte[] poster;
     private String description;
     private Set<CommentFilm> comments;

    

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setPoster(byte[] poster) {
        this.poster = poster;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setComments(Set<CommentFilm> comments) {
        this.comments = comments;
    }

    

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public int getTime() {
        return time;
    }

    public byte[] getPoster() {
        return poster;
    }

    public String getDescription() {
        return description;
    }

    public Set<CommentFilm> getComments() {
        return comments;
    }

    public Film() {
    }

	public Film(long id) {
        idfilm = id;
    }

    
}


