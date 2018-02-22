import GUI.GUIMainMenu;
import javax.swing.JFrame;

public class eWeather 
{
    //τίτλος βασικού παραθύρου
    public static final String textMainFrame = "eWeather";
    
    public static void main(String[] args)
    {
	JFrame mainFrame = new JFrame();
	mainFrame.setSize(800, 500);
	mainFrame.setTitle(textMainFrame);
	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	mainFrame.setVisible(true);
	new GUIMainMenu(mainFrame);
	//new JsonRequesturu();
    }
}
