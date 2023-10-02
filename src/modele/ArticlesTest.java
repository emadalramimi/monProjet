package modele;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class ArticlesTest {

	@Test
	public void testTomates() {
		assertEquals(47, GenerationArticle.générationDeBaseDesTomates().tomatesDeType(TypeTomate.TOMATES).size());
		assertEquals(GenerationArticle.GenerationTomates(),
				GenerationArticle.générationDeBaseDesTomates().tomatesDeType(TypeTomate.TOMATES));
	}

	@Test
	public void testTomatesAppariement() {
		List<Tomate> tomates = GenerationArticle.générationDeBaseDesTomates().tomatesDeType(TypeTomate.TOMATES);
		for (Tomate tomate : tomates) {
			assertEquals(4, tomate.getTomatesApparentées().size());
		}
	}

	@Test
	public void testTomatesCerises() {
		assertEquals(16,
				GenerationArticle.générationDeBaseDesTomates().tomatesDeType(TypeTomate.TOMATES_CERISES).size());
		assertEquals(GenerationArticle.GenerationTomatesCerises(),
				GenerationArticle.générationDeBaseDesTomates().tomatesDeType(TypeTomate.TOMATES_CERISES));
	}

	@Test
	public void testTomatesCerisesAppariement() {
		List<Tomate> tomates = GenerationArticle.générationDeBaseDesTomates().tomatesDeType(TypeTomate.TOMATES_CERISES);
		for (Tomate tomate : tomates) {
			assertEquals(4, tomate.getTomatesApparentées().size());
		}
	}

	@Test
	public void testTomatesEtTomatesCerisesParCouleur() {
		for (int i = 0; i < Couleur.values().length; i++) {
			List<Tomate> tomates = GenerationArticle.générationDeBaseDesTomates().tomatesDeCouleur(Couleur.values()[i]);
			assertTrue(tomates.size() > 0);
			for (Tomate tomate : tomates) {
				assertEquals(Couleur.values()[i], tomate.getCouleur());
			}
		}
	}

	@Test
	public void testTomatesParCouleur() {
		for (int i = 0; i < Couleur.values().length; i++) {
			List<Tomate> tomates = GenerationArticle.générationDeBaseDesTomates()
					.tomatesDetypeDeCouleur(Couleur.values()[i], TypeTomate.TOMATES);
			assertTrue(tomates.size() > 0);
			for (Tomate tomate : tomates) {
				assertEquals(TypeTomate.TOMATES, tomate.getTypeGraine());
				assertEquals(Couleur.values()[i], tomate.getCouleur());
			}
		}
	}

	@Test
	public void testTomatesCerisesParCouleur() {
		for (int i = 0; i < Couleur.values().length; i++) {
			List<Tomate> tomates = GenerationArticle.générationDeBaseDesTomates()
					.tomatesDetypeDeCouleur(Couleur.values()[i], TypeTomate.TOMATES_CERISES);
			if (!(Couleur.values()[i] == Couleur.MULTICOLORE) && !(Couleur.values()[i] == Couleur.BLEU)) {
				assertTrue(tomates.size() > 0);
				for (Tomate tomate : tomates) {
					assertEquals(TypeTomate.TOMATES_CERISES, tomate.getTypeGraine());
					assertEquals(Couleur.values()[i], tomate.getCouleur());
				}
			}
		}
	}

	@Test
	public void testGetterTomateParDésignation() {
		Tomates articles = GenerationArticle.générationDeBaseDesTomates();
		assertNotNull(articles.getTomate("Tomate Brandywine"));
		assertNull(articles.getTomate("Tomate Brandywine goes to Hollywood"));
		assertEquals("Tomate Brandywine", articles.getTomate("Tomate Brandywine").getDésignation());
	}

}
