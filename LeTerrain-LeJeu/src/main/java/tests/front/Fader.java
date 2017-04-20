package tests.front;
import java.util.TimerTask;
import javax.swing.JDialog;
import com.sun.awt.AWTUtilities;

public class Fader extends TimerTask {

    private JDialog jDialog;

    public Fader(JDialog jDialog) { this.jDialog = jDialog; }
    //Comme Fader étend de Timer, c'est la méthode run() qui permet de faire le traitement

    @Override public void run() {
        //On décide de réduire l'opacité du JDialog par 0,01f (car c'est du float)
        //Bien entendu si l'opacité est réduite au maximum, on ferme le JDialog avec dispose()
        if(AWTUtilities.getWindowOpacity(jDialog) > 0.01f){
            AWTUtilities.setWindowOpacity(jDialog,AWTUtilities.getWindowOpacity(jDialog)-0.01f);
        } else { jDialog.dispose(); }
     }
}