/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author souza
 */
public class ViewCart_Dispatcher implements Dispatcher {
      @Override
    public String execute(HttpServletRequest request){
        HttpSession session = request.getSession();
        
            String nextPage = "/jsp/cart.jsp";
            Map cart = (Map) session.getAttribute("cart");
            if (cart == null) {
                nextPage = "/jsp/titles.jsp";
            }
        
        return nextPage;
    }
}
