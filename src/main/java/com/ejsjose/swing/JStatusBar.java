package com.ejsjose.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.Timer;

import javax.swing.BorderFactory;

public class JStatusBar extends JPanelPad {

	private static final long serialVersionUID = 1L;
	private JPanelPad pnEst = new JPanelPad(JPanelPad.TP_JPANEL, new BorderLayout());
	private JPanelPad pnCentro = new JPanelPad(JPanelPad.TP_JPANEL, new BorderLayout());
	private JPanelPad pnEsquerda = new JPanelPad(JPanelPad.TP_JPANEL, new BorderLayout());
	private JPanelPad pnDescEst = new JPanelPad(JPanelPad.TP_JPANEL, new BorderLayout());
	private JPanelPad pnFilial = new JPanelPad(JPanelPad.TP_JPANEL, new BorderLayout());
	private JPanelPad pnNomeFilial = new JPanelPad(JPanelPad.TP_JPANEL, new BorderLayout());
	private JPanelPad pnUsuario = new JPanelPad(JPanelPad.TP_JPANEL, new BorderLayout());
	private JPanelPad pnInfo = new JPanelPad(JPanelPad.TP_JPANEL, new BorderLayout());
	private JPanelPad pnRelogio = new JPanelPad(JPanelPad.TP_JPANEL, new BorderLayout());
	private JPanelPad pnIconFilial = new JPanelPad(JPanelPad.TP_JPANEL, new BorderLayout());
	private JPanelPad pnIconEst = new JPanelPad(JPanelPad.TP_JPANEL, new BorderLayout());
	private JPanelPad pnIconInfo = new JPanelPad(JPanelPad.TP_JPANEL, new BorderLayout());
	private JPanelPad pnIDUSU = new JPanelPad(JPanelPad.TP_JPANEL, new BorderLayout());
	private JPanelPad pnDescInfo = new JPanelPad(JPanelPad.TP_JPANEL, new BorderLayout());
	private JPanelPad pnIconUsuario = new JPanelPad(JPanelPad.TP_JPANEL, new BorderLayout());
	private JLabelPad lFilial = new JLabelPad();
	private JLabelPad lEst = new JLabelPad();
	private JLabelPad lUsuario = new JLabelPad();
	private JLabelPad lInfo = new JLabelPad();
	private JLabelPad lRelogio = new JLabelPad();
	private int iNumEst = 0;
	private int iCodFilial = 0;
	private String sNomeFilial = "";
	private String sDescEst = "";
	private String sIDUsu = "";

	// private Icone.novo("btCalc.gif")

	/**
	 * @param arg0
	 * @param arg1
	 */
	public JStatusBar(LayoutManager arg0, boolean arg1) {
		super(JPanelPad.TP_JPANEL, arg0, arg1);
		MontaStatusBar();
	}

	/**
	 * @param arg0
	 */
	public JStatusBar(LayoutManager arg0) {
		super(JPanelPad.TP_JPANEL, arg0);
		MontaStatusBar();
	}

	/**
	 * @param arg0
	 */
	public JStatusBar(boolean arg0) {
		super(JPanelPad.TP_JPANEL, arg0);
		MontaStatusBar();
	}

	/**
	 * 
	 */
	public JStatusBar() {
		super();
		MontaStatusBar();
	}

