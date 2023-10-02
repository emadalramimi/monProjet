package IHM;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import modele.Panier;

public class Coordonnées extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldPrenom;
	private JTextField textFieldAdresse1;
	private JTextField textFieldAdresse2;
	private JTextField textFieldVille;
	private JTextField textFieldCp;
	private JTextField textFieldTelephone;
	private JTextField textFieldMail;
	private String moyenPaiement;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					Panier panier = new Panier();
					Coordonnées frame = new Coordonnées(panier);
					frame.setSize(400, 500);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Coordonnées(Panier panier) {
		this.setTitle("Ô'Tomates");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("images\\autres\\LogoTomate.png"));

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 609, 478);

		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(this.contentPane);
		this.contentPane.setLayout(new BoxLayout(this.contentPane, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		this.contentPane.add(panel);

		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JLabel lblNewLabel = new JLabel("Vos coordonnées  ");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setIcon(new ImageIcon("images\\autres\\LogoTomate.png"));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new GridLayout(8, 2, 10, 10));
		this.contentPane.add(panel_1);

		JLabel lblNewLabel_2 = new JLabel("Nom :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);

		this.textFieldName = new JTextField();
		this.textFieldName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.textFieldName.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(this.textFieldName);

		this.textFieldName.setColumns(10);
		JLabel lblNewLabel_3 = new JLabel("Prénom :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_3);

		this.textFieldPrenom = new JTextField();
		this.textFieldPrenom.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.textFieldPrenom.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(this.textFieldPrenom);

		this.textFieldPrenom.setColumns(10);
		JLabel lblNewLabel_4 = new JLabel("Adresse 1 : ");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panel_1.add(lblNewLabel_4);

		this.textFieldAdresse1 = new JTextField();
		this.textFieldAdresse1.setHorizontalAlignment(SwingConstants.LEFT);
		this.textFieldAdresse1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panel_1.add(this.textFieldAdresse1);

		this.textFieldAdresse1.setColumns(10);
		JLabel lblNewLabel_5 = new JLabel("Adresse 2 : ");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_5);

		this.textFieldAdresse2 = new JTextField();
		this.textFieldAdresse2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.textFieldAdresse2.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(this.textFieldAdresse2);

		this.textFieldAdresse2.setColumns(10);
		JLabel lblNewLabel_6 = new JLabel("Code Postal : ");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_6);

		this.textFieldCp = new JTextField();
		this.textFieldCp.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.textFieldCp.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(this.textFieldCp);

		this.textFieldCp.setColumns(10);
		JLabel lblNewLabel_7 = new JLabel("Ville : ");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_7);

		this.textFieldVille = new JTextField();
		this.textFieldVille.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.textFieldVille.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(this.textFieldVille);

		this.textFieldVille.setColumns(10);
		JLabel lblNewLabel_7_1 = new JLabel("Téléphone :");
		lblNewLabel_7_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_7_1);

		this.textFieldTelephone = new JTextField();
		this.textFieldTelephone.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.textFieldTelephone.setHorizontalAlignment(SwingConstants.LEFT);
		this.textFieldTelephone.setColumns(10);
		panel_1.add(this.textFieldTelephone);

		JLabel lblNewLabel_7_2 = new JLabel("Mail :");
		lblNewLabel_7_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_7_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_7_2);

		this.textFieldMail = new JTextField();
		this.textFieldMail.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.textFieldMail.setHorizontalAlignment(SwingConstants.LEFT);
		this.textFieldMail.setColumns(10);
		panel_1.add(this.textFieldMail);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 0), 2), "Moyen de paiement",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
		this.contentPane.add(panel_2);
		ButtonGroup buttonGroup = new ButtonGroup();
		JRadioButton rdbtnCB = new JRadioButton("Carte de crédit");
		rdbtnCB.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdbtnCB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Coordonnées.this.moyenPaiement = "Carte de crédit";
			}
		});

		panel_2.add(rdbtnCB);
		buttonGroup.add(rdbtnCB);
		JRadioButton rdbtnPaypal = new JRadioButton("Paypal");
		rdbtnPaypal.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdbtnPaypal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Coordonnées.this.moyenPaiement = "Paypal";
			}
		});

		panel_2.add(rdbtnPaypal);
		buttonGroup.add(rdbtnPaypal);
		JRadioButton rdbtnCheque = new JRadioButton("Paiement par chèque");
		rdbtnCheque.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdbtnCheque.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Coordonnées.this.moyenPaiement = "Paiement par cheque";
			}
		});

		panel_2.add(rdbtnCheque);
		buttonGroup.add(rdbtnCheque);
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 0), 2), "Abonnement à notre newletter",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
		this.contentPane.add(panel_3);

		ButtonGroup buttonGroup2 = new ButtonGroup();

		JRadioButton rdbtnY = new JRadioButton("Oui");
		rdbtnY.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panel_3.add(rdbtnY);
		buttonGroup2.add(rdbtnY);

		JRadioButton rdbtnN = new JRadioButton("Non");
		rdbtnN.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panel_3.add(rdbtnN);
		buttonGroup2.add(rdbtnN);

		JPanel panel_4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel_4.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 0), 0), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		this.contentPane.add(panel_4);

		JButton btnOk = new JButton("OK");
		btnOk.setForeground(new Color(255, 255, 255));
		btnOk.setBackground(new Color(0, 128, 0));
		btnOk.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nom = Coordonnées.this.textFieldName.getText();
				String prenom = Coordonnées.this.textFieldPrenom.getText();
				String adresse1 = Coordonnées.this.textFieldAdresse1.getText();
				String adresse2 = Coordonnées.this.textFieldAdresse2.getText();
				String CP = Coordonnées.this.textFieldCp.getText();
				String Ville = Coordonnées.this.textFieldVille.getText();
				String Telephone = Coordonnées.this.textFieldTelephone.getText();
				String Mail = Coordonnées.this.textFieldMail.getText();
				Facture frame = new Facture(nom, prenom, adresse1, adresse2, CP, Ville, Telephone, Mail,
						Coordonnées.this.moyenPaiement);
				frame.setVisible(true);
			}
		});
		panel_4.add(btnOk);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBackground(new Color(255, 0, 0));
		btnAnnuler.setForeground(new Color(255, 255, 255));
		btnAnnuler.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnAnnuler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Coordonnées.this.dispose();
			}
		});
		panel_4.add(btnAnnuler);
	}
}