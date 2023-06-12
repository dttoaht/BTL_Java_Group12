package GiaoDien;

import Model.Grade;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QLDiemTest {

    public QLDiemTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of find method, of class QLDiem.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        String s = "ABC"; // Test case: s là chuỗi "ABC"
        QLDiem instance = new QLDiem();
        ResultSet result = instance.find(s);
        assertNull(result);
    }

    /**
     * Test of CheckInput method, of class QLDiem.
     */
    @Test
    public void testCheckInput() {
        System.out.println("CheckInput");
        QLDiem instance = new QLDiem();
        boolean result = instance.CheckInput();
        assertFalse(result);
    }

    /**
     * Test of getGradeList method, of class QLDiem.
     */
    @Test
    public void testGetGradeList() {
        System.out.println("getGradeList");
        QLDiem instance = new QLDiem();
        ArrayList<Grade> result = instance.getGradeList();
        assertNotNull(result);
        assertEquals(0, result.size());
    }

    /**
     * Test of showTable method, of class QLDiem.
     */
    @Test
    public void testShowTable() {
        System.out.println("showTable");
        QLDiem instance = new QLDiem();
        assertDoesNotThrow(() -> {
            instance.showTable();
        });
    }

    /**
     * Test of ShowItem method, of class QLDiem.
     */
    @Test
    public void testShowItem() {
        System.out.println("ShowItem");
        int index = 0; // Test case: index là 0
        QLDiem instance = new QLDiem();
        assertDoesNotThrow(() -> {
            instance.ShowItem(index);
        });
    }

    /**
     * Test of Clead method, of class QLDiem.
     */
    @Test
    public void testClead() {
        System.out.println("Clead");
        QLDiem instance = new QLDiem();
        assertDoesNotThrow(() -> {
            instance.Clead();
        });
    }

    /**
     * Test of main method, of class QLDiem.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        assertDoesNotThrow(() -> {
            QLDiem.main(args);
        });
    }

    /**
     * Test of them method, of class QLDiem.
     */
  @Test
public void testThem() {
    System.out.println("them");
    String maSV = "SV001"; // Mã sinh viên
    String hoTenSV = "Nguyen Van A"; // Họ tên sinh viên
    double tiengAnh = 8.5; // Điểm môn Tiếng Anh
    double tinHoc = 7.5; // Điểm môn Tin Học
    double gdtc = 9.0; // Điểm môn Giáo dục công dân

    QLDiem instance = new QLDiem();
    boolean result = instance.them(maSV, hoTenSV, tiengAnh, tinHoc, gdtc);
    assertTrue(result);
}

}