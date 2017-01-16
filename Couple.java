
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
		
		public String toString()
		{
			return ("(x"+sommet.getNumero()+","+couleur+")");
		}
	}
