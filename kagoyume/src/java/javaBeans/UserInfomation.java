/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaBeans;

import DB.UserDataDTO;
import java.io.Serializable;

/**
 *
 * @author Yuu
 */
public class UserInfomation implements Serializable{
    private String name;
    private String password;
    private String mail;
    private String address;
    
    
    public UserInfomation(){
        this.name="";
        this.password="";
        this.mail="";
        this.address="";
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        if(name.trim().length()==0){
            this.name = "";
        }else{
            this.name = name;
         }
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
         if(password.trim().length()==0){
            this.password = "";
        }else{
            this.password = password;
        }
    }
    public String getMail(){
        return mail;
    }
    public void setMail(String mail){
         if(mail.trim().length()==0){
            this.mail = "";
        }else{
            this.mail = mail;
        }
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
         if(address.trim().length()==0){
            this.address = "";
        }else{
            this.address = address;
        }
    } public void Mapping(UserDataDTO udd){
        udd.setName(this.name);
        udd.setPassword(this.password);
        udd.setMail(this.mail);
        udd.setAddress(this.address);
      
    }
}
