package tool;

import fr.unistra.pelican.ByteImage;
import fr.unistra.pelican.Image;

public class Traite {
	private static int NBFORMAT = 8;

	public Traite() {
		
	}

	
	public Image filtreMoy(Image img) {
		
		int l = img.getXDim();
		int h = img.getYDim();
		int c = img.getBDim();
		
		if (c==1) {
			ByteImage new_img = new ByteImage(l, h, 1, 1, c);
			int moy;
			for(int i=1; i<l-1; i++) {
				for (int j=1; j<h-1;j++) {
					moy = getNewMoy(img,i,j);
						new_img.setPixelXYBByte(i,j,0,moy);
				}
			}
			return new_img;
		}
		else {
			System.out.println("Il faut entrer une image à niveau de gris");
			return null;
		}
	}
	
	
	
	
	public Image filtreMedia(Image img) {
		int l = img.getXDim();
		int h = img.getYDim();
		int c = img.getBDim();
		
		if (c==1) {
			ByteImage new_img = new ByteImage(l, h, 1, 1, c);
			int med;
			for(int i=1; i<l-1; i++) {
				for (int j=1; j<h-1;j++) {
					med = getMed(img,i,j);
						new_img.setPixelXYBByte(i,j,0,med);
				}
			}
			return new_img;
		}
		else {
			System.out.println("Il faut entrer une image à niveau de gris");
			return null;
		}
	}
	
	
	
	
	
	public Image filtreMoyColor(Image img, int x, int y) {
		//traiter les images en couleur 
		//generalement fonctions de la meme manier que l'image gris (il faut juste obternir 3 fois plus des valeur)
		return img;
	}
	
	
	public Image filtreMediaColor(Image img, int x, int y) {
		//meme chose que filtreMoyColor
		return img;
	}
	
	public Image regulationImg(Image img) { //ne fonctione pas (arriver pas de detecter un image de niveau gris
		int l = img.getXDim();
		int h = img.getYDim();
		int c = img.getBDim();
		
		if (c==1) {
			ByteImage new_img = new ByteImage(l, h, 1, 1, c);
			int moy;
			for(int i=1; i<l-1; i++) {
				for (int j=1; j<h-1;j++) {
					moy = getValConvolution(img,i,j);
						new_img.setPixelXYBByte(i,j,0,moy);
				}
			}
			return new_img;
		}
		else {
			System.out.println("Il faut entrer une image à niveau de gris");
			return null;
		} 
	}
	
	
	public Image detecterContour(Image img) {
		
		/*
		 * oder une fonction qui prend en entrée une
image en couleurs et qui retourne une transformée de cette image en niveaux de gris. Vous
utiliserez le filtre de Sobel pour extraire les contours de l’image (voir support de cours CM
03). Pour un pixel donné, on travaillera de manière indépendante sur chaque canal RGB
puis on sommera le résultat obtenu pour obtenir une unique valeur qu’on tronquera audelà de 255. La fonction ne devra pas modifier l’image fournie en entrée mais créer une
nouvelle image contenant la transformée
		 */
		
		return img;
		
	}
	
	
	private int getValConvolution(Image img, int x, int y) {
		int total = (img.getPixelXYBByte(x,y,0)*(2/10)) + (img.getPixelXYBByte(x+1,y,0)*(1/10)) + (img.getPixelXYBByte(x+1,y+1,0)*(1/10))
		+ (img.getPixelXYBByte(x-1,y-1,0)*(1/10)) + (img.getPixelXYBByte(x-1,y,0)*(1/10))+ (img.getPixelXYBByte(x,y-1,0)*(1/10))
		+ (img.getPixelXYBByte(x-1,y+1,0)*(1/10)) + (img.getPixelXYBByte(x+1,y-1,0)*(1/10)) + (img.getPixelXYBByte(x,y+1,0)*(1/10));
		System.out.println(total);
		
		return total;
	}
	
	

	private int getNewMoy(Image img, int x, int y) {
		int total = img.getPixelXYBByte(x,y,0) + img.getPixelXYBByte(x+1,y,0) + img.getPixelXYBByte(x+1,y+1,0)
		+ img.getPixelXYBByte(x-1,y-1,0) + img.getPixelXYBByte(x-1,y,0)+ img.getPixelXYBByte(x,y-1,0) 
		+ img.getPixelXYBByte(x-1,y+1,0) + img.getPixelXYBByte(x+1,y-1,0) + img.getPixelXYBByte(x,y+1,0);
		
		int moy = total/NBFORMAT;
		return moy;
		
	}
	
	
	private int getMed(Image img, int x, int y) {
		int med;
		int[] tabVals = getValeur(img,x,y);
		
		for (int j=0; j<tabVals.length-1; j++) {
			for (int i = j; i < tabVals.length; i++) {
                if (tabVals[i] > tabVals[j]) {
       
                    int temp = tabVals[j];
                    tabVals[j] = tabVals[i];
                    tabVals[i] = temp;
                }
            }
        }
		
	/*	for (int i = 0; i <tabVals.length-1; i++) {
			System.out.println(tabVals[i]); 
		}
	
		System.out.println(med);*/
		
		med = tabVals[tabVals.length/2];
		return med;
	}
	
	
	private int[] getValeur(Image img, int x, int y) {
		int val1 = img.getPixelXYBByte(x,y,0); 
		int val2 = img.getPixelXYBByte(x+1,y,0);
		int val3 = img.getPixelXYBByte(x+1,y+1,0);
		int val4 = img.getPixelXYBByte(x-1,y-1,0);
		int val5 = img.getPixelXYBByte(x-1,y,0);
		int val6 = img.getPixelXYBByte(x,y-1,0); 
		int val7 = img.getPixelXYBByte(x-1,y+1,0);
		int val8 = img.getPixelXYBByte(x+1,y-1,0);
		int val9 = img.getPixelXYBByte(x,y+1,0);
		
		int tab[] = {val1, val2, val3, val4, val5, val6, val7, val8, val9};
		return tab;
	}
}
