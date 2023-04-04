package classes;

public class Product {
		private Integer barCode;
		private Double price; 
		private Double weight;
		/**
		 * @param barCode
		 * @param price
		 * @param weight
		 */
		public Product(Integer barCode, Double price, Double weight) {
			super();
			this.barCode = barCode;
			this.price = price;
			this.weight = weight;
		}
		/**
		 * @return the barCode
		 */
		public Integer getBarCode() {
			return barCode;
		}
		/**
		 * @param barCode the barCode to set
		 */
		public void setBarCode(Integer barCode) {
			this.barCode = barCode;
		}
		/**
		 * @return the price
		 */
		public Double getPrice() {
			return price;
		}
		/**
		 * @param price the price to set
		 */
		public void setPrice(Double price) {
			this.price = price;
		}
		/**
		 * @return the weight
		 */
		public Double getWeight() {
			return weight;
		}
		/**
		 * @param weight the weight to set
		 */
		public void setWeight(Double weight) {
			this.weight = weight;
		}
	}
