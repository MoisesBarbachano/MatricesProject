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
public class SumatoriaTest {
    
    public SumatoriaTest() {
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
     * Test of sumarMatrices method, of class Sumatoria.
     */
    @Test
    public void testSumarMatrices() {
        System.out.println("sumarMatrices");
        double[][] primeraMatriz = {{2, -3,5}, {4 , 1, -7}};
        double[][] segundaMatriz = {{1, 0,2}, {-3 , 5, 8}};
        double[][] expResult = {{3, -3,7}, {1 , 6, 1}};
        double[][] result = Sumatoria.sumarMatrices(primeraMatriz, segundaMatriz);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
