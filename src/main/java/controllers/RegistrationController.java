/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entity.HibernateUtil;
import entity.Role;
import entity.User;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Session;


@ManagedBean
@RequestScoped
public class RegistrationController {
    
     private String name;
     private String lastname;
     private String login;
     private String password;
     private String mail;

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }
    
    
    public String goReg()
    {return "reg";}
    
    public String registration()
    {
        
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            User user = new User();
            Role role = new Role();
            role.setId(1);
            user.setLastname(lastname);
            user.setMail(mail);
            user.setLogin(login);
            user.setPassword(password);
            user.setRole(role);
            
            session.save(user);
            
            session.getTransaction().commit();
            session.close();
    
            return "/index?faces-redirect=true";
    }
}
