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
public class EscalarTest {
    
    public EscalarTest() {
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
     * Test of multiplicarPorEscalar method, of class Escalar.
     */
    @Test
    public void testMultiplicarPorEscalar() {
        System.out.println("multiplicarPorEscalar");
        double[][] matriz = new double[2][2];
        matriz[0][0]=1;
        matriz[0][1]=1;
        matriz[1][0]=1;
        matriz[1][1]=1;
        double escalar = 2;
        
        double[][] expResult = new double[2][2];
        expResult[0][0]=2;
        expResult[0][1]=2;
        expResult[1][0]=2;
        expResult[1][1]=2;
        double[][] result = Escalar.multiplicarPorEscalar(matriz, escalar);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
