using System;
using System.Collections.Generic;
using System.Text;
namespace HW5
{
    internal class Courses
    {
        public string CourseName;
        public int CourseIdNum { get; }
        public string[] CoursesStudents { get; set; }
        protected int MaxStudents { get; }
        protected int EmptySlot;

        public Courses(string Cname, int CouID, int Max)
        {
            if (string.IsNullOrEmpty(Cname) || CouID <= 0)
                throw new ArgumentNullException("Argument Exception");
            else
            {
                CourseName = Cname;
                CourseIdNum = CouID;
                this.CoursesStudents = new string[Utils.MAX_STUDENT];
                MaxStudents = Max;
                EmptySlot = 0;
            }
        }
        public void Add_Student(string id)
        {
            Utils.CheckIdNumber(id);
            if (EmptySlot != CoursesStudents.Length)
            {
                CoursesStudents[EmptySlot] = id;
                EmptySlot++;
            }
            else
            {
                Console.WriteLine("No more vaccines in course");
                throw new InvalidOperationException("InvalidOperationException");
            }
        }
        public void Remove_Student(string id)
        {
            Utils.CheckIdNumber(id);
            for (int i = 0; i < EmptySlot; i++)
            {
                if (CoursesStudents[i] == id)
                {
                    for (int j = i; j < EmptySlot; j++)
                    {
                        CoursesStudents[j] = CoursesStudents[j + 1];
                    }
                    EmptySlot--;
                    return;
                }
            }
            Console.WriteLine("No Student found in this course");
            throw new InvalidOperationException("InvalidOperationException");
        }
        public string GetDetails(char i)
        {
            string full = "Course name:" + CourseName + "\nCourse ID:" + CourseIdNum + "\nCurrently Enrolled:" + (EmptySlot - 1) + "\nAvailable Place:" + ((CoursesStudents.Length - EmptySlot) - 1) + "\n";
            string ids = "";
            foreach (var item in CoursesStudents)
            {
                ids += item + i;
            }
            return full + ids;
        }
        public string getStudentCount()
        {
            int counter = 0;
            string d;
            foreach (var item in this.CoursesStudents)
            {
                if (!string.IsNullOrEmpty(item))
                    counter++;
            }
            d = this.CourseName + " - " + counter;
            return d;
        }
    }
}
