using System;
using System.Collections.Generic;
using System.Text;

namespace HW5
{
    public static class Utils
    {
        public const int MAX_STUDENT = 10;
        public const int MAX_COURSES = 5;

        public static void CheckIdNumber(string id)
        {
            if (id.Length != 9 || id[0] != '0')
                throw new ArgumentException("Argument Exception");
        }
    }
}
