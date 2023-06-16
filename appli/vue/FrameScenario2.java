/* Classe FrameScenario2 permettant de créer le 2ème scénario
 *@author  Louis Marouard, Maxime Galmant, Evan Cnaepelnickx, Arthur Lecomte
*/

package vue;

import controleur.Controleur;

public class FrameScenario2
{
	private Controleur 		ctrl;
	private FrameSolo 		frameSolo;
	private ScriptScenario2 scenario2;

	public FrameScenario2(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.frameSolo = new FrameSolo(this.ctrl);
		this.scenario2 = new ScriptScenario2(this.ctrl);
	}

	public FrameSolo getFrameSolo() { return this.frameSolo; }
}