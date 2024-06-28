/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Book;
//import utility.AdmitBookStoreDAO;

/**
 * Title_Dispatcher class implementing the Dispatcher interface.
 * This class is responsible for handling requests to display book titles.
 * It interacts with the persistence layer to fetch book data and sets the 
 * data in the session for the JSP to display.
 * @author souza
 */
public class Title_Dispatcher implements Dispatcher {
    private EntityManagerFactory emf;
    private EntityManager em;
    
    /**
     *
     * @param request
     * @return nextPage
     */
    @Override
    public String execute(HttpServletRequest request){
        
        
//            AdmitBookStoreDAO dao = new AdmitBookStoreDAO();
            emf = Persistence.createEntityManagerFactory("BookShopPU");
            em =  emf.createEntityManager();
            List books = null;
            String nextPage = "/jsp/error.jsp";
            HttpSession session = request.getSession();
            try {
//                books = dao.getAllBooks();
                books = em.createNamedQuery("Book.findAll", Book.class).getResultList();
                session.setAttribute("Books", books);
                emf.close();
                nextPage = "/jsp/titles.jsp";

            } catch (Exception ex) {
                request.setAttribute("result", ex.getMessage());
                nextPage = "/jsp/error.jsp";
            }        
        
        return nextPage;
    }

}
