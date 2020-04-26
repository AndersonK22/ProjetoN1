package br.mack.ps2.persistencia;
import br.mack.ps2.entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaisDAOMySQL implements PaisDAO {
    private String createSQL = "INSERT INTO pais(nome, continente, populacao) VALUES (?, ?, ?)";
    private String readSQL = "SELECT * FROM pais";
    private String updateSQL = "UPDATE pais SET nome=?, continente=?, populacao=? WHERE id=?";
    private String deleteSQL = "DELETE FROM pais WHERE id=?";

    private final MySQLConnection mysql = new MySQLConnection();

    @Override
    public boolean create(Pais pais) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(createSQL);

            stm.setString(1, pais.getNome());
            stm.setString(2, pais.getContinente());
            stm.setLong(3, pais.getPopulacao());

            int registros = stm.executeUpdate();
            return  registros > 0 ? true : false;

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Pais> read() {
        Connection conexao = mysql.getConnection();
        List<Pais> paises = new ArrayList();

        try {
            PreparedStatement stm = conexao.prepareStatement(readSQL);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Pais pais = new Pais();
                pais.setId(rs.getLong("id"));
                pais.setNome(rs.getString("nome"));
                pais.setContinente(rs.getString("continente"));
                pais.setPopulacao(rs.getLong("populacao"));
                paises.add(pais);
            }

            return paises;

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return paises;
    }

    @Override
    public boolean update(Pais pais) {
        Connection conexao = mysql.getConnection();
        int registros = -1;
        try {
            PreparedStatement stm = conexao.prepareStatement(updateSQL);

            stm.setString(1, pais.getNome());
            stm.setString(2, pais.getContinente());
            stm.setLong(3, pais.getPopulacao());
            stm.setLong(4, pais.getId());

            registros = stm.executeUpdate();

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return  registros > 0 ? true : false;

    }

    @Override
    public boolean delete(Pais pais) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(deleteSQL);

            stm.setLong(1, pais.getId());

            int registros = stm.executeUpdate();

            return  registros > 0 ? true : false;

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
}

