package View;

import java.util.ArrayList;
import javax.swing.JComponent;


public abstract class ViewGeneral 
{
    public ArrayList<JComponent> _components;
    
    public ViewGeneral(ArrayList<JComponent> components)
    {
	_components = components;
    }
    
    protected void manageListeners()	//συνάρτηση η οποία διαχειρίζεται τους ακροατές του κάθε component
    {
	for (JComponent comp:_components)
	{
	    assingListener(comp);
	}
    }
    
    protected abstract void assingListener(JComponent comp);	//αφηρημένη συνάρτηση που θα υλοποιηθεί σε κάθε προβολή (View) με τον δικό της κώδικα
}
