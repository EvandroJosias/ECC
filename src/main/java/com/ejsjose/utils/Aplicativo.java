package com.ejsjose.utils;

import com.ejsjose.swing.IFilho;
import com.ejsjose.swing.JButtonPad;
import com.ejsjose.swing.JMenuPad;
import com.ejsjose.swing.JPanelPad;
import com.ejsjose.swing.JMenuItemPad;
import com.ejsjose.swing.FDialogo;
import com.ejsjose.swing.FFDialogo;
import com.ejsjose.swing.FFilho;
import com.ejsjose.swing.FMainScreen;

import java.util.Vector;
import java.lang.reflect.Method;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public abstract class Aplicativo implements ActionListener, KeyListener {

    private static Aplicativo instance = null;	

    public final static int TP_OPCAO_MENU = 0;
	public final static int TP_OPCAO_ITEM = 1;
    public final static int TP_OPCAO_SUBITEM = 2;

    public static boolean bSuporte = true;
    public static FMainScreen telaPrincipal = null;
    public static Component framePrinc = null;	
    public static String strOS = System.getProperty("os.name").toLowerCase();
    public static String strBrowser = "default";

   	protected int iCodSis = 0;
	protected int iCodModu = 0;
    protected Vector<JMenuItem>  vOpcoes = new Vector<>();
	protected Vector<JButtonPad> vBotoes = new Vector<>();
    protected JButtonPad btAtualMenu = new JButtonPad(Icone.novo("btAtualMenu.png"));

    public int iXPanel = 0;    
	public DbConnection con = null;
    public JPanelPad pinBotoes = new JPanelPad(30, 30);

	
	public Aplicativo() {
	    instance = this;
        telaPrincipal = new FMainScreen();

		addOpcao( -1, TP_OPCAO_MENU, "Arquivo", "", 'A', 100000000, 0, false, null );
		// addOpcao( 100000000, TP_OPCAO_MENU, "Tabelas", "", 'T', 100100000, 1, false, null );
		// addOpcao( 100100000, TP_OPCAO_MENU, "Acesso ao sistema", "", 'A', 100101000, 2, false, null );
		// addOpcao( 100101000, TP_OPCAO_ITEM, "Grupos", "Grupos", 'G', 100101010, 3, true, null );
		// addOpcao( 100101000, TP_OPCAO_ITEM, "Usuarios", "Usuarios", 'U', 100101020, 3, true, null );
		// //addOpcao( 100101000, TP_OPCAO_ITEM, "Acesso", "Acesso Menu", 'A', 100101030, 3, true, FAcesso.class );
		// addOpcao( 100101000, TP_OPCAO_ITEM, "Menu", "Menu X Objeto", 'M', 100101040, 3, true, null );
		// addOpcao( 100100000, TP_OPCAO_MENU, "Tabelas Geográficas", "", 'C', 100102000, 2, false, null );
		// addOpcao( 100102000, TP_OPCAO_ITEM, "Paises", "Paises", 'P', 100102020, 3, true, null );
		// addOpcao( 100102000, TP_OPCAO_ITEM, "Cidades", "Cidades", 'd', 100102030, 3, true, null);
		// addOpcao( 100102000, TP_OPCAO_ITEM, "Estados", "Estados", 'E', 100102040, 3, true, null );
		// addOpcao( 100102000, TP_OPCAO_ITEM, "Bairros", "Bairros", 'B', 100102050, 3, true, null );
		// addOpcao( 100100000, TP_OPCAO_MENU, "Objetos", "", 'O', 100103000, 2, false, null );
		// addOpcao( 100103000, TP_OPCAO_ITEM, "Tabela", "Tabelas auxiliares", 'T', 100103010, 3, true, null );
		// addOpcao( 100103000, TP_OPCAO_ITEM, "Objetos aux.", "Vinculo entre tabelas físicas e auxiliares", 'O', 100103020, 3, true, null );
		// addOpcao( 100100000, TP_OPCAO_MENU, "Fluxos", "", 'F', 100104000, 2, false, null );
		// addOpcao( 100104000, TP_OPCAO_ITEM, "Processos", "Processos", 'P', 100104100, 3, true, null );
		// addOpcao( 100104000, TP_OPCAO_ITEM, "Fluxos", "Cadastro de fluxos", 'F', 100104110, 3, true, null );

		// addOpcao( 100100000, TP_OPCAO_MENU, "Outras tabelas genéricas", "", 's', 100105000, 2, false, null );
		// addOpcao( 100105000, TP_OPCAO_ITEM, "Estados civis", "Estados civis", 'i', 100105100, 3, true, null );
		// addOpcao( 100105000, TP_OPCAO_ITEM, "Cadastro de Feriado", "Cadastro de Feriado", 'i', 100105200, 3, true, null );
		// addOpcao( 100105000, TP_OPCAO_ITEM, "Configuração de email", "Configuração de email", 'e', 100105300, 3, true, null );
		// addOpcao( 100105000, TP_OPCAO_ITEM, "Grau de instrução", "Grau de Instrução", 'G', 100105410, 3, true, null );
		
		// addOpcao( 100100000, TP_OPCAO_MENU, "Logs", "", 'l', 100106000, 2, false, null );
		// addOpcao( 100106000, TP_OPCAO_ITEM, "Análise de Logs", "Análise de Logs", 'L', 100106100, 3, true, null );

		// addOpcao( 100000000, TP_OPCAO_MENU, "Ferramentas", "", 'e', 100200000, 1, false, null );
		// addOpcao( 100200000, TP_OPCAO_ITEM, "Ajuste de Sequencia", "Ajusta sequencia", 'A', 100201000, 2, true, null );
		// addOpcao( 100200000, TP_OPCAO_ITEM, "Leitura Fiscal", "Leitura Fiscal", 'F', 100202000, 2, true, null );

		// addOpcao( 100000000, TP_OPCAO_MENU, "Preferências", "", 'P', 100300000, 1, false, null );
		// addOpcao( 100300000, TP_OPCAO_ITEM, "Visual", "Configuração de Visual", 'A', 100301000, 2, true, null );

		// addBotao( "barraGrupo.gif", "Cadastro de Grupos", "Grupos", 100101010, null );
		// addBotao( "barraUsuario.png", "Cadastro de Usuarios", "Usuarios", 100101020, null );
		// addBotao( "barraAcesso.gif", "Controle de Acessos", "Acesso Menu", 100101030, null );

		ajustaMenu();

	}    
    
	public void addOpcao(int iSuperMenu, int iTipo, String sCaption, String titulo, char cAtalho, int iOpcao,
			int iNivel, boolean bExec, Class<? extends IFilho> tela) {

		JMenuItem mOpcao = null;
		JMenuPad mpMaster = null;
		try {
			if (iTipo == TP_OPCAO_MENU) {
				mOpcao = (new JMenuPad(iCodSis, iCodModu, iOpcao, iNivel));
			} else if (iTipo == TP_OPCAO_ITEM) {
				mOpcao = (new JMenuItemPad(iCodSis, iCodModu, iOpcao, iNivel, tela, titulo));
			}
			mOpcao.setText(sCaption);
			mOpcao.setMnemonic(cAtalho);

			if (bExec)
				mOpcao.addActionListener(this);
			if (iSuperMenu == -1) {
				telaPrincipal.addMenu((JMenuPad) mOpcao);
			} else {
				mpMaster = (JMenuPad) getOpcao(iSuperMenu);
				if (mpMaster != null) {
					if (bExec)
						((JMenuItemPad) mOpcao).setEnabled(verifAcesso(iCodSis, iCodModu, iOpcao));
					mpMaster.add(mOpcao);
				}
			}
			vOpcoes.addElement(mOpcao);
		} catch (Exception e) {
			Funcoes.mensagemInforma(null, e.getMessage());
			e.printStackTrace();
		}
	}

	public JMenuItem getOpcao(int iOpcao) {

		JMenuItem miRetorno = null;
		JMenuItem miTemp = null;
		int iCodMenu = -1;
		try {
			for (int i = 0; i < vOpcoes.size(); i++) {
				miTemp = vOpcoes.elementAt(i);
				if (miTemp != null) {
					if (miTemp instanceof JMenuPad)
						iCodMenu = ((JMenuPad) miTemp).getCodMenu();
					else if (miTemp instanceof JMenuItemPad)
						iCodMenu = ((JMenuItemPad) miTemp).getCodItem();
					if (iCodMenu == iOpcao) {
						miRetorno = miTemp;
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return miRetorno;
	}

	public void addSeparador(int iSuperMenu) {

		Object oSuper = null;
		try {
			try {
				oSuper = getOpcao(iSuperMenu);
				if (oSuper != null) {
					if (oSuper instanceof JMenu) {
						((JMenu) oSuper).addSeparator();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} finally {
			oSuper = null;
		}

	}

	public JButtonPad addBotao(String sImagem, String sToolTip, String titulo, int iCodMenu,
			Class<? extends IFilho> tela) {

		JButtonPad btOpcao = null;
		try {

			btOpcao = new JButtonPad(iCodSis, iCodModu, iCodMenu, tela, titulo, false);

			btOpcao.setIcon(Icone.novo(sImagem));

			btOpcao.setContentAreaFilled(false);
			btOpcao.setBorderPainted(false);

			if (sToolTip != null) {
				btOpcao.setToolTipText(sToolTip);

			}
			vBotoes.add(btOpcao);
			adicTelaBotao(btOpcao);
			return btOpcao;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Object abreTela(String titulo, Class<? extends IFilho> telaClass) {
		String name = telaClass.getName();
		Object obj = null;
		Object result = null;
		if (!telaPrincipal.temTela(name)) {
			try {
				obj = telaClass.newInstance();
				if (obj instanceof FFDialogo) {
					FFDialogo tela = (FFDialogo) obj;

					Class<?> partypes[] = new Class[2];
					partypes[0] = DbConnection.class;
					partypes[1] = DbConnection.class;
					Method meth = null;
					try {
						meth = telaClass.getMethod("setConexao", partypes);
					} catch (NoSuchMethodException e) {
					}

					telaPrincipal.criatela(titulo, tela, con);
					tela.setTelaPrim(telaPrincipal);

					if (meth != null) {
						Object arglist[] = new Object[2];
						arglist[0] = con;
						arglist[1] = con;
						meth.invoke(obj, arglist);

					}
					result = tela;
				} else if (obj instanceof FFilho) {
					FFilho tela = (FFilho) obj;

					Class<?> partypes[] = new Class[2];
					partypes[0] = DbConnection.class;
					partypes[1] = DbConnection.class;
					Method meth = null;
					try {
						meth = telaClass.getMethod("setConexao", partypes);
					} catch (NoSuchMethodException e) {
					}

					telaPrincipal.criatela(titulo, tela, con);
					tela.setTelaPrim(telaPrincipal);

					if (meth != null) {
						Object arglist[] = new Object[2];
						arglist[0] = con;
						meth.invoke(obj, arglist);
					}
					result = tela;
				} else if (obj instanceof FDialogo) {
					FDialogo tela = (FDialogo) obj;

					Class<?> partypes[] = new Class[2];
					partypes[0] = DbConnection.class;
					partypes[1] = DbConnection.class;
					Method meth = null;
					try {
						meth = telaClass.getMethod("setConexao", partypes);
					} catch (NoSuchMethodException e) {
					}

					telaPrincipal.criatela(titulo, tela, con);

					if (meth != null) {
						Object arglist[] = new Object[2];
						arglist[0] = con;
						arglist[1] = con;
						meth.invoke(obj, arglist);
					}
					result = tela;
				} else {
					Funcoes.mensagemInforma(framePrinc,
							"Tela construída com " + telaClass.getName() + "\n Não pode ser inciada.");
				}
				obj = null;
			} catch (NullPointerException err) {

				StackTraceElement ste = err.getStackTrace()[0];

				int linha = ste.getLineNumber();
				String classe = ste.getClassName();
				String metodo = ste.getMethodName();

				Funcoes.mensagemErro(framePrinc, "Erro de ponteiro nulo ao abrir a tela!\n" + "Classe:" + classe + "\n"
						+ "Metodo:" + metodo + "\n" + "Linha:" + linha, true, con, err);

				err.printStackTrace();
			} catch (Exception err) {
				Funcoes.mensagemErro(framePrinc, err.getMessage(), true, con, err);

				err.printStackTrace();
			}
		}
		return result;
	}	

	public void ajustaMenu() {
		pinBotoes.setPreferredSize(new Dimension(iXPanel + 4, 30));
		Object oMenu = getOpcao(100000000);
		JMenuItem miSair = null;
		if (oMenu != null) {
			if (oMenu instanceof JMenuPad) {
				miSair = new JMenuItemPad("Sair", 'r');
				miSair.addActionListener(this);
				((JMenuPad) oMenu).addSeparator();
				((JMenuPad) oMenu).add(miSair);
			}
		}
		JMenuPad mAjuda = new JMenuPad("Ajuda");
		JMenuItem miSobre = new JMenuItemPad("Sobre");

		miSobre.addActionListener(this);

		mAjuda.add(miSobre);
		JMenuItem miAtalhos = new JMenuItemPad("Atalhos");
		miAtalhos.addActionListener(this);
		mAjuda.add(miAtalhos);

		if (bSuporte) {
			mAjuda.addSeparator();
			JMenuItem miSuporte = new JMenuItemPad("Suporte");
			miSuporte.addActionListener(this);
			mAjuda.add(miSuporte);
		}

		telaPrincipal.bar.add(mAjuda);

	}

	private void buscaMenuItem(JMenu men) {
		for (int i = 0; i < men.getItemCount(); i++) {
			JMenuItem it = men.getItem(i);
			if (it instanceof JMenuPad) {
				if (!upMenuDB(it, (JMenuPad) men))
					break;
				buscaMenuItem((JMenu) it);
			} else if (it instanceof JMenuItemPad) {
				if (!upMenuDB((JMenuItemPad) it, (JMenuPad) men))
					break;
			}
		}
	}

	public void atualizaMenus() {
		JMenuBar menuBar = telaPrincipal.bar;
		try {
			for (int i = 0; i < menuBar.getMenuCount(); i++) {
				if (!upMenuDB(menuBar.getMenu(i), new JMenuPad())) {
					break;
				}
				buscaMenuItem(menuBar.getMenu(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
			Funcoes.mensagemErro(null, "Erro ao atualizar menus!\n" + e.getMessage());
		}
		Funcoes.mensagemInforma(null, "Menus atualizados com sucesso!");
	}	

	private boolean upMenuDB(JMenuItem men, JMenuPad menPai) {
		boolean bRet = false;
		Class<? extends IFilho> tela = null;
		String sNomeMenu = null;
		String sAcaoMenu = null;
		int iCodMenu = 0;
		try {
			if (men instanceof JMenuItemPad) {
				iCodMenu = ((JMenuItemPad) men).getCodItem();
				tela = ((JMenuItemPad) men).getTela();
			} else if (men instanceof JMenuPad) {
				iCodMenu = ((JMenuPad) men).getCodMenu();
			}
			if (tela != null) {
				sNomeMenu = tela.getName();
				sAcaoMenu = tela.getName();
			} else {
				sNomeMenu = "" + iCodMenu;
				sAcaoMenu = "" + iCodMenu;
			}
			if (iCodMenu != 0) {
				// PreparedStatement ps = con.prepareStatement("EXECUTE PROCEDURE SGUPMENUSP01(?,?,?,?,?,?,?,?,?,?,?)");
				// ps.setInt(1, this.iCodSis);
				// ps.setString(2, this.sDescSis);
				// ps.setInt(3, this.iCodModu);
				// ps.setString(4, Funcoes.copy(this.sDescModu, 50));
				// ps.setInt(5, iCodMenu);
				// ps.setString(6, men.getText());
				// ps.setString(7, sNomeMenu);
				// ps.setString(8, sAcaoMenu);

				// if (menPai.getCodMenu() == 0) {
				// 	ps.setNull(9, java.sql.Types.INTEGER);
				// 	ps.setNull(10, java.sql.Types.INTEGER);
				// 	ps.setNull(11, java.sql.Types.INTEGER);
				// } else {
				// 	ps.setInt(9, menPai.getCodModulo());
				// 	ps.setInt(10, menPai.getCodModulo());
				// 	ps.setInt(11, menPai.getCodMenu());
				// }
				// ps.execute();
				// ps.close();
				// con.commit();
			}
			bRet = true;
		} catch( Exception err ) {
			Funcoes.mensagemInforma(telaPrincipal,
					"Não foi possível atualizar a base de menus!\n" + err + "\n" + this.iCodSis + ", this.sDescSis \n" + this.iCodModu + 
					", + this.sDescModu \n" + "acao: " + sAcaoMenu + "\n" + "nome:"
					+ sNomeMenu + "\n" + iCodMenu + "," + men.getText() + "\n" + "," + menPai.getCodMenu());
		} finally {
			tela = null;
			sNomeMenu = null;
			sAcaoMenu = null;
			iCodMenu = 0;
		}
		return bRet;
	}

	public void show() {
		telaPrincipal.setVisible(true);
	}

	public void adicTelaBotao(JButtonPad bt) {

		pinBotoes.setBorder(null);

		bt.setEnabled(verifAcesso(bt.getCodSistema(), bt.getCodModulo(), bt.getCodItem()));

		pinBotoes.add(bt, iXPanel, 0, 30, 30);

		bt.addActionListener(this);
		iXPanel += 30;

	}

	public boolean verifAcesso(int iCodSisP, int iCodModuP, int iCodMenuP) {
        boolean ret = true;
        return ret;
    };    

	public static Aplicativo getInstace() {
		return instance;
	}

	public void actionPerformed( ActionEvent evt ) {
		Object oTemp = evt.getSource();
		int iCodMenu = -1;
		if (oTemp != null) {
			if (oTemp instanceof JButtonPad) {
				if (((JButtonPad) oTemp) == btAtualMenu) {
					atualizaMenus();
				} else {
					iCodMenu = ((JButtonPad) oTemp).getCodItem();
				}
			} else if (oTemp instanceof JMenuItemPad && !(((JMenuItem) oTemp).getText().equals("Sair"))
					&& !(((JMenuItem) oTemp).getText().equals("Sobre"))
					&& !(((JMenuItem) oTemp).getText().equals("Atalhos"))
					&& !(((JMenuItem) oTemp).getText().equals("Suporte"))) {
				iCodMenu = ((JMenuItemPad) oTemp).getCodItem();
			} else if (oTemp instanceof JMenuPad && !(((JMenuItem) oTemp).getText().equals("Sobre"))) {
				iCodMenu = ((JMenuPad) oTemp).getCodMenu();
			} else if (oTemp instanceof JMenuItemPad) {
				if (((JMenuItem) oTemp).getText().equals("Sair")) {
					telaPrincipal.fecharJanela();
				// } else if (((JMenuItem) oTemp).getText().equals("Sobre")) {
				// 	FSobre tela = new FSobre();
				// 	tela.setVisible(true);
				// 	tela.dispose();
				// } else if (((JMenuItem) oTemp).getText().equals("Atalhos")) {
				// 	FAtalhos tela = new FAtalhos();
				// 	tela.setVisible(true);
				// 	tela.dispose();
				// } else if (((JMenuItem) oTemp).getText().equals("Suporte")) {
				// 	FSuporte tela = new FSuporte();
				// 	tela.setConexao(con);
				// 	tela.setVisible(true);
				// 	tela.dispose();
				}
			}
			if (iCodMenu != -1) {
				Class<? extends IFilho> telaClass = null;
				String titulo = "";
				if (oTemp instanceof JMenuItemPad) {
					telaClass = ((JMenuItemPad) oTemp).getTela();
					if (telaClass != null) {
						titulo = ((JMenuItemPad) oTemp).getTitulo();
					}
				} else if (oTemp instanceof JButtonPad) {
					telaClass = ((JButtonPad) oTemp).getTela();
					if (telaClass != null) {
						titulo = ((JButtonPad) oTemp).getTitulo();
					}
				}
				if (telaClass != null) {
					abreTela(titulo, telaClass);
				}
			}
		}
	}


	@Override
	public void keyTyped(KeyEvent e) { }

	@Override
	public void keyPressed(KeyEvent e) { }

	@Override
	public void keyReleased(KeyEvent e) { }

}
