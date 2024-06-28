/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Checkout_Dispatcher class implementing the Dispatcher interface.
 * This class handles requests related to the checkout process, typically 
 * initializing the checkout view.
 * @author souza
 */
public class Checkout_Dispatcher implements Dispatcher {

    /**
     *
     * @param request
     * @return nextPage = "/jsp/checkout.jsp";
     */
    @Override
    public String execute(HttpServletRequest request){
        HttpSession session = request.getSession();
        String nextPage = "/jsp/checkout.jsp";
        
        return nextPage;
}}
        