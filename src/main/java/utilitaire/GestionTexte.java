package utilitaire;

import java.util.ArrayList;

public class GestionTexte 
{
	public static boolean estNullOuVide(String texte)
	{
		return (texte==null || texte.length()==0);
	}
	
	public static ArrayList<Object> suppressionDoublon(ArrayList<Object> liste)
	{
		int i=0;
		for(i=0; i<liste.size(); i++)
		{
			liste = GestionTexte.supprimer(liste.get(i), liste);
		}
		return liste;
	}
	
	private static ArrayList<Object> supprimer(Object value, ArrayList<Object> liste)
	{
		int compteur = 0;
		int i=0;
		int taille = liste.size();
		for(i=0; i<taille; i++)
		{
			if(i<liste.size() && liste.get(i).equals(value))
			{
				compteur++;
			}
			if(i<liste.size() && liste.get(i).equals(value) && compteur>1)
			{
				liste.remove(i);
			}
		}
		return liste;
	}
}
