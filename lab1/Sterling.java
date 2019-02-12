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
class Sterling {
    private double value;
    
    public Sterling(double value){
        this.value = value;
    }
    
    public double getValue(){
        return value;
    }
    
    public void setValue(double newValue){
        value = newValue;
    }
    
    public void multiplyVal(double factor){
        value *= factor;
    }
}
