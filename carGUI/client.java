package carGUI;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

/**
 * 
 * @author Shahar And Itay
 *this class represent a client with his Qualities 
 */
public class client implements Serializable{
	
	
    protected static final long serialVersionUID = 6L;
    /**
     * client array of ArrayList
     */
    public static ArrayList<client> client_arr = new ArrayList<client>();
    /**
     * first name of String
     */
	protected String first_name;
	/**
     * last name of String
     */
	protected String last_name;
	/**
     * email of String
     */
	protected String email;
	/**
     * password of String
     */
	protected String password;
	/**
     * id of integer
     */
	protected int id;
	/**
     * birth date of String
     */
	protected LocalDate birth_date;
	/**
     * license of integer
     */
	protected int license;
	/**
     * client car of car
     */
	protected car client_car;
	
	/**
	 * Constructor of client
	 * @param first_name, String
	 * @param last_name, String
	 * @param email, String
	 * @param password, String
	 * @param id, integer
	 * @param birth_date, LocalDate
	 * @param license, integer
	 */
	public client(String first_name, String last_name, String email, String password, int id,
			LocalDate birth_date, int license) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.id = id;
		this.birth_date = birth_date;
		this.license = license;
		this.client_car = null;
	}

	/**
	 * 
	 * @return client_car, car
	 */
	public car getClientcar() {
		return client_car;
	}
	/**
	 * 
	 * @param client_car, type car
	 */
	public void setClient_car(car client_car) {
		this.client_car = client_car;
	}
	/**
	 * 
	 * @return first_name, type String
	 */
	public String getFirst_name() {
		return first_name;
	}

	/**
	 * 
	 * @param first_name, type String
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * 
	 * @return last_name, type String
	 */
	public String getLast_name() {
		return last_name;
	}

	/**
	 * 
	 * @param last_name, type String
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * 
	 * @return email, String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email, type String
	 */
	public void setEmail(String email) {
		this.email = email;
	}
/**
 * 
 * @return birth_date, LocalDate
 */
	public LocalDate getBirth_date() {
		return birth_date;
	}

	/**
	 * setter of birth date
	 * @param birth_date, LocalDate
	 */
	public void setBirth_date(LocalDate birth_date) {
		this.birth_date = birth_date;
	}

	/**
	 * 
	 * @return license, integer
	 */
	public int getLicense() {
		return license;
	}

	/**
	 * setter license
	 * @param license, type integer
	 */
	public void setLicense(int license) {
		this.license = license;
	}

	/**
	 * 
	 * @return password, String
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * 
	 * @return id, integer
	 */
	public int getId() {
		return id;
	}

	/**
	 * hashCode
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	/**
	 * equals by client id 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		client other = (client) obj;
		return id == other.id;
	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return "client [first_name=" + first_name + ", last_name=" + last_name + ", email=" + email + ", password="
				+ password + ", id=" + id + ", birth_date=" + birth_date
				+ ", license=" + license + "]";
	}
	
	
	
}