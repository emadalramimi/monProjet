package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import modele.GenerationArticle;
import modele.Panier;
import modele.Tomate;
import modele.Tomates;

public class Description extends JFrame {

	private JPanel contentPane;
	private Tomate tomate;
	private JTextField textPrix;
	private JTextField textNbGraine;
	private Panier panier;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Description frame = new Description(null, null);
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
	public Description(Tomate t, Panier panier) {

		this.tomate = t;
		this.panier = panier;
		this.setTitle("Ô'Tomates");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("images/autres/LogoTomate.png"));
		this.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.tomate = t;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 528, 384);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelNord = new JPanel();
		this.contentPane.add(panelNord, BorderLayout.CENTER);
		panelNord.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panelNordGauche = new JPanel();
		panelNord.add(panelNordGauche);
		panelNordGauche.setLayout(new BorderLayout(0, 0));

		JLabel lblStock = new JLabel(this.Etat());
		lblStock.setForeground(new Color(0, 128, 0));
		lblStock.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblStock.setHorizontalAlignment(SwingConstants.CENTER);
		panelNordGauche.add(lblStock, BorderLayout.SOUTH);

		JLabel lblImageTomate = new JLabel();
		lblImageTomate.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblImageTomate.setHorizontalAlignment(SwingConstants.CENTER);
		lblImageTomate.setIcon(new ImageIcon("images/Tomates200x200/" + this.tomate.getNomImage() + ".jpg"));
		panelNordGauche.add(lblImageTomate, BorderLayout.CENTER);

		JPanel panelNordTitre = new JPanel();
		panelNordGauche.add(panelNordTitre, BorderLayout.NORTH);
		panelNordTitre.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNomTotate = new JLabel(this.tomate.getDésignation());
		lblNomTotate.setForeground(new Color(34, 139, 34));
		lblNomTotate.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomTotate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panelNordTitre.add(lblNomTotate);

		JLabel lblSaut = new JLabel("");
		lblSaut.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panelNordTitre.add(lblSaut);

		JPanel panelNordDroite = new JPanel();
		panelNord.add(panelNordDroite);
		panelNordDroite.setLayout(new BorderLayout(0, 0));

		JPanel panelGraine = new JPanel();
		panelNordDroite.add(panelGraine, BorderLayout.SOUTH);

		JLabel lblGraine = new JLabel("Nombre de Graines ");
		lblGraine.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panelGraine.add(lblGraine);

		this.textNbGraine = new JTextField(String.valueOf(this.tomate.getNombreDeGraines()));
		this.textNbGraine.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.textNbGraine.setEditable(false);
		panelGraine.add(this.textNbGraine);
		this.textNbGraine.setColumns(10);

		JPanel panelDescription = new JPanel();
		panelDescription.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 0), 2), "Description",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
		panelNordDroite.add(panelDescription, BorderLayout.CENTER);

		JTextArea textArea = new JTextArea(this.tomate.getDescription());
		textArea.setEditable(false);
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(textArea);
		panelDescription.setLayout(new BorderLayout());
		panelDescription.add(scrollPane, BorderLayout.CENTER);

		JPanel panelSud = new JPanel();
		this.contentPane.add(panelSud, BorderLayout.SOUTH);
		panelSud.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel = new JPanel();
		panelSud.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBox.addItem("Produits Similaires");
		for (Tomate tomate : this.tomate.getTomatesApparentées()) {
			comboBox.addItem(tomate.getDésignation());
		}
		panel_3.add(comboBox);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);

		JLabel lblPrix = new JLabel("Prix ");
		lblPrix.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panel_2.add(lblPrix);

		this.textPrix = new JTextField("0.00 €");
		this.textPrix.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.textPrix.setEditable(false);
		panel_2.add(this.textPrix);
		this.textPrix.setColumns(10);

		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		int maxSeeds = this.tomate.getNombreDeGraines();
		SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, maxSeeds, 1);
		spinner.setModel(spinnerModel);
		Dimension spinnerSize = spinner.getPreferredSize();
		spinnerSize.width = 50;
		spinner.setPreferredSize(spinnerSize);
		panel_2.add(spinner);

		JPanel panel_1 = new JPanel();
		panelSud.add(panel_1);

		JButton btnValider = new JButton("Ajouter au panier");
		btnValider.setForeground(new Color(255, 255, 255));
		btnValider.setBackground(new Color(0, 128, 0));
		btnValider.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnValider.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int quantite = (int) spinner.getValue();
				boolean articleExiste = false;
				if (quantite == 0) {
					JOptionPane.showMessageDialog(null, "Vous n'avez pas choisi de quantité", "ATTENTION",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				for (int i = 0; i < panier.getTomatesPanier().getLesTomates().size(); i++) {
					Tomate tomatePanier = panier.getTomatesPanier().getLesTomates().get(i);
					// si il y a deja la tomata dans le panier
					if (tomatePanier.getDésignation().equals(Description.this.tomate.getDésignation())) {
						int quantiteExistante = panier.getQuantitéPanier().get(i);
						panier.getQuantitéPanier().set(i, quantiteExistante + quantite);
						articleExiste = true;
						break;
					}
				}
				if (!articleExiste) {
					panier.addToPanier(Description.this.tomate, quantite);
				}
				Description.this.dispose();
				Tomates tomates = GenerationArticle.générationDeBaseDesTomates();
				Accueil frame = new Accueil(tomates, panier);
				frame.setVisible(true);
			}
		});
		panel_1.add(btnValider);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(new Color(255, 255, 255));
		btnAnnuler.setBackground(new Color(255, 0, 0));
		btnAnnuler.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnAnnuler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Description.this.dispose(); // Ferme la fenêtre "Conseils"
			}
		});
		panel_1.add(btnAnnuler);

		// Met a jour quand on ajoute 1 au spinner
		spinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				int quantite = (int) spinner.getValue();
				float prixTotal = quantite * Description.this.tomate.getPrixTTC();
				Description.this.textPrix.setText(String.format("%.2f", prixTotal) + "€");
			}
		});
	}

	private String Etat() {
		if (this.tomate.isDisponible() != true) {
			return "Rupture de Stock";
		}
		return "En stock";
	}

}
