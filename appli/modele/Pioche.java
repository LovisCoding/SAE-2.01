/*Classe Pioche qui permet de créer la pioche
 *@author Louis Marouard, Maxime Galmant, Evan Cnaepelnickx, Arthur Lecomte
*/

package modele;
import javax.swing.*;
import java.util.*;

import controleur.Controleur;

public class Pioche
{
	private final static ArrayList<ImageIcon> lstImagePFinal = new ArrayList<>(Arrays.asList(
			new ImageIcon("./images/cartes/carte_jaune_p.png"),
			new ImageIcon("./images/cartes/carte_joker_p.png"),
			new ImageIcon("./images/cartes/carte_marron_p.png"),
			new ImageIcon("./images/cartes/carte_rose_p.png"),
			new ImageIcon("./images/cartes/carte_verte_p.png")));

	private final static ArrayList<ImageIcon> lstImageSFinal = new ArrayList<>(Arrays.asList(
			new ImageIcon("./images/cartes/carte_jaune_s.png"),
			new ImageIcon("./images/cartes/carte_joker_s.png"),
			new ImageIcon("./images/cartes/carte_marron_s.png"),
			new ImageIcon("./images/cartes/carte_rose_s.png"),
			new ImageIcon("./images/cartes/carte_verte_s.png")));

	private static ArrayList<ImageIcon> lstImageP = new ArrayList<>(lstImagePFinal);
	private static ArrayList<ImageIcon> lstImageS = new ArrayList<>(lstImageSFinal);
	private static boolean scenario = true;
	private static int index;
	private Controleur ctrl;

	public Pioche(Controleur ctrl) { this.ctrl = ctrl; }

	public ImageIcon piocher() 
	{
		this.ctrl.getJoueur().setAJoue(false);

		if (lstImageP.isEmpty())
		{
			System.out.println("Pioche vide");
			return null;
		}
		
		else
		{
			ImageIcon img = null;
			if (!scenario)
				index = (int) (Math.random() * (lstImageP.size() + lstImageS.size()));
				System.out.println("Index = " + index);

			if (index < lstImageP.size())
			{
				img = lstImageP.get(index);
				lstImageP.remove(index);
			}
			
			else
			{
				index = index - lstImageP.size();
				img = lstImageS.get(index);
				lstImageS.remove(index);
			}

			System.out.println("Image : " + img);
			return img;
		}
	}

	public int taillePioche() { return lstImageP.size(); }

	public boolean estVide() { return lstImageP.isEmpty(); }

	public void reset()
	{
		lstImageP = new ArrayList<>(lstImagePFinal);
		lstImageS = new ArrayList<>(lstImageSFinal);

		if (!scenario) { melanger(); }
	}

	public void melanger()
	{
		Collections.shuffle(lstImageP);
		Collections.shuffle(lstImageS);
		index = (int) (Math.random() * (lstImageP.size() + lstImageS.size()));
		scenario = false;
		index = -1;
	}

	public void setIndex(int i) { index = i; }
}