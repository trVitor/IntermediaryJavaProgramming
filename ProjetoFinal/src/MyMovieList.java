import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMovieList {
    private final BibliotecaFilmes biblioteca = new BibliotecaFilmes();
    private List<Filme> listaAtual;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MyMovieList::new);
    }

    public MyMovieList() {
        criarInterfaceGrafica();
    }

    private void criarInterfaceGrafica() {
        JFrame frame = new JFrame("MeetFlix OU CoordinateFlix");
        frame.setSize(750, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Cores
        Color corFundo = new Color(34, 1, 1);
        Color corLetras = Color.WHITE;
        Color corCaixaPesquisa = new Color(102, 51, 51);

        // Configuração de cores do frame
        frame.getContentPane().setBackground(corFundo);

        JPanel panelAdicionar = new JPanel(new GridBagLayout());
        configurarPainel(panelAdicionar, corFundo);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        JTextField campoNome = criarCampoTexto(20, corCaixaPesquisa, corLetras);
        JTextField campoGenero = criarCampoTexto(20, corCaixaPesquisa, corLetras);
        JTextField campoDiretor = criarCampoTexto(20, corCaixaPesquisa, corLetras);
        JTextField campoAno = criarCampoTexto(20, corCaixaPesquisa, corLetras);
        JCheckBox checkBoxAssistido = criarCheckBox("Assistido", corFundo, corLetras);
        JCheckBox checkBoxFavorito = criarCheckBox("Favorito", corFundo, corLetras);
        JButton botaoAdicionar = criarBotao("Adicionar Filme", corCaixaPesquisa, corLetras);

        // Adicionando campos ao painel
        adicionarComponente(panelAdicionar, criarLabel("Nome :", corLetras), gbc, 0, 0);
        adicionarComponente(panelAdicionar, campoNome, gbc, 1, 0);
        adicionarComponente(panelAdicionar, criarLabel("Gênero :", corLetras), gbc, 0, 1);
        adicionarComponente(panelAdicionar, campoGenero, gbc, 1, 1);
        adicionarComponente(panelAdicionar, criarLabel("Diretor :", corLetras), gbc, 0, 2);
        adicionarComponente(panelAdicionar, campoDiretor, gbc, 1, 2);
        adicionarComponente(panelAdicionar, criarLabel("Ano :", corLetras), gbc, 0, 3);
        adicionarComponente(panelAdicionar, campoAno, gbc, 1, 3);
        adicionarComponente(panelAdicionar, botaoAdicionar, gbc, 1, 5, 2);

        frame.add(panelAdicionar, BorderLayout.NORTH);

        JPanel panelFilmes = new JPanel();
        configurarPainel(panelFilmes, corFundo);
        panelFilmes.setLayout(new GridLayout(0, 1)); // Layout alterado para GridLayout

        JScrollPane scrollPane = new JScrollPane(panelFilmes);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel panelBusca = new JPanel();
        configurarPainel(panelBusca, corFundo);
        panelBusca.setLayout(new FlowLayout());
        JTextField campoBusca = criarCampoTexto(20, corCaixaPesquisa, corLetras);
        JButton botaoBuscar = criarBotao("Buscar", corCaixaPesquisa, corLetras);
        botaoBuscar.setPreferredSize(new Dimension(75, 20));
        panelBusca.add(criarLabel("Buscar Filme:", corLetras));
        panelBusca.add(campoBusca);
        panelBusca.add(botaoBuscar);
        frame.add(panelBusca, BorderLayout.SOUTH);


        // Ações dos botões
        botaoAdicionar.addActionListener(e -> {
            try {
                String nome = campoNome.getText();
                String genero = campoGenero.getText();
                String diretor = campoDiretor.getText();
                int ano = Integer.parseInt(campoAno.getText());
                boolean assistido = checkBoxAssistido.isSelected();
                boolean favorito = checkBoxFavorito.isSelected();

                biblioteca.adicionarFilme(nome, genero, diretor, ano, assistido, favorito);
                atualizarListaFilmes(panelFilmes, biblioteca.listarFilmes(), "Todos os Filmes", corFundo, corLetras, corCaixaPesquisa);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Ano deve ser um número inteiro.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
            }
        });

        botaoBuscar.addActionListener(e -> {
            String termoBusca = campoBusca.getText();
            List<Filme> resultadosBusca = biblioteca.buscarFilme(termoBusca);
            atualizarListaFilmes(panelFilmes, resultadosBusca, "Resultado da Busca", corFundo, corLetras, corCaixaPesquisa);
        });

        // Inicialmente, exibe todos os filmes
        listaAtual = biblioteca.listarFilmes();
        atualizarListaFilmes(panelFilmes, listaAtual, "Todos os Filmes", corFundo, corLetras, corCaixaPesquisa);

        frame.setVisible(true);
    }

    private JTextField criarCampoTexto(int colunas, Color corFundo, Color corLetras) {
        JTextField campo = new JTextField(colunas);
        campo.setBackground(corFundo);
        campo.setCaretColor(corLetras);
        campo.setForeground(corLetras);
        return campo;
    }

    private JCheckBox criarCheckBox(String texto, Color corFundo, Color corLetras) {
        JCheckBox checkBox = new JCheckBox(texto);
        checkBox.setBackground(corFundo);
        checkBox.setForeground(corLetras);
        return checkBox;
    }

    private JButton criarBotao(String texto, Color corFundo, Color corLetras) {
        JButton botao = new JButton(texto);
        botao.setBackground(corFundo);
        botao.setForeground(corLetras);
        return botao;
    }

    private JLabel criarLabel(String texto, Color corLetras) {
        JLabel label = new JLabel(texto);
        label.setForeground(corLetras);
        return label;
    }

    private void configurarPainel(JPanel painel, Color corFundo) {
        painel.setBackground(corFundo);
    }

    private void adicionarComponente(JPanel painel, Component componente, GridBagConstraints gbc, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        painel.add(componente, gbc);
    }

    private void adicionarComponente(JPanel painel, Component componente, GridBagConstraints gbc, int x, int y, int largura) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = largura;
        painel.add(componente, gbc);
    }

    private void atualizarListaFilmes(JPanel panelFilmes, List<Filme> filmes, String titulo, Color corFundo, Color corLetras, Color corCaixaPesquisa) {
        panelFilmes.removeAll();

        JLabel labelTitulo = new JLabel(titulo, JLabel.CENTER);
        labelTitulo.setForeground(Color.WHITE);
        panelFilmes.add(labelTitulo);

        JPanel panelBotoesSuperiores = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBotoesSuperiores.setBackground(corFundo);
        JButton botaoFavoritos = criarBotao("Favoritos", corCaixaPesquisa, corLetras);
        botaoFavoritos.setPreferredSize(new Dimension(88, 19));
        JButton botaoAssistidos = criarBotao("Assistidos", corCaixaPesquisa, corLetras);
        botaoAssistidos.setPreferredSize(new Dimension(95, 19));
        JButton botaoTodos = criarBotao("Todos os Filmes", corCaixaPesquisa, corLetras);
        botaoTodos.setPreferredSize(new Dimension(130, 19));

        panelBotoesSuperiores.add(botaoFavoritos);
        panelBotoesSuperiores.add(botaoAssistidos);
        panelBotoesSuperiores.add(botaoTodos);

         // JComboBox para ordenação
        JComboBox<String> comboBoxOrdenacao = new JComboBox<>(new String[]{"Filtro","Por Adição", "Por Nome", "Por Avaliação"});
        comboBoxOrdenacao.setPreferredSize(new Dimension(88, 19));
        comboBoxOrdenacao.setBackground(corCaixaPesquisa);
        comboBoxOrdenacao.setForeground(corLetras); 
        comboBoxOrdenacao.addActionListener(e -> {
            String criterio = (String) comboBoxOrdenacao.getSelectedItem();
            switch (criterio) {
                case "Por Adição":
                    OrdenadorFilmes.ordenarPorAdicao(listaAtual);
                    break;
                case "Por Nome":
                    OrdenadorFilmes.ordenarPorNome(listaAtual);
                    break;
                case "Por Avaliação":
                    OrdenadorFilmes.ordenarPorAvaliacao(listaAtual);
                    break;
            }
            atualizarListaFilmes(panelFilmes, listaAtual, "Filmes Ordenados", corFundo, corLetras, corCaixaPesquisa);
        });
        panelBotoesSuperiores.add(comboBoxOrdenacao);

        botaoFavoritos.addActionListener(e -> {
            listaAtual = biblioteca.listarFavoritos();
            atualizarListaFilmes(panelFilmes, listaAtual, "Filmes Favoritos", corFundo, corLetras, corCaixaPesquisa);
        });

        botaoAssistidos.addActionListener(e -> {
            listaAtual = biblioteca.listarAssistidos();
            atualizarListaFilmes(panelFilmes, listaAtual, "Filmes Assistidos", corFundo, corLetras, corCaixaPesquisa);
        });

        botaoTodos.addActionListener(e -> {
            listaAtual = biblioteca.listarFilmes();
            atualizarListaFilmes(panelFilmes, listaAtual, "Todos os Filmes", corFundo, corLetras, corCaixaPesquisa);
        });
        panelFilmes.add(panelBotoesSuperiores);

        for (Filme filme : filmes) {
            JPanel panelFilme = new JPanel(new BorderLayout()); // Layout alterado para BorderLayout
            configurarPainel(panelFilme, corFundo);
        
            JLabel labelFilme = new JLabel(filme.toString());
            labelFilme.setForeground(corLetras);
            panelFilme.add(labelFilme, BorderLayout.WEST); // Adicionado ao lado esquerdo
        
            JPanel panelControles = new JPanel(); // Painel para os controles
            panelControles.setBackground(corFundo);
            panelControles.setLayout(new FlowLayout(FlowLayout.RIGHT)); // Layout ajustado para alinhar os controles à direita
        
            // Adicionando estrelas para avaliação
            JPanel panelAvaliacao = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Painel para as avaliações
            panelAvaliacao.setBackground(corFundo);
        
            int avaliacao = filme.getAvaliacao();
            for (int i = 1; i <= 5; i++) {
                JLabel labelEstrela = new JLabel(i <= avaliacao ? "\u2605" : "\u2606"); // Estrela preenchida se i <= avaliacao
                labelEstrela.setFont(new Font("SansSerif", Font.PLAIN, 15));
                labelEstrela.setForeground(new Color(255, 255, 0));
                int pontuacao = i;
                labelEstrela.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        filme.setAvaliacao(pontuacao);
                        atualizarListaFilmes(panelFilmes, filmes, titulo, corFundo, corLetras, corCaixaPesquisa);
                    }
                });
                panelAvaliacao.add(labelEstrela);
            }
        
            panelControles.add(panelAvaliacao); // Adicionado ao painel de controles
        
            JCheckBox checkBoxAssistido = criarCheckBox("Assistidos", corFundo, corLetras);
            checkBoxAssistido.setSelected(filme.isAssistido());
            checkBoxAssistido.addActionListener(e -> {
                if (checkBoxAssistido.isSelected()) {
                    biblioteca.marcarComoAssistido(filme.getNome());
                } else {
                    biblioteca.desmarcarComoAssistido(filme.getNome());
                }
                atualizarListaFilmes(panelFilmes, filmes, titulo, corFundo, corLetras, corCaixaPesquisa);
            });
            panelControles.add(checkBoxAssistido); // Adicionado ao painel de controles
        
            JCheckBox checkBoxFavorito = criarCheckBox("Favoritos", corFundo, corLetras);
            checkBoxFavorito.setSelected(filme.isFavorito());
            checkBoxFavorito.addActionListener(e -> {
                if (checkBoxFavorito.isSelected()) {
                    biblioteca.adicionarAosFavoritos(filme.getNome());
                } else {
                    biblioteca.removerDosFavoritos(filme.getNome());
                }
                atualizarListaFilmes(panelFilmes, filmes, titulo, corFundo, corLetras, corCaixaPesquisa);
            });
            panelControles.add(checkBoxFavorito); // Adicionado ao painel de controles
        
            JButton botaoRemover = criarBotao("Remover", corCaixaPesquisa, new Color(255, 255, 125));
            botaoRemover.setPreferredSize(new Dimension(90, 18));
            botaoRemover.addActionListener(e -> {
                if (filme.isFavorito()) {
                    int resposta = JOptionPane.showConfirmDialog(null, "Este filme está marcado como favorito. Deseja realmente removê-lo?", "Confirmação", JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        biblioteca.removerFilme(filme.getNome());
                        atualizarListaFilmes(panelFilmes, filmes, titulo, corFundo, corLetras, corCaixaPesquisa);
                    }
                } else {
                    biblioteca.removerFilme(filme.getNome());
                    atualizarListaFilmes(panelFilmes, filmes, titulo, corFundo, corLetras, corCaixaPesquisa);
                }
            });
            panelControles.add(botaoRemover); // Adicionado ao painel de controles
        
            panelFilme.add(panelControles, BorderLayout.EAST); // Adicionado ao lado direito
            panelFilmes.add(panelFilme);
        }
        panelFilmes.revalidate();
        panelFilmes.repaint();
    }
}