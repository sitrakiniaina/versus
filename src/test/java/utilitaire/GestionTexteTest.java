/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaire;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author herinihaja
 */
public class GestionTexteTest {
    
    public GestionTexteTest() {
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
     * Test of estNullOuVide method, of class GestionTexte.
     */
    @org.junit.Test
    public void testEstNullOuVide() {
        System.out.println("estNullOuVide");
        String texte = "";
        boolean expResult = false;
        boolean result = GestionTexte.estNullOuVide(texte);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of suppressionDoublon method, of class GestionTexte.
     */
    @org.junit.Test
    public void testSuppressionDoublon() {
        System.out.println("suppressionDoublon");
        ArrayList<Object> liste = null;
        ArrayList<Object> expResult = null;
        ArrayList<Object> result = GestionTexte.suppressionDoublon(liste);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
