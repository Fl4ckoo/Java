import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ProductUtil {
    private ProductUtil() {
    }

    public static void createTable() {

        String createSql = "CREATE TABLE PRODUCTS (" +
                "ID INTEGER NOT NULL AUTO_INCREMENT, " +
                "NAME VARCHAR(255), " +
                "PRICE INTEGER NOT NULL," +
                "WEIGHT INTEGER NOT NULL," +
                "PRIMARY KEY(ID))";

        try {
            JDBCUtil.getStatement().executeUpdate(createSql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Created table in given database...");
    }

    public static void insert(Product product) {

        String insertSql = "INSERT INTO PRODUCTS(NAME, PRICE, WEIGHT) VALUES(" +
                "'" + product.getName() + "', " +
                "'" + product.getPrice() + "', " +
                "" + product.getWeight() + ")";

        try {
            JDBCUtil.getStatement().executeUpdate(insertSql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }




    public static List<Product> getAllProducts() {

        String selectSql = "SELECT * FROM Products";

        List<Product> products = new ArrayList<>();

        try {

            ResultSet resultSet = JDBCUtil.getStatement().executeQuery(selectSql);

            while (resultSet.next()) {

                products.add(new Product(
                        resultSet.getLong("ID"),
                        resultSet.getString("FIRST_NAME"),
                        resultSet.getInt("PRICE"),
                        resultSet.getInt("WEIGHT")
                ));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;

    }

    public static void updateProduct(long id, String newName) {

        String updateSql = "UPDATE PRODUCTS SET NAME = '" + newName + "' WHERE ID = " + id;

        try {
            JDBCUtil.getStatement().executeUpdate(updateSql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void deleteProduct(long id) {

        String delete = "DELETE FROM PRODUCTS WHERE ID = " + id;

        try {
            JDBCUtil.getStatement().executeUpdate(delete);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void deleteAll() {

        String deleteAll = "DELETE FROM PRODUCTS";

        try {
            JDBCUtil.getStatement().executeUpdate(deleteAll);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}



