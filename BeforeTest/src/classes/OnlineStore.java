package classes;
import java.util.*;

public class OnlineStore {
	private ArrayList<Package> packages;
	private ArrayList<Truck> trucks;
	private HashMap<Integer, ArrayList<Package>> map;

	public OnlineStore (ArrayList<Package> p, ArrayList<Truck> t)
	{
		super();
		packages = p;
		trucks = t;
		for (Truck truck : trucks) {
			map.put(truck.getNumber(), new ArrayList<Package>());
		}
	}
	public void addTruck(Truck t)
	{
		if(!trucks.contains(t))
		{
			trucks.add(t);
			System.out.println("Truck added");
			map.put(t.getNumber(), null);
		}
		else
			System.out.println("Already exists in store");
	}
	public void addPackage(Package p)
	{
		if(!packages.contains(p))
		{
			packages.add(p);
			System.out.println("Package added");
		}
		else
			System.out.println("Already in Store");
	}
	public void addPackageToTruck (Product pro, Truck tr)
	{
		
	}
}
