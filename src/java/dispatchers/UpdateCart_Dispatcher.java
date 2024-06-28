/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.CartItem;

/**
 * UpdateCart_Dispatcher class implementing the Dispatcher interface.
 * This class handles updating the shopping cart based on user input, such as 
 * removing items or updating item quantities.
 * @author souza
 */
public class UpdateCart_Dispatcher implements Dispatcher {

    /**
     *
     * @param request
     * @return nextPage
     */
    @Override
    public String execute(HttpServletRequest request){

        HttpSession session = request.getSession();
//        String nextPage = "/jsp/cart.jsp";
        
            Map cart = null;
            CartItem item = null;
            String isbn = null;
            String nextPage = "/jsp/cart.jsp";
            cart = (Map) session.getAttribute("cart");
            String[] booksToRemove = request.getParameterValues("remove");
            if (booksToRemove != null) {
                for (int i = 0; i < booksToRemove.length; i++) {
                    cart.remove(booksToRemove[i]);
                }
            }
            Set entries = cart.entrySet();
            Iterator iter = entries.iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                isbn = (String) entry.getKey();
                item = (CartItem) entry.getValue();
                int quantity = Integer.parseInt((request.getParameter(isbn)));
                item.updateQuantity(quantity);
            }
            
          return nextPage;
}}
