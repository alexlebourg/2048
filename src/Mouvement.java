
public class Mouvement {
	//Méthode déplacement à droite
		public static void Droite(int Tab[][])
		{
			for (int i=0; i<Tab.length; i++)
			{
				for (int j=Tab.length-2; j>=0;j--)
				{
					if (Tab[i][3] == 0)
					{
						Tab[i][3] = Tab[i][2];
						Tab[i][2]=0;
						
						if (Tab[i][3] == 0 && Tab[i][2] == 0)
						{
							Tab[i][3] = Tab[i][1];
							Tab[i][1]=0;
						}
						if (Tab[i][3] == 0 && Tab[i][2] == 0 && Tab[i][1] == 0)
						{
							Tab[i][3] = Tab[i][0];
							Tab[i][0]=0;
						}
					}
					if (Tab[i][2] == 0)
					{
						Tab[i][2] = Tab[i][1];
						Tab[i][1]=0;
						
						if (Tab[i][2] == 0 && Tab[i][1] == 0)
						{
							Tab[i][2] = Tab[i][0];
							Tab[i][0]=0;
						}
					}
					if (Tab[i][1] == 0)
					{
						Tab[i][1] = Tab[i][0];
						Tab[i][0]=0;
					}
					
					
				}
				
			}
		}
		//Méthode déplacement à gauche
			public static void Gauche(int Tab[][])
			{
				for (int i=0; i<Tab.length; i++)
				{
					for (int j=1; j<Tab.length;j++)
					{
						if (Tab[i][0] == 0)
						{
							Tab[i][0] = Tab[i][1];
							Tab[i][1]=0;
							
							if (Tab[i][0] == 0 && Tab[i][1] == 0)
							{
								Tab[i][0] = Tab[i][2];
								Tab[i][2]=0;
							}
							if (Tab[i][0] == 0 && Tab[i][1] == 0 && Tab[i][2] == 0)
							{
								Tab[i][0] = Tab[i][3];
								Tab[i][3]=0;
							}
						}
						if (Tab[i][1] == 0)
						{
							Tab[i][1] = Tab[i][2];
							Tab[i][2]=0;
							
							if (Tab[i][1] == 0 && Tab[i][2] == 0)
							{
								Tab[i][1] = Tab[i][3];
								Tab[i][3]=0;
							}
						}
						if (Tab[i][2] == 0)
						{
							Tab[i][2] = Tab[i][3];
							Tab[i][3]=0;
						}
						
						
					}
					
				}
			}
		//Méthode déplacement en bas
			public static void Bas(int Tab[][])
			{
				for (int j=0; j<Tab.length; j++)
				{
					for (int i=Tab.length-2; i>=0;i--)
					{
						if (Tab[3][j] == 0)
						{
							Tab[3][j] = Tab[2][j];
							Tab[2][j]=0;
							
							if (Tab[3][j] == 0 && Tab[2][j] == 0)
							{
								Tab[3][j] = Tab[1][j];
								Tab[1][j]=0;
							}
							if (Tab[3][j] == 0 && Tab[2][j] == 0 && Tab[1][j] == 0)
							{
								Tab[3][j] = Tab[0][j];
								Tab[0][j]=0;
							}
						}
						if (Tab[2][j] == 0)
						{
							Tab[2][j] = Tab[1][j];
							Tab[1][j]=0;
							
							if (Tab[2][j] == 0 && Tab[1][j] == 0)
							{
								Tab[2][j] = Tab[0][j];
								Tab[0][j]=0;
							}
						}
						if (Tab[1][j] == 0)
						{
							Tab[1][j] = Tab[0][j];
							Tab[0][j]=0;
						}
						
						
					}
					
				}
			}
		//Méthode déplacement en haut
			public static void Haut(int Tab[][])
			{
				for (int j=0; j<Tab.length; j++)
				{
					for (int i=1; i<Tab.length;i++)
					{
						if (Tab[0][j] == 0)
						{
							Tab[0][j] = Tab[1][j];
							Tab[1][j]=0;
									
							if (Tab[0][j] == 0 && Tab[1][j] == 0)
							{
								Tab[0][j] = Tab[2][j];
								Tab[2][j]=0;
							}
							if (Tab[0][j] == 0 && Tab[1][j] == 0 && Tab[2][j] == 0)
							{
								Tab[0][j] = Tab[3][j];
								Tab[3][j]=0;
							}
						}
						if (Tab[1][j] == 0)
						{
							Tab[1][j] = Tab[2][j];
							Tab[2][j]=0;
									
							if (Tab[1][j] == 0 && Tab[2][j] == 0)
							{
								Tab[1][j] = Tab[3][j];
								Tab[3][j]=0;
							}
						}
						if (Tab[2][j] == 0)
						{
							Tab[2][j] = Tab[3][j];
							Tab[3][j]=0;
						}												
					}						
				}
			}

