public class Console{
    
    //CLASS LEVEL VARIABLES ------------
    private TheMatrix matrix;
    
    //CONSTRUCTORS ---------------------
    public Console(){
        this(10,10);
    }

    public Console(int xLength,int yLength) throws IllegalArgumentException{      
        this.matrix = new TheMatrix(xLength, yLength);
    }
    
    //PUBLIC METHODS --------------------
    public void paintScreen(){
        int xLength = this.matrix.getXLength();
        int yLength = this.matrix.getYLength();
        String line;
        
        for(int x=0; x<xLength; x++){            
            line = "";            
            for(int y=0; y<yLength; y++){
                line += matrix.returnStrings()[x][y];
            }
            System.out.println(line);
        }
    }
    
    public void clearScreen(){
        for (int i=1; i<= this.matrix.getXLength(); i++){
            System.out.print(String.format("\033[%dA",1)); // Move up
            System.out.print("\033[2K"); // Erase line content            
        }
    }
    
    public TheMatrix getMatrix(){
        return this.matrix;
    }
}