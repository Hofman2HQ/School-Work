using System;
using System.Collections.Generic;
using System.Text;

namespace HW4
{
    public class Car
    {
        public int LicenseP { get; set; }
        public string Manufacturer { get; set; }
        public int AssembYear { get; set; }
        public int Engine { get; set; }
        public string Model { get; set; }
        public Customers Owner { get; set; }

        public Car (int Licenseplate, string Manufacture, int YearAs, int EngineSize,string model, Customers c1)
        {
            LicenseP = Licenseplate;
            Manufacturer = Manufacture;
            AssembYear = YearAs;
            Engine = EngineSize;
            Model = model;
            Owner = c1;
        }

        public override string ToString ()
        {
            string hold;
            hold = "License Plate: "+LicenseP+"   Manufacturer: "+Manufacturer+"  Assembly year: "+AssembYear+"   Engine Size:"+Engine+"    Model: "+Model+"    Owner: "+Owner.ToString();
            return hold;
            
        }
    }
}
