/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.GestionEntity;
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
public class InscriptionTest {
    
    public InscriptionTest() {
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
    public void tearDown() throws Exception {
        
    }

    

   

    /**
     * Test of inscription method, of class Inscription.
     */
    @Test
    public void testInscription() throws Exception {
        System.out.println("inscription");
        long nombreLigne = GestionEntity.getMaxId("membre");
        System.out.println("nombre de ligne avant : "+nombreLigne );
        String nom = "rakotoarisoa";
        String prenom = "herinihaja";
        String dateNaissance = "01-03-1996";
        String sexe = "h";
        String mail = "lion@gmail.com";
        String mdp1 = "lion";
        String mdp2 = "lion";
        Inscription.inscription(nom, prenom, dateNaissance, sexe, mail, mdp1, mdp2);
        tearDown();
        long nombreLignes = GestionEntity.getMaxId("membre");
        System.out.println("nombre de ligne après insert : "+nombreLignes );
        assertEquals(nombreLigne+1, nombreLignes);  
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
