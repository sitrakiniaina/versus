/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.ArrayList;
import mapping.EvenementPhoto;
import mapping.EvenementTexte;
import mapping.Membre;
import mapping.ParticipationPhoto;
import mapping.ParticipationTexte;
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
public class GestionEvenementTest {
    
    public GestionEvenementTest() {
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
     * Test of amisEnCommun method, of class GestionEvenement.
     */
    @Test
    public void testAmisEnCommun() throws Exception {
        System.out.println("amisEnCommun");
        long idMembre1 = 1;
        long idMembre2 = 1;
        long  expResult = 1;
        ArrayList<Membre> result = GestionEvenement.amisEnCommun(idMembre1, idMembre2);
        System.out.println("nombre d'amis en commun de membre 1 et membre 1: "+result.size());
        assertEquals(expResult, result.size());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
   

   
    
}
