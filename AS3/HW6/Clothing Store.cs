using System;
using System.Collections.Generic;
using System.Text;

namespace HW6
{
    internal class Clothing_Store : Store
    {
        public bool IsOnSale { get; set; }
        public double SalePercent;
        private Seasons Season;

        public Clothing_Store(int serialNumber, string name) : base(serialNumber, name)
        {
            IsOnSale = false;
            SalePercent = 0;
            Season = Seasons.Summer;
        }
        public override void ShowInfo()
        {
            Console.WriteLine("Store type: " + GetType().Name + "\nStore's Name: " + Name + "\nProducts:");
            foreach (var item in Products)
            {
                item.ToString();
            }
        }
        public override void PerformTransaction(Item c1, string name)
        {
            base.PerformTransaction(c1, name+" "+Season.ToString());
        }
        public void ChangeCollection()
        {
            int i;
            Console.WriteLine("Please select season to change into:\n1)Summer\n2)Fall\n3)Winter\n4)Spring");
            i = int.Parse(Console.ReadLine());
            if (i <= 4 && i > 0)
                Season = (Seasons)i;
            else
                Console.WriteLine("Wrong Input...");
        }
        public void InitSale()
        {
            Console.WriteLine("Sale is ON!\nPlease write the sale's percentge:");
            SalePercent = (double.Parse(Console.ReadLine()))/100;
            IsOnSale = true;
        }

        public void Sell()
        {
            if (IsOnSale)
            {
                Console.WriteLine("Sale is on!\nWhat cloth would you like to buy?");
                string n = Console.ReadLine();
                int count = 0;
                while (!Products[count].Name.Equals(n))
                    count++;
                Item ionSale = Products[count];
                ionSale.Price = (1.00-SalePercent)*ionSale.Price;
                PerformTransaction(ionSale, n);
            }
        }
        public void EndSale()
        {
            Console.WriteLine("Sale is Over!");
            IsOnSale = false;
        }
        enum Seasons
        {
            Summer,
            Fall,
            Winter,
            Spring
        }
    }
}
