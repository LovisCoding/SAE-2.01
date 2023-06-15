package vue;

import javax.swing.*;
import java.awt.*;

import controleur.Controleur;
import java.awt.event.*;

public class FrameTest extends JFrame implements ActionListener
{
    private Controleur ctrl;

    private JPanel pnlTest;

    private JButton btnScenario1;
    private JButton btnScenario2;
    private JButton btnScenario3;
    private JButton btnScenario4;
    private JButton btnScenario5;

    public FrameTest(Controleur ctrl)
	{
        this.ctrl = ctrl;
        this.setTitle   ( "Scenario" );
		this.setLocation(500, 250) ; // Localisation
        this.setSize    (400, 700 ); // Taille

        this.pnlTest.setLayout(new GridLayout(5,1));

        /*-------------------------*/
		/* Création des composants */
		/*-------------------------*/

        this.pnlTest = new JPanel();
        
        this.btnScenario1 = new JButton("Scenario 1");
        this.btnScenario2 = new JButton("Scenario 2");
        this.btnScenario3 = new JButton("Scenario 3");
        this.btnScenario4 = new JButton("Scenario 4");
        this.btnScenario5 = new JButton("Scenario 5");

        /*-------------------------------*/
		/* Positionnement des composants */
		/*-------------------------------*/

        this.pnlTest.add(btnScenario1);
        this.pnlTest.add(btnScenario2);
        this.pnlTest.add(btnScenario3);
        this.pnlTest.add(btnScenario4);
        this.pnlTest.add(btnScenario5);

        this.add(pnlTest);

        /*-------------------------------*/
		/*         Finalisation          */
		/*-------------------------------*/
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Fermeture de la fenêtre
		this.setVisible( true );
    }
    public void actionPerformed(ActionEvent e)
	{
        if(e.getSource() == btnScenario1)
        {
            System.out.println("Activation du scenario 1");
            this.ctrl.Solo();
            this.dispose();
        }
        if(e.getSource() == btnScenario2)
        {
            System.out.println("Activation du scenario 2");
            this.ctrl.Solo();
            this.dispose();
        }
        if(e.getSource() == btnScenario3)
        {
            System.out.println("Activation du scenario 3");
            this.ctrl.Solo();
            this.dispose();
        }
        if(e.getSource() == btnScenario4)
        {
            System.out.println("Activation du scenario 4");
            this.ctrl.Solo();
            this.dispose();
        }
        if(e.getSource() == btnScenario5)
        {
            System.out.println("Activation du scenario 5");
            this.ctrl.Solo();
            this.dispose();
        }
    }
}