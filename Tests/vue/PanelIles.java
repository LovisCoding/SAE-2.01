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

public class PanelIles extends JPanel implements MouseListener {
    private final double resize = 0.8;
    private Controleur ctrl;
    private JPanel pnlSolo;

    private static List<Color> ensCouleurVisitees;
    private static List<Color> ensCouleur;

    public PanelIles(Controleur ctrl) {
        this.ctrl = ctrl;
        this.pnlSolo = new JPanel();

        this.add(pnlSolo);

        pnlSolo.setVisible(true);
        this.setBackground(new Color(184, 212, 228));
        this.setVisible(true);

        this.addMouseListener(this);
    }

    public void drawIles(Graphics g) {
        for (Ile ile : this.ctrl.getGraphe().getEnsIle()) {
            Image imageIle = ile.getImage();

            int x = ile.getCoCentreX();
            int y = ile.getCoCentreY();

            int resizedPosX = (int) (ile.getPosImageX() * resize);
            int resizedPosY = (int) (ile.getPosImageY() * resize);

            g.drawImage(imageIle, resizedPosX + 50, resizedPosY + 50, (int) (imageIle.getWidth(this) * resize),
                    (int) (imageIle.getHeight(this) * resize), this);

            g.setColor(Color.BLACK);
            String numero = ile.getNom();

            int resizedStringX = (int) (x * resize + 15);
            int resizedStringY = (int) (y * resize + 20);

            g.drawString(numero, resizedStringX, resizedStringY);

            if (ile.estSelectionne()) {
                highlightSelectedIle(g, ile);
            }
        }
    }

    public void drawArete(Graphics g) {
        for (Arete arete : this.ctrl.getGraphe().getEnsArete()) {
            int smt1X = (int) (arete.getIle1().getCoCentreX() * resize);
            int smt1Y = (int) (arete.getIle1().getCoCentreY() * resize);
            int smt2X = (int) (arete.getIle2().getCoCentreX() * resize);
            int smt2Y = (int) (arete.getIle2().getCoCentreY() * resize);

            Graphics2D g2 = (Graphics2D) g;

            g2.setColor(Color.WHITE);
            g2.setStroke(new BasicStroke(10));
            g2.drawLine(smt1X + 50, smt1Y + 50, smt2X + 50, smt2Y + 50);

            g2.setStroke(new BasicStroke(8));
            g2.setColor(arete.getCouleur());
            g2.drawLine(smt1X + 50, smt1Y + 50, smt2X + 50, smt2Y + 50);
        }
    }

    private BufferedImage toBufferedImage(Image image) {
        if (image instanceof BufferedImage) {
            return (BufferedImage) image;
        }

        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2 = bufferedImage.createGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
    	return bufferedImage;
	}

	private void highlightSelectedIle(Graphics g, Ile ile) {
		int x = ile.getCoCentreX();
		int y = ile.getCoCentreY();

		int resizedPosX = (int) (x * resize);
		int resizedPosY = (int) (y * resize);

		int resizedWidth = (int) (ile.getImage().getWidth(this) * resize);
		int resizedHeight = (int) (ile.getImage().getHeight(this) * resize);

		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.RED);
		g2.drawRect(resizedPosX + 50, resizedPosY + 50, resizedWidth, resizedHeight);
	}

	public static void setEnsembleCouleur(List<Color> ensCouleurVisitees, List<Color> ensCouleur) {
		PanelIles.ensCouleurVisitees = ensCouleurVisitees;
		PanelIles.ensCouleur = ensCouleur;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		drawIles(g);
		drawArete(g);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();

		//ctrl.selectionneIle(mouseX, mouseY);

		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	
}
