import java.util.Random;
import java.util.Scanner;


public class Game extends Mouvement{

	// Chiffre aléatoire
	private static Random rand = new Random();
	
	private static int abs(int x)
	{
		return (x < 0) ? -x : x;
	}
	//Détermine un nombre aléatoire pour la place d'un nombre dans le tableau
	private static int nextInt()
	{
		return abs(rand.nextInt())%4;
	}
	//Détermine la valeur aléatoire 2 ou 4
	private static int nextValue()
	{
		return ((rand.nextBoolean()) ? 2 : 4);
		//return 2;
	}
	//Attribut la valeur aléatoire dans une case du tableau
	public static void GenereCase(int Tab[][], int q, int r, int Test, int Egalite)
	{
		/*Teste si le tableau est plein
		 * Si non (donc Test = 0) il génère un chiffre dans le tableau
		 */
		Test = 1;
		for (int i=0;i<4; i++)
		   {
		       for (int j=0;j<4;j++)
		       {
		           if (Tab[i][j] == 0)
		           {
		               Test = 0;
		           }
		       }
		   }
		
		if (Test == 0)
		{
			// Génération du chiffre
			do
			{
				q = nextInt();
				r = nextInt();
			}	
			while (Tab[q][r] != 0);
			{
				Tab[q][r] = nextValue();
			}
		}
		
		
	}
	
	//Méthode pour l'affichage de la grille
	public static void AfficheTab(int Tab[][])
	{
		System.out.println(" ");
		for (int i=0;i<4; i++)
		   {
			System.out.print("\n ________________\n");
			System.out.print("|");
		       for (int j=0;j<4;j++)
		       {
		           if (Tab[i][j]==0)
		           {
		               System.out.print(" . |");
		           }
		           else
		           {
		        	   System.out.print(" "+Tab[i][j]+" |");
		           }
		       }
		   }
		System.out.println("\n ----------------\n");
	}
	
	
	
