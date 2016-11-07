/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kago;

import API.APIsyori;
import API.GetAPI;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Yuu
 */
public class serch extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession hs = request.getSession();
        
        try (PrintWriter out = response.getWriter()) {
            
            APIsyori yahoo = new APIsyori();
            String search = request.getParameter("serch");
            //飛んできたserchをエンコードしてutf-8に。文字バケを失くす為。
            String query = URLEncoder.encode(search, "UTF-8");
            
            //YahooAPIを使った検索。検索ワードに変数queryを代入
             String url = "http://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch?appid=dj0zaiZpPUxKN1pYNWNzTjJ3ayZzPWNvbnN1bWVyc2VjcmV0Jng9MjU-&query=" + query;
            //urlの検索結果をresultに代入
            String result = yahoo.getResult(url);
            //検索結果をジェイソンノードにして文字を読みやすくする
            JsonNode node = yahoo.getJsonNode(result);
            
            //変数jsonにgetで取りだす共通事項を外側から3つ代入
            JsonNode json = node.get("ResultSet").get("0").get("Result");
            //検索結果保管する為にArrayListを作成
            ArrayList<GetAPI> list = new ArrayList<>();
            //検索結果分ArrayListに入れたいのでsizeで回す。jsonの検索結果から最後の3つを除く為に-3を入れる
            for (int i = 0; i < json.size() - 3; i++) {
                //ArrayListのlistに入れる為にitemを作成
                GetAPI item = new GetAPI();
                //itemに検索結果を入れていく。この時に文字列に変換してから入れていく
                item.setName(json.get(String.valueOf(i)).get("Name").asText());
                item.setPrice(json.get(String.valueOf(i)).get("Price").get("_value").asInt());
                item.setImage(json.get(String.valueOf(i)).get("Image").get("Medium").asText());
                item.setDis(json.get(String.valueOf(i)).get("Description").asText());
                item.setCode(json.get(String.valueOf(i)).get("Code").asText());
                //必要な情報全て入れ終わったらlistに代入
                list.add(item);
            }
            //検索結果の情報が入っているlistをセッションに保存
            hs.setAttribute("result", list);
            request.getRequestDispatcher("/serch.jsp").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
