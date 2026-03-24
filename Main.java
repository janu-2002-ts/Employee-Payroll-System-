import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        int choice;

        do
        {
            System.out.println("\n1.Add Employee\n2.View Employees\n3.Generate Payslip\n4.Delete Employee\n5.Exit");
            choice = sc.nextInt();

            switch(choice)
            {
                case 1:
                    Employee e = new Employee();

                    System.out.print("Enter ID: ");
                    e.setId(sc.nextInt());

                    System.out.print("Enter Name: ");
                    e.setName(sc.next());

                    System.out.print("Enter Basic Salary: ");
                    e.setBasic(sc.nextDouble());

                    dao.addEmployee(e);
                    break;

                case 2:
                    dao.viewEmployees();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    dao.generatePayslip(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    dao.deleteEmployee(sc.nextInt());
                    break;
            }
        } while(choice != 5);
    }
}
