/* Classe PanelAccueil permettant de choisir entre les différents modes de jeu
 *@author  Louis Marouard, Maxime Galmant, Evan Cnaepelnickx, Arthur Lecomte
*/

package vue;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controleur.Controleur;

public class PanelAccueil extends JPanel implements ActionListener
{
	private Controleur  ctrl;
	private JPanel 		panelAccueil;
	private JButton 	btnSolo;
	private JButton 	btnMulti;
	private JButton 	btnTest;

	public PanelAccueil(Controleur ctrl) 
	{	
		/*-------------------------*/
		/* Création des composants */
		/*-------------------------*/

		this.ctrl = ctrl;
		panelAccueil = new JPanel();

		panelAccueil.setLayout(new GridLayout(3,1));
		
		/*-------------------------------*/
		/* positionnement des composants */
		/*-------------------------------*/

		this.btnSolo  = new JButton("Solo"		 );
		this.btnMulti = new JButton("Multijoueur");
		this.btnTest  = new JButton("Scenario"	 );

		panelAccueil.add(this.btnSolo);
		panelAccueil.add(this.btnMulti);
		panelAccueil.add(this.btnTest);
		this.add(panelAccueil);

		/*-------------------------------*/
		/* Finalisation                  */
		/*-------------------------------*/
		this.btnSolo .addActionListener(this);
		this.btnMulti.addActionListener(this);
		this.btnTest .addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == this.btnSolo ) {this.ctrl.Solo () ;this.ctrl.getPioche().melanger();}
		if (e.getSource() == this.btnMulti) {this.ctrl.Multi() ;}
		if (e.getSource() == this.btnTest ) {this.ctrl.Test () ;}
	}
}