package main;

import java.io.IOException;
import fr.unistra.pelican.ByteImage;
import fr.unistra.pelican.algorithms.io.ImageSave;


public class Test2 {

	public static void main(String[] args) throws IOException {

		//Déclarer une nouvelle image à 3 canaux
		ByteImage new_img = new ByteImage(300, 300, 1, 1, 3);

		//Accès au canal rouge (canal 0) du pixel p(5,10)
		int r = new_img.getPixelXYBByte(5, 10, 0);
		//Accès au canal vert (canal 1) du pixel p(5,10)
		int g = new_img.getPixelXYBByte(5, 10, 1);
		//Accès au canal vert (canal 2) du pixel p(5,10)
		int b = new_img.getPixelXYBByte(5, 10, 2);

		//Affecter la couleur bleu indigo [121, 28, 248] au pixel p(5,10)
		new_img.setPixelXYBByte(5, 10, 0,121);
		new_img.setPixelXYBByte(5, 10, 1,28);
		new_img.setPixelXYBByte(5, 10, 2,248);

		//Parcourir l'ensemble des pixels d'une image et affecter la couleur verte (0,255,0) à tous les pixels
		for(int x=0; x<new_img.getXDim();x++){
			for(int y=0; y<new_img.getYDim();y++){
				new_img.setPixelXYBByte(x, y, 0, 0);
				new_img.setPixelXYBByte(x, y, 1, 255);
				new_img.setPixelXYBByte(x, y, 2, 0);
			}
		}

		//Sauvegarder une image
		ImageSave.exec(new_img,"img/vert.jpg");

	}

}
