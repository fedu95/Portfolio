/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;



import database.DataHelper;
import entity.User;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;



@ManagedBean
@SessionScoped

public class LoginController implements Serializable{
    
   public List<User> listOfUsers;
  
    boolean correctLogin;

    public boolean isCorrectLogin() {
        return correctLogin;
    }
    private String UserName;
    private String password;

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return password;
    }
   
  
    private boolean userCheck()
    {
            listOfUsers = DataHelper.getInstance().getAllUsers();
            correctLogin = false;
            
            for(User user : listOfUsers)
            {
                    if(user.getLogin().equals(UserName) && user.getPassword().equals(password))
                    {
                            correctLogin = true;
                            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user_id", user.getId());
                            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", UserName);
                            
                            if(user.getRole().getId() == 1)
                            {
                                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user_role", 1);
                            }else if(user.getRole().getId()==2)
                            {
                                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user_role", 2);
                            }
                            
                            break;
                    
                    }
                    else 
                    {correctLogin = false;}
            
                    
            }
                return correctLogin;
    }
   
    public String login() throws SQLException 
    {
            
        
            if(userCheck() == true)
            {
                    
                    
                    return "go";
            }else {
                
                FacesMessage m = new FacesMessage("Неправильный логин или пароль");
                FacesContext.getCurrentInstance().addMessage(null, m);
                
                return "home";}
            
           
                 
   }
       
    
    public String logout()
    {
      FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("username");
      FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("user_role");
      FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("user_id");
      FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

      
      
      
      
      
      return "home";
    }
    
     
   

    
    
}