	public static void main (String[] args)
	{
		//Déclaration des Variables
		int[][] Tab = new int[4][4];
		int q = 0;
		int r = 0;
		int Compteur = 0;
		int Test = 0;
		int Egalite = 0;
		String Haut;
		String Bas;
		String Droite;
		String Gauche;
		String touche;
		
		//Affiche la présentation de début
		System.out.println("Choisissez les touches pour les mouvements.\nAttention, les touches doivent être différentes.\nSi une erreur est présente, les valeurs par défaut seront appliquées\nTapez \"Entrer\" pour avoir directement les valeurs par défaut\n");
		
		//Entre la touche correspondant pour le mouvement HAUT
		Scanner haut = new Scanner(System.in);
		System.out.println("Saisir Haut");
		String sth = haut.nextLine();
		Haut = sth;
		
		/*Test si Haut est vide
		 * Si oui il donne les valeurs par défaut
		 * Si non il remplit les autres mouvements */
		if (!Haut.equals(""))
		{
			//Entre la touche correspondant pour le mouvement BAS
			Scanner bas = new Scanner(System.in);
			System.out.println("Saisir Bas");
			String stb = bas.nextLine();
			Bas = stb;
		
			//Entre la touche correspondant pour le mouvement DROITE
			Scanner droite = new Scanner(System.in);
			System.out.println("Saisir Droite");
			String std = droite.nextLine();
			Droite = std;
			
			//Entre la touche correspondant pour le mouvement GAUCHE
			Scanner gauche = new Scanner(System.in);
			System.out.println("Saisir Gauche");
			String stg = gauche.nextLine();
			Gauche = stg;
			
			/* Test si l'une des valeurs est vide
			 * Si oui, il donne les valeurs par défaut
			 */
			if (Bas.equals("")||Droite.equals("")||Gauche.equals(""))
			{
				//Donne les valeurs par défaut
				System.out.println("Les valeurs par défaut ont été choisies.");
				Haut = "r";
				Bas = "c";
				Droite = "g";
				Gauche = "d";
			}
			
			/* Test si 2 valeurs sont égales
			 * Si oui, il donne les valeurs par défaut
			 */
			if (Haut.equals(Bas)||Haut.equals(Droite)||Haut.equals(Gauche)||Bas.equals(Droite)||Bas.equals(Gauche)||Droite.equals(Gauche))
			{
				//Donne les valeurs par défaut
				System.out.println("Les valeurs par défaut ont été choisies.");
				Haut = "r";
				Bas = "c";
				Droite = "g";
				Gauche = "d";
			}
		}
		else
		{
			// Donne les valeurs par défaut si Haut est vide	
			System.out.println("Les valeurs par défaut ont été choisies.");
				Haut = "r";
				Bas = "c";
				Droite = "g";
				Gauche = "d";
		}
	
		//Génération de la 1ère case
		GenereCase(Tab, q, r, Test, Egalite);
		//Génération de la 2ème case
		GenereCase(Tab, q, r, Test, Egalite);
		//Affichage de la 1ère grille
		AfficheTab(Tab);
		
		/* Boucle permettant la succession des étapes du jeu
		 * Condition de sortie si aucun mouvement n'est possible dans le tableau 
		 * donc si Egalite = 1*/
		do
		{
			if (Egalite == 0)
			{
				System.out.println("Haut = " + Haut + ", Bas = " + Bas + ", Droite = " + Droite + ", Gauche =" + Gauche);

			}
			Scanner Touche = new Scanner(System.in);
			String str = Touche.nextLine();
			touche = str;
			
			/*Si la touche correspond au mouvement Haut
			 * génère toutes les opérations correspondant au mouvement Haut*/
			if (touche.equals(Haut))
			{
				FusionHaut(Tab);
				GenereCase(Tab, q, Compteur, Test, Egalite);
				AfficheTab(Tab);
			}
			
			/*Si la touche correspond au mouvement Bas
			 * génère toutes les opérations correspondant au mouvement Bas*/
			if (touche.equals(Bas))
			{
				FusionBas(Tab);
				GenereCase(Tab, q, Compteur, Test, Egalite);
				AfficheTab(Tab);
			}
			/*Si la touche correspond au mouvement Gauche
			 * génère toutes les opérations correspondant au mouvement Gauche*/
			if (touche.equals(Gauche))
			{
				FusionGauche(Tab);
				GenereCase(Tab, q, Compteur, Test, Egalite);
				AfficheTab(Tab);
			}
			/*Si la touche correspond au mouvement Droite
			 * génère toutes les opérations correspondant au mouvement Droite*/
			if (touche.equals(Droite))
			{
				FusionDroite(Tab);
				GenereCase(Tab, q, Compteur, Test, Egalite);
				AfficheTab(Tab);
			}
			
			/* Compteur: établit la tuile la plus grande après chaque tour
			 * Définit la tuile la plus grande du tableau
			 * afin de dire que le joueur a gagné quand compteur = 2048*/
			
			for (int i=0;i<4; i++)
			   {
			       for (int j=0;j<4;j++)
			       {
			           if (Compteur < Tab[i][j])
			           {
			               Compteur = Tab[i][j];
			           }
			       }
			   }
			/*Affichage Gagné
			 * Si le compteur atteind 2048
			 * ":-) BRAVO!!!!! VOUS AVEZ GAGNÉ!!! :-)" s'affiche
			 */
			if (Compteur >= 2048)
			{
				System.out.println(":-) BRAVO!!!!! VOUS AVEZ GAGNÉ!!! :-)");
				System.out.println("Mais vous pouvez continuer\n");				
			}
			
			/*Test indiquant si le tableau est plein
			 Si Test = 1 le tableau est plein*/
				Test = 1;
				for (int i=0;i<4; i++)
				   {
				       for (int j=0;j<4;j++)
				       {
				           if (Tab[i][j] == 0)
				           {
				               Test = 0;
				           }
				       }
				   }
				
			/*Test s'il reste des mouvement possible que si le tableau est plein
			 * Si Egalite = 1, aucun déplacement n'est possible*/
				if (Test == 1)
				{
					Egalite = 1;
					for (int i=0;i<3; i++)
					   {
					       for (int j=0;j<3;j++)
					       {
					           if (Tab[i][j]==Tab[i][j+1])
					           {
					               Egalite = 0;
					           }
					           if (Tab[i][j]==Tab[i+1][j])
					           {
					               Egalite = 0;
					           }
					       }
					   }
				}
				/*Si Egalite = 0, il continue et génère un chiffre
				 * Si Egalite = 1, Sortie de la Boucle While*/
			
		}
		while (Egalite == 0);
		
		/* Affichage Perdu
		 * Si le tableau est plein et que aucun mouvement n'est perdu
		 * donc quand Egalite = 1
		 * il affiche ":-( Vous avez perdu!!! :-("
		 */
		if (Egalite == 1)
		{
			System.out.println(":-( Vous avez perdu!!! :-(");
		}
		
		
	}
	
	
}
