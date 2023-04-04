package carGUI;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalTime;
import java.util.Locale.Category;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author Shahar And Itay
 *this class shows to the big boss his options to add cars and branches
 */
public class managerGUI extends JFrame{

		/**
		 * background all pages of Color
		 */
		Color bg_all_pages =new Color(204,255,250);

        private static final long serialVersionUID = 3L;
        /**
         * label branch of JLabel
         */
        protected JLabel label;
        /**
         * label car of JLabel
         */
        protected JLabel label_car;
        /**
         * manager of JLabel
         */
        protected JLabel manager;
        /**
         * logout of JButton
         */
        protected JButton logout;
        /**
         * add branch of JButton
         */
        protected JButton add_branch;
        /**
         * cancel branch of JButton
         */
        protected JButton cancel_branch;
        /**
         * branch number hour of JTextField
         */
        protected JTextField branch_number;
        /**
         * branch location hour of JTextField
         */
        protected JTextField branch_location;
        /**
         * branch open hour of JTextField
         */
        protected JTextField branch_open_hour;
        /**
         * temp branch of branch
         */
        protected branch tmp_branch;
        //---------------------------------cars-----------------------------------------------------------//
        /**
         * add car of JButton
         */
        protected JButton add_car;
        /**
         * cancel car of JButton
         */
        protected JButton cancel_car;
        /**
         * car number of JTextField
         */
        protected JTextField car_number;
        /**
         * car manu year of JTextField
         */
        protected JTextField car_manu_year;
        /**
         * car model of JTextField
         */
        protected JTextField car_model;
        /**
         * car other model of JTextField
         */
        protected JTextField car_other_model;
        /**
         * car rent of JTextField
         */
        protected JTextField car_rent;
        /**
         * car category of Choice
         */
        protected Choice car_category;
        /**
         * gear of Choice
         */
        protected Choice gear;
        /**
         * car branch of Choice
         */
        protected Choice car_branch;
        /**
         * temp gear of boolean
         */
        boolean tmp_gear = true;
        /**
         * reset color of Color
         */
		Color reset_color = new Color(0,0,0);

