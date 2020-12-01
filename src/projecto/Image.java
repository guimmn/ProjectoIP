package projecto;

public class Image {
	
	//imgs para teste
	
	
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
					if(!(paste.getColor(xi, yi).isEqualTo(TRANSPARENT))){
				
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
	
	//2 - função para criar fundo de poster
	// ! esta função dá-me erro na segunda tentativa de paste, mas n sei pq...
	
	static ColorImage posterBg(ColorImage pattern, int width, int height){
		
		ColorImage bg = new ColorImage(width, height);
		
		for(int y = 0; y < bg.getHeight(); y += pattern.getHeight()){
			
			for(int x = 0; x < bg.getWidth(); x += pattern.getWidth()){
				
				Image.paste(bg, pattern, x, y);
			}
		}
		
		return bg;
		
	}
	
	//3 - função para duplicar uma imagem e redefinir o seu tamanho conforme um factor
	
	static ColorImage scale(ColorImage img, int factor){
		
		ColorImage scaledImg = new ColorImage(img.getWidth()*factor,img.getHeight()*factor);
		
			for(int x = 0; x < scaledImg.getWidth() ; x++){
				for(int y = 0; y < scaledImg.getHeight(); y++){
					
					Color c = img.getColor(x/factor,y/factor);
					
					scaledImg.setColor(x, y, c);
						
				}
			}
			return scaledImg;
	}
	
	
	
	
	

}
