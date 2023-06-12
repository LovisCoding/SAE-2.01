package modele;

import java.awt.Color;
import java.util.ArrayList;

public class Arete
{
	private int	    num;
	private Ile 	ile1;
	private Ile 	ile2;
	private int 	valeur;
	private Color 	couleur;

	public Arete(int num, Ile ile1, Ile ile2) 
	{
		this.num 	= num;
		this.ile1	= ile1;
		this.ile2	= ile2;
		this.valeur	= 0;
		this.couleur= Color.YELLOW;
	}


	public int 		getNum() 	{return this.num        ;}
	public Ile 	    getIle1() 	{return this.ile1       ;}
	public Ile	    getIle2() 	{return this.ile2       ;}
	public int	    getValeur() {return this.valeur     ;}
    public Color	getCouleur(){return this.couleur    ;}

	public String toString() 
    {
        return "Arete [num=" + num + ", ile1=" + ile1 + ", ile2=" + ile2 + ", valeur=" + valeur + ", couleur="
                + couleur + "]";
    }

	public boolean intersection(ArrayList<Arete> lstArete) 
    {
        double nx1 = this.getIle2().getCoCentreX();
        double ny1 = this.getIle2().getCoCentreY();

        // Vecteur
        double vx1 = this.getIle1().getCoCentreX() - this.getIle2().getCoCentreX();
        double vy1 = this.getIle1().getCoCentreY() - this.getIle2().getCoCentreY();

        for (Arete arete : lstArete) 
        {
            double nx2 = arete.getIle2().getCoCentreX();
            double ny2 = arete.getIle2().getCoCentreY();

            // Vecteur
            double vx2 = arete.getIle1().getCoCentreX() - arete.getIle2().getCoCentreX();
            double vy2 = arete.getIle1().getCoCentreY() - arete.getIle2().getCoCentreY();

            if (vx1 * vy2 - vy1 * vx2 != 0) 
            {
                double v1 = -(-vx1 * ny1 + vx1 * ny2 + vy1 * nx1 - vy1 * nx2) / (vx1 * vy2 - vy1 * vx2);
                double v2 = -( nx1 * vy2 - nx2 * vy2 - vx2 * ny1 + vx2 * ny2) / (vx1 * vy2 - vy1 * vx2);

                if (v1 > 0 && v1 < 1 && v2 > 0 && v2 < 1) 
                {
                    return true;
                }
            }
        }

        return false;
    }

}