/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package GiaoDien;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author trani
 */
public class LoginTest {
    
    public LoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Login.
     */
    @Test
    public void testMain() {
        // Test case: Tham số dòng lệnh hợp lệ
    String[] args = {"admin", "password"};
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    System.setOut(printStream);
    
    // Gọi phương thức main với dữ liệu kiểm thử
    Login.main(args);
    
    // Lấy đầu ra từ bảng điều khiển
    String consoleOutput = outputStream.toString();
    
    // Kiểm tra rằng đầu ra chứa thông báo thành công dự kiến
    assertTrue(consoleOutput.contains("Đăng nhập thành công"));
    
    // Test case: Tham số dòng lệnh trống
    args = new String[0];
    outputStream.reset();
    System.setOut(printStream);
    
    // Gọi phương thức main với dữ liệu kiểm thử
    Login.main(args);
    
    // Lấy đầu ra từ bảng điều khiển
    consoleOutput = outputStream.toString();
    
    // Kiểm tra rằng đầu ra chứa thông báo thất bại dự kiến
    assertTrue(consoleOutput.contains("Đăng nhập không thành công"));
    
    // Thêm các test case khác để kiểm tra các tình huống khác nhau
    // Ví dụ: Tham số dòng lệnh không hợp lệ, v.v.
    }
    
}
