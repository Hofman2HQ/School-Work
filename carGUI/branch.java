package carGUI;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

/**
 * 
 * @author Shahar And Itay
 *this class represent a branch that has his open hours, id(branch number) and location.
 */
public class branch implements Serializable
{
    protected static final long serialVersionUID = 4L;
	/**
	 * branch array of ArrayList
	 */
    public static ArrayList<branch> branch_arr = new ArrayList<branch>();
    /**
     * location of String
     */
	protected String location;
	/**
	 * open hour of LocalTime
	 */
	protected LocalTime open_hour;
	/**
	 * branch number of integer
	 */
	protected int branch_number;
	/**
	 * Constructor of branch
	 * @param branch_number, integer
	 * @param location, String
	 * @param open_hour, LocalTime
	 */
	public branch(int branch_number, String location, LocalTime open_hour) {
		super();
		this.branch_number = branch_number;
		this.location = location;
		this.open_hour = open_hour;
	}
	
	/**
	 * 
	 * @return branch_arr, ArrayList
	 */
	public static ArrayList<branch> getBranch_arr() {
		return branch_arr;
	}
	/**
	 * 
	 * @param branch_arr, ArrayList
	 */
	public static void setBranch_arr(ArrayList<branch> branch_arr) {
		branch.branch_arr = branch_arr;
	}
	/**
	 * 
	 * @return location, String
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * 
	 * @param location, String
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * 
	 * @return open_hour, LocalTime
	 */
	public LocalTime getOpen_hour() {
		return open_hour;
	}
	/**
	 * 
	 * @param open_hour, LocalTime
	 */
	public void setOpen_hour(LocalTime open_hour) {
		this.open_hour = open_hour;
	}
	/**
	 * 
	 * @return branch_number, int
	 */
	public int getBranch_number() {
		return branch_number;
	}
	/**
	 * hashCode
	 */
	@Override
	public int hashCode() {
		return Objects.hash(branch_number);
	}
	/**
	 * equals branch_number
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		branch other = (branch) obj;
		return branch_number == other.branch_number;
	}
	/**
	 * ToString
	 */
	@Override
	public String toString() {
		return "branch [location=" + location + ", open_hour=" + open_hour + ", branch_number=" + branch_number + "]";
	}
	/**
	 * 
	 * @param loc, String
	 * @return var
	 */
	public static branch get_branch_by_loc(String loc)
	{
		for(branch var : branch.branch_arr)
		{
			if(var.getLocation().equals(loc))
			{
				return var;
			}
		}
		System.out.println("not exist!");
		return null;
	}
	

}