		//Méthode de fusion des chiffre pour un déplacement à droite
			public static void FusionDroite(int Tab[][])
			{
				Droite(Tab);
				for (int i=0; i<Tab.length; i++)
				{
						if (Tab[i][3] == Tab[i][2])
						{
							Tab[i][3] = Tab[i][3] + Tab[i][2];
							Tab[i][2]=0;
						}
						else
						{
							if (Tab[i][2] == Tab[i][1])
							{
								Tab[i][2] = Tab[i][2] + Tab[i][1];
								Tab[i][1]=0;
							}
							else
							if (Tab[i][1] == Tab[i][0])
							{
								Tab[i][1] = Tab[i][1] + Tab[i][0];
								Tab[i][0]=0;
							}
						}
						if (Tab[i][1] == Tab[i][0])
						{
							Tab[i][1] = Tab[i][1] + Tab[i][0];
							Tab[i][0]=0;
						}
				}
				Droite(Tab);
			}
		//Méthode de fusion des chiffre pour un déplacement à gauche
				public static void FusionGauche(int Tab[][])
				{
					Gauche(Tab);
					for (int i=0; i<Tab.length; i++)
					{
							if (Tab[i][0] == Tab[i][1])
							{
								Tab[i][0] = Tab[i][0] + Tab[i][1];
								Tab[i][1]=0;
							}
							else
							{
								if (Tab[i][1] == Tab[i][2])
								{
									Tab[i][1] = Tab[i][2] + Tab[i][2];
									Tab[i][2]=0;
								}
								else
								if (Tab[i][2] == Tab[i][3])
								{
									Tab[i][2] = Tab[i][2] + Tab[i][3];
									Tab[i][3]=0;
								}
							}
							if (Tab[i][2] == Tab[i][3])
							{
								Tab[i][2] = Tab[i][2] + Tab[i][3];
								Tab[i][3]=0;
							}
					}
					Gauche(Tab);
				}
		//Méthode de fusion des chiffre pour un déplacement en bas
		public static void FusionBas(int Tab[][])
		{
			Bas(Tab);
			for (int j=0; j<Tab.length; j++)
			{
					if (Tab[3][j] == Tab[2][j])
					{
						Tab[3][j] = Tab[3][j] + Tab[2][j];
						Tab[2][j]=0;
					}
					else
					{
						if (Tab[2][j] == Tab[1][j])
						{
							Tab[2][j] = Tab[2][j] + Tab[1][j];
							Tab[1][j]=0;
						}
						else
						if (Tab[1][j] == Tab[0][j])
						{
							Tab[1][j] = Tab[1][j] + Tab[0][j];
							Tab[0][j]=0;
						}
					}
					if (Tab[1][j] == Tab[0][j])
					{
						Tab[1][j] = Tab[1][j] + Tab[0][j];
						Tab[0][j]=0;
					}
			}
			Bas(Tab);
		}
		//Méthode de fusion des chiffre pour un déplacement en haut
		public static void FusionHaut(int Tab[][])
		{
			Haut(Tab);
			for (int j=0; j<Tab.length; j++)
			{
					if (Tab[0][j] == Tab[1][j])
					{
						Tab[0][j] = Tab[0][j] + Tab[1][j];
						Tab[1][j]=0;
					}
					else
					{
						if (Tab[1][j] == Tab[2][j])
						{
							Tab[1][j] = Tab[2][j] + Tab[2][j];
							Tab[2][j]=0;
						}
						else
						if (Tab[2][j] == Tab[3][j])
						{
							Tab[2][j] = Tab[2][j] + Tab[3][j];
							Tab[3][j]=0;
						}
					}
					if (Tab[2][j] == Tab[3][j])
					{
						Tab[2][j] = Tab[2][j] + Tab[3][j];
						Tab[3][j]=0;
					}
			}
			Haut(Tab);
		}
		
}
