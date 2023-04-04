using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace HW4
{
    public partial class Form2 : Form
    {
        private Garage g1 = new Garage();
        public Form2(ref Garage mainGarage)
        {
            g1 = mainGarage;
            InitializeComponent();
        }

        private void Form2_Load(object sender, EventArgs e)
        {

        }

        private void aCar_Click(object sender, EventArgs e)
        {
            Customers man = new Customers(ID.Text, Fname.Text, Lname.Text, PhoneN.Text, Address.Text);
            Car c1 = new Car(int.Parse(LicenceP.Text), Manufac.Text, int.Parse(Assembly.Text), int.Parse(Engine.Text), Model.Text, man);
            g1.AddCar(c1);
            Form1 f = new Form1(g1);
            this.Visible = false;
        }
    }
}
