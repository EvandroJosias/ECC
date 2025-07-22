package com.ejsjose.views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.w3c.dom.events.MouseEvent;

import com.ejsjose.utils.FMainScreen;

public class mainScreen extends FMainScreen {

    public mainScreen() {
        super("src/main/resources/images", "background.png", "Main Screen", "icon.png", "smallIcon.png", "largeIcon.png", "largeIcon2.png");
    }

    public void displayMenu() {
        // Criação da janela (JFrame)
        JFrame frame = new JFrame("Exemplo Swing");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza a janela para ocupar toda a tela
        frame.setUndecorated(false); // Mantém a barra de título e bordas
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao fechar a janela

        // Criação de um botão (JButton)
        JButton button = new JButton("Clique aqui!");
        button.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Olá, Swing!")); // Ação ao clicar no botão

        // Adiciona o botão à janela
        frame.getContentPane().add(button);

        // Torna a janela visível
        frame.setVisible(true);
    }

    public void dispose() {
    // Libere recursos, feche conexões, etc.
        // Implement dispose logic if needed
        System.out.println("Resources released.");
    }

    public void mousePressed(MouseEvent arg0) {}

	public void mouseReleased(MouseEvent arg0) { }    

    public void mouseEntered(MouseEvent arg0) {

		// if (arg0.getSource() == lbStpinf) {
		// 	setBordaURL(lbStpinf);
		// }
		// else if (arg0.getSource() == lbFreedom) {
		// 	setBordaURL(lbFreedom);
		// }
	}

	public void mouseClicked(MouseEvent arg0) {

		// if (( arg0.getSource() == lbStpinf ) && ( arg0.getClickCount() >= 2 )) {
		// 	Funcoes.executeURL(Aplicativo.strOS, Aplicativo.strBrowser, sURLEmpresa);
		// }
		// else if (( arg0.getSource() == lbFreedom ) && ( arg0.getClickCount() >= 2 )) {
		// 	Funcoes.executeURL(Aplicativo.strOS, Aplicativo.strBrowser, sURLSistema);
		// }
	}

	public void mouseExited(MouseEvent arg0) {

		// if (arg0.getSource() == lbStpinf) {
		// 	lbStpinf.setBorder(borderStpinf);

		// }
		// else if (arg0.getSource() == lbFreedom) {
		// 	lbFreedom.setBorder(borderFreedom);
		// }
	}    
	
}
