package login;
import javax.swing.*;

import java.util.*;

class containsadmin {
    private String substring0="vaibhav";
    private String substring1="rohan";
    private String substring2="ammi";
    private String substring3="uday";
    public boolean checkadmin(String username) {
        if(username.equals(substring0) || username.equals(substring1)|| username.equals(substring2)|| username.equals(substring3)) {
            return true;
        }
        else {
            return false;
        }


    }
    public boolean passwordauthentication(){
        JPasswordField pwd = new JPasswordField();

        int action = JOptionPane.showConfirmDialog(null, pwd, "Enter Password", JOptionPane.OK_CANCEL_OPTION);
        String password;
        boolean flag = false;
        if (action == 0) {
            password = String.valueOf(pwd.getPassword());

            if (password.equals("admin1234")) {
                JOptionPane.showMessageDialog(null, "your login is successful");


                flag = true;
            } else {
                String message = "invalid password";
                JOptionPane.showMessageDialog(null, message, "Dialog",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else{
            JOptionPane.showMessageDialog(null,"Thank you for using our services\nBe sure to get back");
            System.exit(0);}
        return flag;
    }
}
public class login {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        containsadmin ca= new containsadmin();
        String username = JOptionPane.showInputDialog("Please enter Username");
        boolean flag = false;
        if(ca.checkadmin(username)){
            JOptionPane.showMessageDialog(null,"Hello admin : "+username);
            while (flag == false) {

                flag=ca.passwordauthentication();
            }
            projectreview.HotelManagementSystemApp hmsa = new projectreview.HotelManagementSystemApp();
            hmsa.main(null);
        }else{
            JOptionPane.showMessageDialog(null,"Hello user : "+username);
            JPasswordField pwd = new JPasswordField();
            int action = JOptionPane.showConfirmDialog(null, pwd, "Enter Password", JOptionPane.OK_CANCEL_OPTION);
            if (action == 0){
                JOptionPane.showMessageDialog(null, "your login is successful");
                user.userside us = new user.userside();
                us.main(null);


            }else{

                System.exit(0);
            }

        }








    }

}
