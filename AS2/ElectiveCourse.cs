using System;
using System.Collections.Generic;
using System.Text;

namespace HW5
{
    internal class ElectiveCourse : Courses
    {
        public string[] FacultyArr = new string[3];
        enum AcademicLevel
        {
            High,
            Medium,
            Low
        }
        AcademicLevel AL { get; set; }
        int MinStudents { get; set; }
        bool IsOpen { get; set; }

        public ElectiveCourse(string Cname, int CouID, int Max, string[] faculty, int s, int min) : base(Cname, CouID, Max)
        {
            if (faculty.Length > 3 || string.IsNullOrEmpty(faculty[0]) || string.IsNullOrEmpty(faculty[1]) || string.IsNullOrEmpty(faculty[2]))
            {
                throw new ArgumentException("Argument Exception");
            }
            FacultyArr = faculty;
            MinStudents = min;
            AL = (AcademicLevel)s;
        }
        public new string GetDetails(char i)
        {
            string d = base.GetDetails(i);
            d += "\nThe Faculties that alows this course:\n" + FacultyArr[0] + "\n" + FacultyArr[1] + "\n" + FacultyArr[2] + "\nMinimum Students required:" + MinStudents + "\nAcademic Level:" + AL;
            return d;
        }
        public void Open()
        {
            if (!IsOpen)
            {
                if ((EmptySlot - 1) >= MinStudents)
                {
                    IsOpen = true;
                    Console.WriteLine("The Course has opened");
                }
                else
                {
                    throw new ArgumentException("Not enough student in course");
                }
            }
            else
            {
                throw new ArgumentException("The Course is already open!");
            }
        }
        public void Close()
        {
            if (IsOpen)
            {
                IsOpen = false;
                Console.WriteLine("The Course has been closed!");
            }
            else
            {
                throw new ArgumentException("The Course is already Closed!");
            }
        }
    }
}
