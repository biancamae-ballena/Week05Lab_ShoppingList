/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 785284
 */
public class ShoppingListServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        if (action != null && action.equals("logout")) {
            session.invalidate();
            response.sendRedirect("shoppingList");
        } else {
            String user = (String) session.getAttribute("username");
            if (user != null && !user.equals("")) {
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            } else {
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        HttpSession session = request.getSession();
//
//        String username = request.getParameter("username");
//
//        session.setAttribute("username", username);
//        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        if (action != null && !action.equals("")) {
            if (action.equals("register")) {
                String fldUsername = request.getParameter("fldUsername");
                if (fldUsername != null && !fldUsername.equals("")) {
                    session.setAttribute("username", fldUsername);
                    ArrayList<String> items = new ArrayList<String>();
                    session.setAttribute("items", items);
                }
            } else if (action.equals("add")) {
                String fldItem = request.getParameter("fldItem");
                if (fldItem != null && !fldItem.equals("")) {
                    ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
                    if (items == null) // For safety.
                    {
                        items = new ArrayList<String>();
                    }
                    items.add(fldItem);
                    session.setAttribute("items", items);
                }
            } else if (action.equals("delete")) {
                String radSelect = request.getParameter("radSelect");
                if (radSelect != null && !radSelect.equals("")) {
                    try {
                        int selected = Integer.parseInt(radSelect);
                        ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
                        if (items == null) // For safety.
                        {
                            items = new ArrayList<String>();
                        }
                        items.remove(selected);
                        session.setAttribute("items", items);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        response.sendRedirect("shoppingList");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
