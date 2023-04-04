using System;
using System.Collections.Generic;
using System.Text;

namespace HW5
{
    internal class CompulsoryCourse : Courses
    {
        string Faculty { get; set; }
        public enum Semester
        {
            Summer,
            Spring,
            Autumn
        }
        public Semester semester = Semester.Summer;
        public CompulsoryCourse(string Cname, int CouID, int Max, string Facul, int s) : base(Cname, CouID, Max)
        {
            if (string.IsNullOrEmpty(Facul))
                throw new ArgumentNullException("Argument Exception");
            Faculty = Facul;
            semester = (Semester)s;
        }
        public new string GetDetails(char i)
        {
            string d = base.GetDetails(i);
            d += "\nFaculty:" + Faculty + "\nSemester:" + semester;
            return d;
        }
    }
}
