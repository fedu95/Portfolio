package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import database.DataHelper;
import entity.Film;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/ShowImage"})
public class ShowImage extends HttpServlet {


   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
        
            OutputStream out = response.getOutputStream();
            
            response.setContentType("image/jpeg");
            
            int index = Integer.valueOf(request.getParameter("idfilm"));
            List<Film> list = DataHelper.getInstance().getAllFilms();
            
            
            for(Film f : list)
            {
                    if(index == f.getIdfilm())
                    {
                          byte[] image = f.getPoster();
            
                    response.setContentLength(image.length);
                    out.write(image);   
                        
                    
                    }
            
            }
            
            
            
            
           
    
    }


    

}
