package vue;

import controleur.Controleur;

public class FrameScenario1
{
	private Controleur 		ctrl;
	private FrameSolo 		frameSolo;
	private ScriptScenario1 scenario1;

	public FrameScenario1(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.frameSolo = new FrameSolo(this.ctrl);
		this.scenario1 = new ScriptScenario1(this.ctrl);
	}

	public FrameSolo getFrameSolo() { return this.frameSolo; }
}