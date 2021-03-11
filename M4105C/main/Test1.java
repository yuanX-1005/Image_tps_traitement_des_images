package main;
import java.io.IOException;

import fr.unistra.pelican.Image;
import fr.unistra.pelican.algorithms.io.ImageLoader;
import fr.unistra.pelican.algorithms.visualisation.Viewer2D;


public class Test1 {

	
	public static void main(String[] args) throws IOException {

		//Charger une image en mémoire
		Image test= ImageLoader.exec("img\\eiffel.jpg"); 

		//Connaitre la hauteur et la largeur d'une image
		int largeur = test.getXDim();
		int hauteur = test.getYDim();
		
		System.out.println("Image chargÃ©e. Sa taille est "+largeur+" x "+hauteur +" pixels" );
		
		//Afficher une image
		test.setColor(false); //si false => affichage de chaque canal, si true => affichage d'une image couleur
		Viewer2D.exec(test);

	}

}
