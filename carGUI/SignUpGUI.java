package carGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**
 * 
 * @author Shahar And Itay
 *here a new user could sign up to the system and be part of our family
 */
public class SignUpGUI extends JFrame
{
		/**
		 * parameters
		 */
        protected static final long serialVersionUID = 1L;
        /**
         * background all pages  of Color
         */
    	Color bg_all_pages =new Color(204,255,250);
		/**
		 * label of JLabel
		 */
        protected JLabel label;
        /**
         * SignUp of JButton
         */
        protected JButton SignUp;
        /**
         * login of JButton
         */
        protected JButton login;
        /**
         * cancel of JButton
         */
        protected JButton cancel;
        /**
         * first name of JButton
         */
        protected JTextField first_name;
        /**
         * last name of JButton
         */
        protected JTextField last_name;
        /**
         * email of JButton
         */
        protected JTextField email;
        /**
         * password of JButton
         */
        protected JPasswordField password;
        /**
         * password check of JButton
         */
        protected JPasswordField password_check;
        /**
         * id of JButton
         */
        protected JTextField id;
        /**
         * birth date of JButton
         */
        protected JTextField birth_date;
        /**
         * license of JButton
         */
        protected JTextField license;
        /**
         * reset color of Color
         */
		Color reset_color = new Color(0,0,0);

		/**
		 * Constructor of SignUpGUI
		 */
        public SignUpGUI()
        {
            super("SignUpGUI");
            label = new JLabel("");
            login=new JButton("login");
            SignUp = new JButton("Done");
            cancel = new JButton("clear");
            first_name = new JTextField(20); 
            last_name = new JTextField(20);
            email = new JTextField(20); 
            password = new JPasswordField(20); 
            password_check = new JPasswordField(20); 
            id = new JTextField(20); 
            birth_date = new JTextField(20); 
            license = new JTextField(20); 

            SignUp.addActionListener(new ActionListener() 
            {
                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                            if(validation()==false)//if validation not success it wait for filling again
                            {
                                    return;
                            }
                            label.setText("");
                            System.out.println( "ok button has been clicked");
                        System.out.println(first_name.getText() +" " +password.getText());

                        client tmp_client = new client(first_name.getText(),last_name.getText(),email.getText(),password.getText(),Integer.parseInt(id.getText()),LocalDate.parse(birth_date.getText()),Integer.parseInt(license.getText()));
                        client.client_arr.add(tmp_client);
                        System.out.println("client add " + tmp_client.toString());
                      //------client save to memory----------------
                            String filename = "client.ser";
                            FileOutputStream fos = null;
                            ObjectOutputStream out = null;

                            try {
                                    fos = new FileOutputStream(filename);
                                    out = new ObjectOutputStream(fos);
                                    out.writeObject(client.client_arr);
                                    out.close();
                            }
                            catch(IOException ex)
                            {
                                    ex.printStackTrace();
                            }
                            //------client end of save to memory----------------
                            SignInGUI sg = new SignInGUI();
            				sg.getContentPane().setBackground(bg_all_pages);
                            sg.setVisible(true);
                            dispose();
                    }  
                });

                cancel.addActionListener(new ActionListener() 
                {
                        @Override
                        public void actionPerformed(ActionEvent e) 
                        {
                                clear();
                        }
                });

                login.addActionListener(new ActionListener() 
                {
                        @Override
                        public void actionPerformed(ActionEvent e) 
                        {
                                SignInGUI s = new SignInGUI();
                                s.setVisible(true);
                				s.getContentPane().setBackground(bg_all_pages);

                                //setVisible(false);
                                dispose();
                        }
                });


