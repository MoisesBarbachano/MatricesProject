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
        double[][] matriz = {{3, -0.1, -0.2,7.85}, {0.1 , 7, -0.3,-19.3},{0.3 , -0.2, 10,71.4}}; 
        for (int x=0; x < matriz.length; x++) {
            System.out.print("|");
        for (int y=0; y < matriz[x].length; y++) {
            System.out.print (matriz[x][y]);
            if (y!=matriz[x].length-1) System.out.print("\t");
        }
         System.out.println("|");
       }
        double[][] expResult ={{1,0,0,3.0}, {0,1,0,-2.5},{0,0,1,7.000000000000002}};
        double[][] result = GaussJordan.resolverGaussJordan(matriz);
       
        for (int x=0; x < result.length; x++) {
            System.out.print("|");
        for (int y=0; y < result[x].length; y++) {
            System.out.print (result[x][y]);
            if (y!=result[x].length-1) System.out.print("\t");
        }
         System.out.println("|");
       }
        
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
