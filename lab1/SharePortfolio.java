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
public class SharePortfolio {
    public static void main(String args[]){
        Portfolio user = new Portfolio(args[0]);
        ShareHolding share;
        for (int i = 0; i < 5; i++){
            share = new ShareHolding("Cool corp. " + (i + 1),5.5);
            user.addNewHolding(share);
        }
        user.buy("Cool corp. 3",10);
        user.printPortfolio();
    }
}
