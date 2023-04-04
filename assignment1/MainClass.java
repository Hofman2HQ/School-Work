package hw2;
import java.util.Scanner;
public class MainClass {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Folder java_course = new Folder();
		
		Document d1 = new PlainTextDocument ("encapsulation",10, "object-oriented programming (OOP), encapsulation refers to the bundling of data with the methods that operate on that data, or the restricting of direct access to some of an object's components.");
		Document d2 = new WordDocument ("inheritance",8, "object-oriented programming, inheritance is the mechanism of basing an object or class upon another object (prototype-based inheritance) or class (class-based inheritance), retaining similar implementation");
		Document d3 = new PlainTextDocument ("polymorphism",10,"Polymorphism is often referred to as the third pillar of object-oriented programming");
		Document d4 = new WordDocument("interface",8,"an interface is a shared boundary across which two separate components");
		
		java_course.addItem(d1);
		java_course.addItem(d2);
		java_course.addItem(d3);
		java_course.addItem(d4);
		
		java_course.showFiles();
		
		String name = "start";
		while (!name.equals("stop"))
		{
			System.out.println("Type name of Document to see text");
			name = s.nextLine();
			java_course.printText(name);
			System.out.println("************\n");
		}
		
		System.out.println("Finished with Folder, Deleting all files");
		java_course.removeAll();
		
		s.close();
	}

}
