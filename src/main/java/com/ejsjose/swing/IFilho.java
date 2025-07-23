package com.ejsjose.swing;

import java.awt.Component;
import java.awt.Container;

public interface IFilho {
	public abstract void setTitulo(String tit, String name);

	public abstract void setAtribos(int Esq, int Topo, int Larg, int Alt);

	public abstract void setTela(Container c);

	public abstract Container getTela();

	public abstract JPanelPad adicBotaoSair();

	public abstract void setFirstFocus(Component firstFocus);

	public abstract void firstFocus();

	// public abstract void setConexao(DbConnection cn) throws ExceptionSetConexao;

	public abstract void execShow();

	public abstract boolean getInitFirstFocus();

	public abstract void setInitFirstFocus(boolean initFirstFocus);

	public abstract void setTelaPrim(FMainScreen fP);
}