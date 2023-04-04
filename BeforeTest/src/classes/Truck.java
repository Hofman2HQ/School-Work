package classes;

public class Truck {
	private Integer number;
	private Integer maxWeight;
	/**
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}
	/**
	 * @return the maxWeight
	 */
	public Integer getMaxWeight() {
		return maxWeight;
	}
	/**
	 * @param maxWeight the maxWeight to set
	 */
	public void setMaxWeight(Integer maxWeight) {
		this.maxWeight = maxWeight;
	}
	/**
	 * @param number
	 * @param maxWeight
	 */
	public Truck(Integer number, Integer maxWeight) {
		super();
		this.number = number;
		this.maxWeight = maxWeight;
	}
}
