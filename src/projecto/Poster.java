package projecto;

public class Poster {

	int width;
	int height;
	int next;
	
	static final int SIZE_INIT = 100; 
	
	Layer[] layers;
	
	
	Poster(int width, int height){
		
		this.width = width;
		this.height = height;
		
		next = 0;
		
		//capacidade do poster por defeito
		this.layers = new Layer[SIZE_INIT]; 
						
	}
	
	//1
	void setBackground(ColorImage img){
		
		if(img == null){
			throw new NullPointerException("tem que seleccionar uma img, não pode ser null");
		}
		
		ColorImage background = Image.backgroundPattern(img, width, height);
		
		layers[0] = new Layer(background,"bg",1.0,0,0);
		
		next++;
		
	}
	
	//função desenvolvida para testar funcionamento do setBg
	Layer getBackground(){
		
		return this.layers[0];
	}
	
	//2
	void addLayer(Layer layer){
		
		if(layers.length == next){
			
			Layer[] resized = new Layer[layers.length +1];
				
				for(int i = 0; i < layers.length; i++){
					
					resized[i] = layers[i];
				}
				
				layers = resized;
		}
		
		layers[next] = layer;
		next ++;
	}
	
	//3
	void removeLayer(int index){
				
		if(index < 0){
			throw new IllegalArgumentException("index tem que ser maior que 0");
		}
		
		if(index == 0){
			throw new IllegalStateException("Não podes remover o fundo, se quiseres mudá-lo usa o setBackground");
		}
		
		if(index >= next){
			
			throw new IllegalStateException("a posição escolhida não tem nenhuma imagem");
		}
		
		if(index == next - 1){
		layers[index] = null;
		next--;
	} else {
	
		layers[index] = null;
		next = next -1 ;
		
			for(int i = next; i > index; i--){
				
				layers[i-1] = layers[i];
				
			}

		}
	}
	
	//4
	void insertLayer(Layer layer,int index){
		
		if(index >= layers.length){
			throw new IllegalStateException("Não existe essa posição no álbum");
		}
		
		if(index < 0){
			throw new IllegalArgumentException("index tem que ser maior que 0");
		}
		
		if(index == 0){
			throw new IllegalStateException("Não podes inserir uma layer no fundo, se quiseres mudar o fundo usa o setBackground");
		}
		
		if(layers.length == next){
			
			Layer[] resized = new Layer[layers.length +1];
				
				for(int i = 0; i < layers.length; i++){
					
					resized[i] = layers[i];
				}
				
				layers = resized;
		}
		
		if(index >= next){
			layers[next] = layer;
			next ++;//se fizer insert para lá do next é como fazer addlayer
		
		} else {
		
			for(int i = next; i > index; i--){
			
				layers[i] = layers[i-1];
			}
			
			layers[index] = layer;
			next++;
		}
	}
	//5
	void swapLayer(int a, int b){
		
		if(a < 0 || b < 0){
			throw new IllegalArgumentException("index tem que ser maior que 0");
		}
		
		if(a == 0 || b == 0){
			throw new IllegalStateException("Não podes fazer swap com o fundo, se quiseres mudar o fundo usa o setBackground");
		}
		
		Layer a0 = layers[a];
		Layer b0 = layers[b];
		
		layers[a] = b0;
		layers[b] = a0;
	}
	
	ColorImage getFinalPoster(){
		
		ColorImage finalPoster = Image.whiteBg(width, height);
		
		for(int i = 0; i < next; i++){
			
			if(layers[i].active){
			
			Image.paste(finalPoster, layers[i].getLayer(), 0, 0);
			}
		}
		
		return finalPoster;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
