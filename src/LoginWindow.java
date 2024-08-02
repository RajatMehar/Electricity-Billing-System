import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class LoginWindow extends JFrame implements ActionListener {
    JTextField userText,passwordText;
    Choice loginChoice;

    JButton loginButton,cancelButton,signupButton;

    LoginWindow(){
        super("Login");
        Color c = new Color(220,61,61);

        getContentPane().setBackground(c);

        JLabel head1 = new JLabel("Welcome");
        JLabel head2 = new JLabel("Nice to see you again");
        head1.setFont(new Font( "TimesRoman", Font.BOLD , 40));
        head2.setFont(new Font("TimesRoman" , Font.PLAIN , 15));
        head1.setBounds(340,15,300,30);
        head2.setBounds(350,48,250,25);
        head1.setForeground(Color.black);
        head2.setForeground(Color.black);
        add(head1);
        add(head2);

        JLabel username = new JLabel("UserName");
        username.setBounds(300,100,100,20);
        username.setForeground(Color.black);
        add(username);

        userText = new JTextField();
        userText.setBounds(400,100,150,20);

        add(userText);

        JLabel password = new JLabel("Password");
        password.setBounds(300,140,100,20);
        password.setForeground(Color.black);
        add(password);

        passwordText = new JTextField();
        passwordText.setBounds(400,140,150,20);
        add(passwordText);

        JLabel loggin = new JLabel("Loggin In As");
        loggin.setBounds(300,180,100,20);
        loggin.setForeground(Color.black);
        add(loggin);

        loginChoice = new Choice();
        loginChoice.add("Admin");
        loginChoice.add("Customer");
        loginChoice.setBounds(400,180,150,20);
        add(loginChoice);

        loginButton = new JButton("Login");
        loginButton.setBounds(300,220,80,20);
        loginButton.addActionListener(this);
        add(loginButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(500,220,80,20);
        cancelButton.addActionListener(this);
        add(cancelButton);

        signupButton = new JButton("Signup");
        signupButton.setBounds(400,220,80,20);
        signupButton.addActionListener(this);
        add(signupButton);

        ImageIcon profileOne =  new ImageIcon(ClassLoader.getSystemResource("icon/profile.png"));
        Image profileTow = profileOne.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon fprofileOne = new ImageIcon(profileTow);
        JLabel profileLable = new JLabel(fprofileOne);
        profileLable.setBounds(5,5,250,250);
        add(profileLable);



        setSize(640,300);
        setLocation(400,200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==loginButton){
             String susername = userText.getText();
             String spassword = passwordText.getText();
             String suser = loginChoice.getSelectedItem();

             try{
                 database d = new database();
                 String queryy = "select * from Signup where username = '"+susername+"' and password = '"+spassword+"' and usertype ='"+suser+"'";
                 ResultSet resultSet = d.statement.executeQuery(queryy);

                 if (resultSet.next()){
                     String meter = resultSet.getString("meter_no");
                     setVisible(false);
                     new main_Window(suser,meter);
                 }else {
                     JOptionPane.showMessageDialog(null ,"Invalid Login");
                 }

             }catch (Exception E){
                 E.printStackTrace();
             }
        } else if (e.getSource()==cancelButton) {
            setVisible(false);
        } else if (e.getSource()==signupButton) {
            setVisible(false);
            new Signup();
        }

    }

    public static void main(String[] args) {
        new LoginWindow();
    }
}
