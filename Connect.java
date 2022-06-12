import java.sql.*;

public class Connect {
    /**
     * Connect to a sample database
     */
    public static Connection connect() {
        Connection conn = null;
        try {
            // db parameters  
            String url = "jdbc:sqlite:Turtles.db";
            // create a connection to the database  
            conn = DriverManager.getConnection(url);

            return conn;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return conn;
        }
    }

    public static void insert(Turtle turtleObj) {
        String species = turtleObj.getSpecies();
        int turtle_id = turtleObj.getTurtleId();
        float weight = turtleObj.getWeight();
        float length = turtleObj.getLength();
        int working_flippers = turtleObj.getNumberOfWorkingFlippers();
        String location = turtleObj.getSampleLocation();

        String sql = "INSERT INTO turtle(species,weight,length,working_flippers,location,turtle_id) VALUES(?,?,?,?,?,?)";

        try{
            Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, species);
            pstmt.setFloat(2, weight);
            pstmt.setFloat(3, length);
            pstmt.setInt(4, working_flippers);
            pstmt.setString(5, location);
            pstmt.setInt(6, turtle_id);
//            pstmt.setDate(6, date);
            pstmt.executeUpdate();
            System.out.println("Record inserted successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void remove(int id) {
        String sql = "DELETE FROM turtle WHERE turtle_id = ?";

        try {
             Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Record removed successfully");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void update(Turtle turtleObj) {
        String species = turtleObj.getSpecies();
        int turtle_id = turtleObj.getTurtleId();
        float weight = turtleObj.getWeight();
        float length = turtleObj.getLength();
        int working_flippers = turtleObj.getNumberOfWorkingFlippers();
        String location = turtleObj.getSampleLocation();

        String sql = "UPDATE turtle SET species = ?, weight = ?,length = ? ,working_flippers = ?,location = ? WHERE turtle_id=?";

        try (
                Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

                // set the corresponding param
                pstmt.setString(1, species);
                pstmt.setFloat(2, weight);
                pstmt.setFloat(3, length);
                pstmt.setInt(4, working_flippers);
                pstmt.setString(5, location);
                pstmt.setInt(6, turtle_id);
    //            pstmt.setDate(6, date);

                pstmt.executeUpdate();
            System.out.println("Record updated successfully");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}