/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;





import entity.CommentFilm;
import entity.Film;
import entity.Genre;
import entity.HibernateUtil;
import entity.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Администратор
 */
public class DataHelper {
    
    private SessionFactory sessionFactory = null;
    private static DataHelper datahelper;
    private static Session session = null;
    
    private DataHelper(){
    
    sessionFactory = HibernateUtil.getSessionFactory();
    
    }
    
    public static DataHelper getInstance(){
    
            if(datahelper == null)
            {
                datahelper = new DataHelper();
            }   
            
            return datahelper;
    }
    
    
    
    private Session getSession()
    {
    
    return  sessionFactory.getCurrentSession();
  
    }
    
    
    
    public List<CommentFilm> getComments(int id_film)
    {       
            List<CommentFilm> list = new ArrayList<CommentFilm>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            list = session.createCriteria(CommentFilm.class).add(Restrictions.eq("idFilm", id_film)).list();
           } catch(Exception e){}
        finally{session.close();}
        
        
        return list;
    }
        public List<Film> getAllFilms()
    {    
            List<Film> list = new ArrayList<Film>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            list = session.createCriteria(Film.class).list();
           } catch(Exception e){}
        finally{session.close();}
        
        
        return list;
    }
    public List<Genre> getAllGenres()
    {       
           List<Genre> list = new ArrayList<Genre>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            list = session.createCriteria(Genre.class).list();
           } catch(Exception e){}
        finally{session.close();}
        
        
        return list;
    }
    
    
    
    public List<User> getAllUsers()
    {     
        
        List<User> list = new ArrayList<User>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            list = session.createCriteria(User.class).list();
           } catch(Exception e){}
        
        finally{session.close();}
        
        
        return list;
    }
    
    
    public Film getFilmById(long idfilm) throws SQLException
    {     
        Film film = null;
        try{
        
            session = HibernateUtil.getSessionFactory().openSession();
            film = (Film) session.get(Film.class, Long.valueOf(idfilm));
            
        } catch(Exception e)
        
        {
        
            System.out.println("Такого пользователя не найдено");        
        
        }
        
        finally{
            
            session.close();
            
        }
        
        return film;
    }
    
    
    public List<Film> getFilmsByGenre(int id_genre)
    {       
        List<Film> list = new ArrayList<Film>();
         try{
            session = HibernateUtil.getSessionFactory().openSession();
            list = session.createCriteria(Film.class).add(Restrictions.eq("idGenre", id_genre)).list();
           } catch(Exception e){}
        finally{session.close();}
        return list;     
    }
    
    
    public Object getFieldValue(String field, int id)
    {      
        Object o = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            o = session.createCriteria(Film.class).setProjection(Projections.property(field))
                    .add(Restrictions.eq("idfilm", id)).uniqueResult();
           } catch(Exception e){}
        finally{session.close();}
        
        
        return o;
    }
    
    
    
}
