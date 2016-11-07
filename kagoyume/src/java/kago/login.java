/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kago;

import DB.DBManager;
import DB.UserDataDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Yuu
 */
public class login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
         response.setContentType("text/html;charset=UTF-8");
       
        request.setCharacterEncoding("UTF-8");
        HttpSession hs = request.getSession();
        
        try (PrintWriter out = response.getWriter()) {
            //ログインチェック用に打ち込まれたものを変数に代入
            String name = request.getParameter("name");
            String password = request.getParameter("password");

            Connection con = null;
            PreparedStatement st = null;
            ResultSet rs = null;
            con = DBManager.getConnection();
            //ログインチェック
            st = con.prepareStatement("select * from user_t where name=?");
            st.setString(1, name);
            rs = st.executeQuery();
            //パスワードチェック用に用意
            String pass = null;
            //パスワードがチェック用変数と一致したらIDとnameをDTOにセット
            while (rs.next()) {
                pass = rs.getString("password");
                if (password.equals(pass)) {
                    UserDataDTO udd2 = new UserDataDTO();
                    udd2.setUserID(rs.getInt("userID"));
                    udd2.setName(rs.getString("name"));
                    
                    hs.setAttribute("login", udd2);                    
                    request.getRequestDispatcher("/logincomplete.jsp").forward(request, response);
                }
            }
        }
    }

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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
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
