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
import javax.swing.ImageIcon;
import javax.swing.Icon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import controleur.Controleur;
import java.awt.event.ActionEvent;

public class PanelScore extends JPanel implements ActionListener
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
	private JButton btnTour;

	private static int nbRegion;
	private static int nbRegionMax;
	private static int bonus;
	private static int sommeRegion;
	private static int scoreLigne;
	private static int scoreFinal;
	private static boolean tour1 = true;

	public PanelScore(Controleur ctrl) 
	{
		/*-------------------------*/
		/* Création des composants */
		/*-------------------------*/

		this.ctrl = ctrl;
		pnlScore = new JPanel();
		JPanel pnlCentre = new JPanel();

		Icon iconNext = new ImageIcon("./images/next.png");

		this.txtNbRegion1 	= new  JTextField("",3);
		this.txtNbMax1 		= new  JTextField("",3);
		this.txtSommeReg 	= new  JTextField("",3);
		this.txtBonus1 		= new  JTextField("",3);
		this.txtScore1 		= new  JTextField("",3);
		this.txtScoreFinal 	= new JTextField("",SwingConstants.CENTER);

		this.lblScore = new JLabel("Score",SwingConstants.CENTER);

		this.btnTour = new JButton(iconNext);

		Border lineborder = BorderFactory.createLineBorder(Color.black, 1);

		//bordure noire
		this.txtNbRegion1.setBorder(lineborder);
		this.txtNbMax1.setBorder(lineborder);
		this.txtSommeReg.setBorder(lineborder);
		this.txtBonus1.setBorder(lineborder);
		this.txtScore1.setBorder(lineborder);
		this.txtScoreFinal.setBorder(lineborder);

		//Non editable
		this.txtNbRegion1.setEditable(false);
		this.txtNbMax1.setEditable(false);
		this.txtSommeReg.setEditable(false);
		this.txtBonus1.setEditable(false);
		this.txtScore1.setEditable(false);
		this.txtScoreFinal.setEditable( false); 
		
		//Centre les txt
		this.txtNbRegion1.setHorizontalAlignment ( SwingConstants.CENTER); 
		this.txtNbMax1.setHorizontalAlignment ( SwingConstants.CENTER); 
		this.txtSommeReg.setHorizontalAlignment ( SwingConstants.CENTER); 
		this.txtBonus1.setHorizontalAlignment ( SwingConstants.CENTER); 
		this.txtScore1.setHorizontalAlignment ( SwingConstants.CENTER); 
		this.txtScoreFinal.setHorizontalAlignment ( SwingConstants.CENTER); 
		
		this.lblScore.setFont(new Font("Arial",Font.BOLD,18));

		this.btnTour.setVisible(false); 	//affichage des que pile vide



		pnlScore.setLayout(new BorderLayout());
		pnlCentre.setLayout(new GridLayout(9,2,8,8));
		
		/*-------------------------------*/
		/* positionnement des composants */
		/*-------------------------------*/
		
		//Ajout au panel Centre
		pnlCentre.add(new JLabel("nb Region"));
		pnlCentre.add(this.txtNbRegion1);
		pnlCentre.add(new JLabel("x"));
		pnlCentre.add(new JLabel(" "));
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
		

		
		pnlScore.add(this.btnTour,BorderLayout.NORTH);
		pnlScore.add(lblScore,BorderLayout.CENTER);// Ajoute un espace entre le le label et le panel
		pnlScore.add(pnlCentre,BorderLayout.SOUTH);
		
		this.add(pnlScore);


		this.txtNbMax1   .addActionListener(this);
		this.txtNbRegion1.addActionListener(this);
		this.txtBonus1   .addActionListener(this);

		this.btnTour.addActionListener(this);

	}
	public void actionPerformed(ActionEvent e) 
	{ 
		if (e.getSource()==this.btnTour){prochainTour();}
		sommeRegion = nbRegion*nbRegionMax;
		this.txtSommeReg.setText(""+sommeRegion);
		
		this.txtNbMax1.setText(""+nbRegionMax );
		this.txtBonus1.setText(""+bonus);
		scoreLigne = sommeRegion+bonus;
		this.txtScore1.setText("" + (scoreLigne));

		scoreFinal +=scoreLigne;
		this.txtScoreFinal.setText("" + (scoreFinal));
			
	}
	public void ajouterRegion()
	{
		nbRegion ++;
		this.txtNbRegion1.setText(""+nbRegion);
	}
	public void ajouterRegionMax()
	{
		nbRegionMax ++;
		this.txtNbMax1.setText(""+nbRegionMax);
	}
	public void ajouterBonus( )
	{
		bonus ++;
		this.txtBonus1.setText(""+bonus);
	}

	public void affichageBoutonTour()
	{
		this.btnTour.setVisible(true);
	}

	public void prochainTour()
	{
		this.btnTour.setVisible(false);
		nbRegion = -1;
		nbRegionMax = 0;
		bonus = 0;
		scoreLigne = 0;
		this.ajouterRegion();
		this.ctrl.getFrameAccueil().getFrameSolo().getPnlDroit().getPnlPioche().nextRound();
	}
}