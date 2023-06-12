package vue;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controleur.Controleur;

public class PanelAccueil extends JPanel implements ActionListener
{
	private Controleur    ctrl;
	private JPanel pnlAccueil;
	private JButton btnSolo;
	private JButton btnMulti;

	public PanelAccueil(Controleur ctrl) 
	{

	
		/*-------------------------*/
		/* Création des composants */
		/*-------------------------*/

		this.ctrl = ctrl;
		this.pnlAccueil = new JPanel();

		this.setLayout(new GridLayout(2,1));
		


		/*-------------------------------*/
		/* positionnement des composants */
		/*-------------------------------*/
		this.btnSolo  = new JButton("Solo");
		this.btnMulti = new JButton("Multijoueur");

		this.pnlAccueil.add(this.btnSolo);
		this.pnlAccueil.add(this.btnMulti);
		this.add(pnlAccueil);

		/*-------------------------------*/
		/* Finalisation                  */
		/*-------------------------------*/
		this.btnSolo.addActionListener(this);
		this.btnMulti.addActionListener(this);


	
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == this.btnSolo)
		{
			this.ctrl.Solo();
		}
		if (e.getSource() == this.btnMulti)
		{
			this.ctrl.Multi();
		}
	}
}
