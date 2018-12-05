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

//corregir error para poner valor absoluto cuando el valor sea 0, ya que genera negativo
public class InversaGaussJordanTest {
    
    public InversaGaussJordanTest() {
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
     * Test of invertirGaussJordan method, of class InversaGaussJordan.
     */
    @Test
    public void testInvertirGaussJordan() {
        System.out.println("invertirGaussJordan");
        
        double[][] matrizEntrada ={{1, 1, 0}, {1, 0, 1},{0 , 1, 0}};
        double[][] expResult = {{1, 0, -1}, {0 , 0, 1},{-1 ,1, 1}};
        
        double[][] result = InversaGaussJordan.invertirGaussJordan(matrizEntrada);
        
        
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
