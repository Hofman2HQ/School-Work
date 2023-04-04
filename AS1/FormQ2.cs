using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace Task4Q2
{
    public partial class Form2 : Form
    {
        private Form father;
        private string name;
        private double score;
        private int timer = 10;
        private int level = 1;
        private string[] ans;
        private string[][] others;
        private string[] pArr = { "1.png", "2.jpg", "3.jpg", "4.jpg", "5.jpg", "6.jpg", "7.png", "8.png", "9.png", "10.jpg" };
        private int[] used = { 0, 0, 0, 0 };
        private int currentQ;
        private Random rand = new Random();
        private int again = 0;

        public Form2(string name, Form father)
        {

            this.father = father;
            this.score = 0;
            currentQ = rand.Next(0, 10);
            this.name = name;
            InitializeComponent();
            InitializeAns();
            InitializeOthers();
            addAnswers(currentQ);
            ImageSet(currentQ);
            UsedAdd(currentQ);

            label1.Text = timer.ToString();
            timer1.Start();
            label2.Hide();
            comboBox1.Hide();
            button1.Hide();
        }

        private void Form2_Load(object sender, EventArgs e)
        {

        }

        private void ImageSet(int choice)
        {
            pictureBox1.ImageLocation = @"..\..\..\pics\" + pArr[choice];
        }

        private void addAnswers(int choice)
        {
            int place = rand.Next(3);
            for (int i = 0, t = 0; i < 3; i++)
            {
                if (place != i)
                {
                    comboBox1.Items.Add(others[choice][t]);
                    t++;
                } 
                else
                {
                    comboBox1.Items.Add(ans[choice]);
                }
            }
        }

        private void InitializeAns()
        {
            ans = new string[] { };

        }

        private void InitializeOthers()
        {
            others = new string[10][];
            others[0] = new string[] {};
            others[1] = new string[] {};
            others[2] = new string[] {};
            others[3] = new string[] {};
            others[4] = new string[] {};
            others[5] = new string[] {};
            others[6] = new string[] {};
            others[7] = new string[] {};
            others[8] = new string[] {};
            others[9] = new string[] {};

        }
        private void timer1_Tick(object sender, EventArgs e)
        {
            timer--;
            label1.Text = timer.ToString();
            if (timer == 0)
            {
                timer1.Stop();
                pictureBox1.Hide();
                label1.Hide();

                label2.Show();
                comboBox1.Show();
                button1.Show();
            }
        }

        public bool UsedContains(int a)
        {
            foreach (int number in used)
            {
                if (number == a)
                {
                    return true;
                }
            }
            return false;
        }

        public bool UsedAdd(int a)
        {
            for (int i = 0; i < this.used.Length; i++)
            {
                if (used[i] == 0)
                {
                    used[i] = a;
                    return true;
                }
            }
            return false;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (comboBox1.SelectedIndex != -1)
            {
                if (comboBox1.SelectedItem.ToString() == ans[currentQ])
                {
                    if (again == 0)
                    {
                        score++;
                    }
                    else
                    {
                        score += 0.5;
                    }

                    MessageBox.Show("Correct!", "Right Answer!");
                    comboBox1.Items.Clear();
                    currentQ = rand.Next(0, 10);
                    while (UsedContains(currentQ))
                    {
                        currentQ = rand.Next(0, 10);
                    }
                    if (UsedAdd(currentQ) == false)
                    {
                        MessageBox.Show(name + " you successfully manage to finish the game!\nYour score is " + score, "Congrats!");

                        this.Close();
                        this.father.Show();
                        return;
                    }
                    addAnswers(currentQ);
                    ImageSet(currentQ);
                    pictureBox1.Show();
                    label1.Show();
                    button2.Show();
                    timer = 10 - 2*level;
                    level++;
                    again = 0;
                    label1.Text = timer.ToString();
                    timer1.Start();

                    label2.Hide();
                    comboBox1.Hide();
                    button1.Hide();
                }
                else
                {
                    if (again != 0)
                    {
                        MessageBox.Show(name + ", You are a loser!\nYour Score :" + score.ToString(), "Wrong Answer!");
                        this.Close();
                        this.father.Close();
                        return;
                    }
                    MessageBox.Show(name + ", try again! You can do it!\nYour Score currently: " + score.ToString(), "Another Chance!");
                    again++;
                    comboBox1.Items.RemoveAt(comboBox1.SelectedIndex);
                }
            }
        }
    }
}
