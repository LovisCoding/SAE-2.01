package modele;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.awt.Image;
import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Iles
 */

public class Ile 
{
	private String 		nom;
	private String 		couleur;
	private int 		coCentreX;
	private int 		coCentreY;
	private int 		posImageX;
	private int 		posImageY;
	private int 		groupIles;
	private Image 		image;
	private boolean 	estSelectionne;

	public Ile(String nom, String couleur, int coCentreX, int coCentreY, int posImageX, int posImageY, int groupIles) 
	{
		this.nom 		= nom;
		this.couleur 	= couleur;
		this.coCentreX 	= coCentreX;
		this.coCentreY 	= coCentreY;
		this.posImageX 	= posImageX;
		this.posImageY 	= posImageY;
		this.groupIles 	= groupIles;
		this.image 		= Toolkit.getDefaultToolkit().getImage("./images/Iles/"+this.nom+".png");
		this.estSelectionne = false;
	}

	public String 	getNom() 			{return this.nom			;}
	public String 	getCouleur() 		{return this.couleur		;}
	public boolean 	estSelectionne() 	{return this.estSelectionne	;}
	public int 		getCoCentreX() 		{return this.coCentreX		;}
	public int 		getCoCentreY() 		{return this.coCentreY		;}
	public int 		getPosImageX() 		{return this.posImageX		;}
	public int 		getPosImageY() 		{return this.posImageY		;}
	public Image 	getImage() 			{return this.image			;}
	public int 		getGroupIles() 		{return this.groupIles		;}

	public void 	setEstSelectionne(boolean estSelectionne) 	{this.estSelectionne = estSelectionne;}

	public String toString() 
	{
		return "Ile [nom=" + nom + ", couleur=" + couleur + ", coCentreX=" + coCentreX + ", coCentreY=" + coCentreY
				+ ", posImageX=" + posImageX + ", posImageY=" + posImageY + " groupIles = " + groupIles +"]";
	}

	public boolean areteLiee(List<Arete> listeArete)
	{
		for (Arete ac : listeArete)
		{
			if (ac.getIle1().getNom().equals(this.nom) || ac.getIle2().getNom().equals(this.nom))
				return true;
		}
		return false;
	}

	public boolean areteLiee(Arete ac)
	{
		if (ac.getIle1().getNom().equals(this.nom) || ac.getIle2().getNom().equals(this.nom))
			return true;
		return false;
	}

	public ArrayList<Arete> getAreteLiee()
	{
		ArrayList<Arete> listeArete = new ArrayList<Arete>();
		
		for (Arete ac : listeArete)
		{
			if (ac.getIle1().getNom().equals(this.nom) || ac.getIle2().getNom().equals(this.nom))
				listeArete.add(ac);
		}
		return listeArete;
	}

	public Color getPixelColor(int x, int y)
	{
		if (this.getImage() != null && x >= 0 && y >= 0 && x < this.getImage().getWidth(null)
				&& y < this.getImage().getHeight(null)) 
		{
			BufferedImage bufferedImage = new BufferedImage(this.getImage().getWidth(null),
					this.getImage().getHeight(null), BufferedImage.TYPE_INT_ARGB);

			bufferedImage.getGraphics().drawImage(this.getImage(), 0, 0, null);
			return new Color(bufferedImage.getRGB(x, y), true);
		}
		return null;
	}

	public Color estTransparent() { return new Color(0, 0, 0, 0); } // Couleur transparente (alpha = 0)

	public void selectionneIle(Graphe g)
	{
		if (!this.estSelectionne())
		{
			// Vérifier si une autre île est déjà sélectionnée
			for (Ile autreIle : g.getEnsIle())
			{
				if (autreIle.estSelectionne())
				{
					// Vérifier si les deux îles sont adjacentes
					if (g.estAdjacent(this, autreIle))
					{
						// Marquer les deux îles comme sélectionnées
						this.setEstSelectionne(true);
						autreIle.setEstSelectionne(true);

						// Autres actions à effectuer lorsque deux îles sont sélectionnées

						return;
					}
				}
			}

			// Aucune autre île sélectionnée, marquer l'île comme sélectionnée
			this.setEstSelectionne(true);

			// Autres actions à effectuer lorsque l'île est sélectionnée
		}
		
		else
		{
			// L'île est déjà sélectionnée, la déselectionner
			this.setEstSelectionne(false);

			// Autres actions à effectuer lorsque l'île est déselectionnée
		}
	}	
}