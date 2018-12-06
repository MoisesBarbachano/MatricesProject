/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 52999
 */
public class TranspuestaTest {
    
    public TranspuestaTest() {
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
     * Test of transponerMatrices method, of class Transpuesta.
     */
    @Test
    public void testTransponerMatrices() {
        System.out.println("transponerMatrices");
        double[][] matriz = {{1,2,5}, {3 , -4, 7}};
        double[][] expResult = {{1,3}, {2,-4},{5,7}};
        double[][] result = Transpuesta.transponerMatrices(matriz);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
