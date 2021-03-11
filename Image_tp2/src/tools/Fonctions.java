package tools;

import java.io.IOException;

import fr.unistra.pelican.ByteImage;
import fr.unistra.pelican.Image;

public class Fonctions {
	public Fonctions() {
		
	}
	
	public Image CouleurVersGris(Image img) {
		int l = img.getXDim();
		int h = img.getYDim();
		int c = img.getBDim();
		
		if (c==3) {
			ByteImage new_img = new ByteImage(l, h, 1, 1, c);
			for(int i=0; i<l; i++) {
				for (int j=0; j<h;j++) {
					int newColor = (img.getPixelXYBByte(i, j, 0) + img.getPixelXYBByte(i, j, 1) + img.getPixelXYBByte(i, j, 2))/3; 
					new_img.setPixelXYBByte(i,j,0,newColor);
					new_img.setPixelXYBByte(i,j,1,newColor);
					new_img.setPixelXYBByte(i,j,2,newColor);
				}
			}
			return new_img;
		}
		else {
			System.out.println("L'imgae est déjà en couleur gris");
			return null;
		}
	}
	
	public Image binarisation(Image img, int S) {
		int l = img.getXDim();
		int h = img.getYDim();
		int c = img.getBDim();
		
		if (c==1) {
			ByteImage new_img = new ByteImage(l, h, 1, 1, c);
			for(int i=0; i<l; i++) {
				for (int j=0; j<h;j++) {
					if(img.getPixelXYBByte(i, j, 0)<=S)
						new_img.setPixelXYBByte(i,j,0,0);
					else
						new_img.setPixelXYBByte(i,j,0,255);
				}
			}
			return new_img;
		}
		else {
			System.out.println("Il faut entrer une image à niveau de gris");
			return null;
		}
	}
	
	public Image etirerContraste(Image img) {
		int l = img.getXDim();
		int h = img.getYDim();
		int c = img.getBDim();
		
		if (c==1) {
			ByteImage new_img = new ByteImage(l, h, 1, 1, c);
			
			int max = 0, min = 0;
			max = min =  img.getPixelXYBByte(0, 0, 0);
			for(int i = 0;i < l; i++) {
				for(int j = 0; j < h;j++) {
					if (img.getPixelXYBByte(i, j, 0) < min)
						min = img.getPixelXYBByte(i, j, 0);
					if(img.getPixelXYBByte(i, j, 0) > max)
						max = img.getPixelXYBByte(i, j, 0);
				}			
			}
			System.out.println("valeur max : " + max + "  | valeur min : " + min );

			int newContraste;
			for(int i=0; i<l; i++) {
				for (int j=0; j<h;j++) {
					newContraste = 255*(img.getPixelXYBByte(i, j, 0)-min)/(max-min);
					new_img.setPixelXYBByte(i,j,0,newContraste);
				}
			}
			return new_img;
		}
		else {
			System.out.println("Il faut entrer une image à niveau de gris");
			return null;
		}
	}
	
	
	public void afficheHistogramme(Image img) throws IOException {
		int l = img.getXDim();
		int h = img.getYDim();
		int c = img.getBDim();
		
		double[] tabHist = new double[256];
		
		for(int i=0; i<tabHist.length;i++) {
			tabHist[i]=0;
		}
		
		if(c==1) {
			for(int i=0; i<l; i++) {
				for (int j=0; j<h;j++) {
					int a = img.getPixelXYBByte(i, j, 0);
					tabHist[a]++;
				}
			}
		
			HistogramTools histo = new HistogramTools();
			histo.plotHistogram(tabHist);
		}
		else {
			System.out.println("Il faut entrer une image à niveau de gris");
		}
	}
	
	
	public void egalisationHistogramme(Image img) throws IOException {
		int l = img.getXDim();
		int h = img.getYDim();
		int c = img.getBDim();
		
		double[] tabHist = new double[256];
		
		for(int i=0; i<tabHist.length;i++) {
			tabHist[i]=0;
		}
		
		if(c==1) {
			for(int i=0; i<l; i++) {
				for (int j=0; j<h;j++) {
					int a = img.getPixelXYBByte(i, j, 0);
					tabHist[a]++;
				}
			}
			double[] tabHistCumule = new double[256];
			tabHistCumule[0]=tabHist[0];
			
			for(int i=1; i<tabHist.length; i++) {
				tabHistCumule[i]=tabHist[i-1]+tabHist[i];
			}
			
			double[] transf = new double[256];
			
			for(int i=0; i<tabHist.length; i++) {
				transf[i]=((i-1)/(l*h))*tabHistCumule[i];
			}
			
			
		
			HistogramTools histo = new HistogramTools();
			histo.plotHistogram(transf);
		}
		else {
			System.out.println("Il faut entrer une image à niveau de gris");
		}
	}
}
