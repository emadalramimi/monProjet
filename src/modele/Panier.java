package modele;

import java.util.ArrayList;
import java.util.List;

public class Panier {
	private Tomates tomates;
	private List<Integer> quantité;
	public final static float FORFAIT = 4.5F;

	public Panier() {
		this.tomates = new Tomates();
		this.quantité = new ArrayList<Integer>();
	}

	public void addToPanier(Tomate tomate, int quantité) {
		this.tomates.addTomate(tomate);
		this.quantité.add(quantité);
	}

	public Tomates getTomatesPanier() {
		return this.tomates;
	}

	public List<Integer> getQuantitéPanier() {
		return this.quantité;
	}

	public List<Float> getPrixTTCTomate() {
		List<Float> liste_temp = new ArrayList<Float>();
		for (Tomate tom : this.tomates.getLesTomates()) {
			liste_temp.add(tom.getPrixTTC());
		}
		return liste_temp;
	}

	public float getPrixTTCPanier() {
		float total = 0.0F;
		int i = 0;
		for (Tomate tom : this.tomates.getLesTomates()) {
			total = total + tom.getPrixTTC() * this.quantité.get(i);
			i++;
		}
		return total;
	}

	public float getPrixTotal() {
		return this.getPrixTTCPanier() + FORFAIT;
	}

	public void viderPanier() {
		this.tomates = new Tomates();
		this.quantité = new ArrayList<Integer>();
	}

	public void retirerTomate(String nom) {
		int i = 0;
		for (Tomate tom : this.tomates.getLesTomates()) {
			if (tom.getDésignation() == nom) {
				this.tomates.getLesTomates().remove(i);
				this.quantité.remove(i);
			}
			i++;
		}
	}

	public void modifierQuantiteTomate(String nom, int quantite) {
		int i = 0;
		for (Tomate tom : this.tomates.getLesTomates()) {
			if (tom.getDésignation() == nom) {
				this.quantité.set(i, quantite);
			}
			i++;
		}
	}
}