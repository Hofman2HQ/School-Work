using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace HW4
{
    enum Status
    {
        empty, waiting, done
    }
    public class Garage
    {
        public Car[] cars = new Car[Consts.MAX_CARS];
        Status[] status = new Status[Consts.MAX_CARS];
        public int NumCars { get; set; }

        public Garage ()
        {
            cars = new Car[Consts.MAX_CARS];
            status = new Status[Consts.MAX_CARS];
            NumCars = 0;
        }

        public bool AddCar(Car c1)
        {
            for (int i = 0; i < cars.Length; i++)
            {
                if (status[i] == Status.empty)
                {
                    cars[i] = c1;
                    NumCars++;
                    status[i] = Status.waiting;
                    Console.WriteLine("Done");
                    return true;
                }
            }
            Console.WriteLine("No space");
            return false;
        }
        public bool Repair(int license)
        {
            for (int i = 0; i < cars.Length; i++)
            {
                if (cars[i].LicenseP == license && status[i] == Status.waiting && cars[i] != null)
                {
                    Console.WriteLine("Done");
                    status[i] = Status.done;
                    return true;
                }
            }
            Console.WriteLine("No car found");
            return false;
        }

        public override string ToString()
        {
            string hold="";
            foreach (var item in cars)
            {
                if (item != null)
                {
                  hold = item.ToString()+ hold + "\n************************\n";
                }
            }
            return hold;
        }
        public bool RemoveCar(int License, string customerID)
        {
            for (int i = 0; i < cars.Length; i++)
            {
                if (cars[i].LicenseP == License && cars[i].Owner.ID == customerID && status[i] == Status.done && cars[i] != null)
                {
                    Car ToRemove = cars[i];
                    Status remove = status[i];
                    cars = cars.Where(val => val != ToRemove).ToArray();
                    status = status.Where(val => val != remove).ToArray();
                    MessageBox.Show("Done, Car has been removed");
                    return true;
                }
            }
            MessageBox.Show("No matching car found");
            return false;
        }
    }
}
