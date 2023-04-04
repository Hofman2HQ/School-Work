using System;
using System.Collections.Generic;
using System.Text;

namespace HW6
{
    internal class Restaurant : Store, IFood
    {
        public enum RestaurantType
        {
            Meat,
            Cafe,
            Italian,
            Burgers
        }
        protected List<string> Menu { get; set; }
        protected List<string> Specials { get; set; }
        protected RestaurantType Rt { get; set; }
        public Chef Chef { get; set; }

        public Restaurant(int SerialNumber, string name, string restype, string ChefName) : base(SerialNumber, name)
        {
            if (restype.ToString().Equals("Meat") || restype.ToString().Equals("Cafe") || restype.ToString().Equals("Italian") || restype.ToString().Equals("Burgers"))
            {
                Enum.TryParse(restype, out RestaurantType Rt);
                Chef = new Chef(ChefName, (restype).ToString());
            }
            else
            {
                throw new Exception("No restaurant type!");
            }
        }

        public void AddMenu()
        {
            Console.WriteLine("Is that a Special? y/n");
            string choise = Console.ReadLine();
            if (choise == "y")
            {
                AddSpecials();
                Menu.Add(Products[Products.Count - 1].Name);
            }
            else if (choise == "n")
            {
                AddProduct();
                Menu.Add(Products[Products.Count - 1].Name);
            }
            else
            {
                Console.WriteLine("Invalid Input");
            }
        }
        public void ShowMenu()
        {
            Console.WriteLine("Printing Menu......\n");
            for (int i = 0; i < Menu.Count; i++)
            {
                Console.WriteLine(i + 1 + ")" + Menu[i]);
            }
        }

        public void ShowSpecials()
        {
            Console.WriteLine("Printing Specials......\n");
            for (int i = 0; i < Specials.Count; i++)
            {
                Console.WriteLine(i + 1 + ")" + Specials[i]);
            }
        }

        public void ShowChefInfo()
        {
            Console.WriteLine("Chef's Info:");
            Console.WriteLine(Chef.ToString());
        }

        public override void ShowInfo()
        {
            Console.WriteLine("Resturant name: " + Name);
            ShowMenu();
            ShowSpecials();
            ShowChefInfo();
        }

        public override void PerformTransaction(Item c1, string name)
        {
            Console.WriteLine("Performing transaction...");
            transatctions.Add(new Transatction(name, c1.Price));
            Console.WriteLine("Completed!");
        }

        public void AddSpecials()
        {
            Console.WriteLine("Please enter name of Special Dish and it's price:");
            AddProduct();
            Specials.Add(Products[(Products.Count) - 1].Name);
        }

        public void ClearSpecials()
        {
            for (int i = 0; i < Specials.Count; i++)
            {
                Menu.Remove(Specials[i]);
            }
            Specials.Clear();
        }
        public virtual void Sell()
        {
            Console.WriteLine("What meal would you like to purchase?");
            for (int i = 0; i < Products.Count; i++)
            {
                Console.WriteLine(i + "" + Products[i].ToString() + "\n");
            }
            int ch = int.Parse(Console.ReadLine());
            if (Specials.Contains(Products[ch].ToString()))
            {
                Item temp = Products[ch];
                temp.Name = Products[ch].Name + " - Special!";
                PerformTransaction(temp, temp.Name);
            }
            else
            {
                PerformTransaction(Products[ch], Products[ch].Name);
            }
            Console.WriteLine("Enjoy your meal!");
        }
    }
}
