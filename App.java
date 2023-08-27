import java.sql.*;
import java.util.Scanner;

public class App {
    static final String url = "jdbc:mysql://localhost:3306/example";
    static final String username = "root";
    static final String password = "password";
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(url, username, password);
        Statement stmt = con.createStatement();
        PreparedStatement prepstmt;
        ResultSet rs;
        Scanner in = new Scanner(System.in);
        Scanner sin = new Scanner(System.in);

        String query;
        int choice;

        String name;
        int id, age;

        boolean loop = true;
        while (loop) {
            System.out.println("MySQL Java CRUD Operation");
			System.out.print("1. Insert \t");
			System.out.print("2. Update \t");
			System.out.print("3. Delete \t");
			System.out.print("4. Select \t");
			System.out.print("5. Exit \n");
			System.out.print("Enter a choice: ");

            choice = in.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nINSERT DATA");
                    System.out.print("Name : ");
                    name = sin.nextLine();
                    System.out.print("Age : ");
                    age = in.nextInt();

                    query = "INSERT INTO sample(name, age) VALUES (?, ?)";
                    prepstmt = con.prepareStatement(query);
                    prepstmt.setString(1, name);
                    prepstmt.setInt(2, age);
                    prepstmt.executeUpdate();
                    System.out.println("Data Inserted Successfully \n");

                    break;
                
                case 2:
                    System.out.println("\nUPDATE DATA");

                    System.out.print("ID : ");
                    id = in.nextInt();

                    System.out.print("Name : ");
                    name = sin.nextLine();
                    System.out.print("Age : ");
                    age = in.nextInt();

                    query = "UPDATE sample SET name=?, age=? WHERE id=?";
                    prepstmt = con.prepareStatement(query);
                    prepstmt.setString(1, name);
                    prepstmt.setInt(2, age);
                    prepstmt.setInt(3, id);
                    prepstmt.executeUpdate();
                    System.out.println("Data Updated Successfully \n");

                    break;

                case 3:
                    System.out.println("\nDELETE DATA");

                    System.out.print("ID : ");
                    id = in.nextInt();

                    query = "DELETE FROM sample WHERE id=?";
                    prepstmt = con.prepareStatement(query);
                    prepstmt.setInt(1, id);
                    System.out.println("Data Deleted Successfully \n");

                    break;

                case 4:
                    System.out.println("\nREAD DATA");

                    query = "SELECT * FROM sample";
                    rs = stmt.executeQuery(query);

                    while (rs.next()) {
                        System.out.println("\nID : " + rs.getInt("id"));
                        System.out.println("NAME : " + rs.getString("name"));
                        System.out.println("AGE : " + rs.getInt("age"));
                    }
                    System.out.println();

                    break;

                case 5:
                    loop = false;
                    break;

                default:
                System.out.println("Invalid Choice");
                    break;
            }
        }

        in.close();
        sin.close();
        con.close();
    }
}
