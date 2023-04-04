package carGUI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * 
 * @author Shahar And Itay
 *this class shows to the user the login screen, there he can login or move to sign up screen
 */
public class SignInGUI extends JFrame 
{
	protected static final long serialVersionUID = 2L;
	/**
	 * label of JLabel
	 */
	protected JLabel label;
	/**
	 * SignUp of JButton
	 */
	protected JButton SignUp;
	/**
	 * SignIn of JButton
	 */
	protected JButton SignIn;
	/**
	 * cancel of JButton
	 */
	protected JButton cancel;
	/**
	 * email of JTextField
	 */
	protected JTextField email;
	/**
	 * password of JPasswordField
	 */
	protected JPasswordField password;
	/**
	 * background of Color
	 */
	public Color bg_all_pages =new Color(204,255,250);
	
	/**
	 * Constructor of SignInGUI
	 */
	public SignInGUI()
	{
		super("SignInGUI");
		label = new JLabel("");
		SignUp = new JButton("sign up");
		SignIn = new JButton("Done");
		cancel = new JButton("clear");
		email = new JTextField(20); 
		password = new JPasswordField(20); 
		
		SignIn.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println( "ok button has been clicked");
				if(validation()==false)//if validation not success it wait for filling again
				{
					return;
				}
				else if(password.getText().equals("admin") && email.getText().equals("admin@gmail.com"))//if its the manager
				{
					System.out.println("welcome boss");
					managerGUI manage = new managerGUI();
					manage.getContentPane().setBackground(bg_all_pages);
					manage.setVisible(true);
					dispose();
					return;
				}
				client tmp = is_exist(password.getText(),email.getText());
				if(tmp==null)
				{
					return;
				}
				//setVisible(false);
				clientGUI cg = new clientGUI(tmp);//tmp is a client
				cg.getContentPane().setBackground(bg_all_pages);

				cg.setVisible(true);
				dispose();

			}
		});
		
		cancel.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				clear();
				System.out.println("cleard");
			}
		});
		
		SignUp.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				System.out.println( "SignUp button has been clicked");
				SignUpGUI l = new SignUpGUI();
				l.getContentPane().setBackground(bg_all_pages);
				l.setSize(600,400);
				l.setVisible(true);
				dispose();
			}
		});

		initialize();
	}
	
	/**
	 * initialize the gui screen
	 */
	public void initialize()
	{
		setLayout(new GridLayout(0,2));
		add(new JLabel("your email:"));
		add(email);
		add(new JLabel("your password:"));
		add(password);
		add(cancel);
		add(SignIn);
		add(new JLabel("don't have account yet?:"));
		add(SignUp);
		add(label);
		pack();	
	}
	
	/**
	 * validation of parameters and informing the user
	 * @return true or false
	 */
	public boolean validation()
	{
		//check if there is a feild that has not filled
		if(password.getText().isEmpty()|| email.getText().isEmpty())
		{
			System.out.println("must fill all");
            label.setText("Must fill all feilds");
            label.setForeground(Color.red);
		}
		if(email.getText().isEmpty())
		{
			System.out.println("must email field");
            label.setText("Must fill email field");
            label.setForeground(Color.red);
			return false;

		}
		if(password.getText().isEmpty())
		{
			System.out.println("must password field");
            label.setText("Must fill password field");
            label.setForeground(Color.red);
			return false;

		}
		//check email syntax
		 Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		 Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email.getText());
	        
		if(matcher.find() == false)
		{
			label.setText("email is incorrect syntax");
			System.out.println("email is incorrect syntax");
			return false;
		}
		
		System.out.println("has been validate");
		return true;
	}
	
	/**
	 * checks if the user is really exist and return the client if he did exist
	 * @param password, type String
	 * @param email, type String
	 * @return var
	 */
	public client is_exist(String password,String email)
	{
		for(client var :client.client_arr)
		{
			if(var.email.equals(email)&&var.getPassword().equals(password))
			{
				System.out.println("user exist");
				var.toString();
				return var;
			}
		}
		label.setText("user dosent exist!");
		System.out.println("user dosent exist!");
		return null;
	}
	
	/**
	 * clear the board
	 */
	public void clear()
	{
		password.setText("");
		email.setText("");
		label.setText("");

	}
	
}