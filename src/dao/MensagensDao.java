/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import corn.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.sql.Statement.RETURN_GENERATED_KEYS;
import java.util.ArrayList;
import java.util.List;
import model.Mensagem;

/**
 *
 * @author Jéssica
 */
public class MensagensDao implements Persistencia<Mensagem>{

    private static MensagensDao mensagensDao = null;
    
    private MensagensDao(){
    }
    
    public static MensagensDao getInstance(){
        if (mensagensDao==null){
            mensagensDao = new MensagensDao();
        }
        return mensagensDao;
    }
    
    @Override
    public int create(Mensagem r) {
    String sql = "insert into Mensagens" + "(Mensagem, Usuario)" + "values (?,?)";
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement pst = null;
    ResultSet rs = null;
	int codigo = 0;
	try {
		pst = con.prepareStatement(sql, RETURN_GENERATED_KEYS);
		pst.setString(1, r.getMensagem());
		pst.setString(2, r.getUsuario());
		pst.executeUpdate();
		rs = pst.getGeneratedKeys();
		if (rs.next()) {
			codigo = rs.getInt(1);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		ConnectionFactory.closeConnection(con, pst);
	}
	return codigo;
}

    @Override
    public List<Mensagem> read() {
        String sql = "select * from Mensagens";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Mensagem> lista = new ArrayList<>();
        try{
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                String mensagem = rs.getString("Mensagem");
                String usuario = rs.getString("Usuario");
                Mensagem mensagens = new Mensagem(mensagem, usuario);
                lista.add(mensagens);
            }
        }catch(SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(con, pst);
        }
        return lista;
    }

    @Override
    public boolean update(Mensagem r) {
        throw new UnsupportedOperationException("Not supported yet."); //Não será permitido alterar mensagens já enviadas
    }

    @Override
    public boolean delet(Mensagem r) {
        throw new UnsupportedOperationException("Not supported yet."); //Não será possível apagar mensagens já enviadas
    }
    
}
