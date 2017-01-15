import java.util.ArrayList;

public class Motifs_Interdits {
	public ArrayList<Sommet> liste_ponderee;
	
	public void trier_sommets(ArrayList<Sommet> sommets)
	{
		liste_ponderee = new ArrayList<Sommet>(sommets.size());
		int i = 0,  n =0;
		for (Sommet s : sommets)
		{
			int poids = s.getPoids();
			i = 0;
			while (i < n && liste_ponderee.get(i).getPoids() > poids)
			{
				i++;
			}
			liste_ponderee.add(i,s);
			n++;
		}
	}
	
	public boolean maxW_SSS(ArrayList<Sommet> sommets)
	{
		trier_sommets(sommets);
		int n = sommets.size();
		int poidsMax = 0;
		for (int i = 0; i < n; i++)
		{
			Sommet s = liste_ponderee.get(i);
			int meilleurcouleur = s.getMeilleurCouleur();
			poidsMax += s.setCouleur(meilleurcouleur);
		}
		return false;
	}
	
	public static void main(String[] args) 
	{
		/* Pour remplir les donn�es :
		 * 1- Initialiser les N sommets n�cessaire
		 * 2- pour chaque contrainte:
		 * 		Cr�er tous les couples � partir des sommets instanci�s et de la couleur correspondante.
		 * 		Cr�er la contrainte � partir de la liste de couples pr�c�dement cr�e et d'un poids.
		 * 		A la cr�ation de la contrainte, elle va automatiquementse li� � chaque sommet.
		 * 3- Donner la liste de sommets � l'algorithme.
		 */
	}

}
