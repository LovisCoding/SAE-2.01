package vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

import controleur.Controleur;

public class PanelDroit extends JPanel
{
	private Controleur ctrl;
	private PanelPioche pnlPioche;
	private PanelScore  pnlScore;

	public PanelDroit(Controleur ctrl) 
	{
		/*-------------------------*/
		/* Création des composants */
		/*-------------------------*/

		this.ctrl = ctrl;
		this.pnlPioche = new PanelPioche(this.ctrl);
		this.pnlScore = new PanelScore(this.ctrl);

		this.setLayout(new BorderLayout());
		
		/*-------------------------------*/
		/* positionnement des composants */
		/*-------------------------------*/
		this.add (pnlPioche,BorderLayout.NORTH);
		this.add (pnlScore,BorderLayout.CENTER);

		/*-------------------------------*/
		/* Finalisation                  */
		/*-------------------------------*/
	}

	public String getTypeCouleur()
	{
		return this.pnlPioche.getTypeCouleur();
	}
}