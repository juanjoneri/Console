public class TheMatrix{

    //CLASS LEVEL VARIABLES ------------
    private boolean[][] matrix;

    //CONSTRUCTORS ---------------------
    public TheMatrix() throws IllegalArgumentException{
        this(10,10);
    }
    
    public TheMatrix(int xLength, int yLength) throws IllegalArgumentException{
        if(this.isValidLength(xLength) && this.isValidLength(yLength)){
            this.matrix = new boolean[xLength][yLength];            
        } else {
            throw new IllegalArgumentException();            
        }

    }
    
   //PUBLIC METHODS --------------------
    public void setPixel(int x, int y, boolean state){
        if(this.isValidPixel(x,y)){
            matrix[x][y] = state;            
        } else {
            throw new IllegalArgumentException();   
        }
    }
    
    public void paintPixel(int x, int y){
        this.setPixel(x, y, true);
    }
    
    public void deletePixel(int x, int y){
        this. setPixel(x, y , false);
    }
    
    public boolean getPixel(int x, int y){
        if(this.isValidPixel(x,y)){
            return matrix[x][y];            
        } else {
            throw new IllegalArgumentException();   
        }
    }
    
    public int getXLength(){
        return this.matrix.length;
    }
    
    public int getYLength(){
        return this.matrix[0].length;
    }
    
    public String[][] returnStrings(){
        
        int xLength = this.getXLength();
        int yLength = this.getYLength();
        String[][] stringMatrix = new String[xLength][yLength];
        
        for(int x=0; x<xLength; x++){
            for(int y=0; y<yLength; y++){
                if(getPixel(x,y)){
                    stringMatrix[x][y] = "X";
                }
                else{
                    stringMatrix[x][y] = "_";
                }
            }
        }
        
        return stringMatrix;
    }
    
    //PRIVATE METHODS ------------------
    private boolean isValidLength(int length){
        return length>0;
    }
    
    private boolean isValidPixel(int x, int y){
        if(x < this.matrix.length && x >= 0){
            return (y < this.matrix[x].length && y >= 0);
        } else {
            return false;
        }          
    }
}