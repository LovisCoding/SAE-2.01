package modele;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.awt.Image;
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
	public boolean 	getEstSelectionne() {return this.estSelectionne	;}
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
}