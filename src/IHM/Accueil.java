package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import modele.Couleur;
import modele.GenerationArticle;
import modele.Panier;
import modele.Tomate;
import modele.Tomates;
import modele.TypeTomate;

public class Accueil extends JFrame {

	private JPanel contentPane;

	private JComboBox<String> comboBoxCouleur;
	private JComboBox<String> comboBoxType;
	private JList<String> listeDeTomates;

	private Tomates tomates;
	private Panier panier;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Panier panier = new Panier();

					Tomates tomates = GenerationArticle.générationDeBaseDesTomates();
					Accueil frame = new Accueil(tomates, panier);
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
	public Accueil(Tomates tomates, Panier panier) {
		this.setTitle("Ô'Tomates");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("images/autres/LogoTomate.png"));
		this.tomates = tomates;

		this.panier = panier;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 574, 445);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		this.contentPane.add(scrollPane, BorderLayout.CENTER);

		List<String> listeNoms = new ArrayList<>();
		for (Tomate t : this.tomates.getLesTomates()) {
			listeNoms.add(t.getDésignation());
		}

		this.listeDeTomates = new JList(listeNoms.toArray());
		this.listeDeTomates.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.listeDeTomates.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					String selectedValue = Accueil.this.listeDeTomates.getSelectedValue();
					Tomate TomatesSelect = null;
					for (Tomate t : tomates.getLesTomates()) {
						if (t.getDésignation().equals(selectedValue)) {
							TomatesSelect = t;
							Panier panier = new Panier();
							Description frame = new Description(t, panier);
							frame.setVisible(true);
						}
					}

				}
			}
		});
		scrollPane.setViewportView(this.listeDeTomates);

		JPanel panel = new JPanel();
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel.add(panel_3);

		JLabel lblNewLabel = new JLabel("Nos graines de tomates");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel.setForeground(new Color(0, 128, 0));
		panel_3.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setSize(new Dimension(60, 0));
		lblNewLabel_1.setIcon(new ImageIcon("images/autres/LogoTomate.png"));
		panel_3.add(lblNewLabel_1);

		JButton btnPanier = new JButton();
		btnPanier.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnPanier.setBackground(new Color(255, 239, 213));
		btnPanier.setText(this.panier.getPrixTTCPanier() + "€");
		btnPanier.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pagePanier frame = new pagePanier(panier);
				frame.setVisible(true);
			}
		});
		btnPanier.setIcon(new ImageIcon("images/autres/caddie.png"));
		btnPanier.setHorizontalAlignment(SwingConstants.RIGHT);
		btnPanier.setBounds(new Rectangle(20, 0, 0, 0));
		btnPanier.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel.add(btnPanier);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.contentPane.add(panel_1, BorderLayout.SOUTH);

		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 0), 2), "Filtres", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 128, 0)));
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		panel_1.add(panel_2);

		this.comboBoxType = new JComboBox<String>();
		this.comboBoxType.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.comboBoxType.addItem("Toute les tomates");
		for (TypeTomate tomate : TypeTomate.values()) {
			this.comboBoxType.addItem(tomate.getDénomination());
		}
		panel_2.add(this.comboBoxType);

		JLabel iconToute = new JLabel("");
		iconToute.setIcon(new ImageIcon("images/autres/typeTomate.png"));
		panel_2.add(iconToute);

		panel_2.add(this.comboBoxType);

		this.comboBoxCouleur = new JComboBox<String>();
		this.comboBoxCouleur.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.comboBoxCouleur.addItem("Couleurs");
		for (Couleur tomate : Couleur.values()) {
			this.comboBoxCouleur.addItem(tomate.getDénomination());
		}

		JLabel iconCouleurs = new JLabel("");
		iconCouleurs.setIcon(new ImageIcon("images/autres/typeCouleurs.png"));
		panel_2.add(iconCouleurs);

		panel_2.add(this.comboBoxCouleur);

		this.comboBoxCouleur.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Accueil.this.updateTomates();
			}
		});

		this.comboBoxType.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Accueil.this.updateTomates();
			}
		});

		JButton btnNewButton = new JButton("");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Conseils frame = new Conseils();
				frame.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon("images/autres/MainVerte.png"));
		panel_1.add(btnNewButton);

	}

	public void mettreAJourPageAccueil(Couleur couleurSelectionnee) {

		List<Tomate> tomatesDisponibles = new ArrayList<>();

		for (Tomate t : this.tomates.getLesTomates()) {
			tomatesDisponibles.add(t);
		}

		this.tomates.tomatesDeCouleurAvecListe(couleurSelectionnee, tomatesDisponibles);
	}

	private void afficherTomatesAccueil(List<Tomate> tomates) {
		for (Tomate tomate : tomates) {
			tomate.getDésignation();
		}
	}

	// Actualisation de liste de Tomates après filtrage
	private void updateTomates() {

		String typeSelectionne = (String) this.comboBoxType.getSelectedItem();
		String couleurSelectionnee = (String) this.comboBoxCouleur.getSelectedItem();
		List<String> listeNoms = new ArrayList<>();

		// Liste
		if (typeSelectionne.equals("Toute les tomates") && couleurSelectionnee.equals("Couleurs")) {
			for (Tomate t : this.tomates.getLesTomates()) {
				listeNoms.add(t.getDésignation());
			}
			// Liste avec le choix d'un couleur
		} else if (typeSelectionne.equals("Toute les tomates") && !couleurSelectionnee.equals("Couleurs")) {
			List<Tomate> tomatesFiltrees = this.tomates.tomatesDeCouleur(Couleur.getCouleur(couleurSelectionnee));
			for (Tomate t : tomatesFiltrees) {
				listeNoms.add(t.getDésignation());
			}
			// Liste avec le choix d'un type
		} else if (!typeSelectionne.equals("Toute les tomates") && couleurSelectionnee.equals("Couleurs")) {
			List<Tomate> tomatesFiltrees = this.tomates.tomatesDeType(TypeTomate.getTypeTomate(typeSelectionne));
			for (Tomate t : tomatesFiltrees) {
				listeNoms.add(t.getDésignation());
			}
			// Liste avec choix de type et de couleur
		} else {
			List<Tomate> tomatesFiltrees = this.tomates.tomatesDetypeDeCouleur(Couleur.getCouleur(couleurSelectionnee),
					TypeTomate.getTypeTomate(typeSelectionne));
			for (Tomate t : tomatesFiltrees) {
				listeNoms.add(t.getDésignation());
			}
		}
		// Mise à jour de la liste
		this.listeDeTomates.setListData(listeNoms.toArray(new String[listeNoms.size()]));
	}

}
