package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DTO.UsuarioDTO;

public class UsuarioDAO {
	Connection conexao;

	public ResultSet autenticacaoUsuario(UsuarioDTO objusuariodto) {
		conexao = new ConexaoDAO().conectaDB();

		
		try {
			String sql = "select * from usuario where nome_usuario=? and senha_usuario=?; ";
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setString(1, objusuariodto.getNome_usuario());
			pstm.setString(2, objusuariodto.getSenha_usuario());
			ResultSet rs = pstm.executeQuery();
			return rs;

		} catch (SQLException erro) {
			JOptionPane.showConfirmDialog(null, "UsuarioDAO" + erro);
			return null;
		}

	}

}