                initialize();
        }

        /**
         * initialize the screen 
         */
        public void initialize()
        {
            setLayout(new GridLayout(0,2));
            add(new JLabel("your first name:"));
            add(first_name);
            add(new JLabel("your last name:"));
            add(last_name);
            add(new JLabel("your email:"));
            add(email);
            add(new JLabel("your password:"));
            add(password);
            add(new JLabel("your password_check:"));
            add(password_check);
            add(new JLabel("your id:"));
            add(id);
            add(new JLabel("your birth_date:"));
            add(birth_date);
            add(new JLabel("your license:"));
            add(license);
            add(cancel);
            add(SignUp);
            add(new JLabel("allready has an account?:"));
            add(login);
            pack();
            add(label);


        }

        /**
         * validate if parameters are validate and informed the client if not
         * @return true or false
         */
        public boolean validation()
        {
        	label.setText("");
        	label.setForeground(reset_color);
        	email.setForeground(reset_color);
        	id.setForeground(reset_color);

    		label.setOpaque(false);
                //check if there is a feild that has not filled
                if(first_name.getText().isEmpty() || last_name.getText().isEmpty() || password.getText().isEmpty()|| password_check.getText().isEmpty()|| email.getText().isEmpty()|| id.getText().isEmpty()|| birth_date.getText().isEmpty()|| license.getText().isEmpty())
                {
                        System.out.println("Must fill all");
                        label.setText("Must fill all feilds");
                        label.setForeground(Color.red);

                }
                if(first_name.getText().isEmpty())
                {
                        System.out.println("Must fill first name");
                        label.setText("Must fill first name feild");
                        label.setForeground(Color.red);
                        return false;
                }
                if(last_name.getText().isEmpty())
                {
                        System.out.println("Must fill last name");
                        label.setText("Must fill last name feild");
                        label.setForeground(Color.red);
                        return false;
                }
                if(password.getText().isEmpty())
                {
                        System.out.println("Must fill password");
                        label.setText("Must fill password feild");
                        label.setForeground(Color.red);
                        return false;
                }
                if(password_check.getText().isEmpty())
                {
                        System.out.println("Must fill password check");
                        label.setText("Must fill password check feild");
                        label.setForeground(Color.red);
                        return false;
                }
                if(email.getText().isEmpty())
                {
                        System.out.println("Must fill email");
                        label.setText("Must fill email feild");
                        label.setForeground(Color.red);
                        return false;
                }
              //checking email syntax

                Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
                Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email.getText());

               if(matcher.find() == false)
               {
                       System.out.println("email is incorrect syntax");
                       label.setText("email is incorrect syntax");
                       label.setForeground(Color.red);
                       return false;
               }

                if(id.getText().isEmpty())
                {
                        System.out.println("Must fill id");
                        label.setText("Must fill id feild");
                        label.setForeground(Color.red);
                        return false;
                }
                if(birth_date.getText().isEmpty())
                {
                        System.out.println("Must fill birth date");
                        label.setText("Must fill birth date feild");
                        label.setForeground(Color.red);
                        return false;
                }
                if(license.getText().isEmpty())
                {
                        System.out.println("Must fill license");
                        label.setText("must fill license feilds");
                        label.setForeground(Color.red);
                        return false;
                }
                else if(password.getText().equals(password_check.getText())==false)
                {
                        System.out.println("passwords don't matches");
                        label.setText("passwords don't matches");
                        label.setForeground(Color.red);
                        return false;
                }

                for(client item : client.client_arr)
            	{
            		if(item.email.equals(email.getText()))
            		{
            			System.out.println("allready exist email");
                        label.setText("allready existing email");
                        label.setForeground(Color.red);
                    	email.setForeground(Color.red);
                        return false;
            		}
            	}
                for(client item : client.client_arr)
            	{
            		if(item.getId() == Integer.parseInt(id.getText()) )
            		{
            			System.out.println("allready exist id in the system");
                        label.setText("allready existing id");
                        label.setForeground(Color.red);
                    	id.setForeground(Color.red);
                        return false;
            		}
            	}
                
                //else if(birth_date.getText())  //check if up to the format

                
                System.out.println("has been validate");
                return true;
        }

        /**
         * clear the screen text 
         */
        public void clear()
        {
        		label.setText("");
                first_name.setText("");
                last_name.setText("");
                password.setText("");
                password_check.setText("");
                email.setText("");
                id.setText("");
                birth_date.setText("");
                license.setText("");
                email.setForeground(reset_color);
                id.setForeground(reset_color);
        }
}