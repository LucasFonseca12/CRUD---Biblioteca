package app;

import javax.swing.SwingUtilities;

import view.TelaBiblioteca;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TelaBiblioteca tela = new TelaBiblioteca();
                tela.setVisible(true);
            }
        });
    }
}
