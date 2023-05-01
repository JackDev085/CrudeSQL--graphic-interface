package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.FuncionarioDTO;

public class FuncionarioDAO {
	Connection connection;
	PreparedStatement pstm;
	ResultSet rs;
	ArrayList<FuncionarioDTO> lista = new ArrayList<>();

	public void cadastrarFuncionario(FuncionarioDTO objfuncionariodto) {
		String sql = "insert into funcionario (nome_funcionario ,endereco_funcionario) values (?,?)";
		
		connection = new ConexaoDAO().conectaDB();
		
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, objfuncionariodto.getNomeFuncionario());
			pstm.setString(2, objfuncionariodto.getEnderecoFuncionario());
			
			pstm.execute();
			pstm.close();
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "FuncionárioDAO Cadastrar"+ erro);
		}
	}
		public ArrayList<FuncionarioDTO> pesquisarFuncionario() {
			String sql = "select * from funcionario";
			connection = new ConexaoDAO().conectaDB();
			
			try {
				pstm = connection.prepareStatement(sql);
				rs = pstm.executeQuery();
				while(rs.next()){
					FuncionarioDTO objfuncionariodto = new FuncionarioDTO();
					objfuncionariodto.setId_funcionario(rs.getInt("id_funcionario"));
					objfuncionariodto.setNomeFuncionario(rs.getString("nome_funcionario"));
					objfuncionariodto.setEnderecoFuncionario(rs.getString("endereco_funcionario"));
					
					lista.add(objfuncionariodto);
				
				}
				
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, "FuncionárioDAO Consultar"+ erro);
			}
			return lista;
		}
		public void alterarFuncionario(FuncionarioDTO objfuncionariodto) {
			String sql = "update funcionario set nome_funcionario=?, endereco_funcionario=? where id_funcionario=?";
			connection = new ConexaoDAO().conectaDB();
			try {
				pstm = connection.prepareStatement(sql);
				pstm.setString(1, objfuncionariodto.getNomeFuncionario());
				pstm.setString(2, objfuncionariodto.getEnderecoFuncionario());
				pstm.setInt(3, objfuncionariodto.getId_funcionario());
				
				pstm.execute();
				pstm.close();
				
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, "FuncionárioDAO Alterar"+ erro);
			}
			
				
		}
		public void excluirFuncionario(FuncionarioDTO objfuncionariodto) {
			
			String sql = "delete from funcionario where id_funcionario = ?";
			connection = new ConexaoDAO().conectaDB();
			try {
				pstm = connection.prepareStatement(sql);
				pstm.setInt(1, objfuncionariodto.getId_funcionario());
	
				pstm.execute();
				pstm.close();
				
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, "FuncionárioDAO excluir"+ erro);
			}
		}
		
	
}
