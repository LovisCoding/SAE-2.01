package vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

import controleur.Controleur;

public class PanelDroit extends JPanel
{
	private Controleur ctrl;
	private PanelPioche panelPioche;
	private PanelPioche panelPioche2;

	private PanelScore  panelScore;
	private static int 	nbTour;

	public PanelDroit(Controleur ctrl) 
	{
		/*-------------------------*/
		/* Création des composants */
		/*-------------------------*/

		this.ctrl 	= ctrl;
		panelPioche 	= new PanelPioche(this.ctrl);
		panelScore 	= new PanelScore (this.ctrl);
		panelPioche2 	= new PanelPioche(this.ctrl);

		this.setLayout(new BorderLayout());
		
		/*-------------------------------*/
		/* positionnement des composants */
		/*-------------------------------*/

		this.add (panelPioche,BorderLayout.NORTH);
		this.add (panelScore,BorderLayout.CENTER);

		/*-------------------------------*/
		/* Finalisation                  */
		/*-------------------------------*/

		panelPioche2.setVisible(false);
	}

	public PanelPioche getPanelPioche() { return panelPioche; }
	public PanelScore  getPanelScore () { return panelScore; }		
}