package classes;
import java.util.*;

public class Package {
	private ArrayList<Product> products;

	/**
	 * @param products
	 */
	public Package(ArrayList<Product> products) {
		super();
		this.products = products;
	}

	/**
	 * @return the products
	 */
	public ArrayList<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
		System.out.println("Set of products changed successfully");
	}

	public void addProduct (Product a)
	{
		products.add(a);
		System.out.println("Product added!");
	}

	public void removeProduct(Product a)
	{
		if (products.contains(a))
			products.remove(a);
		else
			System.out.println("No such product in package");
	}

	public void emptyPackage()
	{
		if (!products.isEmpty())
		{
			products.clear();
			System.out.println("The package is now empty");
		}
		else	
			System.out.println("No Items in package");
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
