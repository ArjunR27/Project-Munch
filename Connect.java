import java.sql.*;
public class Connect
{
    static Connection connect;

    public static void createRestaurantsTable() throws SQLException
    {
        String createTable = "create table if not exists Restaurants ("
                 + "restID integer primary key auto_increment, "
                 + "name varchar(50) not null, "
                 + "location varchar(50) not null"
                 + ")";
        try (Statement statement = connect.createStatement())
        {
            statement.execute(createTable);
        }
    }
    public static void main(String[] args) throws SQLException {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://ambari-node5.csc.calpoly.edu:3306/cs365munch?user=cs365munch&password=cs365munchpass");
            System.out.println("connected to database");

            createRestaurantsTable();
            System.out.println("Restaurants Table created successfully");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
