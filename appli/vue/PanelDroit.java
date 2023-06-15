package vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

import controleur.Controleur;

public class PanelDroit extends JPanel
{
	private Controleur ctrl;
	private PanelPioche pnlPioche;
	private PanelPioche pnlPioche2;

	private PanelScore  pnlScore;
	private static int 	nbTour;

	public PanelDroit(Controleur ctrl) 
	{
		/*-------------------------*/
		/* Création des composants */
		/*-------------------------*/

		this.ctrl 	= ctrl;
		pnlPioche 	= new PanelPioche(this.ctrl);
		pnlScore 	= new PanelScore(this.ctrl);
		pnlPioche2 	= new PanelPioche(this.ctrl);

		this.setLayout(new BorderLayout());
		
		/*-------------------------------*/
		/* positionnement des composants */
		/*-------------------------------*/
		this.add (pnlPioche,BorderLayout.NORTH);
		this.add (pnlScore,BorderLayout.CENTER);

		/*-------------------------------*/
		/* Finalisation                  */
		/*-------------------------------*/
		pnlPioche2.setVisible(false);
	}

	public PanelPioche getPnlPioche()
	{
		return pnlPioche;
	}
	public PanelScore getPnlScore()
	{
		return pnlScore;
	}
		
}

