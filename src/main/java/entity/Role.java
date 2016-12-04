/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Set;

/**
 *
 * @author Администратор
 */
public class Role {
    
    private long id;
    private String titlerole;
    private Set<User> users;

    public Role() {

    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    

    public Role(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getTitlerole() {
        return titlerole;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitlerole(String titlerole) {
        this.titlerole = titlerole;
    }
    
    
    
}
