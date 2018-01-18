package br.ulbra.model.dao;

import br.ulbra.connection.ConnectionFactory;
import br.ulbra.entity.Pesquisa;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeferson Leon
 */
public class PesquisaDAO {

  Connection con;
   
    public PesquisaDAO() {
        con = ConnectionFactory.getConnection();
    }
   
    //MÉTODOS CRIADOS PARA FAZER PESQUISAS NO BANCO DE DADOS
//EM ORDEM DE CADASTRO TODOS

     public ArrayList<Pesquisa> read() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Pesquisa> pesquisas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbpesquisa");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Pesquisa pesquisa = new Pesquisa();
                
                pesquisa.setId(rs.getInt("idp"));
                pesquisa.setNomep(rs.getString("nomep"));
                pesquisa.setSexop(rs.getString("sexop"));
                pesquisa.setIdadep(rs.getInt("idadep"));
                pesquisa.setGrauip(rs.getString("grauip"));
                pesquisa.setContap(rs.getInt("contap"));
                pesquisa.setSalariop(rs.getString("salariop"));              
              
                pesquisas.add(pesquisa);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PesquisaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return pesquisas;

    }

//PESQUISA PELO LOGIN

    public ArrayList<Pesquisa> readForDesc(String nomep) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Pesquisa> pesquisas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbpesquisa WHERE nomep LIKE ?");
            stmt.setString(1, "%"+nomep+"%");
           
            rs = stmt.executeQuery();

            while (rs.next()) {

               Pesquisa pesquisa= new Pesquisa();

                pesquisa.setId(rs.getInt("idp"));
                pesquisa.setNomep(rs.getString("nomep"));
                pesquisa.setSexop(rs.getString("sexop"));
                pesquisa.setIdadep(rs.getInt("idadep"));
                pesquisa.setGrauip(rs.getString("grauip"));
                pesquisa.setContap(rs.getInt("contap"));
                pesquisa.setSalariop(rs.getString("salariop"));              
              
                pesquisas.add(pesquisa);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PesquisaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return pesquisas;

    }
    
    
    
//MÉTODO CRIADO PARA INSERIR USUÁRIO NO BANCO DE DADOS
    public void create(Pesquisa c) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tbpesquisa (nomep, sexop, idadep, grauip, contap, salariop) VALUES (?,?,?,?,?,?)");
            
            stmt.setString(1, c.getNomep());
            stmt.setString(2, c.getSexop());
            stmt.setInt(3, c.getIdadep());
            stmt.setString(4, c.getGrauip());
            stmt.setInt(5, c.getContap());
            stmt.setString(6, c.getSalariop());                    

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Pesquisa Efetuada com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

// MÉTODO CRIADO PARA EXCLUIR DO BANCO DE DADOS

 public void delete(Pesquisa c) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM tbpesquisa WHERE idp = ?");
            stmt.setInt(1, c.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

//MÉTODO CRIADO PARA MODIFICAR NO BANCO DE DADOS

 public void update(Pesquisa c) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE tbpesquisa SET nomep = ?, sexop = ?, idadep = ?, grauip = ?, contap = ?, salariop = ? WHERE idp = ?");
                       
            stmt.setString(1, c.getNomep());
            stmt.setString(2, c.getSexop());
            stmt.setInt(3, c.getIdadep());
            stmt.setString(4, c.getGrauip());
            stmt.setInt(5, c.getContap());
            stmt.setString(6, c.getSalariop()); 
            stmt.setInt(7, c.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex );
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }


}