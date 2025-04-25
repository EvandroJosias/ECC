package com.ecc.view;

import com.Controllers.FileTypeFilter;
import com.Controllers.Processamento;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.Vector;

public class MainWindows extends JFrame  {
    // toolbar
    private static final DecimalFormat df = new DecimalFormat("0.00");

    private JToolBar tb;

    private JTextArea Origem;
 
    // buttons
    private JButton b1, b2, b3, b4;
 
    // create a combo box
    private JTable Destino;

    private JLabel Title;


    public MainWindows( String pTitle )  {
 
        // create a frame
        super( pTitle );
        
        // set layout for frame
        setLayout(new BorderLayout());
 
        // create a toolbar
        tb = new JToolBar();
 
        Origem = new JTextArea(10,20);
        Origem.setBackground(new Color(1,1,1, (float) 0.01));

        String[] columnNames = { "Quantidade", "Resto", "Medida 01", "Medida 02", "Medida 03", "Medida 04", "Medida 05", "Medida 06", "Medida 07", "Medida 08", "Medida 09", "Medida 10" };
        String[][] data ={{ "Quantidade", "Resto", "Medida 01", "Medida 02", "Medida 03", "Medida 04", "Medida 05", "Medida 06", "Medida 07", "Medida 08", "Medida 09", "Medida 10" }};

        Destino = new JTable(data, columnNames);
        

        // create a panel
        JPanel p = new JPanel();
 
        // create new buttons
        b1 = new JButton("Resetar");
        b2 = new JButton("Abrir");
        b3 = new JButton("Processar");
        b4 = new JButton("Salvar");

        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Origem.setText("");
                DefaultTableModel dm = (DefaultTableModel)Destino.getModel();
                while( Destino.getRowCount() > 1 ) {
                    dm.removeRow( Destino.getRowCount() -1 );
                }
            }
        });

        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JFileChooser fs = new JFileChooser(new File(System.getProperty("user.home")));
                fs.setDialogTitle("Abrir Arquivo");
                fs.setFileFilter(new FileTypeFilter(".csv", "arquivo scv"));
                int result = fs.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    try {
                        File fi = fs.getSelectedFile();
                        BufferedReader br = new BufferedReader(new FileReader(fi.getPath()));
                        String Line = "";
                        String s = "";
                        while ((s = br.readLine()) != null) {
                            Line += s + '\n';
                        }
                        Origem.setText(Line);
                        if (br != null)
                            br.close();
                    } catch (Exception error) {
                        JOptionPane.showMessageDialog(null, error.getMessage());
                    }
                };
            }
        });

        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JOptionPane.showMessageDialog(null,"Processando os dados....");
                Processamento fnc = new Processamento();
                Vector<Double> valor = new Vector();
                String aux = Origem.getText().replaceAll(",", ".");
                fnc.setTextoEntrada(aux);

                long start = System.currentTimeMillis();

                fnc.Processar();

                long elapsed = System.currentTimeMillis() - start;
                System.out.println( elapsed );
                // Está aqui o erro na criação do modelo da tabela
                //DefaultTableModel dm = (DefaultTableModel) Destino.getModel();
                DefaultTableModel dm = new DefaultTableModel();
                while( Destino.getRowCount() > 1 ) {
                    dm.removeRow( Destino.getRowCount() -1 );
                }
                Vector<String> cab = new Vector();
                if( dm.getColumnCount() < 2 ) {
                    cab.add("Quantidade");
                    cab.add("Resto");
                    dm.addColumn("Quantidade");
                    dm.addColumn("Resto");
                }
                System.out.println("total de colunas " + fnc.getTotalcolunas());
                for( int i = dm.getColumnCount(); i < fnc.getTotalcolunas(); i++) {
                    dm.addColumn("Medida"+Integer.toString(i-1));
                    cab.add("Medida "+Integer.toString(i-1));
                }
                System.out.println( cab );
                dm.addRow( cab );
                for(int i = 0; i < fnc.getResultado().size(); i++ ) {
                    Vector<String> vet = new Vector();
                    for( int x = 0; x < fnc.getResultado().get(i).size(); x++ ) {
                        vet.add( df.format( fnc.getResultado().get(i).get(x) ) );
                    }
                    dm.addRow( vet );
                }
                Destino.setModel( dm );
            }
        });

        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MessageFormat header = new MessageFormat("Relatório");
                MessageFormat footer = new MessageFormat("XXX");
                try{
                    PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
                    set.add(OrientationRequested.LANDSCAPE);
                    Destino.print(JTable.PrintMode.FIT_WIDTH);

                }catch (java.awt.print.PrinterException E){
                    JOptionPane.showMessageDialog(null,E);
                }
            }
        });

        //Estiliação//

        Title = new JLabel("Contador   ");
        Font fontTamanho =  new Font("serif",Font.PLAIN,34);
        Title.setFont(fontTamanho);
        Title.setForeground(Color.WHITE);
        b1.setBackground(Color.white);
        b2.setBackground(Color.white);
        b3.setBackground(Color.white);
        b4.setBackground(Color.white);
        b1.setForeground(Color.black);
        b2.setForeground(Color.black);
        b3.setForeground(Color.black);
        b4.setForeground(Color.black);
        p.add(Title);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.setBackground(Color.decode("#2F4F4F"));
        tb.add(p);
 
        add(tb, BorderLayout.NORTH);
        Font fontOrigem =  new Font("serif",Font.PLAIN,18);
        Font fontDestino =  new Font("serif",Font.PLAIN,16);
        Destino.setFont(fontDestino);
        Origem.setFont(fontOrigem);
        Origem.setBackground(Color.decode("#2F4F4F"));
        Origem.setForeground(Color.WHITE);
        add(Origem, BorderLayout.WEST);
        add(Destino, BorderLayout.CENTER);

        Toolkit kit = Toolkit.getDefaultToolkit();  
        Dimension tamTela = kit.getScreenSize();  

        // set the size of the frame
        setSize(tamTela.width, tamTela.height);
    }
    
}
