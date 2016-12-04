package entity;
// Generated 29.08.2016 16:09:18 by Hibernate Tools 4.3.1

import java.util.Set;


/**
 * Users generated by hbm2java
 */


public class User  implements java.io.Serializable {

     private long id;
     private String name;
     private String lastname;
     private String login;
     private String password;
     private String mail;
     private Set<CommentFilm> user_comments;
     private Role role;

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setUser_comments(Set<CommentFilm> user_comments) {
        this.user_comments = user_comments;
    }

    public Set<CommentFilm> getUser_comments() {
        return user_comments;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public long getId() {
        return id;
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

    public User() {
    }

	
    public User(long id) {
        this.id = id;
    }
    

}


