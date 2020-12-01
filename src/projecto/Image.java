package projecto;

public class Image {
	
	//imgs para teste
	
	static ColorImage blackSquare = new ColorImage(100,100);
	
	static ColorImage bg = new ColorImage("bg.png");
	
	static ColorImage salazar = new ColorImage("objc1(1).png");
		
	static ColorImage rectangle = new ColorImage("rectangle.jpeg");
	
	static ColorImage pattern = new ColorImage("pattern.jpeg");
	
	static final Color TRANSPARENT = new Color(255,255,255);
	
	//1 - procedimento para colar uma imagem em cima de outra num determinado sítio
	
	static void paste(ColorImage base, ColorImage paste, int x, int y){
		
		for(int xi = 0; xi < base.getWidth(); xi++){
			
			for(int yi = 0; yi < base.getHeight(); yi++){
				
				if(xi >= x && xi < x + paste.getWidth() && yi >= y && yi < y + paste.getHeight()){
					if(!(paste.getColor(xi - x, yi - x).isEqualTo(TRANSPARENT))){
				
						Color c = paste.getColor(xi - x, yi - y);
					
						base.setColor(xi, yi, c);
					}
				}
			}	
			
		}
		
	}
	
	
	
	//função de teste para 1
	// ! dá erro no getcolor quando uso img a preto e branco !
	// não percebo porquê...
	
	static ColorImage pasteTest(ColorImage base, ColorImage paste){
	
		Image.paste(base, paste, 0, 0);
		
		return base;
		
	}
	
	//3 - função para duplicar uma imagem e redefinir o seu tamanho conforme um factor
	//esta parece estar a funcionar perfeitamente!
	
	static ColorImage scale(ColorImage img, double factor){
		
		ColorImage scaledImg = new ColorImage((int)(img.getWidth()*factor),(int)(img.getHeight()*factor));
		
			for(int x = 0; x < scaledImg.getWidth() ; x++){
				for(int y = 0; y < scaledImg.getHeight(); y++){
					
					Color c = img.getColor((int)(x/factor),(int)(y/factor));
					
					scaledImg.setColor(x, y, c);
						
				}
			}
			return scaledImg;
	}

	//4 - função que devolve selecção circular
	
	static ColorImage circleSelection(ColorImage img, int xCenter, int yCenter, int radius){
		
		//criar imagem com as dimensões correctas, para copiar selecção quadrada
		ColorImage circleImg = new ColorImage(radius*2, radius*2);
		
			for(int x = 0; x < img.getWidth(); x++){
				
				for(int y = 0; y < img.getHeight(); y++){
					
					if(x >= xCenter - radius && x < xCenter + radius && y >= yCenter - radius && y < yCenter + radius){
						
						Color c = img.getColor(x, y);
						circleImg.setColor(x, y, c);
						
					}
				}
			}
						Image.inCircle(circleImg, xCenter, yCenter, radius);
						return circleImg;
	}
	
	//função auxiliar para (4)
	static void inCircle(ColorImage img, int xCenter, int yCenter, int radius){
		
		for(int x = 0; x < img.getWidth(); x++){
			
			for(int y = 0; y < img.getHeight(); y++){
				
				double distance = Math.sqrt(Math.pow(x - xCenter, 2) + Math.pow(y - yCenter, 2));
				
					if(distance > radius){
						
						img.setColor(x, y, TRANSPARENT);
					}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
