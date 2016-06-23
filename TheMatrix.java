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
            throw new IllegalArgumentException("Matrix index cant be negative");
        }

    }

   //PUBLIC METHODS --------------------
    public void setPixel(int x, int y, boolean state){
        if(this.isValidPixel(x,y)){
            matrix[x][y] = state;
        } else {
            throw new IllegalArgumentException("pixel outside matrix");
        }
    }

    public void paintPixel(int x, int y){
        if(this.isValidPixel(x,y)){
            this.setPixel(x, y, true);
        } else {
            throw new IllegalArgumentException("pixel outside matrix");
        }
    }

    public void paintPixel(int[][] coordinates){
        //an int[][2] should be provided; Condition currently not checked!
        for(int[] row : coordinates){
            int x = row[0];
            int y = row[1];
            if(this.isValidPixel(x,y)){
                this.setPixel(x, y, true);
            } else {
                throw new IllegalArgumentException("pixel outside matrix");
            }
        }
    }

    public void deletePixel(int x, int y){
        if(this.isValidPixel(x,y)){
            this.setPixel(x, y, false);
        } else {
            throw new IllegalArgumentException("pixel outside matrix");
        }
    }

    public void deletePixel(int[][] coordinates){
        //an int[][2] should be provided; Condition currently not checked!
        for(int[] row : coordinates){
            int x = row[0];
            int y = row[1];
            if(this.isValidPixel(x,y)){
                this.setPixel(x, y, false);
            } else {
                throw new IllegalArgumentException("pixel outside matrix");
            }
        }
    }

    //GETTERS METHODS --------------------
    public boolean getPixel(int x, int y){
        if(this.isValidPixel(x,y)){
            return matrix[x][y];
        } else {
            throw new IllegalArgumentException("pixel outside matrix");
        }
    }

    public int getXLength(){
        return this.matrix.length;
    }

    public int getYLength(){
        return this.matrix[0].length;
    }

    public String[][] returnStrings(){
        //returns as string reresentation of the matrix

        int xLength = this.getXLength();
        int yLength = this.getYLength();
        String[][] stringMatrix = new String[xLength][yLength];

        for(int x=0; x<xLength; x++){
            for(int y=0; y<yLength; y++){
                if(getPixel(x,y)){
                    stringMatrix[x][y] = "X|"; //However you would like the living to look like
                }
                else{
                    stringMatrix[x][y] = " |"; //However you would like the empty to look like
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
