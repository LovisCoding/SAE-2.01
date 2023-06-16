/* Classe FrameAccueilScenario permettant de choisir le scénario à lancer
 *@author  Louis Marouard, Maxime Galmant, Evan Cnaepelnickx, Arthur Lecomte
*/

package vue;

import javax.swing.*;
import java.awt.*;

import controleur.Controleur;
import java.awt.event.*;

public class FrameAccueilScenario extends JFrame implements ActionListener
{
	private Controleur ctrl;

	private JPanel panelTest;


	private JButton btnScenario1;
	private JButton btnScenario2;
	private JButton btnScenario3;
	private JButton btnScenario4;
	private JButton btnScenario5;

	public FrameAccueilScenario(Controleur ctrl)
	{
		this.ctrl = ctrl;

		panelTest = new JPanel();
		this.setTitle   ( "Scenario" );
		this.setLocation(500, 250) ; // Localisation
		this.setSize    (400, 700 ); // Taille

		panelTest.setLayout(new GridLayout(5,1));

		/*-------------------------*/
		/* Création des composants */
		/*-------------------------*/
		
		this.btnScenario1 = new JButton("Scenario 1");
		this.btnScenario2 = new JButton("Scenario 2");
		this.btnScenario3 = new JButton("Scenario 3");
		this.btnScenario4 = new JButton("Scenario 4");
		this.btnScenario5 = new JButton("Scenario 5");

		/*-------------------------------*/
		/* Positionnement des composants */
		/*-------------------------------*/

		panelTest.add(btnScenario1);
		panelTest.add(btnScenario2);
		panelTest.add(btnScenario3);
		panelTest.add(btnScenario4);
		panelTest.add(btnScenario5);

		this.add(panelTest);

		/*-------------------------------*/
		/*         Finalisation          */
		/*-------------------------------*/
		this.btnScenario1.addActionListener(this);
		this.btnScenario2.addActionListener(this);
		this.btnScenario3.addActionListener(this);
		this.btnScenario4.addActionListener(this);
		this.btnScenario5.addActionListener(this);


		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Fermeture de la fenêtre
		this.setVisible( true );
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == this.btnScenario1)
		{
			System.out.println("Activation du scenario 1");
			this.ctrl.Solo();
			this.ctrl.setScenario();
			this.dispose();
		}

		if(e.getSource() == this.btnScenario2)
		{
			System.out.println("Activation du scenario 2");
			this.ctrl.Solo();
			this.ctrl.setScenario2();
			this.dispose();
		}

		if(e.getSource() == this.btnScenario3)
		{
			System.out.println("Activation du scenario 3");
			this.ctrl.Solo();
			this.dispose();
		}

		if(e.getSource() == this.btnScenario4)
		{
			System.out.println("Activation du scenario 4");
			this.ctrl.Solo();
			this.dispose();
		}
		
		if(e.getSource() == this.btnScenario5)
		{
			System.out.println("Activation du scenario 5");
			this.ctrl.Solo();
			this.dispose();
		}
	}
}