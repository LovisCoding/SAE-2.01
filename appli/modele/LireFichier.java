/*Classe Fichier permettant de récupérer les données du fichier .txt 
 *Auteurs : Louis Marouard, Maxime Galmant, Evan Cnaepelnickx, Arthur Lecomte
*/
package modele;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;

import java.io.File;

import controleur.Controleur;

public class LireFichier 
{
	private String 			 nomFichier;
	private ArrayList<Ile> 	 lstIles;
	private ArrayList<Arete> lstAretes;
	private Controleur 		 ctrl;

	public LireFichier(String nomFichier, Controleur ctrl)
	{
		this.nomFichier = nomFichier;
		this.lstIles 	= new ArrayList<Ile>  ();
		this.lstAretes	= new ArrayList<Arete>();
		this.ctrl 		= ctrl;
	}

	public void lire()
	{
		/*---------------------*/
		/* Création du scanner */
		/*---------------------*/
		
		try 
		{
			Scanner sc  = new Scanner(new File(this.nomFichier), "UTF-8");
		
			/*------------------------------------------*/
			/* Récupération des données du fichier .txt */
			/*------------------------------------------*/

			String nom 	    = "";
			String couleur	= "";
			int coCentreX	= 0;
			int coCentreY 	= 0;
			int posImageX	= 0;
			int posImageY	= 0;
			int groupIle 	= 1; // va mettre un numero de Group d'iles à une ile
			int numArete	= 0;

			boolean lineArete = false;
			boolean lineBonus = false;

			while (sc.hasNextLine())
			{
				String line = sc.nextLine();

				if (line.equals("		Centre			Position image	"	))    	{line = sc.nextLine();}
				if (line.equals("		x	y		x	y"	   				))    	{line = sc.nextLine();}

				if (line.equals("\t\t\t\t\t\t"	   							))
				{
					line = sc.nextLine();
					groupIle++;
				}

				if (line.equals("[ARETE]"))
				{
					lineArete = true;
					line = sc.nextLine();
				}

				if (line.equals("[BONUS]"))
				{
					lineArete = false;
					lineBonus = true;
					line = sc.nextLine();
				}

				String[] parts = line.split("\t");

				if (!lineArete && !lineBonus)
				{
					// System.out.println(parts[0]	+ " 1: " + parts[1] + " 2: " + parts[2] + " 3: " + parts[3] + " 4: " + parts[5] + "5:" + parts[6]);
					nom 	  	= parts[0];
					couleur	   	= parts[1];
					coCentreX	= Integer.parseInt(parts[2]);
					coCentreY 	= Integer.parseInt(parts[3]);
					posImageX	= Integer.parseInt(parts[5]);		//On saute l'emplacement 4 car il s'agit d'une tabulation
					posImageY	= Integer.parseInt(parts[6]);

					this.ctrl.getGraphe().ajouterIles(new Ile(nom, couleur, coCentreX, coCentreY, posImageX, posImageY, groupIle));
				}

				else if (lineArete)
				{
					numArete++;
					Ile ile1 = null;
					Ile ile2 = null;

					for (Ile i : this.ctrl.getGraphe().getEnsIle())
					{
						if (parts[0].equals(i.getNom())) { ile1 = i; }
						if (parts[1].equals(i.getNom())) { ile2 = i; }
					}

					this.ctrl.getGraphe().ajouterArete(new Arete(numArete,ile1,ile2));
				}

				else
				{
					for (Arete a : this.ctrl.getGraphe().getEnsArete())
					{
						if (a.getIle1().getNom().equals(parts[0]) && a.getIle2().getNom().equals(parts[1])
							|| a.getIle1().getNom().equals(parts[1]) && a.getIle2().getNom().equals(parts[0]))
						{
							a.setCouleur(Color.GREEN);
						}
					}
				}
			}

			sc.close();

			// System.out.println("Nombre d'arete : " + ctrl.getGraphe().getEnsArete().size());
			// System.out.println("Nombre d'ile : " + ctrl.getGraphe().getEnsIle().size());
		
		}

		/*-----------------------------------------------------------------------------------------------------------------------*/
		/* Gestion des erreurs grâce à un Try/Catch permettant d'envoyer un message d'erreur si le fichier .txt n'est pas trouvé */
		/*-----------------------------------------------------------------------------------------------------------------------*/

		catch (FileNotFoundException e) {System.out.println("Fichier non trouvé");}
	}
	
	public List<Ile> 	getLstIles  () 		{return this.lstIles  ;}
	public List<Arete> 	getLstArete () 		{return this.lstAretes;}
}