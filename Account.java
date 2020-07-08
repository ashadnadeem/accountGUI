
package account;

/**
 *
 * @author Ashad Nadeem
 */
public class Account {

    private int id;
    private double balance;
    
    public Account(int id, double balance){
        this.id = id;
        this.balance = balance;
    }
    //return id
    public int getID(){
        return this.id;
    }
    public double getbalance(){
        return this.balance;
    }
    //set balance
    public void setBalance(double bal){
        this.balance = bal;
    }  
    public void deposit(double amount)throws Neg{
        if(amount<0)    throw new Neg("Negative Amount");
        this.balance = this.balance + amount; 
    }
    public void withdraw(double amount)throws Neg{
        if(amount<0)    throw new Neg("Negative Amount");
        if ((this.balance - amount) < 0)    throw new Neg("Amount Exceeds the Balance; Transaction Failed");
        this.balance = this.balance - amount; 
    }
    
    
}
