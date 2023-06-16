package vue;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.Icon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import controleur.Controleur;
import java.awt.event.ActionEvent;
import modele.Score;

public class PanelScore extends JPanel implements ActionListener
{
	private Controleur 	ctrl;
	private JPanel 		panelScore;

	private Score		score;
	private boolean 	affiche = true;

	private JTextField 	txtNbRegion1;
	private JTextField 	txtNbMax1;
	private JTextField 	txtSommeReg;
	private JTextField 	txtBonus1;
	private JTextField 	txtScore1;
	private JTextField 	txtScoreFinal;

	private JLabel 		lblScore;
	private JButton 	btnTour;
	private JButton 	btnFinPartie;

	public PanelScore(Controleur ctrl) 
	{
		/*-------------------------*/
		/* Création des composants */
		/*-------------------------*/

		this.ctrl = ctrl;
		score     = this.ctrl.getScore();
		panelScore  = new JPanel();

		JPanel panelCentre = new JPanel();
		Icon iconNext 	 = new ImageIcon("./images/next.png");
		Icon iconFin 	 = new ImageIcon("./images/arrivee.png");

		this.txtNbRegion1 	= new  JTextField("",3);
		this.txtNbMax1 		= new  JTextField("",3);
		this.txtSommeReg 	= new  JTextField("",3);
		this.txtBonus1 		= new  JTextField("",3);
		this.txtScore1 		= new  JTextField("",3);
		this.txtScoreFinal 	= new  JTextField("",SwingConstants.CENTER);
		
		this.lblScore 		= new  JLabel("Score",SwingConstants.CENTER);
		this.btnTour 		= new  JButton(iconNext);
		this.btnFinPartie	= new JButton(iconFin);

		Border lineborder = BorderFactory.createLineBorder(Color.black, 1);

		//bordure noire
		this.txtNbRegion1	.setBorder(lineborder);
		this.txtNbMax1		.setBorder(lineborder);
		this.txtSommeReg	.setBorder(lineborder);
		this.txtBonus1		.setBorder(lineborder);
		this.txtScore1		.setBorder(lineborder);
		this.txtScoreFinal	.setBorder(lineborder);

		//Non editable
		this.txtNbRegion1	.setEditable(false);
		this.txtNbMax1		.setEditable(false);
		this.txtSommeReg	.setEditable(false);
		this.txtBonus1		.setEditable(false);
		this.txtScore1		.setEditable(false);
		this.txtScoreFinal	.setEditable( false); 
		
		//Centre les txt
		this.txtNbRegion1	.setHorizontalAlignment ( SwingConstants.CENTER); 
		this.txtNbMax1		.setHorizontalAlignment ( SwingConstants.CENTER); 
		this.txtSommeReg	.setHorizontalAlignment ( SwingConstants.CENTER); 
		this.txtBonus1		.setHorizontalAlignment ( SwingConstants.CENTER); 
		this.txtScore1		.setHorizontalAlignment ( SwingConstants.CENTER); 
		this.txtScoreFinal	.setHorizontalAlignment ( SwingConstants.CENTER); 
		
		this.lblScore.setFont(new Font("Arial",Font.BOLD,18));

		this.btnTour.setVisible(false); 	//affichage des que pile vide
		this.btnFinPartie.setVisible(false); 	//affichage des que pile vide

		panelScore.setLayout(new BorderLayout());
		panelCentre.setLayout(new GridLayout(9,2,8,8));
		this.setLayout(new BorderLayout());
		
		/*-------------------------------*/
		/* positionnement des composants */
		/*-------------------------------*/
		
		//Ajout au panel Centre
		panelCentre.add(new JLabel("nb Region")	);
		panelCentre.add(this.txtNbRegion1			);
		panelCentre.add(new JLabel("x",SwingConstants.CENTER)			);
		panelCentre.add(new JLabel(" ")			);
		panelCentre.add(new JLabel("nbRegion max"));
		panelCentre.add(this.txtNbMax1			);
		panelCentre.add(new JLabel("=")			);
		panelCentre.add(this.txtSommeReg			);
		panelCentre.add(new JLabel("bonus")		);
		panelCentre.add(this.txtBonus1			);
		panelCentre.add(new JLabel("score ligne")	);
		panelCentre.add(this.txtScore1			);
		panelCentre.add(new JLabel("score final")	);
		panelCentre.add(this.txtScoreFinal		);
		
		
		panelScore.add(lblScore,	  BorderLayout.CENTER);// Ajoute un espace entre le le label et le panel
		panelScore.add(panelCentre,	  BorderLayout.SOUTH );
		
		this.add(panelScore,BorderLayout.NORTH );
		this.add(this.btnTour,BorderLayout.CENTER );
		this.add(btnFinPartie,BorderLayout.SOUTH);

		this.btnFinPartie.addActionListener(this);
		this.btnTour	 .addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) 
	{ 
		if (e.getSource()==this.btnTour) {prochainTour();} 
		if (e.getSource()==this.btnFinPartie)
		{
			JOptionPane.showMessageDialog(null, "Fin de la partie, votre score est de : " + this.ctrl.getScore().getScoreFinal() + " points");
			this.ctrl.getFrameAccueil().getFrameSolo().dispose(); 
		}

}
	public void affichageBoutonTour()
	{
		if (affiche)
		{
			affiche = false;
			this.btnTour.setVisible(true);
		}
		else
		{
			this.btnFinPartie.setVisible(true);
			this.ctrl.getFrameAccueil().getFrameSolo().getpanelIles().setfinPartie(true);
		}
		
	}

	public void prochainTour()
	{
		this.btnTour.setVisible(false);
		score.prochainTour();
		
		//réactualisation du panel
		this.ctrl.getFrameAccueil().getFrameSolo().getpanelDroit().getPanelPioche().nextRound();
	}
	
	public void maj(String nbRegion, String nbRegionMax, String multRegion,String bonus, String scoreLigne, String scoreFinal)
	{
		this.txtNbRegion1 .setText(nbRegion		);
		this.txtNbMax1	  .setText(nbRegionMax	);
		this.txtSommeReg  .setText(multRegion	);
		this.txtBonus1	  .setText(bonus		);
		this.txtScore1	  .setText(scoreLigne	);
		this.txtScoreFinal.setText(scoreFinal	);
	}
}