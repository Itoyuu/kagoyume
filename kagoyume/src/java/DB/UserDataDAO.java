/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
/**
 *
 * @author Yuu
 */
public class UserDataDAO {
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    //購入商品をＤＢへ送る処理
 public void buy(UserDataDTO udd) throws SQLException{
      
        Connection con=null;
        PreparedStatement st = null;
  
      try{
        con = DBManager.getConnection();
        st = con.prepareStatement("update user_t set total = ? + total where userID=?"); 
        st.setInt(1, udd.getTotal());
        st.setInt(2, udd.getUserID());
        st.executeUpdate();
        
        con.close();
        st.close();
 } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
           if (con != null) {
              } con.close();
           }
      }
 //新規登録の処理
  public void insert(UserDataDTO ud) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = DBManager.getConnection();
            st = con.prepareStatement("INSERT INTO user_t(name,password,mail,address,newDate) VALUES(?,?,?,?,?)");
            st.setString(1, ud.getName());
            st.setString(2,ud.getPassword());//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, ud.getmMail());
            st.setString(4, ud.getAddress());
            st.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }
        
        
  }
  public void Deleteresult(UserDataDTO udd) throws SQLException{
          
            Connection con = null;
            PreparedStatement st = null;
            
            try{
            con = DBManager.getConnection();
            st=con.prepareStatement("delete from user_t where userID = ?");
            st.setInt(1,udd.getUserID());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
           if (con != null) {
              } con.close();
            }
            }

//アップデート機能の作成
public void Update(UserDataDTO udd) throws SQLException{
           
           Connection con = null;
           PreparedStatement st = null;

           try{
               con = DBManager.getConnection();
               st = con.prepareStatement("update user_t set name=?,password=?,mail=?,address=?,newData=?");
               st.setString(1, udd.getName());
               st.setString(2, udd.getPassword());
               st.setString(3, udd.getmMail());
               st.setString(4, udd.getAddress());
               st.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
               st.executeUpdate();
               } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
           if (con != null) {
              } con.close();
            }
            }
           }

   