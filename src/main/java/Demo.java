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


                String sql = "insert into student values (8, 'Johninhohff', '49')";
                boolean status = st.execute(sql);

                System.out.println(status);



                /*
                read
                 */
//                String sql = "select * from student";
//                ResultSet rs = st.executeQuery(sql);
//                ResultSetMetaData rsmd = rs.getMetaData();
//                int columnCount = rsmd.getColumnCount();
//                System.out.println("column count: " + columnCount);
//
//
//                while (rs.next()) {
//                    System.out.println("------ nouvelle ligne -----");
//
//                    for (int i = 1; i < columnCount + 1; i++) {
//                        String columnName = rsmd.getColumnName(i);
//                        int type = rsmd.getColumnType(i);
//
//                        if (type == Types.INTEGER || type == Types.BIGINT) {
//                            System.out.println(columnName + ": " + rs.getInt(i));
//                        } else if (type == Types.VARCHAR || type == Types.CHAR) {
//                            System.out.println(columnName + ": " + rs.getString(i));
//                        } else {
//                            System.out.println(columnName + ": " + rs.getObject(i));
//                        }
//                    }
//                }

                /*
                update
                 */






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

