package carGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * 
 * @author Shahar And Itay
 *this class shows in graphical way to the client the possibale cars and stores
 */
public class clientGUI extends JFrame {
	
	/**
	 * parameters
	 */
	protected static final long serialVersionUID = 71L;
	/**
	 * background all pages of Color
	 */
	Color bg_all_pages =new Color(204,255,250);

	/**
	 * name of JLabel
	 */
	protected JLabel name;
	/**
	 * sort of Choice
	 */
	protected Choice sort;
	/**
	 * sort button of JButton
	 */
	protected JButton sort_btn;
	/**
	 * car selected button of JButton
	 */
	protected JButton car_select;
	/**
	 * logout button of JButton
	 */
	protected JButton logout;
	/**
	 * branch column names of String array
	 */
    private String[] branch_ColumnsNames = {"branch_number", "location", "open_hour"};
    /**
	 * car columns names of String array
	 */
    private String[] car_ColumnsNames = {"car number", "manifacture year", "model","other model","rent price","car category","gear","branch number","is availble"};
    /**
	 * branch data of Object array
	 */
    private Object[][] branch_data;
    /**
	 * car data of Object array
	 */
    private Object[][] car_data;
    /**
	 * i, integer
	 */
    private int i=0;
    /**
	 * j, integer
	 */
    private int j = 0;
    /**
	 * car i, integer
	 */
    private int car_i;
    /**
	 * car j, integer
	 */
    private int car_j;
    /**
	 * branch scroll pane of JScrollPane
	 */   		   		
    private JScrollPane branch_scrollPane;
    /**
	 * branch table of JTable
	 */ 
    private JTable branch_table;
    /**
	 * car scroll pane of JScrollPane
	 */
    private JScrollPane car_scrollPane;
    /**
     * car table of JTable
     */
    private JTable car_table;
    
