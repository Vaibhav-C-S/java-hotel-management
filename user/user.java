package user;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class foodorder extends JFrame implements ActionListener {

    int order;
    JDialog frame = new JDialog();

    JLabel l;
    JCheckBox cb1, cb2, cb3,cb4,cb5,cb6;
    JButton b;
    void ch(){
        l=new JLabel("--------------------------MENU------------------------");
        l.setBounds(50,50,300,20);
        cb1=new JCheckBox("Pizza   ₹ 200");
        cb1.setBounds(100,100,150,20);
        cb2=new JCheckBox("Burger ₹ 100");
        cb2.setBounds(100,150,150,20);
        cb3=new JCheckBox("Tea    ₹ 20");
        cb3.setBounds(100,200,150,20);
        cb4 = new JCheckBox("Coffee ₹ 30");
        cb4.setBounds(100,250,150,20);
        cb5 = new JCheckBox("Pani puri ₹ 40");
        cb5.setBounds(100,300,150,20);
        cb6 = new JCheckBox("Chaat ₹ 15");
        cb6.setBounds(100,350,150,20);

        
        b=new JButton("Order");
        b.setBounds(100,400,80,30);
        b.addActionListener(this);
        frame.add(l);frame.add(cb1);frame.add(cb2);frame.add(cb3);frame.add(cb4);frame.add(cb5);frame.add(cb6);frame.add(b);
        frame.setSize(400,500);

        frame.setLayout(null);


        frame.setAlwaysOnTop(true);
        frame.setModal(true);
        frame.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        frame.setVisible(true);



    }






    public void actionPerformed(
    ActionEvent e)

    {
        float amount = 0;
        String msg = "";
        if (cb1.isSelected()) {
            amount += 200;
            msg = "Pizza:  ₹200\n";
        }
        if (cb2.isSelected()) {
            amount += 100;
            msg += "Burger: ₹100\n";
        }
        if (cb3.isSelected()) {
            amount += 20;
            msg += "Tea: ₹20\n";
        }
        if(cb4.isSelected()){
            amount +=30;
            msg+="coffee: ₹30\n";
        }
        if(cb5.isSelected()){
            amount +=40;
            msg+="pani puri: ₹40\n";
        }
        if(cb6.isSelected()){
            amount +=15
            ;
            msg+="chaat: ₹15\n";
        }
        msg += "-----------------\n";

        float tax=(5*amount)/100;
        float totalamount=amount+tax;

        JOptionPane.showMessageDialog(this, msg + "Total    : ₹ " + amount+ "\nGST(5%): ₹ "+tax+ "\n------------------------------------------\n"+ "Total(including GST of 5%): ₹ " + totalamount);

        frame.dispose();


    }

}
class cleaning{

    public void room() throws InterruptedException {

//        JOptionPane.showMessageDialog(null,"The staff is arriving in 3");
//        Thread.sleep(1000);
//        JOptionPane.showMessageDialog(null,"The staff is arriving in 2");
//        Thread.sleep(1000);
//        JOptionPane.showMessageDialog(null,"The staff is arriving in 1");


        JOptionPane.showMessageDialog(null,"Your request has been recieved");
        Thread.sleep(3000);
        JOptionPane.showMessageDialog(null,"Our staff is Ready for Visting you");
        JOptionPane.showMessageDialog(null,"He is near your door.Please open your door ");
        JOptionPane.showMessageDialog(null,"Your room has been cleaned.....");

    }}

class customer{


    String name;
    String dateofarrival;
    int numberOfNights;
    int order;

    public void details()   {
        JTextField field3 = new JTextField();
        JTextField field4 = new JTextField();
        JTextField field5 = new JTextField();
        Object [] fields = {

                "Enter name ",field3,
                "\nDate(YYYY-MM-DD)",field4,
                "\nNumber of nights",field5

        };
        int action=JOptionPane.showConfirmDialog(null,fields,"Customer details",JOptionPane.OK_CANCEL_OPTION);
        if(action !=0){
            JOptionPane.showMessageDialog(null,"Thank you for using our services\nBe sure to get back");
            System.exit(0);

        }
        String guestName ;
        guestName = field3.getText();
        dateofarrival = null;
        try {
            dateofarrival = String.valueOf(field4.getText());

        }
        catch (InputMismatchException ex) {
            JOptionPane.showMessageDialog(null,"Please enter the correct format");

        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        try{
            cal.setTime(sdf.parse(dateofarrival));
        }catch(ParseException e){
            e.printStackTrace();
        }


        int numberOfNights = Integer.parseInt(field5.getText());
        try {
            numberOfNights = Integer.parseInt(field5.getText());

        }
        catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Wrong datatype of number of nights entered");

        }
        cal.add(Calendar.DAY_OF_MONTH, numberOfNights);

        String dateAfter = sdf.format(cal.getTime());
        JOptionPane.showMessageDialog(null,guestName+":\nChecked in Date: "+dateofarrival+"\nYou should Check out at: "+dateAfter);

    }
    public void choice() throws InterruptedException {
        int opinion =Integer.parseInt(JOptionPane.showInputDialog("Please feel free to use our services\n1.Cleaning\n2.Order food\n3.exit\n"));
        if(opinion == 1){
            cleaning clean = new cleaning();
            clean.room();
        }
        else if(opinion == 2){
            foodorder f = new foodorder();
            f.ch();

        }else if (opinion == 3){
            JOptionPane.showMessageDialog(null,"Thank you for using our services\nBe sure to get back");
            System.exit(0);
        }

    }
}



public class userside {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub


       JOptionPane.showMessageDialog(null,"Welcome,How can we help You");
        customer cs= new customer ();
        cs.details();
        while (true){
            cs.choice();
        }
    }
}
