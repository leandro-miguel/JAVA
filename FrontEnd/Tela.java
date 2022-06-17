package FrontEnd;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.Arrays;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.io.*;
import java.awt.TextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import java.awt.ScrollPane;
import javax.swing.JTextArea;
import java.awt.Button;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Tela extends JFrame {

//	Atributos
	private JPanel contentPane;
	protected String arquivo;
	protected String resultado;
	protected String teste;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
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
	public Tela() {
		setTitle("SORTEIO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 308);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenu mnNewMenu = new JMenu("Instru\u00E7\u00F5es");
		mnMenu.add(mnNewMenu);
		
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnSalvarNomes = new JButton("Salvar");
		btnSalvarNomes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.setSelectedFile(new File("fileToSave.txt"));
				int returnVal = jFileChooser.showOpenDialog(getParent());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
//				       System.out.println("You chose to open this file: " +
//				    		   jFileChooser.getSelectedFile().getName());
//				       JOptionPane.showConfirmDialog(null, "You chose to open this file: " +
//				    		   jFileChooser.getSelectedFile().getName());
				}

			}
		});
		
		JTextPane panelHelp = new JTextPane();
		panelHelp.setBackground(Color.GRAY);
		panelHelp.setEditable(false);
		panelHelp.setText("1 - Clique em Procurar algum arquivo de texto que possui os nomes.\n"
				+ "2 - Clique em Sorteio\n" 
				+ "3 - Para limpar os resultados, use o botão de limpar \n" + "4 - De acordo com as regras do servidor, "
						+ "o usuário tem que no ter no mínimo ter 3 votações\n");
		panelHelp.setBounds(119, 11, 305, 225);
		contentPane.add(panelHelp);
		
		ScrollPane scrollPaneHelp = new ScrollPane();
		scrollPaneHelp.setBackground(Color.GRAY);
		scrollPaneHelp.setBounds(109, 0, 325, 247);
		contentPane.add(scrollPaneHelp);
		
		scrollPaneHelp.setVisible(false);
		
		
		
		btnSalvarNomes.setBounds(168, 66, 89, 23);
		contentPane.add(btnSalvarNomes);

		btnSalvarNomes.setVisible(false);
		panelHelp.setVisible(false);

		JTextPane textPanelCaminhoFile = new JTextPane();
		textPanelCaminhoFile.setEditable(false);
		textPanelCaminhoFile.setBounds(109, 21, 315, 23);
		contentPane.add(textPanelCaminhoFile);

		JTextPane textPaneResultadoQtd = new JTextPane();
		textPaneResultadoQtd.setEditable(false);
		textPaneResultadoQtd.setBounds(10, 195, 414, 23);
		contentPane.add(textPaneResultadoQtd);

		JTextPane textPaneResultado = new JTextPane();
		textPaneResultado.setEditable(false);
		textPaneResultado.setBounds(10, 140, 414, 23);
		contentPane.add(textPaneResultado);

		JButton btnSorteio = new JButton("Sorteio");
		btnSorteio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar mes = Calendar.getInstance();
				List<String[]> lista = new ArrayList<>();
				FileReader fr = null;
				try {
					fr = new FileReader(arquivo);
				} catch (FileNotFoundException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}

				BufferedReader br = new BufferedReader(fr);

				String str;
				try {
					while ((str = br.readLine()) != null) {
						lista.add(str.split("\n"));
					}
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				String[] vencedor = lista.get(new Random().nextInt(lista.size()));
				var aux = 0;
				for (int i = 0; i < lista.size(); i++) {
					Object nomes = Arrays.toString(lista.get(i));
					Object winner = Arrays.toString(vencedor);
					if (nomes.equals(winner)) {
						aux++;
					}
				}
				System.out.println(aux);

				try {
					br.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("O Vencedor do mês " + mes.get(Calendar.MONTH) + " é " + Arrays.toString(vencedor));

				resultado = "O Vencedor do mês " + mes.get(Calendar.MONTH) + " é " + Arrays.toString(vencedor);

				textPaneResultado.setText(resultado);
				textPaneResultadoQtd.setText(String.valueOf(aux));

			}
		});
		
		JButton btnAbrirHelp = new JButton("Open");
		btnAbrirHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPaneHelp.setVisible(true);
				panelHelp.setVisible(true);
				btnSorteio.setVisible(false);
				
			}
		});
		mnNewMenu.add(btnAbrirHelp);
		
		JButton btnFecharHelp = new JButton("Closed");
		btnFecharHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPaneHelp.setVisible(false);
				panelHelp.setVisible(false);
				btnSorteio.setVisible(true);
			}
		});
		mnNewMenu.add(btnFecharHelp);
		
		JButton btnCarregar = new JButton("Carregar");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser openFile = new JFileChooser();
				openFile.showOpenDialog(null);
				arquivo = openFile.getSelectedFile().toString();
				textPanelCaminhoFile.setText(arquivo);
				btnSorteio.setVisible(true);
				btnSalvarNomes.setVisible(false);
				textPaneResultado.setVisible(true);
				btnSalvarNomes.setVisible(false);
				
			}
		});
		btnCarregar.setBounds(10, 21, 89, 23);
		contentPane.add(btnCarregar);

		btnSorteio.setBounds(168, 66, 89, 23);
		contentPane.add(btnSorteio);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPaneResultado.setText("");
				textPaneResultadoQtd.setText("");
			}
		});
		btnLimpar.setBounds(335, 66, 89, 23);
		contentPane.add(btnLimpar);

		JButton btnNomes = new JButton("Nomes");
		btnNomes.setEnabled(false);
		btnNomes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextArea textAreaNome = new TextArea();
				textAreaNome.setBounds(10, 100, 414, 160);
				contentPane.add(textAreaNome);
				textPaneResultado.setVisible(false);
				btnSorteio.setVisible(false);
				btnSalvarNomes.setVisible(true);
			}
		});
		btnNomes.setBounds(10, 66, 89, 23);
		contentPane.add(btnNomes);

		JLabel lblNewLabel = new JLabel("Vencedor");
		lblNewLabel.setBounds(185, 115, 74, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Quantidade de vezes que votou");
		lblNewLabel_1.setBounds(133, 174, 182, 14);
		contentPane.add(lblNewLabel_1);

	}
}
