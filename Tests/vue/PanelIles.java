package vue;

import javax.swing.*;
import controleur.Controleur;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.List;

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
			int resizedStringY = (int) (y * resize + 10 );

			g.drawString(numero, resizedStringX, resizedStringY);

			if (ile.getEstSelectionne()) 
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
		g.drawImage(new ImageIcon("./images/wave2.gif").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
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
	}

	public void mouseClicked(MouseEvent evt)
	{
		if (evt.getClickCount() == 1) 
		{
			// simple
			int mouseX = evt.getX();
			int mouseY = evt.getY();

			for (Ile ile : ctrl.getGraphe().getEnsIle()) 
			{
				Image imageIle    = ile.getImage();
				int resizedPosX   = (int) (ile.getPosImageX() * resize);
				int resizedPosY   = (int) (ile.getPosImageY() * resize);
				int resizedWidth  = (int) (imageIle.getWidth (PanelIles.this) * resize);
				int resizedHeight = (int) (imageIle.getHeight(PanelIles.this) * resize);

				int x = ile.getCoCentreX() - ile.getPosImageX();
				int y = ile.getCoCentreY() - ile.getPosImageY();

				if ( mouseX > ile.getPosImageX() && mouseY > ile.getPosImageY() && mouseX < x && mouseY < y)
				/*if (mouseX >= imageX && mouseX < imageX + resizedWidth &&
					mouseY >= imageY && mouseY < imageY + resizedHeight)*/
				{
					BufferedImage bufferedImage = toBufferedImage(imageIle);
					int pixel = bufferedImage.getRGB(mouseX - ile.getPosImageX(), mouseY - ile.getPosImageY());
					if ((pixel >> 24) != 0x00)

					{
						System.out.println("Image " + ile.getNom() + " sélectionnée");
						ile.setEstSelectionne(true);
						repaint();
					}
					else
						System.out.println("Image non sélectionnée");
				}
			}





			for (Ile ile : ctrl.getGraphe().getEnsIle())
			{
				for (Ile ile2 : ctrl.getGraphe().getEnsIle())
					for (Arete a : ctrl.getGraphe().getEnsArete())
					{
						if (ile.getEstSelectionne() && ile2.getEstSelectionne() 
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
								System.out.println("L'arête est déjà c.getNom()olorée");
								return;
								}
							}
							Arete tmp = new Arete(a.getNum(), a.getIle1(), a.getIle2(), this.ctrl.getJoueur().getCouleurJoueur());

										// Vérifie si l'arête est connecter a une arête colorée
							if (!tmp.getIle1().areteLiee(this.ctrl.getGraphe().getEnsAreteColorer()) && !tmp.getIle2().areteLiee(this.ctrl.getGraphe().getEnsAreteColorer())) 
							{
									System.out.println("L'arête est connectée à une arête colorée");
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

							// Coloration des arêtes
							// if (color == 1)
							// {
							// this.ctrl.getJoueur().ajouterCoupnbColor1();
							// System.out.println(this.ctrl.getJoueur().getRdmColor1());
							// System.out.println("Coups :"+this.ctrl.getJoueur().getNbCoupsColor1());
							// if (this.ctrl.getJoueur().getNbCoupsColor1() > this.ctrl.getJoueur().getRdmColor1()) 
							// {
							// 	color = 2;
							// 	System.out.println("Changement de couleur");
							// 	this.ctrl.getGraphe().setEnsSommetVisite(new ArrayList<Sommet>());
							// }
							// }

							// if (color == 2) 
							// {
							// this.ctrl.getJoueur().setCouleurJoueur(Color.BLUE);
							// if (this.ctrl.getJoueur().getNbCoupsColor2() > this.ctrl.getJoueur().getRdmColor2()) 
							// {
							// 	System.out.println("Win");
							// 	this.victoire();
							// 	break;
							// } 
							// else 
							// {
							// 	this.ctrl.getJoueur().ajouterCoupnbColor2();
							// }
							// }

							// boolean inEnsCouleur1= false;
							// boolean inEnsCouleur2= false;

							// //Ensemble de couleur stocké dans une liste, cela permettra de compte le nb de Regions visitées
							// if (ensCouleurVisitees.isEmpty())
							// {
							// 	//On va  ajouter toutes les couleurs des sommets de l'arête
							// 	ensCouleur.add(a.getIle1().getCouleur() );
							// 	ensCouleur.add(a.getIle2().getCouleur() );

							// if (a.getIle1().getCouleur()==a.getIle2().getCouleur())
							// {
							// 	ensCouleurVisitees.add(a.getIle1().getCouleur());


							// }
							// else
							// {
							// 	ensCouleurVisitees.add(a.getIle1().getCouleur());
							// 	ensCouleurVisitees.add(a.getIle2().getCouleur());
							// }
							// }
							// else
							// {
							// 	ensCouleur.add(a.getIle2().getCouleur() );
							// 	for (Color c : ensCouleurVisitees) 
							// 	{
							// 		if(a.getIle1().getCouleur().equals(c))
							// 		{
							// 			System.out.println("meme couleur sommet 1");
							// 			inEnsCouleur1=true;
							// 		}
							// 		if(a.getIle2().getCouleur().equals(c))
							// 		{
							// 			System.out.println("meme couleur sommet 2");
							// 			inEnsCouleur2=true;
							// 		}

							// 	}
							// 	if (!inEnsCouleur1 )
							// 	{
							// 		System.out.println("sommet 1: " + a.getIle1().getCouleur() );
							// 		System.out.println("sommet 2: " + a.getIle2().getCouleur() );
							// 		ensCouleurVisitees.add(a.getIle1().getCouleur());
							// 	}
							// 	if (!inEnsCouleur2 )
							// 	{
							// 		ensCouleurVisitees.add(a.getIle2().getCouleur());
							// 	}
							// 	//inEnsCouleur1 = false;			//Verifier si inutile
							// 	//inEnsCouleur2 = false;
							// }
							// //Ajout des bonus
							// if(a.getPointBonus() != 0 )
							// {
							// 	bonus+=a.getPointBonus();
							// }

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
		else if (evt.getClickCount() == 2)
		{
			// Double-clic
			
			System.out.println("Double-clic");

		}
	}

	public void mouseEntered(MouseEvent evt){}

	public void mouseExited(MouseEvent evt){}

	public void mousePressed(MouseEvent evt){}

	public void mouseReleased(MouseEvent evt){}
}