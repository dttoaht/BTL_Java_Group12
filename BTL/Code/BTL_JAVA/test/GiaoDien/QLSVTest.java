/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package GiaoDien;

import Model.SinhVien;
import java.util.ArrayList;
import javax.swing.ImageIcon;
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
public class QLSVTest {
    
    public QLSVTest() {
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
     * Test of ResizeImage method, of class QLSV.
     */
    @Test
    public void testResizeImage() {
        System.out.println("ResizeImage");
        String imagePath = "";
        byte[] pic = null;
        QLSV instance = new QLSV();
        ImageIcon expResult = null;
        ImageIcon result = instance.ResizeImage(imagePath, pic);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CheckInput method, of class QLSV.
     */
    @Test
    public void testCheckInput() {
        System.out.println("CheckInput");
        QLSV instance = new QLSV();
        boolean expResult = false;
        boolean result = instance.CheckInput();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSinhVienList method, of class QLSV.
     */
    @Test
    public void testGetSinhVienList() {
        System.out.println("getSinhVienList");
        QLSV instance = new QLSV();
        ArrayList<SinhVien> expResult = null;
        ArrayList<SinhVien> result = instance.getSinhVienList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showTable method, of class QLSV.
     */
    @Test
    public void testShowTable() {
        System.out.println("showTable");
        QLSV instance = new QLSV();
        instance.showTable();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of formatPhoneNumber method, of class QLSV.
     */
    @Test
    public void testFormatPhoneNumber() {
        System.out.println("formatPhoneNumber");
        int phoneNumber = 0;
        QLSV instance = new QLSV();
        String expResult = "";
        String result = instance.formatPhoneNumber(phoneNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ShowItem method, of class QLSV.
     */
    @Test
    public void testShowItem() {
        System.out.println("ShowItem");
        int index = 0;
        QLSV instance = new QLSV();
        instance.ShowItem(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Clean method, of class QLSV.
     */
    @Test
    public void testClean() {
        System.out.println("Clean");
        QLSV instance = new QLSV();
        instance.Clean();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class QLSV.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        QLSV.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
