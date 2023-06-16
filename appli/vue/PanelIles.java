/*Classe PanelIles qui affiche toute la carte
 *@author Louis Marouard, Maxime Galmant, Evan Cnaepelnickx, Arthur Lecomte
*/

package vue;

import javax.swing.*;

import controleur.Controleur;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import modele.Ile;
import modele.Arete;

public class PanelIles extends JPanel implements MouseListener
{
	private final double resize = 0.8;

	private Controleur   ctrl;
	private JPanel       pnlSolo;
	private static int nbIleSelectionne =0;
	private static boolean ile1 = true;
	private static boolean ile2 = false; 
	private static boolean finPartie = false;

	public PanelIles(Controleur ctrl) 
	{
		/*-------------------------*/
		/* Création des composants */
		/*-------------------------*/

		this.ctrl 		= ctrl;
		this.pnlSolo	= new JPanel();

		/*-------------------------------*/
		/* positionnement des composants */
		/*-------------------------------*/

		this.add(pnlSolo);

		/*-------------------------------*/
		/* 			Finalisation         */
		/*-------------------------------*/

		pnlSolo.setVisible(true);
		this.setBackground(new Color(184,212,228));
		this.setVisible(true);

		this.addMouseListener(this);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		//Background
		g.drawImage(new ImageIcon("./images/bg.gif").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
		Graphics2D g2 = (Graphics2D) g;
		this.drawGroupIles(g2);
		// Dessine une image en bas Du Panel
		this.drawArete(g2);
		this.drawIles(g2);
		
		
		Image titre = Toolkit.getDefaultToolkit().getImage("./images/cinke_terra.png");
		g.drawImage(titre, 600, 5, (int) (titre.getWidth(this) * 0.4), (int) (titre.getHeight(this) * 0.4), this);
	}

	public void drawGroupIles(Graphics g)
	{

		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2 ));
		g2.setColor(new Color(0,204,204));
		g2.drawLine(100,360,700,360);//740
		g2.drawLine(700, 360, 1000, 100);
		g2.drawLine(700, 360, 950, 670);
		g2.drawLine(400, 100, 400, 700);
	}
	public void drawIles(Graphics g)
	{
		double resize = 0.8; // Facteur de redimensionnement

		
		for (Ile ile : this.ctrl.getGraphe().getEnsIle())
		{
			if (nbIleSelectionne > 1) { ile.setEstSelectionne(false); }
			if (ile1)
			{
				if (ile.getNom().equals("Ticó") && this.ctrl.getJoueur().getRdmColor1() == 0)
					{
						ile.setEstSelectionne(true);
						this.ctrl.getFrameAccueil().getFrameSolo().getpanelBandeau().setLbl(ile.getNom());
						ile1 = false;
						
					}
				if (ile.getNom().equals("Mutaa") && this.ctrl.getJoueur().getRdmColor1() == 1)
					{
						ile.setEstSelectionne(true);
						ile1 = false;
						this.ctrl.getFrameAccueil().getFrameSolo().getpanelBandeau().setLbl(ile.getNom());
						
					}
			
				}
			if (ile2)
			{
				ile.setEstSelectionne(false);
				if (ile.getNom().equals("Ticó") && this.ctrl.getJoueur().getRdmColor2() == 0)
					{
						ile.setEstSelectionne(true);
						this.ctrl.getFrameAccueil().getFrameSolo().getpanelBandeau().setLbl(ile.getNom());
						ile2 = false;
						
					}
				if (ile.getNom().equals("Mutaa") && this.ctrl.getJoueur().getRdmColor2() == 1)
					{
						ile.setEstSelectionne(true);
						ile2 = false;
						this.ctrl.getFrameAccueil().getFrameSolo().getpanelBandeau().setLbl(ile.getNom());
						
					}
			
				}
				
			
			

			Image imageIle = ile.getImage();

			int x = ile.getCoCentreX();
			int y = ile.getCoCentreY();

			// Redimensionner les coordonnées de l'image
			int resizedPosX = (int) (ile.getPosImageX() * resize);
			int resizedPosY = (int) (ile.getPosImageY() * resize);

			g.drawImage(imageIle, resizedPosX + 50, resizedPosY + 50,
				(int) ( imageIle.getWidth (this) * resize),
				(int) ( imageIle.getHeight(this) * resize), this);

			g.setColor(Color.BLACK);
			String numero = ile.getNom();

			// Redimensionner les coordonnées du texte
			int resizedStringX = (int) (x * resize + 15 );
			int resizedStringY = (int) (y * resize + 20 );

			g.drawString(numero, resizedStringX, resizedStringY);

			if (ile.estSelectionne()) { highlightSelectedIle(g, ile);}
		}
	}
	private void highlightSelectedIle(Graphics g, Ile ile)
	{
		int x = ile.getCoCentreX();
		int y = ile.getCoCentreY();
		int highlightRadius = 15;

		g.setColor(Color.YELLOW);
		int resizedX = (int) (x * resize) - highlightRadius / 2 + 50;
		int resizedY = (int) (y * resize) - highlightRadius / 2 + 50;
		g.fillOval(resizedX, resizedY, highlightRadius, highlightRadius);
	}

	public void drawArete(Graphics g)
	{
		for (Arete arete : this.ctrl.getGraphe().getEnsArete())
		{
			int smt1X = (int) (arete.getIle1().getCoCentreX()*resize);
			int smt1Y = (int) (arete.getIle1().getCoCentreY()*resize);
			int smt2X = (int) (arete.getIle2().getCoCentreX()*resize);
			int smt2Y = (int) (arete.getIle2().getCoCentreY()*resize);

			Graphics2D g2 = (Graphics2D) g;

			//dessine les contours blancs

			g2.setColor(Color.WHITE);
			g2.setStroke(new BasicStroke(10));
			g2.drawLine(smt1X + 50,smt1Y + 50,smt2X + 50,smt2Y + 50);

			//dessine le trait en lui même

			g2.setStroke(new BasicStroke(8));
			g2.setColor(arete.getCouleur());
			g2.drawLine(smt1X + 50,smt1Y + 50,smt2X + 50,smt2Y + 50);
		}
	}

	private BufferedImage toBufferedImage(Image image)
	{
		if (image instanceof BufferedImage) {return (BufferedImage) image;}

		BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null),
				BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2 = bufferedImage.createGraphics();
		g2.drawImage(image, 0, 0, null);
		g2.dispose();

		return bufferedImage;
	}

	public void mouseClicked(MouseEvent evt)
	{
		if (evt.getClickCount() == 1)
		{
			// simple
			int mouseX = evt.getX();
			int mouseY = evt.getY();

			nbIleSelectionne = 0;

			for (Ile ile : ctrl.getGraphe().getEnsIle())
			{
				Image imageIle    = ile.getImage();
				int resizedPosX   = (int) (ile.getPosImageX() * resize);
				int resizedPosY   = (int) (ile.getPosImageY() * resize);
				int resizedWidth  = (int) (imageIle.getWidth(PanelIles.this) * resize);
				int resizedHeight = (int) (imageIle.getHeight(PanelIles.this) * resize);

				int imageX = resizedPosX + getX() + 20;
				int imageY = resizedPosY + getY() + 20;

				// if (mouseX >= ile.getImage().getWidth(this) && mouseX < ile.getImage().getWidth(this) + resizedWidth &&
				// 		mouseY >= ile.getImage().getHeight(this) && mouseY < ile.getImage().getHeight(this) + resizedHeight)

				if (ile.estSelectionne()) { nbIleSelectionne++; }

				if (mouseX >= imageX - 50 && mouseX < imageX + resizedWidth + 50 &&
					mouseY >= imageY - 50 && mouseY < imageY + resizedHeight + 50)
				{
					int pixelX = mouseX - imageX;
					int pixelY = mouseY - imageY;

					if (estOpaque(imageIle, pixelX, pixelY))
					{
						System.out.println("Image " + ile.getNom() + " sélectionnée");
						// this.ctrl.setLbl(ile.getNom());
						ile.selectionneIle(this.ctrl.getGraphe());
						this.ctrl.getFrameAccueil().getFrameSolo().getpanelBandeau().setLbl(ile.getNom());

						repaint();
					}

					else { System.out.println("Image non sélectionnée"); }
				}
			}

			for (Ile ile : this.ctrl.getGraphe().getEnsIle())
			{
				for (Ile ile2 : this.ctrl.getGraphe().getEnsIle())
				{
					for (Arete a : this.ctrl.getGraphe().getEnsArete())
					{
						if (ile.estSelectionne() && ile2.estSelectionne()
							&& ile != ile2 && (a.getIle1() == ile && a.getIle2() == ile2 || a.getIle1() == ile2 && a.getIle2() == ile))
						{
							System.out.println("Les arêtes existent");

							Arete tmp = new Arete(a.getNum(), a.getIle1(), a.getIle2(),
									this.ctrl.getJoueur().getCouleurJoueur());

							// Vérification des arêtes colorées
							if (!this.ctrl.getGraphe().getEnsAreteColorer().isEmpty())
							{
								System.out.println("Il y a des arêtes colorées");

								for (Arete ac : this.ctrl.getGraphe().getEnsAreteColorer())
								{
									// Vérifie si l'arête est déjà colorée
									if ((ac.getIle1().getNom().equals(ile.getNom()) && ac.getIle2().getNom().equals(ile2.getNom()))
										|| (ac.getIle1().getNom().equals(ile2.getNom()) && ac.getIle2().getNom().equals(ile.getNom())))
									{
										System.out.println("L'arête est déjà colorée");
										return;
									}
								}

								// Vérifie si l'arête est connecter a une arête colorée
								if (!tmp.getIle1().areteLiee(this.ctrl.getGraphe().getEnsAreteColorer())
									&& !tmp.getIle2().areteLiee(this.ctrl.getGraphe().getEnsAreteColorer())
									&& !this.ctrl.getGraphe().getEnsIlesVisite().isEmpty())
								{
									System.out.println("L'arête n'est pas connectée à une arête colorée");
									return;
								}

								if (!this.ctrl.getGraphe().getIleDepart().areteLiee(tmp) 
									&& !this.ctrl.getGraphe().getIleArrivee().areteLiee(tmp)
									&& !this.ctrl.getGraphe().getEnsIlesVisite().isEmpty())
								{
									System.out.println("Ext 1 : " + this.ctrl.getGraphe().getIleDepart()
										+ " Ext 2 : " + this.ctrl.getGraphe().getIleArrivee());
									System.out.println("L'arête n'est pas connectée à une extrémité");
									return;
								}

								// Vérification des intersections
								if (tmp.intersection(this.ctrl.getGraphe().getEnsAreteColorer()))
								{
									System.out.println("Il y a une intersection");
									return;
								}

								// Vérification de cycle
								if (this.ctrl.getGraphe().formeCycle(tmp))
								{
									System.out.println("Il y a un cycle");
									return;
								}

							}

							else { System.out.println("Il n'y a pas d'arête colorée"); }

							// Vérification de la couleur
							String couleur = ctrl.getFrameAccueil().getFrameSolo().getpanelDroit().getPanelPioche().getTypeCouleur();
							if (!tmp.bonneCouleur(ctrl) && couleur != "Joker")
								return;

							if (this.ctrl.getJoueur().getAJoue() == false)
							{

								if (a.getCouleur().equals(Color.GREEN))
								{
									System.out.println("même couleur");
									this.ctrl.getScore().ajouterBonus();
								}

								this.ctrl.getGraphe().ajouterAreteColorer(a);
								
								a.getIle1().selectionneIle(this.ctrl.getGraphe());
								a.getIle2().selectionneIle(this.ctrl.getGraphe());
								this.ctrl.getJoueur().setAJoue(true);

								this.ctrl.getScore().maj();
								if (finPartie)
								{
									JOptionPane.showMessageDialog(null, "Fin de la partie, votre score est de : " + this.ctrl.getScore().getScoreFinal() + " points");
									this.ctrl.getFrameAccueil().getFrameSolo().dispose(); 
								}
							}

							System.out.println("Arete " + a.getIle1().getNom() + " " + a.getIle2().getNom() + " sélectionnée");
							System.out.println("Couleur : " + a.getCouleur());
							System.out.println(this.ctrl.getGraphe().getEnsAreteColorer().size() + " arêtes colorées");

							break;
						}
					}
				}
			}
		}
	}

	public void mouseEntered (MouseEvent evt){}
	public void mouseExited  (MouseEvent evt){}
	public void mousePressed (MouseEvent evt){}
	public void mouseReleased(MouseEvent evt){}

	private boolean estOpaque(Image image, int x, int y)
	{
		BufferedImage bufferedImage = toBufferedImage(image);

		if (x >= 0 && x < bufferedImage.getWidth() && y >= 0 && y < bufferedImage.getHeight())
		{
			int pixel = bufferedImage.getRGB(x, y);
			return (pixel >> 24) != 0x00;
		}
		
		return false;
	}
	public void setTour1True()
	{
		 ile2 = true;
	}
	public void setfinPartie(boolean b)
	{
		finPartie = b;
	}
}