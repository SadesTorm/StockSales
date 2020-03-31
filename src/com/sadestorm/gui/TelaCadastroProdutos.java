package com.sadestorm.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.sadestorm.dao.ConexaoDb;

public class TelaCadastroProdutos extends JFrame {

	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	private JPanel contentPane;
	private JTextField txtMarcaProduto;
	private JTextField txtModeloProduto;
	private JTextField txtPrecoProduto;
	private JTextField txtQtdProduto;
	private JTextField txtCorProduto;

	private JComboBox comboBoxCategoriaProduto;
	private JTextField txtTamanhoProduto;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TelaCadastroProdutos() {

		// inicia conexao com o banco de dados para consulta
		conexao = ConexaoDb.conector();
		System.out.println(conexao);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 374, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMarca = new JLabel("MARCA:");
		lblMarca.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMarca.setBounds(10, 176, 56, 14);
		contentPane.add(lblMarca);

		JLabel lblModelo = new JLabel("MODELO:");
		lblModelo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblModelo.setBounds(10, 204, 56, 14);
		contentPane.add(lblModelo);

		JLabel lblValor = new JLabel("PRE\u00C7O:");
		lblValor.setBounds(143, 264, 46, 14);
		contentPane.add(lblValor);

		JLabel lblQuantidade = new JLabel("QTD:");
		lblQuantidade.setHorizontalAlignment(SwingConstants.TRAILING);
		lblQuantidade.setBounds(10, 264, 56, 14);
		contentPane.add(lblQuantidade);

		txtMarcaProduto = new JTextField();
		txtMarcaProduto.setBounds(87, 173, 208, 20);
		contentPane.add(txtMarcaProduto);
		txtMarcaProduto.setColumns(10);

		txtModeloProduto = new JTextField();
		txtModeloProduto.setBounds(87, 201, 208, 20);
		contentPane.add(txtModeloProduto);
		txtModeloProduto.setColumns(10);

		txtPrecoProduto = new JTextField();
		txtPrecoProduto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!((e.getKeyChar() >= KeyEvent.VK_0 && e.getKeyChar() <= KeyEvent.VK_9)
						|| (e.getKeyChar() == KeyEvent.VK_ENTER || e.getKeyChar() == KeyEvent.VK_SPACE
								|| e.getKeyChar() == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
				}
			}
		});

		txtPrecoProduto.setBounds(190, 261, 105, 20);
		txtPrecoProduto.setColumns(10);
		contentPane.add(txtPrecoProduto);

		txtQtdProduto = new JTextField();
		txtQtdProduto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!((e.getKeyChar() >= KeyEvent.VK_0 && e.getKeyChar() <= KeyEvent.VK_9)
						|| (e.getKeyChar() == KeyEvent.VK_ENTER || e.getKeyChar() == KeyEvent.VK_SPACE
								|| e.getKeyChar() == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
				}
			}
		});
		txtQtdProduto.setBounds(87, 261, 46, 20);
		txtQtdProduto.setColumns(10);
		contentPane.add(txtQtdProduto);

		comboBoxCategoriaProduto = new JComboBox();
		comboBoxCategoriaProduto.setBounds(87, 323, 208, 22);
		comboBoxCategoriaProduto.setModel(
				new DefaultComboBoxModel(new String[] { "Categoria do Produto", "Tenis", "Relogio", "Bone" }));
		contentPane.add(comboBoxCategoriaProduto);

		JLabel lblCor = new JLabel("COR:");
		lblCor.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCor.setBounds(10, 233, 56, 14);
		contentPane.add(lblCor);

		txtCorProduto = new JTextField();
		txtCorProduto.setBounds(87, 229, 208, 20);
		txtCorProduto.setColumns(10);
		contentPane.add(txtCorProduto);

		JButton btnSalvat = new JButton("SALVAR");
		btnSalvat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (txtCorProduto.getText().equals("") || txtMarcaProduto.getText().equals("")
						|| txtModeloProduto.getText().equals("") || txtPrecoProduto.getText().equals("")
						|| txtQtdProduto.getText().equals("") || txtTamanhoProduto.getText().equals("")
						|| comboBoxCategoriaProduto.getSelectedItem().equals("Categoria do Produto")) {

					JOptionPane.showMessageDialog(null, "Preencha Todos Os Campos");

				} else {

					CadastrarProduto();
					LimparCampos();

				}
			}
		});
		btnSalvat.setBounds(200, 356, 95, 23);
		contentPane.add(btnSalvat);

		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				LimparCampos();

			}
		});
		btnCancelar.setBounds(87, 356, 102, 23);
		contentPane.add(btnCancelar);

		JButton btnNewButton = new JButton("SAIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				TelaInicial.frame.setVisible(true);
				dispose();

			}
		});
		btnNewButton.setBounds(87, 390, 208, 23);
		contentPane.add(btnNewButton);

		JLabel lblCadastrarProdutos = new JLabel("CADASTRAR PRODUTO");
		lblCadastrarProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarProdutos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadastrarProdutos.setBounds(87, 132, 208, 14);
		contentPane.add(lblCadastrarProdutos);

		JLabel lblLogoCad = new JLabel("");
		lblLogoCad.setBounds(120, 11, 135, 120);
		ImageIcon icon = new ImageIcon("D:\\Projetos Java\\StockSales\\icones\\logoHl.png");
		icon.setImage(icon.getImage().getScaledInstance(lblLogoCad.getWidth(), lblLogoCad.getHeight(), 1));
		lblLogoCad.setIcon(icon);
		contentPane.add(lblLogoCad);

		JLabel lblTamanho = new JLabel("TAMANHO:");
		lblTamanho.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTamanho.setBounds(0, 295, 67, 14);
		contentPane.add(lblTamanho);

		txtTamanhoProduto = new JTextField();
		txtTamanhoProduto.setColumns(10);
		txtTamanhoProduto.setBounds(87, 292, 46, 20);
		contentPane.add(txtTamanhoProduto);

	}

	private void CadastrarProduto() {
		String sql = "insert into tbProduto(marcaProduto,modeloProduto,corProduto,categoriaProduto,qtdproduto,valorproduto,tamanhoProduto) values(?,?,?,?,?,?,?)";

		try {

			/*
			 * private JTextField txtModeloProduto; private JTextField txtPrecoProduto;
			 * private JTextField txtQtdProduto; private JTextField txtCorProduto
			 */

			pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, txtMarcaProduto.getText());
			pst.setString(2, txtModeloProduto.getText());
			pst.setString(3, txtCorProduto.getText());
			pst.setString(4, comboBoxCategoriaProduto.getSelectedItem().toString());
			pst.setInt(5, 0);
			pst.setFloat(5, Float.parseFloat(txtPrecoProduto.getText()));
			pst.setString(6, txtTamanhoProduto.getText());
			pst.executeUpdate();

			final ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {

				int qtd = Integer.parseInt(txtQtdProduto.getText());
				// incrementa a quantidade do produto
				pst = conexao.prepareStatement(
						"UPDATE tbProduto SET qtdproduto = qtdproduto +" + qtd + "  WHERE idproduto =" + rs.getInt(1));
				pst.execute();

				CadastraProdutoStock(rs.getInt(1));
			}
			rs.close();
			// System.out.println("id do produto cadastrado" + rs.getInt(1));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void CadastraProdutoStock(int idProduto) throws SQLException {
		String sql = "insert into tbStock(fkproduto,attqtdproduto,dataattproduto,attvalorproduto,fkcolaborador) values(?,?,?,?,?)";

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		dateFormat.format(date);

		pst = conexao.prepareStatement(sql);

		pst.setInt(1, idProduto); // id do produto
		pst.setString(2, txtQtdProduto.getText());
		pst.setString(3, dateFormat.format(date));
		pst.setString(4, txtPrecoProduto.getText());
		pst.setInt(5, 1); // id colaborador logado ------------------------------------------------

		pst.executeUpdate();

	}

	private void LimparCampos() {

		txtMarcaProduto.setText(null);
		txtModeloProduto.setText(null);
		txtCorProduto.setText(null);
		txtQtdProduto.setText(null);
		txtPrecoProduto.setText(null);
		txtTamanhoProduto.setText(null);
		comboBoxCategoriaProduto.setSelectedIndex(0);
	}
}
