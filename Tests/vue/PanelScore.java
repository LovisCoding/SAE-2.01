package vue;

import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import controleur.Controleur;

public class PanelScore extends JPanel
{
	private Controleur ctrl;
	private JPanel pnlScore;

	private JTextField txtNbRegion1;
	private JTextField txtNbMax1;
	private JTextField txtSommeReg;
	private JTextField txtBonus1;
	
	private JTextField txtScore1;
	private JTextField txtScoreFinal;

	private JLabel lblScore;




	public PanelScore(Controleur ctrl) 
	{
		/*-------------------------*/
		/* Création des composants */
		/*-------------------------*/

		this.ctrl = ctrl;
		pnlScore = new JPanel();
		JPanel pnlCentre = new JPanel();



		this.txtNbRegion1 = new  JTextField("",5);
		this.txtNbMax1 = new  JTextField("",5);
		this.txtSommeReg = new  JTextField("",5);
		this.txtBonus1 = new  JTextField("",5);
		this.txtScore1 = new  JTextField("",5);
		this.txtScoreFinal = new JTextField("",SwingConstants.CENTER);

		this.lblScore = new JLabel("Score",SwingConstants.CENTER);

		Border lineborder = BorderFactory.createLineBorder(Color.black, 1);

		this.txtNbRegion1.setBorder(lineborder);
		this.txtNbMax1.setBorder(lineborder);
		this.txtSommeReg.setBorder(lineborder);
		this.txtBonus1.setBorder(lineborder);
		this.txtScore1.setBorder(lineborder);
		this.txtScoreFinal.setBorder(lineborder);

		



		pnlScore.setLayout(new BorderLayout());
		pnlCentre.setLayout(new GridLayout(9,2,8,8));
		
		/*-------------------------------*/
		/* positionnement des composants */
		/*-------------------------------*/
		
		//Ajout au panel Centre
		pnlCentre.add(new JLabel("nb Region"));
		pnlCentre.add(this.txtNbRegion1);
		pnlCentre.add(new JLabel("nbRegion max"));
		pnlCentre.add(this.txtNbMax1);
		pnlCentre.add(new JLabel("="));
		pnlCentre.add(this.txtSommeReg);
		pnlCentre.add(new JLabel("bonus"));
		pnlCentre.add(this.txtBonus1);
		pnlCentre.add(new JLabel("score ligne"));
		pnlCentre.add(this.txtScore1);
		pnlCentre.add(new JLabel("score final"));
		pnlCentre.add(this.txtScoreFinal);

		this.lblScore.setFont(new Font("Arial",Font.BOLD,18));
		pnlScore.add(lblScore,BorderLayout.NORTH);
		pnlScore.add(new JPanel(),BorderLayout.CENTER);
		pnlScore.add(pnlCentre,BorderLayout.SOUTH);
		
		
		this.add (pnlScore);
		;

		/*-------------------------------*/
		/* Finalisation                  */
		/*-------------------------------*/
	}
}