using System;
using System.Collections.Generic;
using System.Text;

namespace HW6
{
    internal abstract class Store : IStore
    {
        public int SerialNumber { get => serialNumber; set => serialNumber = value; }
        public string Name { get; set; }
        private double Earnings { get; set; }
        protected List<Item> Products;
        protected List<Transatction> transatctions;
        private int serialNumber;

        
        public Store(int serialNumber, string name)
        {
            this.serialNumber = serialNumber;
            Name = name;
            Earnings = 0;
            Products = new List<Item>();
            transatctions = new List<Transatction>();
        }
        public void RemoveProduct(string product)
        {
            for (int i = 0; i < Products.Count; i++)
            {
                if (Products[i].Name == product)
                {
                    Products.RemoveAt(i);
                    Console.WriteLine("Product Removed !");
                    return;
                }
            }
            Console.WriteLine("No product found");
        }
        public abstract void ShowInfo();
        public virtual void PerformTransaction(Item c1, string name)
        {
            transatctions.Add(new Transatction(name, c1.Price));
            Console.WriteLine("Transaction Completed!");
        }

        public void Sell(Item item, string name)
        {
            if (Products.Contains(item))
            {
                PerformTransaction(item, name);
                Earnings += item.Price;
                Console.WriteLine("Sell Finished\nEarnings updated");
            }
            else
            {
                Console.WriteLine("No item found in the store");
            }
        }

        public void AddProduct()
        {
            Console.WriteLine("Please enter the name and price of the product");
            Products.Add(new Item(Console.ReadLine(), double.Parse(Console.ReadLine())));
            Console.WriteLine("Product has been added!");
        }

        public void ResetStore()
        {
            Console.WriteLine("Reseting Store...");
            Products.Clear();
            Earnings = 0;
            transatctions.Clear();
            Console.WriteLine("Reset Complete!\nPlease enter new name:");
            Name = Console.ReadLine();
        }
    }
}
