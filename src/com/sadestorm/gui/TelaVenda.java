package com.sadestorm.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class TelaVenda extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodProduto;
	private JTextField txtQuantidade;
	private JTextField txtTotal;
	private JTable table;
	private JTextField txtSubTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVenda frame = new TelaVenda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public JRadioButton rdbtnAVista;
	public JRadioButton rdbtnCartaoDeCredito;
	public JButton btnMaster;
	public JButton btnVisa;
	public JButton btnElo;
	
	public TelaVenda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodProduto = new JLabel("Cod. Produto ");
		lblCodProduto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCodProduto.setBounds(10, 45, 106, 14);
		contentPane.add(lblCodProduto);
		
		txtCodProduto = new JTextField();
		txtCodProduto.setBounds(10, 63, 156, 20);
		contentPane.add(txtCodProduto);
		txtCodProduto.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQuantidade.setBounds(10, 94, 92, 14);
		contentPane.add(lblQuantidade);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(10, 111, 156, 20);
		contentPane.add(txtQuantidade);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotal.setBounds(10, 142, 68, 14);
		contentPane.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setColumns(10);
		txtTotal.setBounds(10, 160, 156, 20);
		contentPane.add(txtTotal);
		
		table = new JTable();
		table.setBounds(176, 46, 583, 266);
		contentPane.add(table);
		
		txtSubTotal = new JTextField();
		txtSubTotal.setBackground(Color.WHITE);
		txtSubTotal.setEditable(false);
		txtSubTotal.setBounds(10, 269, 156, 43);
		contentPane.add(txtSubTotal);
		txtSubTotal.setColumns(10);
		
		JLabel lblSubTotal = new JLabel("Sub. Total");
		lblSubTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSubTotal.setBounds(10, 248, 136, 20);
		contentPane.add(lblSubTotal);
	
		JButton btnFinalizarVenda = new JButton("FINALIZAR PEDIDO");
	
		btnFinalizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnFinalizarVenda.setBounds(574, 337, 174, 43);
		ImageIcon icon = new ImageIcon("D:\\Projetos Java\\StockSales\\icones\\ok.png");
		icon.setImage(icon.getImage().getScaledInstance(25, 25, 1));
		btnFinalizarVenda.setIcon(icon);
		contentPane.add(btnFinalizarVenda);
		
		rdbtnCartaoDeCredito = new JRadioButton("Cat\u00E3o de Credito");
		rdbtnCartaoDeCredito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnAVista.setSelected(false);
				btnElo.setEnabled(true);
				btnMaster.setEnabled(true);
				btnVisa.setEnabled(true);
			}
		});
		rdbtnCartaoDeCredito.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnCartaoDeCredito.setBounds(10, 187, 136, 23);
		contentPane.add(rdbtnCartaoDeCredito);
		
		rdbtnAVista = new JRadioButton("A Vista");
		rdbtnAVista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnCartaoDeCredito.setSelected(false);
				btnElo.setEnabled(false);
				btnMaster.setEnabled(false);
				btnVisa.setEnabled(false);
			}
		});
		rdbtnAVista.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnAVista.setBounds(10, 218, 136, 23);
		contentPane.add(rdbtnAVista);
		
		btnMaster = new JButton("");
		btnMaster.setEnabled(false);
		btnMaster.setBounds(30, 337, 89, 43);
		ImageIcon iconMaster = new ImageIcon("D:\\Projetos Java\\StockSales\\icones\\master.png");
		iconMaster.setImage(iconMaster.getImage().getScaledInstance(65, 65, 1));
		btnMaster.setIcon(iconMaster);
		contentPane.add(btnMaster);
		
		btnVisa = new JButton("");
		btnVisa.setEnabled(false);
		btnVisa.setBounds(128, 337, 89, 43);
		ImageIcon iconVisa = new ImageIcon("D:\\Projetos Java\\StockSales\\icones\\visa.png");
		iconVisa.setImage(iconVisa.getImage().getScaledInstance(65, 65, 1));
		btnVisa.setIcon(iconVisa);
		contentPane.add(btnVisa);
		
		btnElo = new JButton("");
		btnElo.setEnabled(false);
		btnElo.setBounds(231, 337, 89, 43);
		ImageIcon iconElo = new ImageIcon("D:\\Projetos Java\\StockSales\\icones\\elo.png");
		iconElo.setImage(iconElo.getImage().getScaledInstance(50, 50, 1));
		btnElo.setIcon(iconElo);
		contentPane.add(btnElo);
	}
}
