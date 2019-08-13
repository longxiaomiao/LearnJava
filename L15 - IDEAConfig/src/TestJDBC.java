public class TestJDBC {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("驱动初始化成功！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}