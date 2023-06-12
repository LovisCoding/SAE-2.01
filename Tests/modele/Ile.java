package modele;
import java.awt.Toolkit;
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
		
	}

	public String getNom() {return this.nom;}

	public String getCouleur() {return this.couleur;}

	public int getCoCentreX() {return this.coCentreX;}

	public int getCoCentreY() {return this.coCentreY;}

	public int getPosImageX() {return this.posImageX;}

	public int getPosImageY() 
	{
		return this.posImageY;
	}
	public String toString() 
	{
		return "Ile [nom=" + nom + ", couleur=" + couleur + ", coCentreX=" + coCentreX + ", coCentreY=" + coCentreY
				+ ", posImageX=" + posImageX + ", posImageY=" + posImageY + " groupIles = " + groupIles +"]";
	}
	public Image getImage() {return this.image;}

	public int getGroupIles() {return this.groupIles;}
}