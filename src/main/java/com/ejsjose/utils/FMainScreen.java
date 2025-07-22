package com.ejsjose.utils;

import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;

public abstract class FMainScreen extends JFrame implements ActionListener, MouseListener, WindowListener {

    private static final long serialVersionUID = 1L;

	public FMainScreen(String sDirImagem, String sImgFundo) {

		this(sDirImagem, sImgFundo, null, null, null, null, null);
	}   
    
    public FMainScreen(String sDirImagem, String sImgFundo, String sTitulo, String sIcone, String sIconePequeno, String sIconeGrande, String sIconeGrande2) {
        super(sTitulo);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza a janela para ocupar toda a tela
        setUndecorated(false); // Mantém a barra de título e bordas
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao fechar a janela
    }

}
