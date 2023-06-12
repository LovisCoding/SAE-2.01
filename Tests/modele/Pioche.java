package modele;


public class Pioche 
{
	private int nbCartes;

	public Pioche()
	{
		this.nbCartes = 10;
	}

	public int getNbCartes()
	{
		return this.nbCartes;
	}
	public int piocher()
	{
		
		this.nbCartes--;
		return (int)(Math.random()*nbCartes+1);
	}

	
	
}