package GUI;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;


public abstract class GUIGeneral 
{
    protected ArrayList<JComponent> componentList = new ArrayList<JComponent>();
    protected JPanel panel;
    protected JFrame _parentFrame;
    
    //ετικέτα πλήκτρου επιστροφής κοινή για όλες τις διεπαφές χρήστη.
    public static String textBtnReturn = "Επιστροφή";
   
    protected GUIGeneral(JFrame parentFrame)
    {
	_parentFrame = parentFrame;
	panel = new JPanel();
    }
    
    protected void createButton(String btnText)	//συνάρτηση που δημιουργεί ένα πλήκτρο, του αναθέτει ένα μοναδικό όνομα ως 	    
    {						//ιδιότητα που το ξεχωρίζει από τα υπόλοιπα, και το προσθέτει στη λίστα των αντικειμένων ελέγχου componentList και στο τρέχον panel.
	JButton btn = new JButton(btnText);	//δημιρουγία πλήκτρου με κείμενο το btnText.
	btn.setName(btnText);			//ανάθεση στο πλήκτρο ενός μοναδικού ονόματος btnText.
	panel.add(btn);
	componentList.add(btn);			//προσθήκη του πλήκτρου στη λίστα componentList
    }
    
    protected abstract void createGUI();	//κάθε κλάση θα πρέπει να υλοιποιεί μια μέθοδο createGUI()
}
