package com.sadestorm.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.sadestorm.dao.ConexaoDb;

public class TelaCadastroUsuario extends JFrame {

	/**
	 * 
	 */

	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	private JPanel contentPane;
	private JTextField txtBairro;
	private JTextField txtComplemento;
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JFormattedTextField txtCpf;
	private JFormattedTextField txtDdd;
	private JTextField txtTelefone;
	private JTextField txtEmail = null;
	private JTextField txtSobrenome;
	private JTextField txtNumero;
	private JTextField txtCidade;
	private JTextField txtNome;

	private JComboBox<String> comboBoxEstado;

	String REGEXCPF = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\.?\\d{2}";
	String REGEXCEP = "\\d{2}\\.?\\d{3}\\-?\\d{3}";
	String REGEXFONE = "\\d{4}\\ - ?\\d{4}";

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 */
	public TelaCadastroUsuario() throws ParseException {

		conexao = ConexaoDb.conector();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelContato = new JPanel();
		panelContato.setBounds(20, 141, 510, 74);
		contentPane.add(panelContato);
		panelContato.setLayout(null);

		JLabel lblDddd = new JLabel("DDD:");
		lblDddd.setBounds(10, 19, 46, 14);
		panelContato.add(lblDddd);

		txtDdd = new JFormattedTextField(new MaskFormatter("##"));
		txtDdd.setBounds(85, 16, 25, 20);
		panelContato.add(txtDdd);
		txtDdd.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(120, 19, 59, 14);
		panelContato.add(lblTelefone);

		MaskFormatter maskTelefone = new MaskFormatter("#### - ####");
		maskTelefone.setPlaceholderCharacter('_');
		txtTelefone = new JFormattedTextField(maskTelefone);
		txtTelefone.setBounds(189, 16, 75, 20);
		panelContato.add(txtTelefone);
		txtTelefone.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 47, 46, 14);
		panelContato.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(85, 44, 312, 20);
		panelContato.add(txtEmail);
		txtEmail.setColumns(10);

