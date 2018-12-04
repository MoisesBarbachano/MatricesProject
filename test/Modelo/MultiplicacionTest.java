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
public class MultiplicacionTest {
    
    public MultiplicacionTest() {
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
     * Test of multiplicarMatrices method, of class Multiplicacion.
     */
    @Test
    public void testMultiplicarMatrices() {
        System.out.println("multiplicarMatrices");
       
        double[][] primeraMatriz = {{1, 0,2}, {-1 , 3, 1}};
        double[][] segundaMatriz ={{3,1}, {2,1},{1,0}};
        double[][] expResult = {{5,1}, {4,2}};
        double[][] result = Multiplicacion.multiplicarMatrices(primeraMatriz, segundaMatriz);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
