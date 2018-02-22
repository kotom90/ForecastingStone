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
    
    public static final String textBtnReturn = "Επιστροφή"; //ετικέτα πλήκτρου επιστροφής κοινή για όλες τις διεπαφές χρήστη.
   
    protected GUIGeneral(JFrame parentFrame)
    {
	_parentFrame = parentFrame;
	panel = new JPanel();				    //δημιουργία ενός νέρου panel
    }
    
    protected void createButton(String btnText)		    //συνάρτηση που δημιουργεί ένα πλήκτρο, του αναθέτει ένα μοναδικό όνομα ως 	    
    {							    //ιδιότητα που το ξεχωρίζει από τα υπόλοιπα, και το προσθέτει στη λίστα των αντικειμένων ελέγχου componentList και στο τρέχον panel.
	JButton btn = new JButton(btnText);		    //δημιρουγία πλήκτρου με κείμενο το btnText.
	btn.setName(btnText);				    //ανάθεση στο πλήκτρο ενός μοναδικού ονόματος btnText.
	panel.add(btn);					    //εισαγωγή πλήκτρου στο panel
	componentList.add(btn);				    //προσθήκη του πλήκτρου στη λίστα componentList
    }
    
    protected void reDrawFrame()			    //αφού προστεθούν όλα τα components θέλουμε να εμφανίσουμε το νέο panel
    {
	_parentFrame.getContentPane().removeAll();	    //αδειάζουμε το frame από τα υπάρχοντα panels
	_parentFrame.getContentPane().add(panel);	    //εισάγουμε το νέο panel που δημιουργείται
	_parentFrame.validate();			    //ανανεώνουμε το περιεχόμενο του frame
    }
    
    protected abstract void createGUI();		    //κάθε κλάση θα πρέπει να υλοιποιεί μια μέθοδο createGUI() που θα δημιουργεί τα δικά της components
}