	private void MontaStatusBar() {
		this.setFont(SwingParams.getFontpad());
		montaStatus();
		Timer tm = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				upRelogio();
			}
		});
		tm.start();
	}

	private void montaStatus() {

		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(300, 25));
		this.setBorder(BorderFactory.createRaisedBevelBorder());

		pnNomeFilial.add(lFilial);
		pnDescEst.add(lEst);
		pnIDUSU.add(lUsuario);
		pnDescInfo.add(lInfo);

		lFilial.setPreferredSize(new Dimension(260, 20));
		lFilial.setFont(new Font("Arial", Font.PLAIN, 12));
		lFilial.setForeground(new Color(118, 89, 170));

		lEst.setPreferredSize(new Dimension(100, 20));
		lEst.setFont(new Font("Arial", Font.PLAIN, 12));
		lEst.setForeground(new Color(118, 89, 170));

		lUsuario.setPreferredSize(new Dimension(100, 20));
		lUsuario.setFont(new Font("Arial", Font.PLAIN, 12));
		lUsuario.setForeground(new Color(118, 89, 170));

		lInfo.setPreferredSize(new Dimension(180, 20));
		lInfo.setFont(new Font("Arial", Font.PLAIN, 12));
		lInfo.setForeground(new Color(118, 89, 170));

		pnFilial.setPreferredSize(new Dimension(180, 23));
		pnFilial.setBorder(BorderFactory.createLoweredBevelBorder());

		pnEst.setPreferredSize(new Dimension(180, 23));
		pnEst.setBorder(BorderFactory.createLoweredBevelBorder());
		// pnEst.add(lEst, BorderLayout.WEST);

		pnInfo.setBorder(BorderFactory.createLoweredBevelBorder());

		pnFilial.add(pnIconFilial, BorderLayout.WEST);
		pnFilial.add(pnNomeFilial, BorderLayout.CENTER);

		pnEst.add(pnIconEst, BorderLayout.WEST);
		pnEst.add(pnDescEst, BorderLayout.CENTER);

		pnUsuario.add(pnIconUsuario, BorderLayout.WEST);
		pnUsuario.add(pnIDUSU, BorderLayout.CENTER);

		pnInfo.add(pnIconInfo, BorderLayout.WEST);
		pnInfo.add(pnDescInfo, BorderLayout.CENTER);

		pnUsuario.setBorder(BorderFactory.createLoweredBevelBorder());
		// pnUsuario.add(lUsuario, BorderLayout.WEST);

		pnEsquerda.add(pnFilial, BorderLayout.WEST);
		pnEsquerda.add(pnEst, BorderLayout.CENTER);
		pnCentro.add(pnUsuario, BorderLayout.WEST);
		pnCentro.add(pnInfo, BorderLayout.CENTER);

		this.add(pnEsquerda, BorderLayout.WEST);
		this.add(pnCentro, BorderLayout.CENTER);

		lRelogio.setPreferredSize(new Dimension(125, 20));
		lRelogio.setFont(new Font("Arial", Font.PLAIN, 12));
		lRelogio.setForeground(new Color(118, 89, 170));
//		lRelogio.setHorizontalAlignment(SwingConstants.CENTER);

		pnRelogio.setBorder(BorderFactory.createLoweredBevelBorder());
		pnRelogio.add(lRelogio, BorderLayout.CENTER);
		this.add(pnRelogio, BorderLayout.EAST);

		// c.add(pnStatus, BorderLayout.SOUTH);
	}

	public void upRelogio() {
		String hora = "", minuto = "";
		String dia = "", mes = "", ano = "";
		Calendar cal = Calendar.getInstance();
		hora = "" + ( cal.get(Calendar.HOUR_OF_DAY) );
		minuto = "" + ( cal.get(Calendar.MINUTE) );
		minuto = minuto.length() > 1 ? minuto : "0" + minuto;
		dia = "" + ( cal.get(Calendar.DAY_OF_MONTH) );
		dia = dia.length() > 1 ? dia : "0" + dia;
		mes = "" + ( cal.get(Calendar.MONTH) + 1 );
		mes = mes.length() > 1 ? mes : "0" + mes;
		ano = "" + ( cal.get(Calendar.YEAR) );
		lRelogio.setText(dia + "/" + mes + "/" + ano + " " + hora + ":" + minuto);
		lRelogio.repaint();
	}

	public void setCodFilial(int iCodFilial) {
		this.iCodFilial = iCodFilial;
		ajustaFilial();
	}

	public void setUsuario(String sIDUsu) {
		this.sIDUsu = sIDUsu.trim();
		lUsuario.setText(sIDUsu);

	}

	public void setNumEst(int iNumEst) {
		this.iNumEst = iNumEst;
		ajustaEst();
	}

	public void setNomeFilial(String sNomeFilial) {
		this.sNomeFilial = sNomeFilial;
		ajustaFilial();
	}

	public void setDescEst(String sDescEst) {
		this.sDescEst = sDescEst;
		ajustaEst();
	}

	public int getCodFilial() {
		return iCodFilial;
	}

	public int getNumEst() {
		return iNumEst;
	}

	public String getDescEst() {
		return sDescEst;
	}

	public String getUsuario() {
		return sIDUsu;
	}

	public String getNomeFilial() {
		return sNomeFilial;
	}

	private void ajustaEst() {
		lEst.setText(( " " + iNumEst + "-" + sDescEst.trim() ));
	}

	private void ajustaFilial() {
		lFilial.setText(( " " + iCodFilial + "-" + sNomeFilial.trim() ));
	}

	public void setInfo(String sTexto) {
		if (sTexto == null)
			sTexto = "";
		else
			sTexto = sTexto.trim();
		lInfo.setText(sTexto);
	}

}
