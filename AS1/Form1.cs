using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using HW4;

namespace HW4
{

    public partial class Form1 : Form
    {
        public static Garage mainGarage = new Garage();
        public Form1(Garage garage)
        {
            InitializeComponent();
            button2.Text = "Start Maintenance";
        }

        private void AddCar_Click(object sender, EventArgs e)
        {
            Form2 frm = new Form2(ref mainGarage);
            frm.ShowDialog();
            frm.VisibleChanged += formVisibleChanged;
            richTextBox1.Text = mainGarage.ToString();
            string carName = mainGarage.ToString().Substring(15, 8);
            comboBox1.Items.Add(carName);
            textBox1.Text = "Licence Plate";
            textBox2.Text = "ID of Car to remove";

        }
        private void formVisibleChanged(object sender, EventArgs e)
        {
            Form2 frm = (Form2)sender;
            if (!frm.Visible)
            {
                richTextBox1.Text = mainGarage.ToString();
                frm.Dispose();
            }
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            bool a = mainGarage.Repair(int.Parse(comboBox1.Text));
            if (a)
            {
                MessageBox.Show(comboBox1.Text + " Has started maintenance");
                richTextBox1.Text += comboBox1.Text + " is Repaird!";
            }
            else
            {
                MessageBox.Show(comboBox1.Text + " isn't in the garage");
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            mainGarage.RemoveCar(int.Parse(textBox1.Text),textBox2.Text);
            MessageBox.Show("Car has been removed");
            richTextBox1.Text = mainGarage.ToString();
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            textBox1.Clear();
        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {
            textBox2.Clear();
        }
    }
}
