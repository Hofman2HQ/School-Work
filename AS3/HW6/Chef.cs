using System;
using System.Collections.Generic;
using System.Text;

namespace HW6
{
    internal class Chef
    {
        string Name { get; set; }
        string Speciality { get; set; }

        public Chef (string name, string special)
        {
            Name = name;
            Speciality = special;
        }
        public Chef (string name)
        {
            this.Name = name;
            Speciality = "none";
        }
        public override string ToString()
        {
            return "Name:"+this.Name.ToString() +"\nSpeciality:"+ this.Speciality.ToString();
        }
    }
}
