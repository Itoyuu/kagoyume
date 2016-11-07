/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

/**
 *
 * @author Yuu
 */
//yahooAPIを使って検索してきたものを保存する箱
public class GetAPI{
    private String name;
    private int price;
    private String image;
    private String dis;
    private String code;
    
    
    public GetAPI(){
    this.name="";
    this.price=0;
    this.image="";
    this.dis="";
    this.code="";
  
    }
    
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setPrice(int price){
        this.price=price;
    }
    public int getPrice(){
        return price;
    }
    public void setImage(String image){
        this.image=image;
    }
    public String getImage(){
        return image;
    }
    public void setDis(String dis){
        this.dis=dis;
    }
    public String getDis(){
        return dis;
    }
    public void setCode(String code){
        this.code=code;
    }
    public String getCode(){
        return code;
    }
    
}
