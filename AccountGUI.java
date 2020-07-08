
package account;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class AccountGUI extends JFrame implements ActionListener {
    
    private JTextField idField, balanceField, depositField, withdrawField;
    
    private JButton depositButton, withdrawButton;
    
    private JLabel statusLabel = new JLabel();
    
    private Account acc = new Account(1,1000);
    
    public AccountGUI(){
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(2,2));
        p1.add(new JLabel("AccountID: "));
        p1.add(idField = new JTextField(4));
        p1.add(new JLabel("AccountBalance: "));
        p1.add(balanceField = new JTextField(4));
        idField.setEditable(false);
        balanceField.setEditable(false);
        p1.setBorder(new TitledBorder("Account INformation"));
        
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(2,3));
        p2.add(new JLabel("Deposit"));
        p2.add(depositField = new JTextField());
        p2.add(depositButton = new JButton("Deposit"));
        p2.add(new JLabel("withdraw"));
        p2.add(withdrawField = new JTextField());
        p2.add(withdrawButton = new JButton("Withdraw"));
        p2.setBorder(new TitledBorder("Deposit or Withdraw Funds"));
        
        Container con = getContentPane();
        con.add(p1, BorderLayout.WEST);
        con.add(p2, BorderLayout.CENTER);
        con.add(statusLabel, BorderLayout.SOUTH);
        
        refreshFields();
        
        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == depositButton){
            try{
                double depositVal = Double.parseDouble(depositField.getText());
                acc.deposit(depositVal);
                refreshFields();
                statusLabel.setText("Transaction Performed");
            }
            catch(Neg f){
                statusLabel.setText(f.toString());
            }
        }
        if(e.getSource() == withdrawButton){
            try{
                double witdrawVal = Double.parseDouble(withdrawField.getText());
                acc.withdraw(witdrawVal);
                refreshFields();
                statusLabel.setText("Transaction Performed");
            }
            catch(Neg f){
                statusLabel.setText(f.toString());
            }
        }
    }
    
    public void refreshFields(){
        idField.setText("" + acc.getID());
        balanceField.setText("" + acc.getbalance());
        depositField.setText("");
        withdrawField.setText("");
        statusLabel.setText(" ");
    }
    
    public static void main(String[]args){
        AccountGUI obj = new AccountGUI();
        obj.setSize(400,200);
        obj.setVisible(true);
        obj.pack();
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
