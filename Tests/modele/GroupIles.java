package modele;

import java.util.List;
import java.util.ArrayList;
public class GroupIles 
{
	private List<ArrayList<Ile>> iles;

	public GroupIles()
	{
		this.iles = new ArrayList<ArrayList<Ile>>();
	}

	public void ajouterGroupe(ArrayList<Ile> iles2)
	{
		this.iles.add(iles2);
	}
	public void remove(int ile)
	{
		this.iles.remove(ile);
	}
	public List<Ile> getIles(int index)
	{
		return this.iles.get(index);
	}
	public int taille()
	{
		return this.iles.size();
	}

}
