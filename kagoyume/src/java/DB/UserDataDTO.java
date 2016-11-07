/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Timestamp;
/**
 *
 * @author Yuu
 */
public class UserDataDTO {
    private String name;
    private String password;
    private String mail;
    private String address;
    private int userID;
    private int total;
    private String itemCode;
    private Timestamp newDate;
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getmMail(){
        return mail;
    }
    public void setMail(String mail){
        this.mail=mail;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public int getUserID(){
        return userID;
    }
    public void setUserID(int userID){
        this.userID=userID;
    }
    
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    public String getItemCode(){
        return itemCode;
    }
    public void setItemCode(String itemCode){
        this.itemCode=itemCode;
    }
    public Timestamp getNewDate() {
        return newDate;
    }
    public void setNewDate(Timestamp newDate) {
        this.newDate = newDate;
    }
}
