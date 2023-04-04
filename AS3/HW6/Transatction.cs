using System;
using System.Collections.Generic;
using System.Text;

namespace HW6
{
    internal class Transatction
    {
        public string Name { get; set; }
        public double Price { get; set; }
        public DateTime Date { get; set; }

        public Transatction(string name, double price)
        {
            Name = name;
            Price = price;
            Date = DateTime.Now;
        }
    }
}
