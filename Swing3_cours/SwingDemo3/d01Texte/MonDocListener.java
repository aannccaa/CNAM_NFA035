package d01Texte;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author rosmord
 */
class MonDocListener implements DocumentListener {

    private JFormulaireSecret demo;

    public MonDocListener(JFormulaireSecret demo) {
        this.demo = demo;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        verifierMotDePasse();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        verifierMotDePasse();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        // Jamais appelée
    }

    private void verifierMotDePasse() {
        if ("secret".equals(demo.getMonChampTexte().getText())) {
            demo.getAffichageField().setText("correct");
        } else {
            demo.getAffichageField().setText("incorrect");
        }
    }
}
