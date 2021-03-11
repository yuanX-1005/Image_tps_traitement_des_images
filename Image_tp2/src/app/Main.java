package app;

import java.io.IOException;

import fr.unistra.pelican.Image;
import fr.unistra.pelican.algorithms.io.ImageLoader;
import fr.unistra.pelican.algorithms.visualisation.Viewer2D;
import tools.Fonctions;

public class Main {
	
	public static void main(String args[]) throws IOException {
//		Image img1 = ImageLoader.exec("img\\eiffel.jpg"); 
//		//img1.setColor(true); //si false => affichage de chaque canal, si true => affichage d'une image couleur
//		Viewer2D.exec(img1);
//		
		Fonctions f = new Fonctions();
//		Image img2 = f.CouleurVersGris(img1);
//		
//		//img2.setColor(true); //si false => affichage de chaque canal, si true => affichage d'une image couleur
//		Viewer2D.exec(img2);
		
//		Image img3 = ImageLoader.exec("img\\foie.jpg"); 
//		//img1.setColor(true); //si false => affichage de chaque canal, si true => affichage d'une image couleur
//		Viewer2D.exec(img3);
//		
//		Image img4 = f.binarisation(img3,140);
//		Viewer2D.exec(img4);
		
		Image img5 = ImageLoader.exec("img\\plage.jpg"); 
		//img1.setColor(true); //si false => affichage de chaque canal, si true => affichage d'une image couleur
		Viewer2D.exec(img5);
		
		Image img6 = f.etirerContraste(img5);
		Viewer2D.exec(img6);
		
		f.afficheHistogramme(img5);
		f.afficheHistogramme(img6);
		f.egalisationHistogramme(img5);
		f.egalisationHistogramme(img6);
	}
}
