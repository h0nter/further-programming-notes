/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author h0nter
 */
class Portfolio {
    private String name;
    private ArrayList<ShareHolding> holdings;
    
    public Portfolio(String name){
        this.name = name;
        holdings = new ArrayList<ShareHolding>(0);
    }
    
    public void addNewHolding(ShareHolding holding){
        holdings.add(holding);
    }
    
    public double getTotal(){
        double total = 0;
        for(int i = 0; i < holdings.size(); i++){
            total += (holdings.get(i).getQuantity() * holdings.get(i).getPrice());
        }
        return total;
    }
    
    public void buy(String cName, int amount){
        int i = 0;
        int index = -1;
        while(i < holdings.size() && index == -1){
            if (holdings.get(i).getName().equals(cName)){
                index = i;
            }
            i++;
        }
        if (index != -1 ){
            holdings.get(index).buy(amount);
        }else{
            addNewHolding(new ShareHolding(cName,5.5));
            holdings.get(holdings.size() - 1).buy(amount-1);
        }
    }
    
    public void sell(String cName, int amount){
        int i = 0;
        int index = -1;
        while(i < holdings.size() && index == -1){
            if (holdings.get(i).getName().equals(cName)){
                index = i;
            }
            i++;
        }
        if (index != -1 ){
            holdings.get(index).sell(amount);
        }else{
            System.out.println("Sorry, incorrect company (share) name.");
        }
    }
    
    public void printPortfolio(){
        for (int i = 0; i < holdings.size(); i++){
            ShareHolding sh = holdings.get(i);
            System.out.println((i+1)+". "+sh.getName()+" | "+sh.getPrice()+" | "+sh.getQuantity());
        }
        System.out.println("TOTAL: "+getTotal());
    }
}
