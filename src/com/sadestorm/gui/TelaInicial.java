package com.sadestorm.gui;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaInicial extends JFrame {

	public static TelaInicial frame;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/*
	 * usuario login total, apenas para gestores
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new TelaInicial();
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
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCaixa = new JLabel("");
		lblCaixa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
				TelaVenda telaVenda = new TelaVenda();
				telaVenda.setVisible(true);

			}
		});
		lblCaixa.setBounds(10, 27, 148, 148);
		ImageIcon iconCai = new ImageIcon("D:\\Projetos Java\\StockSales\\icones\\caixa.png");
		iconCai.setImage(iconCai.getImage().getScaledInstance(105, 100, 100));
		lblCaixa.setIcon(iconCai);
		contentPane.add(lblCaixa);

		JLabel lblCadProduto = new JLabel("");
		ImageIcon iconCadProduto = new ImageIcon("D:\\Projetos Java\\StockSales\\icones\\produto.png");
		iconCadProduto.setImage(iconCadProduto.getImage().getScaledInstance(105, 100, 100));
		lblCadProduto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				TelaCadastroProdutos tealCadastroProdutos = new TelaCadastroProdutos();
				tealCadastroProdutos.setVisible(true);

			}
		});
		lblCadProduto.setBounds(168, 27, 148, 148);
		lblCadProduto.setIcon(iconCadProduto);
		contentPane.add(lblCadProduto);

		JLabel lblCadCliente = new JLabel("");
		ImageIcon iconCadCliente = new ImageIcon("D:\\Projetos Java\\StockSales\\icones\\cliente.png");
		iconCadCliente.setImage(iconCadCliente.getImage().getScaledInstance(105, 100, 100));
		lblCadCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				TelaCadastroUsuario tealCadastroCliente = null;
				try {
					tealCadastroCliente = new TelaCadastroUsuario();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tealCadastroCliente.setVisible(true);
			}
		});
		lblCadCliente.setBounds(332, 27, 148, 148);
		lblCadCliente.setIcon(iconCadCliente);
		contentPane.add(lblCadCliente);
	}

}
