package vue;

import javax.swing.*;
import controleur.Controleur;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.event.MouseListener;
import java.awt.image.RescaleOp;
import java.awt.image.BufferedImage;


import modele.Ile;
import modele.Arete;

public class PanelIles extends JPanel implements MouseListener
{
	private Controleur   ctrl;
	private JPanel       pnlSolo;
	private boolean      selected = false;
	private final double resize = 0.8;
	
	public PanelIles(Controleur ctrl) 
	{
		/*-------------------------*/
		/* Création des composants */
		/*-------------------------*/

		this.ctrl 		= ctrl;
		this.pnlSolo 	= new JPanel();

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
			int resizedStringY = (int) (y * resize + 50 );

			System.out.println(this.ctrl.getGraphe().getEnsIle().toString());
			g.drawString(numero, resizedStringX, resizedStringY);
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
			g2.setColor(new Color(188,188,180));
			g2.drawLine(smt1X + 50,smt1Y + 50,smt2X + 50,smt2Y + 50);
			System.out.println(this.ctrl.getGraphe().getEnsArete().toString());
		}
	}
	 
	public void paintComponent (Graphics g)
	{
		super.paintComponent ( g );
		Graphics2D g2 = (Graphics2D) g;

		// Dessine une image en bas Du Panel
		this.drawArete(g2);
		this.drawIles(g2);
		Image titre = Toolkit.getDefaultToolkit().getImage("./images/cinke_terra.png");
		g.drawImage(titre, 500, 5,(int) (titre.getWidth(this) * 0.4), (int) (titre.getHeight(this) * 0.4), this);

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
			// Clic simple
			int mouseX = evt.getX();
			int mouseY = evt.getY();
			// Logique pour traiter le clic simple

			selected = !selected;
			//surbrille(this.);
		} 
		else if (evt.getClickCount() == 2)
		{
			// Double-clic
			int mouseX = evt.getX();
			int mouseY = evt.getY();
			
				for (Ile ile : ctrl.getGraphe().getEnsIle())
				{
					Image imageIle = ile.getImage();
					int x = ile.getCoCentreX();
					int y = ile.getCoCentreY();
					int resizedPosX   = (int) (ile.getPosImageX() * resize);
					int resizedPosY   = (int) (ile.getPosImageY() * resize);
					int resizedWidth  = (int) (imageIle.getWidth (PanelIles.this) * resize);
					int resizedHeight = (int) (imageIle.getHeight(PanelIles.this) * resize);
					if (mouseX >= resizedPosX && mouseX < resizedPosX + resizedWidth &&
							mouseY >= resizedPosY && mouseY < resizedPosY + resizedHeight)
					{
						BufferedImage bufferedImage = toBufferedImage(imageIle);
						int pixel = bufferedImage.getRGB(mouseX - resizedPosX, mouseY - resizedPosY);
						if ((pixel >> 24) != 0x00)
						{
							System.out.println("Image " + ile.getNom() + " sélectionnée");
						}
					}
				}
			System.out.println("Double-clic");

		}
		repaint();
	}

	public void mouseEntered(MouseEvent evt){}

	public void mouseExited(MouseEvent evt){}

	public void mousePressed(MouseEvent evt){}

	public void mouseReleased(MouseEvent evt){}

	public void surbrille(Graphics g)
	{
		RescaleOp brighterOp = new RescaleOp(1.2f, 0, null);
		Image imageIle = this.ctrl.getGraphe().getEnsIle().get(0).getImage();

		// Appliquer le filtre sur l'image de l'île
		BufferedImage brighterImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = brighterImage.createGraphics();
		g.drawImage(imageIle, this.ctrl.getGraphe().getEnsIle().get(0).getCoCentreX(), this.ctrl.getGraphe().getEnsIle().get(0).getCoCentreY(),
			(int) ( imageIle.getWidth(this) * resize),
			(int) ( imageIle.getHeight(this) * resize), this);
		g2d.dispose();
		brighterOp.filter(brighterImage, brighterImage);

		// Dessiner l'image plus lumineuse
		g.drawImage(brighterImage, 0, 0, getWidth(), getHeight(), this);
	}
}