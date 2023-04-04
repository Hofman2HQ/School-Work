package carGUI;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The Main of Program
 * @author Shahar And Itay
 */
public class Main {
/**
 * Public Static Void main
 * @param args, type String
 * @throws ClassNotFoundException represent a exception
 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ClassNotFoundException {
		/**
		 * represent a parameter of Color
		 */
		Color bg_all_pages =new Color(204,255,250);

		//----read branch memo---------
		/**
		 * represent a name of file 
		 */
		String filename = "branch.ser";
		/**
		 * represent a file input of stream
		 */
		FileInputStream fis = null;
		/**
		 * represent a object input of stream
		 */
		ObjectInputStream in = null;
		
		try {
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			branch.branch_arr = (ArrayList<branch>)in.readObject();
			in.close();
		}
		catch(IOException ex)
		{
			System.out.println("branch error");
			ex.printStackTrace();
		}
		
		//-----end of read branch memo------------
		
		//----read car memo---------
		String filename_car = "car.ser";
		FileInputStream fis_car = null;
		ObjectInputStream in_car = null;
		
		try {
			fis_car = new FileInputStream(filename_car);
			in_car = new ObjectInputStream(fis_car);
			car.car_arr = (ArrayList<car>)in_car.readObject();
			in_car.close();
		}
		catch(IOException ex)
		{
			System.out.println("car error");
			ex.printStackTrace();
		}
		
		//-----end of read car memo------------
		
		//----read client memo---------
				String filename_client = "client.ser";
				FileInputStream fis_client = null;
				ObjectInputStream in_client = null;
				
				try {
					fis_client = new FileInputStream(filename_client);
					in_client = new ObjectInputStream(fis_client);
					client.client_arr = (ArrayList<client>)in_client.readObject();					
					in_client.close();
				}
				catch(IOException ex)
				{
					System.out.println("client error");
					ex.printStackTrace();
				}
				
				//-----end of read client memo------------
		client user = new client("uti","liti","c@gmail.com","111",2,LocalDate.parse("1998-05-05"),456);
		client.client_arr.add(user);
		
		////Manager email : admin@gmail.com, password: admin
		SignInGUI s = new SignInGUI();
		s.getContentPane().setBackground(bg_all_pages);
		s.setVisible(true);
		
		
		
	}

}