package hw2;

import java.util.*;

public class Folder {
	private List<Document> DocList;
	
	public Folder() {
		this.DocList = new ArrayList<Document>();
	}
	
	public void addItem (Document d1)
	{
		DocList.add(d1);
	}
	public void remove (String DocName)
	{
		for (Document d1 : DocList) {
			if (d1.getFileName().compareTo(DocName) == 0)
			{
				DocList.remove(d1);
				return;
			}
		}
		System.out.println("No Document with this name found");
	}
	
	public void printType()
	{
		for (Document d1 : DocList) {
			System.out.println("Document "+d1.getFileName()+" type is: "+d1.getClass());
		}
	}
	
	public void showFiles()
	{
		for (Document d1 : DocList) {
			System.out.println(d1.getFileName()+"\n*********");
		}
	}
	
	public void removeAll()
	{
		if(this.DocList.removeAll(DocList))
			System.out.println("Removed all!");
	}
	
	public void printText(String DocName)
	{
		for (Document d1 : DocList) {
			if (d1.getFileName().equals(DocName))
			{
				d1.ToString();
				return;
			}
		}
		System.out.println("No document found!");
	}
}
