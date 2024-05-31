import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection = SingletonConnection.getConnection();
        try{

            System.out.println("connection is valid ="+connection.isValid(0));
            //select
            PreparedStatement selectps = connection.prepareStatement("select * from students");

            ResultSet resultSet = selectps.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("st_id") + "-" + resultSet.getString("st_name"));
            }

            //insert

            PreparedStatement insertps = connection.prepareStatement("insert into students (st_name) values (?)");
            insertps.setString(1,"ali");
            int insertCount = insertps.executeUpdate();
            System.out.println("insert count ="+insertCount);



            // select

            PreparedStatement selectps2 = connection.prepareStatement("select * from students");
            resultSet = selectps2.executeQuery();
            while (resultSet.next()) {

                System.out.println(resultSet.getInt("st_id") + "-" + resultSet.getString("st_name"));

            }

            // update
            PreparedStatement updateps = connection.prepareStatement("update students set st_name = ? where st_id = ?");
            updateps.setString(1,"taher");
            updateps.setInt(2,2);
            int updateCount = updateps.executeUpdate();
            System.out.println("update count ="+updateCount);



            // select

            System.out.println("after updating");

            PreparedStatement selectps3 = connection.prepareStatement("select * from students");
            resultSet = selectps3.executeQuery();
            while (resultSet.next()) {

                System.out.println(resultSet.getInt("st_id") + "-" + resultSet.getString("st_name"));

            }




            // delete
            PreparedStatement deleteps = connection.prepareStatement("delete from students where st_id = ?");
            deleteps.setInt(1,4);
            int deleteCount = deleteps.executeUpdate();
            System.out.println("delete count ="+deleteCount);



            // select

            System.out.println("after deleting");

            PreparedStatement selectps4 = connection.prepareStatement("select * from students");
            resultSet = selectps4.executeQuery();
            while (resultSet.next()) {

                System.out.println(resultSet.getInt("st_id") + "-" + resultSet.getString("st_name"));

            }

        }catch (SQLException e){
            System.out.println(e);
        }

    }
}