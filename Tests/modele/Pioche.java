package modele;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import java.util.*;

import controleur.Controleur;

public class Pioche 
{
	private  static ArrayList<ImageIcon> lstImagePFinal = new ArrayList<>(Arrays.asList
	(
		new ImageIcon("./images/cartes/carte_jaune_p.png"	),
		new ImageIcon("./images/cartes/carte_joker_p.png"	),
		new ImageIcon("./images/cartes/carte_marron_p.png"	),
		new ImageIcon("./images/cartes/carte_rose_p.png"	),
		new ImageIcon("./images/cartes/carte_verte_p.png"	) ) );

	private  static ArrayList<ImageIcon> lstImageSFinal = new ArrayList<>(Arrays.asList
	(
		new ImageIcon("./images/cartes/carte_jaune_s.png"	),
		new ImageIcon("./images/cartes/carte_joker_s.png"	),
		new ImageIcon("./images/cartes/carte_marron_s.png"	),
		new ImageIcon("./images/cartes/carte_rose_s.png"	),
		new ImageIcon("./images/cartes/carte_verte_s.png"	) ) );

	private static ArrayList<ImageIcon> lstImageP = new ArrayList<>(lstImagePFinal);;
	private static ArrayList<ImageIcon> lstImageS = new ArrayList<>(lstImageSFinal);
	private Controleur ctrl;

	public Pioche(Controleur ctrl) 
	{
		this.ctrl = ctrl;
		
	}

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
			int rdm = (int)(Math.random()*(lstImageP.size()+lstImageS.size()));
			System.out.println("Random =" + rdm);

			if (rdm <lstImageP.size())
			{
				img = lstImageP.get(rdm);
				lstImageP.remove(rdm);
			}

			else if (rdm == lstImageP.size())
			{
				img = lstImageS.get(0);
				lstImageS.remove(0);
			}

			else
			{
				rdm = rdm -lstImageP.size();
				img = lstImageS.get(rdm);
				lstImageS.remove(rdm);
			}

			System.out.println("image :" + img);
			return img;
		}
	}

	public int taillePioche() { return lstImageP.size(); }
	
	public boolean estVide() { return lstImageP.isEmpty(); }

	public void reset()
	{
		System.out.println("dans reset");
		lstImageP.clear();
		lstImageP.addAll(lstImagePFinal);

		Collections.shuffle(lstImageP);
		lstImageS = new ArrayList<>(lstImageSFinal);
		Collections.shuffle(lstImageS);
	}
	public void melanger ()
	{
		Collections.shuffle(lstImageP);
		Collections.shuffle(lstImageS);
	}
}