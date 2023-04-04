package carGUI;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

/**
 * 
 * @author Shahar And Itay
 *this class represent car and has its parameters
 */
public class car implements Serializable,Comparable<car>{
    protected static final long serialVersionUID = 5L;

	/**
	 * parameters of car class
	 */
    public static ArrayList<car> car_arr = new ArrayList<car>();
	/**
	 * represent a enum of type category 
	 * @author Shahar And Itay
	 */
	public static enum category
	{
		/**
		 * category of type min
		 */
		min,
		/**
		 * category of type sadan
		 */
		sadan,
		/**
		 * category of type manager
		 */
		manager,
		/**
		 * category of type suv
		 */
		suv};
	/**
	 * car number of integer
	 */
	protected int car_number;
	/**
	 * car manu year of integer
	 */
	protected int car_manu_year;
	/**
	 * model of String
	 */
	protected String model;
	/**
	 * other model of String
	 */
	protected String other_model;
	/**
	 * car category of category
	 */
	protected category car_category;
	/**
	 * gear of boolean
	 */
	protected Boolean gear;
	/**
	 * rent of integer
	 */
	protected int rent;
	/**
	 * is available of boolean
	 */
	protected boolean is_available;
	/**
	 * car branch of branch
	 */
	protected branch car_branch;
	
	/**
	 * car Constructor 
	 * @param car_number, integer
	 * @param car_manu_year, integer
	 * @param model, String
	 * @param other_model, String
	 * @param car_category, car_category
	 * @param gear, boolean
	 * @param rent, integer
	 * @param car_branch, integer
	 */
	public car(int car_number, int car_manu_year, String model, String other_model, car.category car_category,
			Boolean gear, int rent,branch car_branch) {
		super();
		this.car_number = car_number;
		this.car_manu_year = car_manu_year;
		this.model = model;
		this.other_model = other_model;
		this.car_category = car_category;
		this.gear = gear;
		this.rent = rent;
		this.is_available = true;
		this.car_branch = car_branch;
	}
/**
 * getter and setter of branch
 * @return car_branch, branch
 */
	public branch getCar_branch() {
		return car_branch;
	}

	/**
	 * getter and setter of branch
	 * @param car_branch, branch
	 */
	public void setCar_branch(branch car_branch) {
		this.car_branch = car_branch;
	}
	
	/**
	 * getter and setter of isIs_available
	 * @return is_available, boolean
	 */
	public boolean isIs_available() {
		return is_available;
	}

	/**
	 * 
	 * @param is_available, boolean
	 */
	public void setIs_available(boolean is_available) {
		this.is_available = is_available;
	}

	/**
	 * 
	 * @return car_number, int
	 */
	public int getCar_number() {
		return car_number;
	}

	/**
	 * @return car_manu_year, int
	 */
	public int getCar_manu_year() {
		return car_manu_year;
	}
/**
 * setter of car manu year
 * @param car_manu_year, type int
 */
	public void setCar_manu_year(int car_manu_year) {
		this.car_manu_year = car_manu_year;
	}
/**
 * 
 * @return model, String
 */
	public String getModel() {
		return model;
	}
/**
 * setModel
 * @param model, String
 */
	public void setModel(String model) {
		this.model = model;
	}
/**
 * @return other_model, String
 */
	public String getOther_model() {
		return other_model;
	}
	/**
	 * 
	 * @param other_model, type String
	 */

	public void setOther_model(String other_model) {
		this.other_model = other_model;
	}
 /**
  * @return car_category, category
  */
	public category getCar_category() {
		return car_category;
	}
/**
 * 
 * @param car_category, type category
 */
	public void setCar_category(category car_category) {
		this.car_category = car_category;
	}
/**
 * getter of gear
 * @return gear, type Boolean
 */
	public Boolean getGear() {
		return gear;
	}
/**
 * setter of gear
 * @param gear of boolean
 */
	public void setGear(Boolean gear) {
		this.gear = gear;
	}
/**
 * @return rent, int
 */
	public int getRent() {
		return rent;
	}
/**
 * 
 * @param rent, type int
 */
	public void setRent(int rent) {
		this.rent = rent;
	}
	/**
	 * hashCode
	 */
	@Override
	public int hashCode() {
		return Objects.hash(car_number);
	}
/**
 * equals
 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		car other = (car) obj;
		return car_number == other.car_number;
	}
/**
 * toString
 */
	@Override
	public String toString() {
		return "car [car_number=" + car_number + ", car_manu_year=" + car_manu_year + ", model=" + model
				+ ", other_model=" + other_model + ", car_category=" + car_category + ", gear=" + gear + ", rent="
				+ rent + " is availabe: " + is_available + " car branch: " + car_branch;
	}
/**
 * compareTo
 */
	@Override
	public int compareTo(car o) {
		 if (rent == o.getRent())
	            return rent - o.getRent();
	        return model.compareTo(o.getModel());
	}
	

}