		JPanel panelDadosPessoal = new JPanel();
		panelDadosPessoal.setBounds(20, 37, 510, 93);
		contentPane.add(panelDadosPessoal);
		panelDadosPessoal.setLayout(null);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 11, 72, 14);
		panelDadosPessoal.add(lblCpf);
		MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");
		maskCpf.setPlaceholderCharacter('_');
		txtCpf = new JFormattedTextField(maskCpf);
		txtCpf.setBounds(85, 8, 149, 20);
		panelDadosPessoal.add(txtCpf);
		txtCpf.setColumns(10);

		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(10, 68, 72, 14);
		panelDadosPessoal.add(lblSobrenome);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 40, 72, 14);
		panelDadosPessoal.add(lblNome);

		txtSobrenome = new JTextField();
		txtSobrenome.setBounds(85, 65, 415, 20);
		panelDadosPessoal.add(txtSobrenome);
		txtSobrenome.setColumns(10);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(85, 37, 415, 20);
		panelDadosPessoal.add(txtNome);

		JPanel panelEndereco = new JPanel();
		panelEndereco.setBounds(20, 226, 510, 130);
		contentPane.add(panelEndereco);
		panelEndereco.setLayout(null);

		JLabel lblCep = new JLabel("CEP: ");
		lblCep.setBounds(10, 15, 66, 14);
		panelEndereco.add(lblCep);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(195, 15, 46, 14);
		panelEndereco.add(lblCidade);

		MaskFormatter maskCep = new MaskFormatter("##.###-###");
		maskCep.setPlaceholderCharacter('_');
		txtCep = new JFormattedTextField(maskCep);
		txtCep.setBounds(86, 12, 104, 20);
		panelEndereco.add(txtCep);
		txtCep.setColumns(10);

		txtCidade = new JTextField();
		txtCidade.setBounds(245, 12, 163, 20);
		panelEndereco.add(txtCidade);
		txtCidade.setColumns(10);

		comboBoxEstado = new JComboBox<String>();
		comboBoxEstado.setBounds(454, 11, 46, 22);
		panelEndereco.add(comboBoxEstado);
		comboBoxEstado.setModel(new DefaultComboBoxModel<String>(
				new String[] { "UF", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
						"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

		txtEndereco = new JTextField();
		txtEndereco.setBounds(86, 42, 414, 20);
		panelEndereco.add(txtEndereco);
		txtEndereco.setColumns(10);

		txtBairro = new JTextField();
		txtBairro.setBounds(245, 70, 163, 20);
		panelEndereco.add(txtBairro);
		txtBairro.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(195, 73, 46, 14);
		panelEndereco.add(lblBairro);

		txtNumero = new JTextField();
		txtNumero.setBounds(86, 70, 86, 20);
		panelEndereco.add(txtNumero);
		txtNumero.setColumns(10);

		JLabel lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setBounds(10, 73, 66, 14);
		panelEndereco.add(lblNumero);

		JLabel lblRua = new JLabel("Endere\u00E7o");
		lblRua.setBounds(10, 45, 66, 14);
		panelEndereco.add(lblRua);

		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(10, 98, 80, 14);
		panelEndereco.add(lblComplemento);

		txtComplemento = new JTextField();
		txtComplemento.setBounds(86, 98, 414, 20);
		panelEndereco.add(txtComplemento);
		txtComplemento.setColumns(10);

		JButton btnSalvarUsuario = new JButton("SALVAR");
		btnSalvarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				System.out.println("entrou" + txtEmail.getText());

				if (txtNome.getText().equals("") || txtSobrenome.getText().equals("")) {

					JOptionPane.showMessageDialog(null, " NOME E SOBRENOME Inválido");

				} else if (txtDdd.getText().equals("  ") && txtTelefone.getText().matches(REGEXFONE)) {

					JOptionPane.showMessageDialog(null, "DDD Inválido");

				} else if (!txtEmail.getText().isEmpty() && isValidEmailAddressRegex(txtEmail.getText()) == false) {
					System.out.println("entrou - 2");

					JOptionPane.showMessageDialog(null, "E-mail Inválido");

				} else if (txtCep.getText().matches(REGEXCEP)
						&& ((txtCidade.getText().equals("") || comboBoxEstado.getSelectedItem().toString() == "UF"
								|| txtEndereco.getText().equals("") || txtNumero.getText().equals("")))) {

					JOptionPane.showMessageDialog(null, "Lorgadouro Incompleto");

				} else {
					CadastrarCliente();
					LimparCamposUsuario();
				}
			}
		});
		btnSalvarUsuario.setBounds(415, 367, 103, 50);

		contentPane.add(btnSalvarUsuario);

		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparCamposUsuario();
			}
		});
		btnCancelar.setBounds(272, 367, 110, 50);
		contentPane.add(btnCancelar);

		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaInicial.frame.setVisible(true);
				dispose();

			}
		});
		btnSair.setBounds(20, 367, 110, 50);
		contentPane.add(btnSair);
	}

	private void CadastrarCliente() {

		String cpf = null;
		String cep = null;
		String telefone = null;
		String estado = null;

		if (txtCpf.getText().matches(REGEXCPF)) {
			String result = txtCpf.getText().replaceAll("\\.", "");
			result = result.replaceAll("\\-", "");
			cpf = result;
		}
		if (txtCep.getText().matches(REGEXCEP)) {
			String result = txtCep.getText().replaceAll("\\.", "");
			result = result.replaceAll("\\-", "");
			cep = result;
		}

		if (txtTelefone.getText().matches(REGEXFONE)) {
			String result = txtTelefone.getText().replaceAll("\\ - ", "");
			telefone = result;

		}
		if (comboBoxEstado.getSelectedItem().toString() != "UF") {
			estado = comboBoxEstado.getSelectedItem().toString();
		}

		System.out.println("telefone = " + txtTelefone.getText() + "regex ----> " + telefone);
		String sql = "insert into tbUsuario(nomeusuario," + "sobrenomeusuario," + "emailusuario," + "dddusuario,"
				+ "foneusuario," + "cpfusuario," + "cepusuario," + "cidadeusuario," + "estadousuario,"
				+ "enderecousuario," + "numerousuario," + "bairrousuario," + "complementousuario," + "tipousuario)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {

			/*
			 * private JTextField txtModeloProduto; private JTextField txtPrecoProduto;
			 * private JTextField txtQtdProduto; private JTextField txtCorProduto
			 */

			pst = conexao.prepareStatement(sql);

			pst.setString(1, txtNome.getText());
			pst.setString(2, txtSobrenome.getText());
			pst.setString(3, txtEmail.getText());
			pst.setString(4, txtDdd.getText());
			pst.setString(5, telefone);
			pst.setString(6, cpf);
			pst.setString(7, cep);
			pst.setString(8, txtCidade.getText());
			pst.setString(9, estado);
			pst.setString(10, txtEndereco.getText());
			pst.setString(11, txtNumero.getText());
			pst.setString(12, txtBairro.getText());
			pst.setString(13, txtComplemento.getText());
			pst.setString(14, "CLIENTE");

			pst.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("erro" + e);
		}
	}

	public JTextField DefinirTiposCaracteresETamanho(int tamanho, String caracteres) {
		try {
			// defino a variável que vai guardar a quantidade de caracteres
			String quantidade = "";

			// defino um método de repetição para repetir o numero de
			// vezes do tamanho
			for (int i = 0; i < tamanho; i++) {
				// defino asterisco para aceitar qualquer coisa e crio a máscara
				quantidade = quantidade + "*";
			}
			// **********... de acordo com o tamanho informado
			// defino que a mascara possui essa
			// quantidade de elementos que foi informado em tamanho e
			// foi colocada com * dentro de quantidade
			javax.swing.text.MaskFormatter nome = new javax.swing.text.MaskFormatter(quantidade);

			// defino que o parâmetro caracter recebido pelo
			// método contém os caracteres válidos
			nome.setValidCharacters(caracteres);

			// retorno a mascara que foi criada

			return new javax.swing.JFormattedTextField(nome);

		} // fim do try
		catch (Exception e) {
			// mensagem se acontecer erro
			JOptionPane.showMessageDialog(null, "Ocorreu um erro");
			// retorno um campo de texto comum
			return new JTextField();
		} // fim do catch
	}// fim do método

	public static boolean isValidEmailAddressRegex(String email) {
		boolean isEmailIdValid = false;
		if (email != null && email.length() > 0) {
			String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches()) {
				isEmailIdValid = true;
			}
		}
		return isEmailIdValid;
	}

	private void LimparCamposUsuario() {

		txtBairro.setText(null);
		txtCep.setText(null);
		txtCidade.setText(null);
		txtComplemento.setText(null);
		txtCpf.setText(null);
		txtDdd.setText(null);
		txtEmail.setText(null);
		txtEndereco.setText(null);
		txtNome.setText(null);
		txtNumero.setText(null);
		txtSobrenome.setText(null);
		txtTelefone.setText(null);

	}
}
