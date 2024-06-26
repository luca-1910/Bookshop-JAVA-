/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author souza
 */
public class Checkout_Dispatcher implements Dispatcher {
      @Override
    public String execute(HttpServletRequest request){
        HttpSession session = request.getSession();
        String nextPage = "/jsp/checkout.jsp";
        
        return nextPage;
}}
        