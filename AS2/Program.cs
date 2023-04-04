using System;
using System.Linq;

namespace HW5
{
    internal class Program
    {
        public static void ClearScreen()
        {
            Console.Clear();
        }
        static void Main(string[] args)
        {
            CompulsoryCourse[] MandCourse = new CompulsoryCourse[Utils.MAX_COURSES];
            ElectiveCourse[] Elective = new ElectiveCourse[Utils.MAX_COURSES];
            Console.WriteLine("College admin menu:\n1)Add Mendatory or Elective course\n2)Add Student to a course\n3)Print Courses for student\n4)Remove Student\n5)Remove Student from Course\n6)Get all courses details\n7)Number of student for each course\n8)Number of courses for each student\nPress E to exit");
            string Choise = Console.ReadLine();
            int CourseIDChoise = 0;
            int M = 0; int E = 0;
            while (!Choise.Equals("e"))
            {
                switch (Choise)
                {
                    case "2":
                        {
                            Console.WriteLine("Please Selcet Mandatory - 1 or Elective - 2");
                            int choise = int.Parse(Console.ReadLine());
                            if (choise == 1)
                            {
                                Console.WriteLine("Please Enter Course ID and Student ID to add to said course");
                                CourseIDChoise = int.Parse(Console.ReadLine());
                                if (M != 0)
                                    foreach (var item in MandCourse)
                                    {
                                        if (CourseIDChoise == item.CourseIdNum)
                                        {
                                            item.Add_Student(Console.ReadLine());
                                            Console.WriteLine("Student has been added to Compulsory Course" + item.CourseName + "\n");
                                            Console.WriteLine("Press any key to continue");
                                            Console.ReadKey();
                                            ClearScreen();
                                            break;
                                        }
                                    }
                                else
                                {
                                    throw new ArgumentException("Argument Exception");
                                }
                            }
                            else if (choise == 2)
                            {
                                Console.WriteLine("Please Enter Course ID and Student ID to add to said course");
                                CourseIDChoise = int.Parse(Console.ReadLine());
                                if (E != 0)
                                    foreach (var item in Elective)
                                    {
                                        if (CourseIDChoise == item.CourseIdNum)
                                        {
                                            item.Add_Student(Console.ReadLine());
                                            Console.WriteLine("Student has been added to Elective Course" + item.CourseName + "\n");
                                            Console.WriteLine("Press any key to continue");
                                            Console.ReadKey();
                                            ClearScreen();
                                            break;
                                        }
                                    }
                                else
                                {
                                    throw new ArgumentException("Argument Exception");
                                }
                            }
                        }
                        break;
                    case "1":
                        {
                            Console.WriteLine("Compusory - 1 / Elective - 2");
                            int choise = int.Parse(Console.ReadLine());
                            if (choise == 1)
                            {
                                Console.WriteLine("Please write the Course name, ID and Max student, Faculty and Which Semester (1 - Summer, 2 - Spring, 3 - Autumn)");
                                MandCourse[M] = new CompulsoryCourse(Console.ReadLine(), int.Parse(Console.ReadLine()), int.Parse(Console.ReadLine()), Console.ReadLine(), ((int.Parse(Console.ReadLine())) - 1));
                                M++;
                                Console.WriteLine("Course added!");
                                Console.WriteLine("Press any key to continue");
                                Console.ReadKey();
                                ClearScreen();
                            }
                            else if (choise == 2)
                            {
                                Console.WriteLine("Which Faculties are teaching this course? Max 3, if less - just leave empty");
                                string[] fac = new string[3];
                                for (int i = 0; i < 3; i++)
                                {
                                    fac[i] = Console.ReadLine();
                                }
                                Console.WriteLine("Please write the Course name, ID and Max student, What's the Academic level (1 - High, 2 - Medium, 3 - low), Minimum students to open");
                                Elective[E] = new ElectiveCourse(Console.ReadLine(), int.Parse(Console.ReadLine()), int.Parse(Console.ReadLine()), fac, (int.Parse(Console.ReadLine()) - 1), int.Parse(Console.ReadLine()));
                                E++;
                                Console.WriteLine("Course added!");
                                Console.WriteLine("Press any key to continue");
                                Console.ReadKey();
                                ClearScreen();
                            }
                        }
                        break;
                    case "3":
                        {
                            Console.WriteLine("Please write Student ID to print out the courses");
                            string id = Console.ReadLine();
                            Console.WriteLine("Checking if ID is valid");
                            Utils.CheckIdNumber(id);
                            Console.WriteLine("Valid!");
                            Console.WriteLine("Mandatory Course for student:");
                            foreach (var item in MandCourse)
                            {
                                foreach (var item2 in item.CoursesStudents)
                                {
                                    if (item2.Equals(id))
                                    {
                                        item.GetDetails('-');
                                    }
                                }
                            }
                            Console.WriteLine("Elective Courses for student:");
                            foreach (var item in Elective)
                            {
                                foreach (var item2 in item.CoursesStudents)
                                {
                                    if (item2.Equals(id))
                                    {
                                        item.GetDetails('-');
                                    }
                                }
                            }
                            Console.WriteLine("Press any key to continue");
                            Console.ReadKey();
                            ClearScreen();
                        }
                        break;
                    case "4":
                        {
                            Console.WriteLine("Enter Student ID to remove:");
                            string ToDelete = Console.ReadLine();
                            Console.WriteLine("Checking if ID is Valid...");
                            Utils.CheckIdNumber(ToDelete);
                            foreach (var item in MandCourse)
                            {
                                item.CoursesStudents = item.CoursesStudents.Where(val => val != ToDelete).ToArray();
                            }
                            foreach (var item in Elective)
                            {
                                item.CoursesStudents = item.CoursesStudents.Where(val => val != ToDelete).ToArray();
                            }
                            Console.WriteLine("Student removed!");
                            Console.WriteLine("Press any key to continue");
                            Console.ReadKey();
                            ClearScreen();
                        }
                        break;
                    case "5":
                        {
                            Console.WriteLine("Enter Student ID to remove:");
                            string ToDelete = Console.ReadLine();
                            Console.WriteLine("Checking if ID is valid...");
                            Utils.CheckIdNumber(ToDelete);
                            Console.WriteLine("Enter Course ID to remove student from");
                            int FromCourse = int.Parse(Console.ReadLine());
                            foreach (var item in MandCourse)
                            {
                                if (item.CourseIdNum == FromCourse)
                                {
                                    item.CoursesStudents = item.CoursesStudents.Where(val => val != ToDelete).ToArray();
                                    Console.WriteLine("Student removed from Course!");
                                    Console.WriteLine("Press any key to continue");
                                    Console.ReadKey();
                                    ClearScreen();
                                    break;
                                }
                            }
                            foreach (var item in Elective)
                            {
                                if (item.CourseIdNum == FromCourse)
                                {
                                    item.CoursesStudents = item.CoursesStudents.Where(val => val != ToDelete).ToArray();
                                    Console.WriteLine("Student removed from Course!");
                                    Console.WriteLine("Press any key to continue");
                                    Console.ReadKey();
                                    ClearScreen();
                                    break;
                                }
                            }
                            Console.WriteLine("No Course found with this student");
                            Console.WriteLine("Press any key to continue");
                            Console.ReadKey();
                            ClearScreen();
                        }
                        break;
                    case "6":
                        {
                            Console.WriteLine("Printing all courses:\n///////////////////////////////////");
                            foreach (var item in MandCourse)
                            {
                                item.GetDetails('\n');
                                Console.WriteLine("//////////////////////////////////");
                            }
                            foreach (var item in Elective)
                            {
                                item.GetDetails('\n');
                                Console.WriteLine("//////////////////////////////////");
                            }
                            Console.WriteLine("Press any key to continue");
                            Console.ReadKey();
                            ClearScreen();
                        }
                        break;
                    case "7":
                        {
                            Console.WriteLine("Printing number of students in each course:");
                            foreach (var item in MandCourse)
                            {
                                item.getStudentCount();
                                Console.WriteLine("//////////////////////////////////");
                            }
                            foreach (var item in Elective)
                            {
                                item.GetDetails('\n');
                                Console.WriteLine("//////////////////////////////////");
                            }
                            Console.WriteLine("Press any key to continue");
                            Console.ReadKey();
                            ClearScreen();
                        }
                        break;
                    case "8":
                        {
                            /*No idea*/
                            Console.WriteLine("Press any key to continue");
                            Console.ReadKey();
                            ClearScreen();
                        }
                        break;
                    case "e":
                        {
                            Console.WriteLine("Bye Bye");
                            Console.WriteLine("Press any key to continue");
                            Console.ReadKey();
                            ClearScreen();
                        }
                        break;
                    default:
                        {
                            Console.WriteLine("Wrong input, try again");
                            ClearScreen();
                        }
                        break;
                }
                Console.WriteLine("College admin menu:\n1)Add Mendatory or Elective course\n2)Add Student to a course\n3)Print Courses for student\n4)Remove Student\n5)Remove Student from Course\n6)Get all courses details\n7)Number of student for each course\n8)Number of courses for each student\nPress E to exit");
                Choise = Console.ReadLine();
            }
        }
    }
}
