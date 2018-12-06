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
public class DeterminanteTest {
    
    public DeterminanteTest() {
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
     * Test of obtenerDeterminante method, of class Determinante.
     */
    @Test
    public void testObtenerDeterminante() {
        
        System.out.println("obtenerDeterminante");
        
        //datos de entrada
        double[][] matriz = new double[3][3];
        matriz[0][0]=3;
        matriz[0][1]=2;
        matriz[0][2]=1;
        matriz[1][0]=0;
        matriz[1][1]=2;
        matriz[1][2]=-5;
        matriz[2][0]=-2;
        matriz[2][1]=1;
        matriz[2][2]=4;
        
        //datos de salida
        double expResult = 63;
        double result = Determinante.obtenerDeterminante(matriz);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of esPar method, of class Determinante.
     */
    @Test
    public void testEsPar() {
        System.out.println("esPar");
        int valor = 2;
        boolean expResult = true;
        boolean result = Determinante.esPar(valor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
