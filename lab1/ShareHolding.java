/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author h0nter
 */
public class ShareHolding {
    private String companyName;
    private Sterling price;
    private int quantity;
    
    public ShareHolding(String companyName, double pricePShare){
        this.companyName = companyName;
        price = new Sterling(pricePShare);
        quantity = 1;
    }
    
    public String getName(){
        return companyName;
    }
    
    public double getPrice(){
        return price.getValue();
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void buy(int amount){
        quantity += amount;
    }
    
    public void sell(int amount){
        if (amount <= quantity){
            quantity -= amount;
        }else{
            System.out.println("Sorry, you cannot sell more share holdings than you own.");
        }
    }
}
