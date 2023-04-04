using System;
using System.Collections.Generic;
using System.Collections;
using System.Linq;

namespace HW6
{
    internal class Program
    {
        static void Main(string[] args)
        {
            List<Store> Stores = new List<Store>();
            string Choise = "0";
            while (!Choise.Equals("e"))
            {
                Console.WriteLine("STORE ADMIN MENU\n1)Create new Store\n2)Add Product to store\n3)Clear item from Store\n4)Print all products\n5)Print special/promotional items from store\nOr e for Exit");
                Choise = Console.ReadLine();
                switch (Choise)
                {
                    case "1":
                        {
                            Console.Clear();
                            Console.WriteLine("Creating new Store!\nWhat type of Store would you like to create?");
                            Console.WriteLine("1)Clothing Store\n2)Restaurant\n3)Fast Food Joint");
                            int nm = int.Parse(Console.ReadLine());
                            switch (nm)
                            {
                                case 1:
                                    {
                                        Console.WriteLine("Please enter Serial number and name for Clothing store:");
                                        int serial = int.Parse(Console.ReadLine());
                                        string name = Console.ReadLine();
                                        Console.WriteLine("Creating Clothing Store...");
                                        Stores.Add(new Clothing_Store(serial,name));
                                        Console.WriteLine("Clothing Store has been created!");
                                    }
                                    break;
                                case 2:
                                    {
                                        Console.WriteLine("Please enter Serial number and name for Restaurant:");
                                        int serial = int.Parse(Console.ReadLine());
                                        string name = Console.ReadLine();
                                        Console.WriteLine("Please provide the chefs name");
                                        string chef = Console.ReadLine();
                                        Console.WriteLine("Type of restaurant(Meat, Cafe, Italian or Burgers)");
                                        string type = Console.ReadLine();
                                        Stores.Add(new Restaurant(serial,name,type ,chef));
                                        Console.WriteLine("Restaurant has been created!");
                                    }
                                    break;
                                case 3:
                                    {
                                        Console.WriteLine("Please enter Serial number and name for Fast Food Joint:");
                                        int serial = int.Parse(Console.ReadLine());
                                        string name = Console.ReadLine();
                                        Console.WriteLine("Please provide the Chefs name");
                                        string chef = Console.ReadLine();
                                        Console.WriteLine("Type of Fast Food? (Meat, Cafe, Italian or Burgers)");
                                        string type = Console.ReadLine();
                                        Stores.Add(new Restaurant(serial, name, type, chef));
                                        Console.WriteLine("Fast Food joint has been created!");
                                    }break;
                                default:
                                    break;
                            }
                            Console.WriteLine("Reset Menu...\nPress any key");
                            Console.ReadKey();
                            Choise = "0";
                            Console.Clear();
                        }break;
                    case "2":
                        {
                            Console.Clear();
                            Console.WriteLine("Please Write the number of the store to add item:");
                            for (int j = 0; j < Stores.Count; j++)
                            {
                                Console.WriteLine(j+") "+Stores[j].Name+" - "+Stores[j].GetType().Name);
                            }
                            int i = int.Parse((Console.ReadLine()));
                            Stores[i].AddProduct();
                            Console.WriteLine("Reset Menu...\nPress any key");
                            Console.ReadKey();
                            Choise = "0";
                            Console.Clear();
                        }
                        break;
                    case "3":
                        {
                            Console.Clear();
                            Console.WriteLine("Please Write the number of the store to remove item:");
                            for (int j = 0; j < Stores.Count; j++)
                            {
                                Console.WriteLine(j + ") " + Stores[j].Name + " - " + Stores[j].GetType().Name);
                            }
                            int i = int.Parse((Console.ReadLine()));
                            Console.WriteLine("What item would you like to remove?");
                            Stores[i].ShowInfo();
                            string product = Console.ReadLine();
                            Stores[i].RemoveProduct(product);
                            Console.WriteLine("Reset Menu...\nPress any key");
                            Console.ReadKey();
                            Choise = "0";
                            Console.Clear();
                        }
                        break;
                    case "4":
                        {
                            Console.WriteLine("Choose Store to print from:");
                            for (int j = 0; j < Stores.Count; j++)
                            {
                                Console.WriteLine(j + ") " + Stores[j].Name + " - " + Stores[j].GetType().Name);
                            }
                            int i = int.Parse(Console.ReadLine());
                            Stores[i].ShowInfo();
                            Console.WriteLine("Reset Menu...\nPress any key");
                            Console.ReadKey();
                            Choise = "0";
                            Console.Clear();
                        }
                        break;
                    case "5":
                        {
                            Console.WriteLine("Choose Store to print from:");
                            for (int j = 0; j < Stores.Count; j++)
                            {
                                Console.WriteLine(j + ") " + Stores[j].Name + " - " + Stores[j].GetType().Name);
                            }
                            int i = int.Parse(Console.ReadLine());
                            if (Stores[i].GetType().Name.Equals("FastFoodRestaurant"))
                            {
                                FastFoodRestaurant ffr = (FastFoodRestaurant)Stores[i];
                                ffr.ShowSpecials();
                            }
                            else if (Stores[i].GetType().Name.Equals("Restaurant"))
                            {
                                Restaurant restaurant = (Restaurant)Stores[i];
                                restaurant.ShowSpecials();
                            }
                            else
                            {
                                Console.WriteLine("No specials, Printing products\n");
                                Stores[i].ShowInfo();
                            }
                            Console.WriteLine("Reset Menu...\nPress any key");
                            Console.ReadKey();
                            Choise = "0";
                            Console.Clear();
                        }
                        break;
                    case "e": Console.WriteLine("Goodbye");break;
                    default:
                        break;
                }
            }
        }
    }
}