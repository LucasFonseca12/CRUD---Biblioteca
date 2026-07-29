package controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.BibliotecaDAO;
import model.Livro;
import view.TelaBiblioteca;


public class BibliotecaController {
	
	private TelaBiblioteca tela;
	private BibliotecaDAO bibliotecaDAO;
	
	public BibliotecaController(TelaBiblioteca tela) {
		this.tela = tela;
		this.bibliotecaDAO = new BibliotecaDAO();
	}
	
	public void salvar() {
		String titulo = tela.getTxtTitulo().getText().trim();
        String autor = tela.getTxtAutor().getText().trim();
        String genero = tela.getTxtGenero().getText().trim();
        String idioma = tela.getTxtIdioma().getText().trim();
        String quantidadeTexto = tela.getTxtQuantidade().getText().trim();
        String precoTexto = tela.getTxtPreco().getText().trim();
        
        if (titulo.isEmpty() || autor.isEmpty() || genero.isEmpty() || idioma.isEmpty() || quantidadeTexto.isEmpty() || precoTexto.isEmpty()) {
        	JOptionPane.showMessageDialog(
                    tela,
                    "Preencha os campos obrigatórios.",
                    "Atenção",
                    JOptionPane.WARNING_MESSAGE
                );
                return;
        }
        
        try {
        	
        	int quantidade = Integer.parseInt(quantidadeTexto);
            int preco = Integer.parseInt(precoTexto);
            
        	String idTexto = tela.getTxtId().getText().trim();
        	
        	if (idTexto.isEmpty()) {
        		Livro livro = new Livro(titulo,
        				autor,
                		genero,
                		idioma,
                		quantidade,
                		preco
                		);
                bibliotecaDAO.salvar(livro);
                JOptionPane.showMessageDialog(tela, "Livro salvo com sucesso.");
            } else {
                Livro livro = new Livro(Integer.parseInt(idTexto), titulo,
                		autor,
                		genero,
                		idioma,
                		quantidade,
                		preco);
                bibliotecaDAO.atualizar(livro);
                JOptionPane.showMessageDialog(tela, "Livro atualizado com sucesso.");
            }

            limpar();
            carregarTabela();
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    tela,
                    "Erro ao salvar: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
                );
            }
	} 
	
	public void excluir() {
        int linha = tela.getTabelaLivros().getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(
                tela,
                "Selecione um livro na tabela para excluir.",
                "Atenção",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        int confirmacao = JOptionPane.showConfirmDialog(
            tela,
            "Deseja realmente excluir o livro selecionado?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION
        );

        if (confirmacao != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            int id = Integer.parseInt(tela.getTxtId().getText());
            bibliotecaDAO.excluir(id);
            JOptionPane.showMessageDialog(tela, "Livro excluído com sucesso.");
            limpar();
            carregarTabela();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                tela,
                "Erro ao excluir: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
	
	public void limpar() {
        tela.getTxtId().setText("");
        tela.getTxtTitulo().setText("");
        tela.getTxtAutor().setText("");
        tela.getTxtGenero().setText("");
        tela.getTxtIdioma().setText("");
        tela.getTxtQuantidade().setText("");
        tela.getTxtPreco().setText("");
        tela.getTabelaLivros().clearSelection();
    }
	
	public void carregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tela.getTabelaLivros().getModel();
        modelo.setRowCount(0);

        try {
            List<Livro> livros = bibliotecaDAO.listar();

            int i;
            for (i = 0; i < livros.size(); i++) {
                Livro c = livros.get(i);
                modelo.addRow(new Object[] {
                    c.getId(),
                    c.getTitulo(),
                    c.getAutor(),
                    c.getGenero(),
                    c.getIdioma(),
                    c.getQuantidade(),
                    c.getPreco()
                    
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                tela,
                "Erro ao carregar tabela: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
	
	public void preencherFormulario() {
        int linha = tela.getTabelaLivros().getSelectedRow();

        if (linha != -1) {
            tela.getTxtId().setText(tela.getTabelaLivros().getValueAt(linha, 0).toString());
            tela.getTxtTitulo().setText(tela.getTabelaLivros().getValueAt(linha, 1).toString());
            tela.getTxtAutor().setText(tela.getTabelaLivros().getValueAt(linha, 2).toString());
            tela.getTxtGenero().setText(tela.getTabelaLivros().getValueAt(linha, 3).toString());
            tela.getTxtIdioma().setText(tela.getTabelaLivros().getValueAt(linha, 4).toString());
            tela.getTxtQuantidade().setText(tela.getTabelaLivros().getValueAt(linha, 5).toString());
            tela.getTxtPreco().setText(tela.getTabelaLivros().getValueAt(linha, 6).toString());
            
        }
    }
}