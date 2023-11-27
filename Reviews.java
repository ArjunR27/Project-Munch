import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Reviews {
    public static void attachReviewToRating(Connection con,
                                            int ratingID,
                                            int restID,
                                            String review) throws SQLException
    {
        Statement statement = con.createStatement();
        statement.executeUpdate("insert into Reviews(ratingID, restID, review) values("+ratingID+", " + restID + ", '" + review + "');");
    }
}

import java.sql.Connection;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;

public class Users
{
    public static void addUser(Connection con, String name, String username, String password) throws SQLException
    {
        Statement statement = con.createStatement();
        statement.executeUpdate("insert into Users(name, username, password) values('"+name+"', '" + username + "', '" + password + "');");
    }
}
