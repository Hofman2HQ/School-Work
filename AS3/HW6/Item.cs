using System;
using System.Collections.Generic;
using System.Text;

namespace HW6
{
    internal class Item
    {
        public string Name { get; set; }
        public double Price { get; set; }

        public Item(string name, double price)
        {
            Name = name; Price = price; 
        }
        public override bool Equals(object obj)
        {
            if (((Item)obj).Name == Name)
                return true;
            return false;
        }
        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

        public override string ToString()
        {
            return Name + " - " + Price;
        }
    }
}
