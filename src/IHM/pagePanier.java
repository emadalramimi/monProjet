package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modele.GenerationArticle;
import modele.Panier;
import modele.Tomate;

public class pagePanier extends JFrame {

	private JPanel contentPane;
	private JTextField PrixTTC;
	private JTextField Expedition;
	private JTextField Total;
	private DefaultTableModel modeleTable;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					pagePanier frame = new pagePanier(new Panier());
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
	public pagePanier(Panier Panier) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.setContentPane(this.contentPane);
		this.contentPane.setLayout(new BoxLayout(this.contentPane, BoxLayout.Y_AXIS));

		JPanel panelTitre = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelTitre.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		this.contentPane.add(panelTitre);

		JLabel lblTitre = new JLabel("Votre Panier");
		lblTitre.setForeground(new Color(0, 128, 0));
		lblTitre.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitre.setVerticalAlignment(SwingConstants.TOP);
		lblTitre.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		panelTitre.add(lblTitre);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("images/autres/caddie.png"));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		panelTitre.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		this.contentPane.add(scrollPane);

		this.modeleTable = new DefaultTableModel(new Object[] { "", "Produit", "Prix", "Quantité", "Total" }, 0);
		this.table = new JTable();
		scrollPane.setViewportView(this.table);
		this.table.setModel(this.modeleTable);
		this.table.setEnabled(false);

		Iterator<Tomate> itr = Panier.getTomatesPanier().getLesTomates().iterator();
		Iterator<Integer> itr2 = Panier.getQuantitéPanier().iterator();

		while (itr.hasNext()) {
			Tomate tomate = itr.next();
			int quantité = itr2.next();
			this.modeleTable
					.addRow(new Object[] { new ImageIcon("images/Tomates200x200/" + tomate.getNomImage() + ".jpg"),
							tomate.getDésignation(), tomate.getPrixTTC(), quantité, tomate.getPrixTTC() * quantité });
		}

		JPanel p2 = new JPanel();
		this.contentPane.add(p2);
		p2.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		p2.add(panel, BorderLayout.EAST);
		panel.setLayout(new GridLayout(3, 2, 0, 0));

		JLabel lblNewLabel_1 = new JLabel("Sous-Total :");
		panel.add(lblNewLabel_1);

		this.PrixTTC = new JTextField();
		panel.add(this.PrixTTC);
		this.PrixTTC.setColumns(10);
		this.PrixTTC.setText(Panier.getPrixTTCPanier() + " €");

		JLabel lblNewLabel_3 = new JLabel("Expédition (forfait) :");
		panel.add(lblNewLabel_3);

		this.Expedition = new JTextField();
		panel.add(this.Expedition);
		this.Expedition.setColumns(10);
		this.Expedition.setText(4.50 + " €");

		JLabel lblTotal = new JLabel("TOTAL :");
		panel.add(lblTotal);

		this.Total = new JTextField();
		panel.add(this.Total);
		this.Total.setColumns(10);
		this.Total.setText(Panier.getPrixTotal() + " €");

		JPanel panel_1 = new JPanel();
		p2.add(panel_1, BorderLayout.SOUTH);

		JButton btnValider = new JButton("Valider le panier");
		btnValider.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Coordonnées frame = new Coordonnées(Panier);
				frame.setVisible(true);
				pagePanier.this.dispose();
			}
		});
		panel_1.add(btnValider);

		JButton btnValider_1 = new JButton("Vider le panier");
		btnValider_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pagePanier.this.modeleTable.setRowCount(0);
				Panier.viderPanier();
			}
		});
		panel_1.add(btnValider_1);

		JButton btnContinuer = new JButton("Continuer les achats");
		panel_1.add(btnContinuer);
		btnContinuer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Accueil frame = new Accueil(GenerationArticle.générationDeBaseDesTomates(), Panier);
				frame.setVisible(true);
				pagePanier.this.dispose();
			}
		});

		JButton btnRecalculer = new JButton("Recalculer le panier");
		btnRecalculer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pagePanier.this.PrixTTC.setText(Panier.getPrixTTCPanier() + " €");
				pagePanier.this.Expedition.setText(4.50 + " €");
				pagePanier.this.Total.setText(Panier.getPrixTotal() + " €");
			}
		});
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		buttonPanel.add(btnRecalculer);
		p2.add(buttonPanel, BorderLayout.WEST);
	}

}