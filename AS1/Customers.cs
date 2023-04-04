using System;
using System.Collections.Generic;
using System.Text;

namespace HW4
{
    public class Customers
    {
        public string ID { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string PhoneNum { get; set; }
        public string Address { get; set; }

        public Customers(string id, string fName, string lname, string pNum, string address)
        {
            ID = id;
            FirstName = fName;
            LastName = lname;
            PhoneNum = pNum;
            Address = address;
        }

        public override string ToString ()
        {
            string hold;
            hold =  FirstName+"   "+ LastName +"  "+ PhoneNum +"  "+ Address;
            return hold;
        }
    }
}
