package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.UsuarioDAO;
import DTO.UsuarioDTO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import java.awt.FlowLayout;
import javax.swing.table.DefaultTableModel;

public class jframeview extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeUsuario;
	private JPasswordField txtSenhaUsuario;
	private JTable table;
	private JTable table_3;
	private JScrollPane tabelaFuncionario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jframeview frame = new jframeview();
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
	public jframeview() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNomeUsuario = new JTextField();
		txtNomeUsuario.setBounds(10, 60, 105, 20);
		contentPane.add(txtNomeUsuario);
		txtNomeUsuario.setColumns(10);

		JLabel lblNewLabel = new JLabel("Usuário");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 37, 105, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("senha");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 83, 53, 23);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Entrar no Sistema");
		btnNewButton.setBounds(20, 166, 117, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar();
			}
		});
		contentPane.add(btnNewButton);

		txtSenhaUsuario = new JPasswordField();
		txtSenhaUsuario.setBounds(10, 106, 105, 20);
		contentPane.add(txtSenhaUsuario);

		table = new JTable();
		table.setBounds(248, 125, 1, 1);
		contentPane.add(table);

		tabelaFuncionario = new JScrollPane();
		tabelaFuncionario.setBounds(180, 30, 452, 427);
		contentPane.add(tabelaFuncionario);

		table_3 = new JTable();
		tabelaFuncionario.setViewportView(table_3);
		table_3.setModel(
				new DefaultTableModel(
						new Object[][] { { null, null, null }, { null, null, null }, { null, null, null },
								{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
								{ null, null, null }, { null, null, null }, },
						new String[] { "New column", "New column", "New column" }));
	}

	public void logar() {

		try {
			String nome_usuario, senha_usuario;
			nome_usuario = txtNomeUsuario.getText();
			senha_usuario = txtSenhaUsuario.getText();
			UsuarioDTO objusuariodto = new UsuarioDTO();
			objusuariodto.setNome_usuario(nome_usuario);
			objusuariodto.setSenha_usuario(senha_usuario);

			UsuarioDAO objusuariodao = new UsuarioDAO();
			ResultSet rsusuariodao = objusuariodao.autenticacaoUsuario(objusuariodto);
			if (rsusuariodao.next()) {

				// chamar tela que quero abrir
				frmPrincipal objfrmprincipal = new frmPrincipal();
				objfrmprincipal.setVisible(true);
				dispose();

			} else {
				JOptionPane.showMessageDialog(null, "Usuário ou senha inválida-");
				// enviar mensagem dizendo "incorreto"
			}

		} catch (SQLException erro) {

			JOptionPane.showMessageDialog(null, "FRMM ERROR" + erro);
		}
	}

}
