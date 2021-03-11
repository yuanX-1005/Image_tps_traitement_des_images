package tool;

import java.io.IOException;

import fr.unistra.pelican.Image;
import fr.unistra.pelican.algorithms.io.ImageLoader;
import fr.unistra.pelican.algorithms.noise.Speckle;
import fr.unistra.pelican.algorithms.visualisation.Viewer2D;


public class NoiseTools {

	public static Image addNoise(Image img, double noiseLevel){
	
		//Déclarer une nouvelle image pour stocker resultat
		Image result = Speckle.exec(img, noiseLevel, 2);
		
		return result;	
	}
	
	
	public static void main(String[] args) throws IOException {

		//Charger une image en memoire
		Image test= ImageLoader.exec("img/plage.jpg"); 

		Image noisyImage=addNoise(test,0.2);
		
		//Afficher une image
		noisyImage.setColor(true); //si false => affichage de chaque canal, si true => affichage d'une image couleur
		Viewer2D.exec(noisyImage);
		
		
		Traite f = new Traite();
		
		//img1.setColor(true); //si false => affichage de chaque canal, si true => affichage d'une image couleur
		
		Image imgbis = f.filtreMoy(noisyImage);
		Viewer2D.exec(imgbis);
		
		Image imgtest2 = f.filtreMedia(noisyImage);
		Viewer2D.exec(imgtest2);
		
		Image test3= ImageLoader.exec("img/momo.jpg"); 
		Viewer2D.exec(test3);
		Image img3 = f.regulationImg(test3);
		Viewer2D.exec(img3);
	}

}
