package com.ejsjose.swing;

import com.ejsjose.utils.DbConnection;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

public abstract class FMainScreen extends JFrame implements ActionListener, MouseListener, WindowListener {

    private static final long serialVersionUID = 1L;

    public JMenuBar bar = new JMenuBar();
	protected JMenuItem sairMI = new JMenuItem();    
    public JDesktopPane dpArea = new JDesktopPane();
	public JStatusBar statusBar = new JStatusBar();

	public FMainScreen(String sDirImagem, String sImgFundo) {

		this(sDirImagem, sImgFundo, null, null, null, null, null);
	}   
    
    public FMainScreen(String sDirImagem, String sImgFundo, String sTitulo, String sIcone, String sIconePequeno, String sIconeGrande, String sIconeGrande2) {
        super(sTitulo);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza a janela para ocupar toda a tela
        setUndecorated(false); // Mantém a barra de título e bordas
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao fechar a janela
    }

    public FMainScreen() {
        this("./images", "background.png", "Main Windows", "icon.png", "smallIcon.png", "largeIcon.png", "largeIcon2.png");
    }

	public void addMenu(JMenuPad menu) {
		bar.add(menu);
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

	public void criatela(String titulo, FFDialogo comp, DbConnection cn) {

		// comp.setName( nome );
		String name = comp.getClass().getName();
		comp.setTitulo(titulo, name);
		comp.setConexao(cn);
		comp.execShow();
	}

	public void criatela(String titulo, FFilho comp, DbConnection cn, boolean show) {

		// comp.setName( nome );
		String name = comp.getClass().getName();
		comp.setTitulo(titulo, name);
		dpArea.add(name, comp);
		comp.setConexao(cn);

		if(show){
			comp.execShow();

			try {
				comp.setSelected(true);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void criatela(String titulo, FFilho comp, DbConnection cn) {
		criatela(titulo, comp, cn, true);
	}

	public void criatela(String titulo, FDialogo comp, DbConnection cn) {

		String name = comp.getClass().getName();
		// comp.setName( name );
		comp.setTitulo(titulo, name);
		comp.setConexao(cn);
		comp.setVisible(true);
	}	

    public abstract void fecharJanela();	

	public boolean temTela(String nome) {
		boolean retorno = false;
		int i = 0;
		JInternalFrame[] telas = dpArea.getAllFrames();
		JInternalFrame tela = null;
		while (true) {
			try {
				tela = telas[i];
			} catch (java.lang.Exception e) {
				break;
			}
			if (tela == null) {
				break;
			} else if (tela.getName() == null) {
				i++;
				continue;
			} else if (tela.getName().equals(nome)) {
				try {
					tela.setSelected(true);
				} catch (Exception e) {
				}
				retorno = true;
				break;
			}
			i++;
		}
		return retorno;
	}

	

	// ActionListener methods
	@Override
	public void actionPerformed(ActionEvent e) {
		// Implement action handling logic if needed
	}
	
	// WindowListener methods
	@Override
	public void windowOpened(WindowEvent e) {
		// Window opened event
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		// Window closing event
		dispose();
	}
	
	@Override
	public void windowClosed(WindowEvent e) {
		// Window closed event
	}
	
	@Override
	public void windowIconified(WindowEvent e) {
		// Window iconified event
	}
	
	@Override
	public void windowDeiconified(WindowEvent e) {
		// Window deiconified event
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		// Window activated event
	}
	
	@Override
	public void windowDeactivated(WindowEvent e) {
		// Window deactivated event
	}
	
}
