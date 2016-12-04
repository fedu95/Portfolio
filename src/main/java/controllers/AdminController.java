/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entity.CommentFilm;
import entity.Film;
import entity.Genre;
import entity.HibernateUtil;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.hibernate.Session;

@ManagedBean
@RequestScoped
public class AdminController implements Serializable{
    
    private String title;
    private int time;
    private String decription;
    private int year;
    private String country;
    private long id_genre;
    private List<Genre> genrelist;
    private File poster;

    public void setPoster(File poster) {
        this.poster = poster;
    }

    public File getPoster() {
        return poster;
    }

    public List<Genre> getGenrelist() 
        {
        Session s = null;
        try{
            s = HibernateUtil.getSessionFactory().openSession();
            
            genrelist = s.createCriteria(Genre.class).list();
        }finally{ s.close();
        }
        
    
       
        
        return genrelist;
    }
    

    public void setGenrelist(List<Genre> genrelist) {
        this.genrelist = genrelist;
    }
    
    

    public void setId_genre(long id_genre) {
        this.id_genre = id_genre;
    }

    public long getId_genre() {
        return id_genre;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTitle() {
        return title;
    }

    public int getTime() {
        return time;
    }

    public String getDecription() {
        return decription;
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }
    
    public String addFilm()
    {
       
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Genre g = new Genre();
        g.setId(id_genre);
        Film film = new Film();
        film.setGenre(g);
        film.setTitle(title);
        film.setCountry(country);
        film.setTime(time);
        film.setDescription(decription);
        film.setYear(year);
        
        s.save(film);
        s.getTransaction().commit();
        s.close();
        
        GenreController genreControl = new GenreController();
       
        
        return "home";
    }
    
    public void deleteComments(CommentFilm cf)
    {
    
     Session s = HibernateUtil.getSessionFactory().openSession();
     s.beginTransaction();
     s.delete(cf);
     s.getTransaction().commit();
     s.close();
    
    
    }
        
  /*  public void deleteFilm()
    {
        Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        long id_film = Long.valueOf(params.get("id_film"));
        
          Session s = HibernateUtil.getSessionFactory().openSession();
          s.beginTransaction();
            
          Film f = (Film) s.get(Film.class, id_film);
           
            
            for(CommentFilm c : f.getComments())
           {
                
             
                
             }
                
                
              
          
               s.close();
           
       
        
    }*/
    
    
    
    
}
