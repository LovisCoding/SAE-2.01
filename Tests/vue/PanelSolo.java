package vue;
import javax.swing.*;
import controleur.Controleur;
import java.awt.Image;
import java.awt.FlowLayout;



public class PanelSolo extends JPanel
{
	private Controleur    ctrl;
	private JPanel pnlSolo;
	public PanelSolo(Controleur ctrl) 
	{
	
		
		/*-------------------------*/
		/* Création des composants */
		/*-------------------------*/

		this.ctrl = ctrl;
		this.pnlSolo = new JPanel();

		pnlSolo.setLayout(null);
		ImageIcon imageIcon = new ImageIcon("./data/images/Fama.png");
		Image img = imageIcon.getImage();
		int largeur = imageIcon.getIconWidth();
		int hauteur = imageIcon.getIconHeight();
		int x =1090;
		int y = 290;
		JLabel imageLabel = new JLabel(imageIcon);

		imageLabel.setBounds(x, y, largeur, hauteur);
		pnlSolo.add(imageLabel);
		

		


		/*-------------------------------*/
		/* positionnement des composants */
		/*-------------------------------*/
		
		pnlSolo.add(new JLabel("Choisissez votre niveau :"));

		
		this.add(pnlSolo);

		/*-------------------------------*/
		/* Finalisation                  */
		/*-------------------------------*/
		
		pnlSolo.setVisible(true);
		this.setVisible(true);
	
	}
	
	
}