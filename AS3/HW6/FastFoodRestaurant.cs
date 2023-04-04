using System;
using System.Collections.Generic;
using System.Text;

namespace HW6
{
    internal class FastFoodRestaurant : Restaurant
    {
        public List<Item> promotionMeals;
        public DateTime OilChangeDate;

        internal List<Item> PromotionMeals { get => promotionMeals; set => promotionMeals = value; }

        public FastFoodRestaurant(int SerialNumber, string name, string restype, string ChefName) : base(SerialNumber, name, restype, ChefName)
        {
            OilChangeDate = DateTime.Now;
            promotionMeals = new List<Item>();
        }
        public void GetPromotions()
        {
            foreach (var item in PromotionMeals)
            {
                item.ToString();
            }
        }
        public void AddPromotion()
        {
            Console.WriteLine("What's the meal's name you'd like to add?");
            string s = Console.ReadLine();
            for (int i = 0; i < Products.Count; i++)
            {
                if (Products[i].Name == s)
                {
                    PromotionMeals.Add(Products[i]);
                    Console.WriteLine("Meal has been added!");
                    return;
                }
            }
            Console.WriteLine("No Meal found, Creating new meal");
            AddProduct();
            PromotionMeals.Add(Products[((PromotionMeals.Count) - 1)]);
            Console.WriteLine("Meal has been created and moved to Promotional");
        }

        public void ChangeOil()
        {
            OilChangeDate = DateTime.Now;
            Console.WriteLine("Oil Change date updated!\n" + OilChangeDate.ToString());
        }

        public override void Sell()
        {
            Console.WriteLine("What meal would you like to purchase?");
            for (int i = 0; i < Products.Count; i++)
            {
                Console.WriteLine(i + "" + Products[i].ToString() + "\n");
            }
            int ch = int.Parse(Console.ReadLine());
            if (PromotionMeals.Contains(Products[ch]))
            {
                Item temp = Products[ch];
                temp.Name = Products[ch].Name + " - Promotion!";
                PerformTransaction(temp, temp.Name);
            }
            else
            {
                PerformTransaction(Products[ch], Products[ch].Name);
            }
            Console.WriteLine("Enjoy your meal!");
        }
        public override void ShowInfo()
        {
            Console.WriteLine("Fast Food name: "+Name+"\nHere's the menu:");
            foreach (var item in Products)
            {
                if (PromotionMeals.Contains(item))
                {
                    Console.WriteLine(item+" - Promotion!");
                }
                else
                {
                    Console.WriteLine(item);
                }
            }
        }
    }
}
