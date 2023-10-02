package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Facture extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Facture frame = new Facture(null, null, null, null, null, null, null, null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Facture(String nom, String prenom, String adresse1, String adresse2, String CP, String Ville,
			String Telephone, String Mail, String moyenDePaiement) {
		this.setTitle("Ô'Tomates");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("images\\autres\\LogoTomate.png"));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 509, 338);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBorder(new LineBorder(new Color(176, 196, 222), 2));
		this.contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setPreferredSize(new Dimension(100, 40));
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("Votre facture");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setForeground(new Color(50, 205, 50));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel.setToolTipText("");
		String imagePath = "images\\autres\\LogoTomate.png";
		ImageIcon imageIcon = new ImageIcon(imagePath);
		Image image = imageIcon.getImage();
		Image scaledImage = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		lblNewLabel.setIcon(scaledIcon);
		panel_1.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		this.contentPane.add(scrollPane, BorderLayout.CENTER);

		JTextPane p = new JTextPane();
		p.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		scrollPane.setViewportView(p);

		p.setText("INFORMATION CLIENT " + "\n" + "Nom : " + nom + " " + "\n" + "Prénom : " + prenom + "\n" + "Adresse 1: " + adresse1 + "\n"
				+ "Adresse 2: " + adresse2 + "\n" + "Code Postal: " + CP + "\n" + "Ville: " + Ville + "\n"
				+ "Téléphone: " + Telephone + "\n" + "E-mail: " + Mail + "\n" + "Moyen de paiement: " + moyenDePaiement
				+ "\n");

		// Changer la police du texte
		SimpleAttributeSet style = new SimpleAttributeSet();
		StyleConstants.setFontFamily(style, "Times New Roman");
		StyleConstants.setFontSize(style, 14);

		StyledDocument doc = p.getStyledDocument();
		doc.setCharacterAttributes(0, p.getText().length(), style, true);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		this.contentPane.add(panel, BorderLayout.SOUTH);
		panel.setPreferredSize(new Dimension(100, 40));

		JButton btnPrint = new JButton("Imprimer");
		btnPrint.setForeground(new Color(255, 255, 255));
		btnPrint.setBackground(new Color(0, 128, 0));
		btnPrint.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnPrint.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					p.print();
				} catch (PrinterException ex) {
					ex.printStackTrace();
				}
			}
		});
		panel.add(btnPrint);

		JButton btnNewButton_1 = new JButton("Quitter");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Facture.this.dispose();
			}
		});
		panel.add(btnNewButton_1);
	}
	
	
}
