package com.ejsjose.swing;

import java.awt.Cursor;
import javax.swing.JMenuItem;

public class JMenuItemPad extends JMenuItem {

	private static final long serialVersionUID = 1L;
	private int iCodSys = 0;
	private int iCodMod = 0;
	private int iCodIt = 0;
	private int iCodNiv = 0;
	private Class<? extends IFilho> tela = null;
	private String titulo = "";

	public String getTitulo() {
		return titulo;
	}

	public int getICodIt() {
		return iCodIt;
	}

	public int getICodMod() {
		return iCodMod;
	}

	public int getICodNiv() {
		return iCodNiv;
	}

	public int getICodSys() {
		return iCodSys;
	}

	public Class<? extends IFilho> getTela() {
		return tela;
	}

	/**
	 * Construtor da classe JMenuItem(). <BR>
	 * 
	 */

	public JMenuItemPad() {
		this(0, 0, 0, 0, null, "");
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	public JMenuItemPad(String s, char c) {
		super(s, c);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	/**
	 * Construtor da classe JMenuItem(). <BR>
	 * 
	 */

	public JMenuItemPad(String menu) {
		super(menu);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	/**
	 * Construtor da classe JMenu(). <BR>
	 * Construtor que ja ajusta os paramatros basicos do JMenuPad.
	 * 
	 * @param tela
	 * @param titulo
	 * 
	 */

	public JMenuItemPad(int iCodSistema, int iCodModulo, int iCodItem, int iCodNivel, Class<? extends IFilho> tela, String titulo) {
		iCodSys = iCodSistema;
		iCodMod = iCodModulo;
		iCodIt = iCodItem;
		iCodNiv = iCodNivel;
		this.tela = tela;
		this.titulo = titulo;
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	/**
	 * Ajusta o código do sistema. <BR>
	 * 
	 * @param iCod
	 *            - Código do sistema.
	 * @see #getCodSistema
	 * 
	 */

	public void setCodSistema(int iCod) {
		iCodSys = iCod;
	}

	/**
	 * Retorna o código do sistema. <BR>
	 * 
	 * @return Código do sistema ou zero se o código não foi definido.
	 * @see #setCodSistema
	 * 
	 */

	public int getCodSistema() {
		return iCodSys;
	}

	/**
	 * Ajusta o código do módulo do sistema. <BR>
	 * 
	 * @param iCod
	 *            - Código do módulo.
	 * @see #getCodModulo
	 * 
	 */

	public void setCodModulo(int iCod) {
		iCodMod = iCod;
	}

	/**
	 * Retorna o código do módulo do sistema. <BR>
	 * 
	 * @return Código do módulo ou zero se o código não foi definido.
	 * @see #setCodModulo
	 * 
	 */

	public int getCodModulo() {
		return iCodMod;
	}

	/**
	 * Ajusta o código do item. <BR>
	 * O código do item é composto da seguinte forma: <BR>
	 * 8 casas decimais (caso casas da direita nao usadas colocar 0)<BR>
	 * e mais uma unidade para detalhamentos longos. agrupadas de dois em dois,
	 * ex: 19|26|03|17|8. <BR>
	 * <BR>
	 * No exemplo o código do menu principal é: 19<BR>
	 * submenu1: 26<BR>
	 * submenu2: 03<BR>
	 * submenu3: 17<BR>
	 * item: 8<BR>
	 * 
	 * @param iItem
	 *            - Código do item.
	 * @see #getCodItem
	 * 
	 */

	public void setCodItem(int iCod) {
		iCodIt = iCod;
	}

	/**
	 * Retorna o código do item.
	 * 
	 * @return Código do item ou zero se o código não foi definido.
	 * @see #setCodItem
	 * 
	 */

	public int getCodItem() {
		return iCodIt;
	}

	/**
	 * Ajusta o nível do item. <BR>
	 * O nível especifica que nível de detalhe que o<BR>
	 * menu se encontra.
	 * 
	 * @param iNivel
	 *            - Nível do menu pode ser: 1,2,3,4.
	 * 
	 * @see #getCodNivel
	 * 
	 */

	public void setNivel(int iNivel) {
		iCodNiv = iNivel;
	}

	/**
	 * Retorna o nível do item. <BR>
	 * 
	 * @return Nível.
	 * @see #setNivel
	 * 
	 */

	public int getCodNivel() {
		return iCodNiv;
	}
}
