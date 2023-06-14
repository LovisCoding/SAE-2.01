package vue;

import javax.swing.*;
import controleur.Controleur;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.List;
import java.awt.image.RescaleOp;

import modele.Ile;
import modele.Arete;

public class PanelIles extends JPanel implements MouseListener
{
	private final double resize = 0.8;
	
	private Controleur   ctrl;
	private JPanel       pnlSolo;

	private static List<Color>ensCouleurVisitees ;
	private static List<Color>ensCouleur ;
	
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
		/* Finalisation                  */
		/*-------------------------------*/
		
		pnlSolo.setVisible(true);
		this.setBackground(new Color(184,212,228));
		this.setVisible(true);
		
		this.addMouseListener(this);

	}

	public void drawIles(Graphics g)
	{
		double resize = 0.8; // Facteur de redimensionnement

		for (Ile ile : this.ctrl.getGraphe().getEnsIle())
		{
			Image imageIle = ile.getImage();

			int x = ile.getCoCentreX();
			int y = ile.getCoCentreY();

			// Redimensionner les coordonnées de l'image
			int resizedPosX = (int) (ile.getPosImageX() * resize);
			int resizedPosY = (int) (ile.getPosImageY() * resize);

			g.drawImage(imageIle, resizedPosX + 50, resizedPosY + 50,
				(int) ( imageIle.getWidth(this) * resize),
				(int) ( imageIle.getHeight(this) * resize), this);

			g.setColor(Color.BLACK);
			String numero = ile.getNom();

			// Redimensionner les coordonnées du texte
			int resizedStringX = (int) (x * resize + 15 );
			int resizedStringY = (int) (y * resize + 20 );

			g.drawString(numero, resizedStringX, resizedStringY);

			if (ile.estSelectionne()) 
			{
				highlightSelectedIle(g, ile);
			}
		}
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
	 
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		//Background
		g.drawImage(new ImageIcon("./images/bg.gif").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
		Graphics2D g2 = (Graphics2D) g;
		
		// Dessine une image en bas Du Panel
		this.drawArete(g2);
		this.drawIles(g2);
		Image titre = Toolkit.getDefaultToolkit().getImage("./images/cinke_terra.png");
		g.drawImage(titre, 500, 5, (int) (titre.getWidth(this) * 0.4), (int) (titre.getHeight(this) * 0.4), this);
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

		for (Ile iles : this.ctrl.getGraphe().getEnsIle())
		{
            // Vérifie si l'île possède la même couleur que la carte tirée
            if (iles.getCouleur().equals(this.ctrl.getFrameAccueil().getFrameSolo().getTypeCouleur()) || this.ctrl.getFrameAccueil().getFrameSolo().getTypeCouleur() == "Joker")
			{
                System.out.println("test2");
                /*for (Arete a : ctrl.getGraphe().getEnsArete())
				{
                    System.out.println("test3");
                    Arete tmp = new Arete(a.getNum(), ile, iles, this.ctrl.getJoueur().getCouleurJoueur());

				    // Vérifie si l'arête est connecter a une arête colorée
				    if (!tmp.getIle1().areteLiee(this.ctrl.getGraphe().getEnsAreteColorer()) && !tmp.getIle2().areteLiee(this.ctrl.getGraphe().getEnsAreteColorer()))
				    {*/
                        // Créer un filtre de couleur pour rendre l'image plus lumineuse
                        RescaleOp brighterOp = new RescaleOp(1.2f, 0, null);

                        // Appliquer le filtre sur l'image de l'île
                        BufferedImage brighterImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
                        Graphics2D g2d = brighterImage.createGraphics();
                        g2d.drawImage(iles.getImage(), iles.getPosImageX(), iles.getPosImageY(), getWidth(), getHeight(), this);
                        g2d.dispose();
                        brighterOp.filter(brighterImage, brighterImage);

                        // Dessiner l'image plus lumineuse
                        g.drawImage(brighterImage, iles.getPosImageX(), iles.getPosImageY(), getWidth(), getHeight(), this);
                    //}
                //}
			}
		}
	}

	public void mouseClicked(MouseEvent evt)
	{
		if (evt.getClickCount() == 1) 
		{

			int nbSelection = 0;
			for (Ile ile : this.ctrl.getGraphe().getEnsIle())
			{
				if (ile.estSelectionne())
					nbSelection++;
			
			}

			if (nbSelection %2 == 0)
				for (Ile ile : this.ctrl.getGraphe().getEnsIle())
					ile.setEstSelectionne(false);
			

			// simple
			int mouseX = evt.getX();
			int mouseY = evt.getY();

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
				if (mouseX >= imageX - 30 && mouseX < imageX + resizedWidth + 30 &&
					mouseY >= imageY - 30 && mouseY < imageY + resizedHeight + 30) 
				{
					int pixelX = mouseX - imageX;
					int pixelY = mouseY - imageY;
					if (estOpaque(imageIle, pixelX, pixelY))
					{
						System.out.println("Image " + ile.getNom() + " sélectionnée");
						this.ctrl.getFrameAccueil().getFrameSolo().getPnlBandeau().setLbl(ile.getNom());
						ile.setEstSelectionne(true);
						repaint();
					}
					else
					{
						System.out.println("Image non sélectionnée");
					}
					
				}
				
			}

			for (Ile ile : ctrl.getGraphe().getEnsIle())
			{
				for (Ile ile2 : ctrl.getGraphe().getEnsIle())
				{
					for (Arete a : ctrl.getGraphe().getEnsArete())
					{
						if (ile.estSelectionne() && ile2.estSelectionne() 
							&& ile != ile2 && (a.getIle1() == ile && a.getIle2() == ile2 || a.getIle1() == ile2 && a.getIle2() == ile))
						{
							System.out.println("Les arêtes existent");

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

								Arete tmp = new Arete(a.getNum(), a.getIle1(), a.getIle2(), this.ctrl.getJoueur().getCouleurJoueur());

								// Vérifie si l'arête est connecter a une arête colorée
								if (!tmp.getIle1().areteLiee(this.ctrl.getGraphe().getEnsAreteColorer()) && !tmp.getIle2().areteLiee(this.ctrl.getGraphe().getEnsAreteColorer())) 
								{
									System.out.println("L'arête n'est pas connectée à une arête colorée");
                                    return;
                                    
                                }
								if (!this.ctrl.getGraphe().getEnsSommetVisite().get(0).areteLiee(tmp) &&
									!this.ctrl.getGraphe().getEnsSommetVisite().get(this.ctrl.getGraphe().getEnsSommetVisite().size()-1).areteLiee(tmp) && 
									this.ctrl.getGraphe().getEnsSommetVisite().size() > 1)
								{
									System.out.println("Ext 1 : " + this.ctrl.getGraphe().getEnsSommetVisite().get(0) + " Ext 2 : " + this.ctrl.getGraphe().getEnsSommetVisite().get(this.ctrl.getGraphe().getEnsSommetVisite().size()-1));
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
							else
							System.out.println("Il n'y a pas d'arête colorée");

							if (!a.getIle1().getNom().equals("Mutaa") && !a.getIle2().getNom().equals("Mutaa") && this.ctrl.getJoueur().getCouleurJoueur() == Color.BLUE)
							{
								System.out.println("Le joueur ne peut pas colorer cette arête en bleu");
								return;
							}
							else if (!a.getIle1().getNom().equals("Tic\u00F3") && !a.getIle2().getNom().equals("Tic\u00F3") && this.ctrl.getJoueur().getCouleurJoueur() == Color.RED)
							{
								System.out.println("Le joueur ne peut pas colorer cette arête en rouge");
								return;
							}

							a.setCouleur(this.ctrl.getJoueur().getCouleurJoueur());
							this.ctrl.getGraphe().ajouterAreteColorer(a);
							for (Ile i : ctrl.getGraphe().getEnsIle())
								i.setEstSelectionne(false);

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

	public void mouseEntered(MouseEvent evt){}

	public void mouseExited(MouseEvent evt){}

	public void mousePressed(MouseEvent evt){}

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
}