		/**
		 * Constructor of managerGUI
		 */
        public managerGUI()
        {
                super("managerGUI");
                label = new JLabel("");
                label_car = new JLabel("");

                manager = new JLabel("Welcome Manager!");
                logout = new JButton("logout");
                add_branch = new JButton(" add_branch ");
                cancel_branch = new JButton("clear branch details");
                branch_number = new JTextField(20);
                branch_open_hour = new JTextField(20);
                branch_location = new JTextField(20);
                branch_init();//show the branches available

                add_branch.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e)
                        {
                                System.out.println( "add_branch button has been clicked");
                        if(branch_validation()==false)
                        {
                                return; //means that need to fill again
                        }
                        tmp_branch = new branch(Integer.parseInt(branch_number.getText()),branch_location.getText(),LocalTime.parse(branch_open_hour.getText()));
                        branch.branch_arr.add(tmp_branch);
                        System.out.println("branch addad");
                        System.out.println(tmp_branch.toString());
                        branch_init();//show the branches available
                        label.setText("");

                        //------branch save to memory----------------
                        String filename = "branch.ser";
                        FileOutputStream fos = null;
                        ObjectOutputStream out = null;

                        try {
                                fos = new FileOutputStream(filename);
                                out = new ObjectOutputStream(fos);
                                out.writeObject(branch.branch_arr);
                                out.close();
                        }
                        catch(IOException ex)
                        {
                                ex.printStackTrace();
                        }
                        //------branch end of save to memory----------------

                        }

                });
                cancel_branch.addActionListener(new ActionListener()
                {
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                                clear_branch();
                                System.out.println("cleard");
                        }
                });
                //---------------------------------cars----------------------------------------------------------------
                add_car = new JButton(" add_car ");
                cancel_car = new JButton("clear car details");
                car_number = new JTextField(20);
                car_manu_year = new JTextField(20);
                car_model = new JTextField(20);
                car_other_model = new JTextField(20);
                car_rent = new JTextField(20);
                car_category = new Choice();
                gear = new Choice();
                car_branch = new Choice();
                car_category_init();
                branch_init();
                add_car.addActionListener(new ActionListener() 
                {
                        public void actionPerformed(ActionEvent e)
                        {
                                        System.out.println( "add car button has been clicked");
                                if(car_validation()==false)
                                {
                                        return; //means that need to fill again
                                }
                                label_car.setText("");

                                System.out.println(gear.getSelectedItem());
                                if(gear.getSelectedItem().equals("auto"))
                                {
                                        tmp_gear = true;
                                }
                                else
                                {
                                        tmp_gear = false;
                                }
                                System.out.println(car_branch.getSelectedItem());
                                //System.out.println(branch.get_branch_by_loc(car_branch.getSelectedItem()));
                                tmp_branch = branch.get_branch_by_loc(car_branch.getSelectedItem());

                                car tmp_car = new car(Integer.parseInt(car_number.getText()),Integer.parseInt(car_manu_year.getText()),car_model.getText(),car_other_model.getText(),car.category.valueOf(car_category.getSelectedItem()),tmp_gear,Integer.parseInt(car_rent.getText()),tmp_branch);
                                car.car_arr.add(tmp_car);
                                System.out.println("car addad");
                                System.out.println(tmp_car.toString());

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
                        }
                });
                cancel_car.addActionListener(new ActionListener()
                {
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                                clear_car();
                                System.out.println("cleard");
                        }
                });
                logout.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e)
                        {
                                System.out.println("logout button has been clicked");
                                SignInGUI sg = new SignInGUI();
                				sg.getContentPane().setBackground(bg_all_pages);

                                sg.setVisible(true);
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
        		setLayout(new BorderLayout());
        		add(addA(), BorderLayout.NORTH);
        		add(addB(), BorderLayout.WEST);
        		this.add(Box.createRigidArea(new Dimension(16, 0)));
        		add(addC(), BorderLayout.EAST);
    			pack();
        }
        
        /**
         * holds a part panel of the board
         * @return
         */
        private JPanel addA()
        {
        	JPanel A = new JPanel();
        	A.setLayout(new FlowLayout());
        	A.add(manager);
        	A.add(logout);
        	A.setBackground(bg_all_pages);
        	return A;
        }
        /**
         * holds a part panel of the board
         * @return
         */
        private JPanel addB()
        {
        	JPanel B = new JPanel();
        	B.setLayout(new GridLayout(0, 2));
        	B.add(new JLabel("add branch section"));
            B.add(label);
            B.add(new JLabel("new branch number"));
            B.add(branch_number);
            B.add(new JLabel("insert branch location"));
            B.add(branch_location);
            B.add(new JLabel("insert branch open hours"));
            B.add(branch_open_hour);
            B.add(cancel_branch);
            B.add(add_branch);
        	B.setBackground(bg_all_pages);

            return B;
        }
        /**
         * holds a part panel of the board
         * @return
         */
        private JPanel addC()
        {
        	JPanel C = new JPanel();
        	C.setLayout(new GridLayout(0, 2));
        	C.add(new JLabel("add car section"));
        	C.add(label_car);
        	gear.add("auto");
        	gear.add("hand");
        	C.add(new JLabel("new car number"));
        	C.add(car_number);
        	C.add(new JLabel("insert car manufacture year"));
        	C.add(car_manu_year);
        	C.add(new JLabel("insert car model"));
        	C.add(car_model);
        	C.add(new JLabel("insert car other model"));
        	C.add(car_other_model);
        	C.add(new JLabel("insert car_rent"));
        	C.add(car_rent);
        	C.add(new JLabel("insert car category"));
        	C.add(car_category);
        	C.add(new JLabel("insert gear"));
        	C.add(gear);
        	C.add(new JLabel("insert car branch"));
        	C.add(car_branch);
        	C.add(cancel_car);
            C.add(add_car);
        	C.setBackground(bg_all_pages);

            return C;
        }


        /**
         * make sure that branch adding is validate
         * @return true or false
         */
        public boolean branch_validation()
        {
	        	label.setText("");
	        	label.setForeground(reset_color);
	        	branch_number.setForeground(reset_color);
                //check if there is a feild that has not filled
                if( branch_number.getText().isEmpty()|| branch_location.getText().isEmpty()|| branch_open_hour.getText().isEmpty() )
                {
                        System.out.println("Must fill all feilds");
                        label.setText("Must fill all feilds");
                        label.setForeground(Color.red);

                }
                if(branch_number.getText().isEmpty())
                {
                        System.out.println("Must fill branch number field");
                        label.setText("Must fill branch number field");
                        label.setForeground(Color.red);
                        return false;
                }
                if(branch_location.getText().isEmpty())
                {
                        System.out.println("Must fill branch location field");
                        label.setText("Must fill branch location field");
                        label.setForeground(Color.red);
                        return false;
                }
                if(branch_open_hour.getText().isEmpty())
                {
                        System.out.println("Must fill branch open hour field");
                        label.setText("Must fill branch open hour field");
                        label.setForeground(Color.red);
                        return false;
                }
                for(branch item: branch.branch_arr)
                {
                    if(item.getBranch_number() == Integer.parseInt(branch_number.getText()))
                    {
                        System.out.println("branch number allready exists");
                        label.setText("branch number allready exists");
                        label.setForeground(Color.red);
        	        	branch_number.setForeground(Color.red);
                        return false;
                    }
                }

                return true;
        }

        //---------------------------------cars----------------------------------------------------------------

        /**
         * make sure that car adding is validate
         * @return true or false
         */
        public boolean car_validation()
        {
        	    label_car.setText("");
	    		Color reset_color = new Color(0,0,0);
	    		label_car.setForeground(reset_color);
	        	car_number.setForeground(reset_color);
                //check if there is a feild that has not filled
                if(car_number.getText().isEmpty()|| car_manu_year.getText().isEmpty()|| car_model.getText().isEmpty()|| car_other_model.getText().isEmpty()|| car_rent.getText().isEmpty() )
                {
                        System.out.println("Must fill all feilds");
                        label_car.setText("Must fill all feilds");
                        label_car.setForeground(Color.red);
                }
                if(car_number.getText().isEmpty())
                {
                        System.out.println("Must fill car number filed");
                        label_car.setText("Must fill number filed");
                        label_car.setForeground(Color.red);
                        return false;
                }
                if(car_manu_year.getText().isEmpty())
                {
                        System.out.println("Must fill car manu year filed");
                        label_car.setText("Must fill car manu year filed");
                        label_car.setForeground(Color.red);
                        return false;
                }
                if(car_model.getText().isEmpty())
                {
                        System.out.println("Must fill car model filed");
                        label_car.setText("Must fill car model filed");
                        label_car.setForeground(Color.red);
                        return false;
                }
                if(car_other_model.getText().isEmpty())
                {
                        System.out.println("Must fill car other model filed");
                        label_car.setText("Must fill car other model filed");
                        label_car.setForeground(Color.red);
                        return false;
                }
                if(car_rent.getText().isEmpty())
                {
                        System.out.println("Must fill car rent filed");
                        label_car.setText("Must fill car rent filed");
                        label_car.setForeground(Color.red);
                        return false;
                }
                for(car item: car.car_arr)
                {
                    if(item.getCar_number() == Integer.parseInt(car_number.getText()))
                    {
                        System.out.println("car number allready exists");
                        label_car.setText("car number allready exists");
                        label_car.setForeground(Color.red);
                        car_number.setForeground(Color.red);
                        return false;
                    }
                }
                return true;
        }

        /**
         * initialize the branch array by the exists branches from branch ArrayList
         */
        public void branch_init()
        {
                if(car_branch != null)
                {
                        car_branch.removeAll();
                        for(branch var : branch.branch_arr)
                        {
                                car_branch.add(var.getLocation());
                        }
                }

        }

        /**
         * initialize the car category array by the exists car categorys from 
         */
        public void car_category_init()
        {
                car_category.add("min");
                car_category.add("sadan");
                car_category.add("manager");
                car_category.add("suv");
        }
        /**
         * clear the branch text
         */
        public void clear_branch()
        {
                branch_number.setText("");
                branch_location.setText("");
                branch_open_hour.setText("");
                label.setText("");
                branch_number.setForeground(reset_color);
        }
        /**
         * clear the car text
         */
        public void clear_car()
        {
                car_number.setText("");
                car_manu_year.setText("");
                car_model.setText("");
                car_other_model.setText("");
                car_rent.setText("");
                label_car.setText("");
	        	car_number.setForeground(reset_color);

        }

}