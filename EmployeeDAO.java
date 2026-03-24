import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDAO 
{
    public void addEmployee(Employee e) 
    {
        try 
        {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "insert into employee values(?,?,?)"
            );

            ps.setInt(1, e.getId());
            ps.setString(2, e.getName());
            ps.setDouble(3, e.getBasic());

            ps.executeUpdate();

            System.out.println("Inserted");
        } 
        catch (Exception ex) 
        {
            System.out.println(ex);
        }
    }

    public void viewEmployees() 
    {
        try 
        {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "select * from employee"
            );

            ResultSet rs = ps.executeQuery();

            while(rs.next()) 
            {
                System.out.println(
                    rs.getInt(1) + " " +
                    rs.getString(2) + " " +
                    rs.getDouble(3)
                );
            }
        } 
        catch (Exception ex) 
        {
            System.out.println(ex);
        }
    }

    public void generatePayslip(int id) 
    {
        try 
        {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "select * from employee where id=?"
            );

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) 
            {
                double basic = rs.getDouble(3);
                double hra = basic * 0.2;
                double da = basic * 0.1;
                double total = basic + hra + da;

                System.out.println("ID: " + rs.getInt(1));
                System.out.println("Name: " + rs.getString(2));
                System.out.println("Basic: " + basic);
                System.out.println("HRA: " + hra);
                System.out.println("DA: " + da);
                System.out.println("Total Salary: " + total);
            }
        } 
        catch (Exception ex) 
        {
            System.out.println(ex);
        }
    }

    public void deleteEmployee(int id) 
    {
        try 
        {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "delete from employee where id=?"
            );

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Deleted");
        } 
        catch (Exception ex) 
        {
            System.out.println(ex);
        }
    }
}
