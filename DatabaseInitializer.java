import java.sql.*;
public class DatabaseInitializer
{
    static Connection connect;

    private static void executeUpdate(String query) throws SQLException
    {
        try (Statement statement = connect.createStatement())
        {
            statement.execute(query);
        }
    }

    public static void createRestaurantsTable() throws SQLException
    {
        String createTable = "create table if not exists Restaurants ("
                 + "restID integer primary key auto_increment, "
                 + "name varchar(50) not null, "
                 + "location varchar(50) not null"
                 + ")";
        executeUpdate(createTable);
    }


    public static void createUsersTable() throws SQLException
    {
        String createTable = "create table if not exists Users ("
                + "userID integer primary key auto_increment, "
                + "name varchar(50) not null, "
                + "username varchar(50) not null, "
                + "password varchar(50) not null"
                + ")";
        executeUpdate(createTable);
    }

    public static void createRatingsTable() throws SQLException
    {
        String createTable = "create table if not exists Ratings ("
                + "ratingID integer primary key auto_increment, "
                + "restID integer, "
                + "rating integer not null, "
                + "userID integer, "
                + "foreign key(userID) references Users(userID), "
                + "foreign key(restID) references Restaurants(restID)"
                + ")";
        executeUpdate(createTable);
    }

    public static void createReviewsTable() throws SQLException
    {
        String createTable = "create table if not exists Reviews ("
                + "ratingID integer primary key, "
                + "restID integer, "
                + "review varchar(200), "
                + "foreign key(ratingID) references Ratings(ratingID), "
                + "foreign key(restID) references Restaurants(restID)"
                + ")";
        executeUpdate(createTable);
    }

    public static void initializeDatabase() throws SQLException
    {
        createRestaurantsTable();
        createRatingsTable();
        createReviewsTable();
        createUsersTable();
    }


    public static void main(String[] args) throws SQLException {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://ambari-node5.csc.calpoly.edu:3306/cs365munch?user=cs365munch&password=cs365munchpass");
            System.out.println("connected to database");

            initializeDatabase();
            System.out.println("all tables created successfully");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
