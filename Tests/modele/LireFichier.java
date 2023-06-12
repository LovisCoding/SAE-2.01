/*Classe Fichier permettant de récupérer les données du fichier .txt 
 *Auteurs : Louis Marouard, Maxime Galmant, Evan Cnaepelnickx, Arthur Lecomte
*/
package modele;

import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;

import java.io.File;

public class LireFichier 
{
	private String 			nomFichier;
	private ArrayList<Ile> 	iles;
	private GroupIles 		groupIles;

	public LireFichier(String nomFichier)
	{
		this.nomFichier = nomFichier;
		this.iles 		= new ArrayList<Ile>();
		this.groupIles 	= new GroupIles();
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
				int cpt 		= 0;
			while (sc.hasNextLine())
			{

				cpt++;
				String line = sc.nextLine();
				

				if (line.equals("		Centre			Position image	"	    ))    	{line = sc.nextLine();}
				if (line.equals("		x	y		x	y"	    ))    	{line = sc.nextLine();}
				if (line.equals("						"	    ))    	
				{
					line = sc.nextLine();
					this.groupIles.ajouterGroupe(this.iles);
					this.iles = new ArrayList<Ile>();
				}
				
				String[] parts = line.split("\t");
				System.out.println(parts[0]	+ " 1: " + parts[1] + " 2: " + parts[2] + " 3: " + parts[3] + " 4: " + parts[5] + "5:" + parts[6]);
				nom 	  	= parts[0];
				couleur	   	= parts[1];
				coCentreX	= Integer.parseInt(parts[2]);
				coCentreY 	= Integer.parseInt(parts[3]);
				posImageX	= Integer.parseInt(parts[5]);		//On saute le 4 car il s'agit d'une tabulation
				posImageY	= Integer.parseInt(parts[6]);

				this.iles.add(new Ile(nom, couleur, coCentreX, coCentreY, posImageX, posImageY));
				
				

				}
			
				
			
			sc.close();
			for ( Ile i : this.iles)
			{
				System.out.println(i.toString());
			}
		}

		/*-----------------------------------------------------------------------------------------------------------------------*/
		/* Gestion des erreurs grâce à un Try/Catch permettant d'envoyer un message d'erreur si le fichier .txt n'est pas trouvé */
		/*-----------------------------------------------------------------------------------------------------------------------*/

		catch (FileNotFoundException e) {System.out.println("Fichier non trouvé");}
	}
	
	public List<Ile> getLstIles () 		{return this.iles;}
	public GroupIles getGroupIles () 	{return this.groupIles;}
}