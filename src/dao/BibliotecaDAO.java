package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Livro;
import util.Conexao;

public class BibliotecaDAO {

    public void salvar(Livro livro) {
        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "INSERT INTO livro (titulo, autor, genero, idioma, quantidade, preco) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            conn = Conexao.conectar();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getGenero());
            stmt.setString(4, livro.getIdioma());
            stmt.setInt(5, livro.getQuantidade());
            stmt.setInt(6, livro.getPreco());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar livro: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void atualizar(Livro livro) {
        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "UPDATE livro SET titulo = ?, autor = ?, genero = ?, idioma = ?, quantidade = ?, preco = ? WHERE id = ?";

        try {
            conn = Conexao.conectar();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getGenero());
            stmt.setString(4, livro.getIdioma());
            stmt.setInt(5, livro.getQuantidade());
            stmt.setInt(6, livro.getPreco());
            stmt.setInt(7, livro.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar livro: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void excluir(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "DELETE FROM livro WHERE id = ?";

        try {
            conn = Conexao.conectar();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir livro: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Livro> listar() {
        List<Livro> lista = new ArrayList<Livro>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT id, titulo, autor, genero, idioma, quantidade, preco FROM livro ORDER BY id DESC";

        try {
            conn = Conexao.conectar();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Livro livro = new Livro();
                livro.setId(rs.getInt("id"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setAutor(rs.getString("autor"));
                livro.setGenero(rs.getString("genero"));
                livro.setIdioma(rs.getString("idioma"));
                livro.setQuantidade(rs.getInt("quantidade"));
                livro.setPreco(rs.getInt("preco"));
                lista.add(livro);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar livros: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return lista;
    }
}