import java.util.ArrayList;

public class Sommet {
	private ArrayList<ArrayList<Contrainte>> contraintes;
	private int poidsMax;
	private int couleur;
	private int numero;
	private static int next_sommet;

	public static void incrementer(){next_sommet++;}
	
	public class Couple {
		Sommet sommet;
		int couleur;
		
		public Couple(Sommet s, int i)
		{
			sommet = s;
			couleur = i;
		}
		
		Sommet getSommet() {return sommet;}
		int getCouleur() {return couleur;}
	}
	
	public Sommet()
	{
		contraintes = new ArrayList<ArrayList<Contrainte>>(3);
		for (int i = 0; i < 3; i++)
		{
			ArrayList<Contrainte> alc = new ArrayList<Contrainte>();
			contraintes.add(alc);
		}
		poidsMax = 0;
		numero = next_sommet;
		incrementer();
		couleur = -1;
	}
	
	public void ajouter_contrainte(int couleur, Contrainte c)
	{
		if (!contraintes.contains(c))
		{
			contraintes.get(couleur).add(c);
			poidsMax += c.getPoids();
		}
	}
	
	public void supprimer_contrainte(int couleur, Contrainte c)
	{
		contraintes.get(couleur).remove(c);
	}
	
	public int getPoids()
	{
		return poidsMax;
	}
	
	public int getPoidsMaximalPotentiel()
	{
		int poids = 0;
		for (int i = 0; i < 3; i++)
		{
			for (Contrainte c : contraintes.get(i))
			{
				poids += c.getPoids();
			}
		}
		poidsMax = poids;
		return poids;
	}
	
	public int getMeilleurCouleur()
	{
		int poids_listes[] = new int[3], poids_couleur[] = new int[3];
		int result = 0;
		for (int i = 0; i < 3; i++)
		{
			for(Contrainte c : contraintes.get(i))
			{
				poids_listes[i] += c.getPoids();
			}
		}
		poids_couleur[0] = poids_listes[1] + poids_listes[2];
		poids_couleur[1] = poids_listes[0] + poids_listes[2];
		poids_couleur[2] = poids_listes[0] + poids_listes[1];
		if (poids_couleur[0] > poids_couleur[1])
		{
			if (poids_couleur[0] > poids_couleur[2])
			{
				result = 0;
			}
			else
			{
				result = 1;
			}
		}
		return result;
	}
	
	public int setCouleur(int c)
	{
		int poids = 0;
		for (int i = 0; i < 3; i++)
		{
			if (i != c)
			{
				for (Contrainte cont : contraintes.get(i))
				{
					poids += cont.getPoids();
					cont.supprimer_contrainte();
				}
			}
		}
		couleur = c;
		return poids;
	}
}
