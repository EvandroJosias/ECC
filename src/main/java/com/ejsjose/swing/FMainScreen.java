package com.ejsjose.swing;

import com.ejsjose.utils.DbConnection;
import com.ejsjose.utils.Icone;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;

import java.awt.Color;
import java.awt.Container;
import java.awt.BorderLayout;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

public class FMainScreen extends JFrame implements ActionListener, MouseListener, WindowListener {

    private static final long serialVersionUID = 1L;
	private JSplitPane splitPane = null;

	protected JMenuItem sairMI = new JMenuItem();    

    public String sImgFundo = null;
    public JMenuBar bar = new JMenuBar();	
    public JDesktopPane dpArea = new JDesktopPane();
	public JStatusBar statusBar = new JStatusBar();

    public Container c = getContentPane();
	public Color padrao = new Color(145, 167, 208);

    public FMainScreen() {
        this("./images", "background.png", "Controle ECC", "icon.png", "smallIcon.png", "largeIcon.png", "largeIcon2.png");
    }

	public FMainScreen(String sDirImagem, String sImgFundo) {
		this(sDirImagem, sImgFundo, null, null, null, null, null);
	}   
    
    public FMainScreen(String sDirImagem, String sImgFundo, String sTitulo, String sIcone, String sIconePequeno, String sIconeGrande, String sIconeGrande2) {
//	public FMainScreen(String sDirImagem, String sImgFundo, String sImgLogoSis, String sImgLogoEmp, Color bgcolor, String urlempresa, String urlsistema) {		
        super(sTitulo);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza a janela para ocupar toda a tela
        setUndecorated(false); // Mantém a barra de título e bordas
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao fechar a janela

		// if (bgcolor != null) {
		// 	padrao = bgcolor;
		// }

		if (sDirImagem != null) {
			//Imagem.dirImages = sDirImagem;
			Icone.dirImages = sDirImagem;
		}
		// lbFreedom = new JLabelPad(Icone.novo(imgLogoSis));
		// lbStpinf = new JLabelPad(Icone.novo(imgLogoEmp));

		this.sImgFundo = sImgFundo;

		c.setLayout(new BorderLayout());


        // Usar a barra de menu já declarada como propriedade da classe
        // Inicializar a barra de menu se ainda não foi feito
        if (bar == null) {
            bar = new JMenuBar();
        }

        // Definir a barra de menu da janela
		this.setJMenuBar(bar);

		sairMI.setText("Sair");
		sairMI.setMnemonic('r');

		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane.setContinuousLayout(true);
		splitPane.setOneTouchExpandable(true);

		splitPane.setTopComponent(dpArea);

		splitPane.setDividerSize(1);

		//montaStatus();

		c.add(splitPane, BorderLayout.CENTER);

		setExtendedState(MAXIMIZED_BOTH);

		inicializaTela();

		sairMI.addActionListener( new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				fecharJanela();
			}
		});

		// addWindowListener(new WindowAdapter() {
		// 	public void windowClosing(WindowEvent e) {
		// 		fecharJanela();
		// 	}
		// });

		// Adicona o Listener para tratar eventos da janela
		addWindowListener(this);
		System.out.println("final da funcao costructor FMainScreen");
	}

	public void addMenu(JMenuPad menu) {
		if (bar == null) {
			bar = new JMenuBar();
			this.setJMenuBar(bar);
		}
		bar.add(menu);
		// Força a atualização da interface gráfica
		bar.revalidate();
		bar.repaint();
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

    public void fecharJanela() {
		int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente sair?", "Confirmação", JOptionPane.YES_NO_OPTION);
		if (resposta == JOptionPane.YES_OPTION) {
			dispose(); // Fecha a janela e libera recursos
		}
	};	

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

	public void inicializaTela() {
		// Garantir que a barra de menu está definida
		if (this.getJMenuBar() == null && bar != null) {
			this.setJMenuBar(bar);
		}
		// TODO: implementar o inicializaTela
		System.out.println("Tela inicializada.");
	};

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
