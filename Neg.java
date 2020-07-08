
package account;

public class Neg extends Exception{
    private String message;
    public Neg(String msg){
        this.message = msg;
    }
    public String toString(){
        return this.message;
    }
}
