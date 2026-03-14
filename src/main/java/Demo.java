import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;


public class Demo {

    public static void main(String[] args) throws SQLException {

        Dotenv dotenv = Dotenv.load();
        String url = dotenv.get("DB_URL");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            if (connection != null) {
                System.out.println("Connected to the database!");
                Statement st = connection.createStatement();


                /*
                create
                 */

//
//                String createSql = "insert into new_student (name, age) values (?,?)";
//                PreparedStatement ppst = connection.prepareStatement(createSql);
//                ppst.setString(1,"Denis");
//                ppst.setInt(2,5);
//                int rowsCreate = ppst.executeUpdate();
//                System.out.println("rows created: " + rowsCreate);





                /*
                update
                 */

//                String updateSql = "update new_student set name = ? where id = ?";
//                PreparedStatement ppst = connection.prepareStatement(updateSql);
//                ppst.setString(1, "Navin");
//                ppst.setInt(2, 1);
//                int rowsUpdated = ppst.executeUpdate();
//                System.out.println("rows updated: " + rowsUpdated);


                /*
                delete
                 */

                String updateSql = "delete from new_student where id = ?";
                PreparedStatement ppst = connection.prepareStatement(updateSql);
                ppst.setInt(1, 1);
                int rowsDeleted = ppst.executeUpdate();
                System.out.println("rows deleted: " + rowsDeleted);


                /*
                read
                 */
                String readSql = "select * from new_student";
                ResultSet rs = st.executeQuery(readSql);
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
                System.out.println("column count: " + columnCount);


                while (rs.next()) {
                    System.out.println("------ nouvelle ligne -----");

                    for (int i = 1; i < columnCount + 1; i++) {
                        String columnName = rsmd.getColumnName(i);
                        int type = rsmd.getColumnType(i);

                        if (type == Types.INTEGER || type == Types.BIGINT) {
                            System.out.println(columnName + ": " + rs.getInt(i));
                        } else if (type == Types.VARCHAR || type == Types.CHAR) {
                            System.out.println(columnName + ": " + rs.getString(i));
                        } else {
                            System.out.println(columnName + ": " + rs.getObject(i));
                        }
                    }
                }










            } else {
                System.out.println("Failed to make connection!");
            }


        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
//


    }
}

