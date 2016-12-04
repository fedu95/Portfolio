/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import database.DataHelper;
import entity.CommentFilm;
import entity.Film;
import entity.HibernateUtil;
import entity.User;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;
import org.hibernate.Session;






@ManagedBean
@ApplicationScoped

public class FilmListController {
    public String text;
    public String date;
    public String username;
    public int idFilm;
    public boolean usercomment = false;
    
    
    
    
    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        return date;
    }

    public String getUsername() {
        return username;
    }
    
    
    public List<Film> listFilms;
    public List<CommentFilm> comments;

    public void setComments(List<CommentFilm> comments) {
        this.comments = comments;
    }

    public List<CommentFilm> getComments() {
        return comments;
    }

    public void setListFilms(List<Film> listFilms) {
        this.listFilms = listFilms;
    }

    public List<Film> getListFilms() {
        return listFilms;
    }
    
    public void refreshComments()
    {
        Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
       
       
        Session s = HibernateUtil.getSessionFactory().openSession();
        Film f = (Film) s.get(Film.class,  Long.valueOf(idFilm));
        comments = new ArrayList<CommentFilm>(f.getComments());
        s.close();
        
  
    }
 public void addComment() throws NamingException, SQLException
   {
            Map<String,Object> map  = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            Map<String,String> objpar = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
            long id_user = Long.valueOf((String) map.get("user_id"));
            username = objpar.get("username");
            
            Date time = new Date(System.currentTimeMillis());
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm dd.MM.yyyy");
            date = dateFormat.format(time);
            
        
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            CommentFilm comment = new CommentFilm();
            Film f = new Film();
            User u = new User();
            u.setId(id_user);
            f.setIdfilm(idFilm);
            comment.setComment(text);
            comment.setDate(time);
            comment.setUser(u);
            comment.setFilm(f);
            comment.setUsername(username);
            
            session.save(comment);
            
            session.getTransaction().commit();
            session.close();
           
            myComment(Long.valueOf(idFilm),id_user);
            refreshComments();
           
           
   }
   

    public String fillFilmById() throws SQLException, NamingException
    {
            Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
            idFilm = Integer.valueOf(params.get("idfilm"));
            
             Map<String,Object> map  = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            long id_user = Long.valueOf((Long) map.get("user_id"));
            
            myComment(Long.valueOf(idFilm),id_user);
            for(Film f : DataHelper.getInstance().getAllFilms())
            {
                
                if(f.getIdfilm() == idFilm)
                {
                        listFilms = new ArrayList<Film>();
                        listFilms.add(f);
                                         
                        
                        comments = new ArrayList<CommentFilm>(f.getComments());
                        
                }
             }
            
            return "descript";
             
    }

    public boolean isUsercomment() {
        return usercomment;
    }

    public void setUsercomment(boolean usercomment) {
        this.usercomment = usercomment;
    }
    
    public void myComment(long id_film, long id_user) throws NamingException, SQLException
   {
         Session s = HibernateUtil.getSessionFactory().openSession();
         Map<String,Object> map = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
         Long role_user = Long.valueOf((String) map.get("user_role"));


         s.beginTransaction();
         
         Film f = (Film) s.get(Film.class, id_film);
         for(CommentFilm cm : f.getComments())
         {
             if(role_user == 2)
             {
                 cm.setMycom(true);
             }
             else if(cm.getUser().getId() == id_user)
                {
                        cm.setMycom(true);
                
                
                }
             
             else{cm.setMycom(false);}
         }
         
         s.update(f);
         s.getTransaction().commit();
         s.close();
            
   }
    
    public void deleteComment()
    {
        Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        long id = Long.valueOf(params.get("id_comm"));
        Session s= null;
        
        try
        {
            s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            CommentFilm c = (CommentFilm) s.get(CommentFilm.class, id);
            s.delete(c);
            s.getTransaction().commit();
        }
       
        finally{
                s.close();
                refreshComments();
        }
    
    }
    
    
    
}
