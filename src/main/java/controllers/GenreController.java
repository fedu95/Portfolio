/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import database.DataHelper;
import entity.Film;
import entity.Genre;
import entity.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Администратор
 */

@ManagedBean
@RequestScoped

public class GenreController {
    
    public GenreController()
    {   
       HibernateUtil.getSessionFactory();
        fillGenresAndFilms();
        adminLogin();
        
    }
    
    public boolean adminActive;
    public List<Genre> genreList;
    public List<Film> listFilms;

    public void setListFilms(List<Film> listFilms) {
        this.listFilms = listFilms;
    }

    public List<Film> getListFilms() {
        return listFilms;
    }

   public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }
    
    
    public void fillGenresAndFilms()
    {
        genreList = DataHelper.getInstance().getAllGenres(); 
        for(Genre g : genreList)
        {
                listFilms = new ArrayList<Film>(g.getFilms());
        }
        
    }
    
    public String fillFilmsByGenre()
    {
      Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
      int id = Integer.valueOf(params.get("genre_id"));
      
      for(Genre g : genreList)
        {   if(g.getId() == id)
        {
      
             listFilms = new ArrayList<Film>(g.getFilms());
      }}
     
      
        return "go";
      
    }

    public void adminLogin() {

        adminActive = false;
        
    Map<String,Object> params = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    int role_user = Integer.valueOf((Integer) params.get("user_role"));
    
    if(role_user == 2)
    {
            adminActive = true;
    
    }else if (role_user == 1) {adminActive = false;}

    }

    public boolean isAdminActive() {
        return adminActive;
    }

    public void setAdminActive(boolean adminActive) {
        this.adminActive = adminActive;
    }
    
    
    
}
