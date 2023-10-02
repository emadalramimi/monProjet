package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import modele.Tomates;

public class Conseils extends JFrame {

	private JPanel contentPane;
	private JTextArea TitreTextArea;
	private JTextArea bodyTextArea;


	public Conseils() {
		this.setTitle("Ô'Tomates");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("images\\autres\\LogoTomate.png"));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 458, 431);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelTitre = new JPanel();
		this.contentPane.add(panelTitre, BorderLayout.NORTH);
		panelTitre.setLayout(new BorderLayout(0, 0));

		JLabel lblTitre = new JLabel("Conseils de culture   ");
		lblTitre.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblTitre.setForeground(new Color(0, 128, 0));
		panelTitre.add(lblTitre);

		JLabel lblNewLabelIcon = new JLabel(new ImageIcon("images/autres/LogoTomate.png"));
		panelTitre.add(lblNewLabelIcon, BorderLayout.EAST);

		JPanel panelText = new JPanel();
		this.contentPane.add(panelText, BorderLayout.CENTER);
		panelText.setLayout(new BorderLayout(0, 0));

		this.TitreTextArea = new JTextArea(Tomates.CONSEILS_DE_CULTURE_TITRE);
		this.TitreTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.TitreTextArea.setForeground(new Color(0, 128, 0));
		this.TitreTextArea.setEditable(false);
		this.TitreTextArea.setLineWrap(true);
		this.TitreTextArea.setWrapStyleWord(true);
		panelText.add(this.TitreTextArea, BorderLayout.NORTH);

		JScrollPane scrollPane = new JScrollPane();
		panelText.add(scrollPane, BorderLayout.CENTER);

		this.bodyTextArea = new JTextArea(Tomates.CONSEILS_DE_CULTURE);
		this.bodyTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.bodyTextArea.setEditable(false);
		this.bodyTextArea.setLineWrap(true);
		this.bodyTextArea.setWrapStyleWord(true);
		scrollPane.setViewportView(this.bodyTextArea);

		JPanel panel_2 = new JPanel();
		this.contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));

		JButton btnOK = new JButton("OK");
		btnOK.setForeground(new Color(255, 255, 255));
		btnOK.setBackground(new Color(0, 128, 0));
		btnOK.setFont(new Font("Times New Roman", Font.PLAIN, 12));
	    btnOK.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            Conseils.this.dispose(); // Ferme la fenêtre "Conseils"
	        }
	    });
	    panel_2.add(btnOK, BorderLayout.EAST);
	}
}
