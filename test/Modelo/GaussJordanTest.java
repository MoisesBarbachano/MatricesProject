/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

//Por el momento tiene error arreglar 
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
public class GaussJordanTest {
    
    public GaussJordanTest() {
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
     * Test of resolverGaussJordan method, of class GaussJordan.
     */
    @Test
    public void testResolverGaussJordan() {
        System.out.println("resolverGaussJordan");
        double[][] matriz = {{1, 1, 1,3}, {2 ,3, 7,0},{1 , 3, -2,17}}; 
      
        
        double[][] expResult ={{1,0,0,1}, {0,1,0,4},{0,0,1,-2}};
        
        
        double[][] result = GaussJordan.resolverGaussJordan(matriz);
       
       
        
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
