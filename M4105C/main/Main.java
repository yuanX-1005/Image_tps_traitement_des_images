package main;

import fr.unistra.pelican.ByteImage;
import fr.unistra.pelican.Image;
import fr.unistra.pelican.algorithms.io.ImageLoader;
import fr.unistra.pelican.algorithms.visualisation.Viewer2D;

public class Main {
	
	public static void main(String args[]) {
//	Image img = null;
//	
//	img = lectureImage("img\\eiffel.jpg");
//	affichage(img);
//	
//	
//	img.setColor(false); //si false => affichage de chaque canal, si true => affichage d'une image couleur
//	Viewer2D.exec(img);
//	
//	ByteImage newImage = créerImage();
//	newImage.setColor(false);
//	Viewer2D.exec(newImage);
//	
//	Image imgG = lectureImage("img\\iut.jpg");
//	extrema(imgG);
//	imgG.setColor(false); //si false => affichage de chaque canal, si true => affichage d'une image couleur
//	Viewer2D.exec(imgG);
	
	Image imgI = lectureImage("img\\iut.jpg");
	Image imgI2 = inverser(imgI);
	imgI.setColor(false); //si false => affichage de chaque canal, si true => affichage d'une image couleur
	Viewer2D.exec(imgI);
	imgI2.setColor(false); //si false => affichage de chaque canal, si true => affichage d'une image couleur
	Viewer2D.exec(imgI2);
	
	
	}
	
	
	public static Image lectureImage(String filename) {
		Image img = ImageLoader.exec(filename);
		
		int largeur = img.getXDim();
		int hauteur = img.getYDim();
		
		int canal = img.getBDim();
		
		System.out.println("largeur : " + largeur + " | hauteur : " + hauteur + " | canal : " + canal);
		

		return img;
	}
	
	public static void affichage(Image img) {
		
		for(int x = 0; x < img.getXDim();x++){
			for(int y = 0; y < img.getYDim();y++){
				if(img.getBDim()==3) {
					int r = img.getPixelXYBByte(x, y, 0);
					int v = img.getPixelXYBByte(x, y, 1);
					int b = img.getPixelXYBByte(x, y, 2);
					System.out.print(r + " " + v + " " + b + " \t" );
				}
				else {
					int g = img.getPixelXYBByte(x, y, 0);
					System.out.print(g + " \t" );
				}
				
			}
			System.out.println("\n");
		}
	}
	
	
	public static ByteImage créerImage() {
		int largeur = 450, hauteur = 300;
		ByteImage new_img = new ByteImage(largeur, hauteur, 1, 1, 1);
		
		for(int i = 0; i < largeur; i++ ) {
			for(int j = 0; j < hauteur; j++) {
				new_img.setPixelXYBByte(i, j, 0, 255);
			}
		}
		
		for(int i = (largeur/2)-25;i < (largeur/2)+25; i++) {
			for(int j = 0; j<hauteur;j++) 
			new_img.setPixelXYBByte(i, j, 0, 0);
			
		}
			
		for(int i = 0;i < largeur; i++) {
			for(int j = (hauteur/2)-25; j<(hauteur/2)+25;j++) {
				new_img.setPixelXYBByte(i, j, 0, 0);
			}			
		}
		
		
		/*
		 * new_img.setColor(false); //si false => affichage de chaque canal, si true =>
		 * affichage d'une image couleur Viewer2D.exec(new_img);
		 */
		
		return new_img;
		
	}
	
	public static void extrema(Image img) {
		if(img.getBDim() == 1) {
			int max = 0, min = 0;
			max = min =  img.getPixelXYBByte(0, 0, 0);
			for(int i = 0;i < img.getXDim(); i++) {
				for(int j = 0; j < img.getYDim();j++) {
					if (img.getPixelXYBByte(i, j, 0) < min)
						min = img.getPixelXYBByte(i, j, 0);
					if(img.getPixelXYBByte(i, j, 0) > max)
						max = img.getPixelXYBByte(i, j, 0);
				}			
			}
			System.out.println("valeur max : " + max + "  | valeur min : " + min );
		}
	}
	
	
	public static Image inverser(Image img) {
		int l = img.getXDim();
		int h = img.getYDim();
		int c = img.getBDim();
		
		ByteImage new_img = new ByteImage(l, h, 1, 1, c);
		for(int i = 0, x = l-1 ;i < l && x > 0; i++, x--) {
			for(int j = 0; j < h;j++) {
				if(c==1) {
					new_img.setPixelXYBByte(i,j,0,img.getPixelXYBByte(x, j, 0));
				}
				if(c==3) {
					new_img.setPixelXYBByte(i,j,0,img.getPixelXYBByte(x, j, 0));
					new_img.setPixelXYBByte(i,j,1,img.getPixelXYBByte(x, j, 1));
					new_img.setPixelXYBByte(i,j,2,img.getPixelXYBByte(x, j, 2));
				}
			}			
		}

		return new_img;
	}
}
