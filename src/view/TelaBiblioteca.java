package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.BibliotecaController;

public class TelaBiblioteca extends JFrame {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblId;
	private JLabel lblTitulo;
	private JLabel lblAutor;
	private JLabel lblGenero;
	private JLabel lblIdioma;
	private JLabel lblQuantidade;
	private JLabel lblPreco;
	
	private JTextField txtId;
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtGenero;
	private JTextField txtIdioma;
	private JTextField txtQuantidade;
	private JTextField txtPreco;
	
	private JButton btnNovo;
	private JButton btnSalvar;
	private JButton btnExcluir;
	private JButton btnLimpar;
	
	private JTable tabelaLivros;
	private DefaultTableModel modeloTabela;
	
	private BibliotecaController controller;
	
	public TelaBiblioteca() {
		setTitle("Biblioteca Glúteos Sarados - Arujá");
		setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        
        criarComponentes();

        controller = new BibliotecaController(this);
        configurarEventos();
        controller.carregarTabela();
	}
	
	private void criarComponentes() {
		JPanel painelBiblioteca = new JPanel(new GridLayout(7, 2, 10, 8));
		painelBiblioteca.setBorder(BorderFactory.createTitledBorder("Dados do Livro"));
		BorderFactory.createEmptyBorder(10, 15, 10, 15);
		
		lblId = new JLabel("ID:");
        txtId = new JTextField();
        txtId.setEditable(false);
        
        lblTitulo = new JLabel("Titulo:");
        txtTitulo = new JTextField();
        
        lblAutor = new JLabel("Autor:");
        txtAutor = new JTextField();
        
        lblGenero = new JLabel("Gênero:");
        txtGenero = new JTextField();
        
        lblIdioma = new JLabel("Idioma:");
        txtIdioma = new JTextField();
        
        lblQuantidade = new JLabel("Quantidade:");
        txtQuantidade = new JTextField();
        
        lblPreco = new JLabel("Preço:");
        txtPreco = new JTextField();
        
        painelBiblioteca.add(lblId);
        painelBiblioteca.add(txtId);
        painelBiblioteca.add(lblTitulo);
        painelBiblioteca.add(txtTitulo);
        painelBiblioteca.add(lblAutor);
        painelBiblioteca.add(txtAutor);
        painelBiblioteca.add(lblGenero);
        painelBiblioteca.add(txtGenero);
        painelBiblioteca.add(lblIdioma);
        painelBiblioteca.add(txtIdioma);
        painelBiblioteca.add(lblQuantidade);
        painelBiblioteca.add(txtQuantidade);
        painelBiblioteca.add(lblPreco);
        painelBiblioteca.add(txtPreco);
        
        add(painelBiblioteca, BorderLayout.NORTH);
        
        modeloTabela = new DefaultTableModel(new Object[] { "ID", "Título", "Autor", "Gênero", "Idioma", "Quantidade", "Preço"}, 0) {

            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tabelaLivros = new JTable(modeloTabela);
        tabelaLivros.setRowHeight(25);
        JScrollPane scrollPane = new JScrollPane(tabelaLivros);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Livros"));
        add(scrollPane, BorderLayout.CENTER);
        BorderFactory.createEmptyBorder(5, 10, 10, 10);
        
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 12));

        btnNovo = new JButton("Novo");
        btnSalvar = new JButton("Salvar");
        btnExcluir = new JButton("Excluir");
        btnLimpar = new JButton("Limpar");
        
        painelBotoes.add(btnNovo);
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnExcluir);
        painelBotoes.add(btnLimpar);

        add(painelBotoes, BorderLayout.SOUTH);        
	}
	private void configurarEventos() {
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                controller.limpar();
            }
        });

        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                controller.salvar();
            }
        });

        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                controller.excluir();
            }
        });

        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                controller.limpar();
            }
        });

        tabelaLivros.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                controller.preencherFormulario();
            }
        });
    }

	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}

	public JTextField getTxtTitulo() {
		return txtTitulo;
	}

	public void setTxtTitulo(JTextField txtTitulo) {
		this.txtTitulo = txtTitulo;
	}

	public JTextField getTxtAutor() {
		return txtAutor;
	}

	public void setTxtAutor(JTextField txtAutor) {
		this.txtAutor = txtAutor;
	}

	public JTextField getTxtGenero() {
		return txtGenero;
	}

	public void setTxtGenero(JTextField txtGenero) {
		this.txtGenero = txtGenero;
	}

	public JTextField getTxtIdioma() {
		return txtIdioma;
	}

	public void setTxtIdioma(JTextField txtIdioma) {
		this.txtIdioma = txtIdioma;
	}

	public JTextField getTxtQuantidade() {
		return txtQuantidade;
	}

	public void setTxtQuantidade(JTextField txtQuantidade) {
		this.txtQuantidade = txtQuantidade;
	}

	public JTextField getTxtPreco() {
		return txtPreco;
	}

	public void setTxtPreco(JTextField txtPreco) {
		this.txtPreco = txtPreco;
	}

	public JTable getTabelaLivros() {
		return tabelaLivros;
	}

	public void setTabelaLivros(JTable tabelaLivros) {
		this.tabelaLivros = tabelaLivros;
	}	
	
	
}