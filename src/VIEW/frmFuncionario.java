package VIEW;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableModel;

import DAO.FuncionarioDAO;
import DTO.FuncionarioDTO;

public class frmFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTable table;
	private JTable tabelaFuncionario;
	private JTextField txtCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmFuncionario frame = new frmFuncionario();
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
	public frmFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 371, 567);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 153, 153));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome do funcionário");
		lblNewLabel.setBounds(10, 102, 140, 14);
		contentPane.add(lblNewLabel);

		txtNome = new JTextField();
		txtNome.setBounds(10, 115, 162, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Endereço do funcionário");
		lblNewLabel_1.setBounds(10, 147, 155, 14);
		contentPane.add(lblNewLabel_1);

		txtEndereco = new JTextField();
		txtEndereco.setBounds(10, 160, 162, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		

		JButton btnCadastrar = new JButton("Cadatrar");
		btnCadastrar.setForeground(new Color(102, 51, 0));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarFuncionario();
				listarValoresFuncionario();
				limparCampos();
			}
		});
		btnCadastrar.setBounds(33, 191, 89, 23);
		contentPane.add(btnCadastrar);

		table = new JTable();
		table.setBounds(222, 249, 155, -185);
		contentPane.add(table);

		tabelaFuncionario = new JTable();
		tabelaFuncionario.setBorder(new CompoundBorder());
		tabelaFuncionario.setModel(new DefaultTableModel(
			new Object[][] {
				{"", null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Id Funcion\u00E1rio", "Nome funcion\u00E1rio", "Endere\u00E7o"
			}
		));
		tabelaFuncionario.getColumnModel().getColumn(0).setPreferredWidth(84);
		tabelaFuncionario.getColumnModel().getColumn(1).setPreferredWidth(101);
		tabelaFuncionario.setBounds(0, 284, 355, 205);
		contentPane.add(tabelaFuncionario);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setForeground(new Color(51, 51, 255));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarValoresFuncionario();
			}
		});
		btnPesquisar.setBounds(132, 224, 89, 23);
		contentPane.add(btnPesquisar);
		
		JLabel lblNewLabel_2 = new JLabel("Código");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_2.setBounds(44, 259, 45, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nome");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_3.setBounds(172, 258, 34, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Endereço");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_4.setBounds(268, 259, 58, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Código");
		lblNewLabel_5.setBounds(10, 53, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		txtCodigo.setBounds(10, 71, 52, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JButton btnCarregarCampos = new JButton("CARREGAR CAMPOS");
		btnCarregarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarregarCampos();
				
			}
		});
		btnCarregarCampos.setBounds(171, 494, 140, 23);
		contentPane.add(btnCarregarCampos);
		
		JButton bntLimpar = new JButton("Limpar");
		bntLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		bntLimpar.setBounds(132, 191, 89, 23);
		contentPane.add(bntLimpar);
		
		JButton btnAlterar = new JButton("Atlterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarFuncionario();
				listarValoresFuncionario();
			}
		});
		btnAlterar.setBounds(33, 225, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirFuncionario();
				listarValoresFuncionario();
				limparCampos();
			}
		});
		btnExcluir.setForeground(new Color(220, 20, 60));
		btnExcluir.setBounds(237, 191, 89, 23);
		contentPane.add(btnExcluir);
	}

	private void listarValoresFuncionario() {
		try {
			FuncionarioDAO objfuncionariodao = new FuncionarioDAO();
			DefaultTableModel model = (DefaultTableModel) tabelaFuncionario.getModel();
			model.setNumRows(0);

			ArrayList<FuncionarioDTO> lista = objfuncionariodao.pesquisarFuncionario();
			for (int num = 0; num < lista.size(); num++) {
				model.addRow(new Object[] { lista.get(num).getId_funcionario(), lista.get(num).getNomeFuncionario(),
						lista.get(num).getEnderecoFuncionario() });
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Listar Valores VIEW" + erro);
			;
		}
	}
	
	private void CarregarCampos() {
		int setar = tabelaFuncionario.getSelectedRow();
		txtCodigo.setText(tabelaFuncionario.getModel().getValueAt(setar, 0).toString());
		txtNome.setText(tabelaFuncionario.getModel().getValueAt(setar, 1).toString());
		txtEndereco.setText(tabelaFuncionario.getValueAt(setar, 2).toString());
		
	}
	private void cadastrarFuncionario() {
		String nome, endereco;

		nome = txtNome.getText();
		endereco = txtEndereco.getText();
		FuncionarioDTO objfuncionariodto = new FuncionarioDTO();
		objfuncionariodto.setNomeFuncionario(nome);
		objfuncionariodto.setEnderecoFuncionario(endereco);

		FuncionarioDAO objfuncionariodao = new FuncionarioDAO();
		objfuncionariodao.cadastrarFuncionario(objfuncionariodto);
	}
	private void limparCampos() {
		txtCodigo.setText("");
		txtNome.setText("");
		txtEndereco.setText("");
		txtNome.requestFocus();
	}
	private void alterarFuncionario() {
		int id_funcionario;
		String nome_funcionario,endereco_funcionario;
		id_funcionario = Integer.parseInt(txtCodigo.getText());
		nome_funcionario = txtNome.getText();
		endereco_funcionario = txtEndereco.getText();
		
		FuncionarioDTO objfuncionariodto = new FuncionarioDTO();
		objfuncionariodto.setId_funcionario(id_funcionario);
		objfuncionariodto.setNomeFuncionario(nome_funcionario);
		objfuncionariodto.setEnderecoFuncionario(endereco_funcionario);
		
		FuncionarioDAO objfuncionariodao = new FuncionarioDAO();
		objfuncionariodao.alterarFuncionario(objfuncionariodto);
		
		
	}
	
	private void excluirFuncionario() {
		int id_funcionario;
		
		id_funcionario = Integer.parseInt(txtCodigo.getText());
		
		
		FuncionarioDTO objfuncionariodto = new FuncionarioDTO();
		objfuncionariodto.setId_funcionario(id_funcionario);
		FuncionarioDAO objfuncionariodao = new FuncionarioDAO();
		objfuncionariodao.excluirFuncionario(objfuncionariodto);
	}
}