    /**
     * Constructor of clientGUI, it gets a client for future options
     * @param client_in, type client
     */
    public clientGUI(client client_in) {
    	
    	super("clientGUI");
		logout = new JButton("logout");
		car_select = new JButton("select car");
		sort_btn = new JButton("sort");
		sort = new Choice();
		name = new JLabel(client_in.first_name + " " + client_in.last_name);

		branch_data = new Object[branch.branch_arr.size()][3];
    	branch_table = new JTable(branch_data, branch_ColumnsNames);
    	branch_table.setPreferredScrollableViewportSize(new Dimension(500, 70));
    	branch_table.setFillsViewportHeight(true);
    	branch_table.setDefaultEditor(Object.class, null);//  cannot edit values table
    	branch_table.setBackground(new Color(165,209, 186));
    	branch_scrollPane = new JScrollPane(branch_table);
    	branch_table.setEnabled(false);
    	System.out.println("print branch_arr");
    	for(branch var : branch.branch_arr)
    	{
    		branch_data[i][j] = var.getBranch_number();
    		branch_data[i][j+1] = var.getLocation();
    		branch_data[i][j+2] = var.getOpen_hour();
    		i++;
    	}
    	
    	//--car section---------
    	car_data = new Object[car.car_arr.size()][10];
    	car_table = new JTable(car_data, car_ColumnsNames);
    	car_table.setPreferredScrollableViewportSize(new Dimension(500, 70));
    	car_table.setFillsViewportHeight(true);
    	car_table.setDefaultEditor(Object.class, null);//  cannot edit values table
    	car_table.setBackground(new Color(165,209, 186));
    	car_scrollPane = new JScrollPane(car_table);
    	print_car_data();//printing the car data
    	
    	logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				System.out.println( "logout button has been clicked");
				SignInGUI sg = new SignInGUI();
				sg.getContentPane().setBackground(bg_all_pages);

				sg.setVisible(true);
				dispose();
			}
		});
    	
    	sort_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println( "sort  button has been clicked");
				System.out.println(sort.getSelectedItem());
				sort_arr(sort.getSelectedItem());
			}
		});
    	
    	//------user picked a car--------
    	car_select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println( "car select  button has been clicked");
				System.out.println(car_table.getSelectedRow());
				car_picked(client_in);
			}
		});
    	
    	sort_initialize();
    	initialize();
    }
    /**
     * initialize the borderr layout
     */
    private void initialize() {
    	setLayout(new BorderLayout());
    	add(addA(), BorderLayout.NORTH);
    	add(addB(), BorderLayout.CENTER);
    	setLayout(new FlowLayout());

    	add(addC());
     	setSize(600,350);
    	
    }
    
    /**
     * holds a panel at the board
     * @return
     */
    private JPanel addA()
    {
    	JPanel A = new JPanel();
    	A.setLayout(new FlowLayout());
    	A.add(sort);
    	A.add(sort_btn);
    	A.add(car_select);
    	A.setBackground(new Color(165, 209, 186));

    	JPanel B = new JPanel();
    	B.setLayout(new FlowLayout());
    	B.add(name);
    	B.add(logout);
    	B.setBackground(new Color(165, 209, 186));
    	JPanel ALL = new JPanel();
    	ALL.setLayout(new BorderLayout());
    	ALL.add(A, BorderLayout.EAST);
    	ALL.add(B, BorderLayout.WEST);
    	return ALL;
    }
    /**
     * holds a part panel of the board
     * @return
     */
    private JPanel addB()
    {
    	JPanel B = new JPanel();
    	B.setLayout(new FlowLayout());
    	B.add(car_scrollPane, BorderLayout.NORTH);
    	return B;
    }
    /**
     * holds a part panel of the board
     * @return
     */
    private JPanel addC	()
    {
    	JPanel C = new JPanel();
    	C.setLayout(new FlowLayout());
    	C.add(branch_scrollPane);
    	return C;
    }
    /**
     * print the car data to the screen
     */
    public void print_car_data()
    {
        car_i=0;
        car_j = 0;
    	System.out.println("print car data");
    	for(car var : car.car_arr)
    	{
    		car_data[car_i][car_j] = var.getCar_number();
    		car_data[car_i][car_j+1] = var.getCar_manu_year();
    		car_data[car_i][car_j+2] = var.getModel();
    		car_data[car_i][car_j+3] = var.getOther_model();
    		car_data[car_i][car_j+4] = var.getRent();
    		car_data[car_i][car_j+5] = var.getCar_category();
    		if(var.getGear()==true)
    		{
    			car_data[car_i][car_j+6] = "auto";
    		}
    		else
    		{
    			car_data[car_i][car_j+6] = "hand";
    		}
    		car_data[car_i][car_j+7] = var.getCar_branch().getBranch_number();
    		car_data[car_i][car_j+8] = var.is_available;

    		car_i++;
    	}
    }
    /**
     * sort initialize by adding categorys to the sort button
     */
    private void sort_initialize() {
    	sort.add("none");
    	sort.add("price");
    	sort.add("car number");
    	sort.add("model");
    	sort.add("category");
    	sort.add("year");

    }
    
    /**
     * sorting the array of car by the asked type
     * @param type
     */
    private void sort_arr(String type) {
    	//System.out.println(car.car_arr);
    	System.out.println("sorting by "+ type);
    	if(type.equals("model"))
    	{
    		car.car_arr.sort(compareByModel);
    	}
    	else if(type.equals("category"))
    	{
    		car.car_arr.sort(compareByCategory);
    	}
    	else if(type.equals("price"))
    	{
    		car.car_arr.sort(compareByRent);
    	}
    	else if(type.equals("car number"))
    	{
    		car.car_arr.sort(compareByCarNumber);
    	}
    	else if(type.equals("year"))
    	{
    		car.car_arr.sort(compareByCarYear);
    	}
    	//System.out.println(car.car_arr);
    	print_car_data();
    }
    /**
     * compare using to compare by compareByModel
     */
    //--------compare--------//
    public Comparator<car> compareByModel = new Comparator<car>() {
		@Override
		public int compare(car o1, car o2) {
			return o1.getModel().compareTo(o2.getModel());
		}
	};
	/**
     * compare using to compare by compareByCategory
     */
	public Comparator<car> compareByCategory = new Comparator<car>() {
		@Override
		public int compare(car o1, car o2) {
			return o1.getCar_category().compareTo(o2.getCar_category());
		}
	};
	/**
     * compare using to compare by compareByRent
     */
	public Comparator<car> compareByRent = new Comparator<car>() {
		@Override
		public int compare(car o1, car o2) 
		{
			 return o1.getRent() - o2.getRent();		
	    }
	};
	/**
     * compare using to compare by compareByCarNumber
     */
	public Comparator<car> compareByCarNumber = new Comparator<car>() {
		@Override
		public int compare(car o1, car o2) 
		{
			 return o1.getCar_number() - o2.getCar_number();		
	    }
	};
	/**
     * compare using to compare by compareByCarYear
     */
	public Comparator<car> compareByCarYear = new Comparator<car>() {
		@Override
		public int compare(car o1, car o2) 
		{
			 return o1.getCar_manu_year() - o2.getCar_manu_year();		
	    }
	};
	//--------compare--------//
	
		
    /**
     * car picked and assigned it to the client
     * @param client_in, type client
     */
	public void car_picked(client client_in)//set the car to the client
	{
		System.out.println(car.car_arr.get(car_table.getSelectedRow()).car_number);
		if(client_in.getClientcar()!=null)
		{
			System.out.println("you allready have car");
			return;
		}

		if(	car.car_arr.get(car_table.getSelectedRow()).is_available == false)
		{
			System.out.println("sorry this allready has been rented");
			return;
		}
		client_in.setClient_car(car.car_arr.get(car_table.getSelectedRow())); //set the car to the client
		car.car_arr.get(car_table.getSelectedRow()).setIs_available(false);//set the car available to false
		System.out.println(client_in.getClientcar());
    	print_car_data();
    	//------car save to memory----------------
		String filename_car = "car.ser";
		FileOutputStream fos_car = null;
		ObjectOutputStream out_car = null;
		
		try {
			fos_car = new FileOutputStream(filename_car);
			out_car = new ObjectOutputStream(fos_car);
			out_car.writeObject(car.car_arr);
			out_car.close();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		//------car end of save to memory----------------
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
	}

   
}