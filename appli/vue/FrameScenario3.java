package vue;

import controleur.Controleur;

public class FrameScenario3
{
	private Controleur 		ctrl;
	private FrameSolo 		frameSolo;
	private ScriptScenario3 scenario3;

	public FrameScenario3(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.frameSolo = new FrameSolo(this.ctrl);
		this.scenario3 = new ScriptScenario3(this.ctrl);
	}

	public FrameSolo getFrameSolo() { return this.frameSolo; }
}