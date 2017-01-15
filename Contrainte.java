import java.util.ArrayList;

public class Contrainte {
		private ArrayList<Sommet.Couple> couples;
		private int poids;
		private int numero_contrainte;
		private static int next_contrainte;
		
		public static void incrementer(){next_contrainte++;}
		
		public Contrainte(ArrayList<Sommet.Couple> c, int p)
		{
			couples = c;
			poids = p;
			numero_contrainte = next_contrainte;
			incrementer();
			
			for (Sommet.Couple couple : couples)
			{
				Sommet s = couple.getSommet();
				s.ajouter_contrainte(couple.getCouleur(), this);
			}
		}
		
		public void supprimer_contrainte()
		{
			for (Sommet.Couple c : couples)
			{
				Sommet s = c.getSommet();
				s.supprimer_contrainte(c.getCouleur(), this);
			}
		}

		public int getPoids() {
			return poids;
		}
}
