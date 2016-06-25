public class TheMatrix{

    //CLASS LEVEL VARIABLES ------------

    private boolean[][] matrix;
    //    (xLength)^ ^(yLength)
    private int[][] neighbours;
    private int xLength, yLength;

    //CONSTRUCTORS ---------------------
    public TheMatrix() throws IllegalArgumentException{
        this(10,10);
    }

    public TheMatrix(int xLength, int yLength) throws IllegalArgumentException{
        if(this.isValidLength(xLength) && this.isValidLength(yLength)){
            this.xLength = xLength;
            this.yLength = yLength;
            this.matrix = new boolean[xLength][yLength];
            this.neighbours = new int[xLength][yLength];
        } else {
            throw new IllegalArgumentException("Matrix index cant be negative");
        }

    }

   //PUBLIC METHODS --------------------
    public void setPixel(int x, int y, boolean state){
        if(this.isValidPixel(x,y)){
            if(matrix[x][y] != state){
                matrix[x][y] = state;
                updateNeighbours(x,y,state);
            }
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
        return this.xLength;
    }

    public int getYLength(){
        return this.yLength;
    }

    public String[][] returnStrings(){
        //returns a matrix with a string reresentation of its intries

        int xLength = this.getXLength();
        int yLength = this.getYLength();
        String[][] stringMatrix = new String[xLength][yLength];

        for(int x=0; x<xLength; x++){
            for(int y=0; y<yLength; y++){
                if(getPixel(x,y)){
                    stringMatrix[x][y] = "X|"; //<(full)
                }
                else{
                    stringMatrix[x][y] = " |"; //<(empty)
                }
            }
        }

        return stringMatrix;
    }

    public int getNeighbours(int x, int y){
        if(this.isValidPixel(x,y)){
            return neighbours[x][y];
        } else {
            throw new IllegalArgumentException("pixel outside matrix");
        }
    }

    //PRIVATE METHODS ------------------
    private boolean isValidLength(int length){
        return length>0;
    }

    private boolean isValidPixel(int x, int y){
        if(x < xLength && x >= 0){
            return (y < yLength && y >= 0);
        } else {
            return false;
        }
    }

    private void updateNeighbours(int x, int y, boolean state){

        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j ++){
                if(isInside(x + i, y + j)){
                    this.neighbours[x + i][y + j] = state ? this.neighbours[x + i][y + j] + 1 : this.neighbours[x + i][y + j] - 1;
                }
            }
        }
        //note the algorithm adds a neghbour to itself, neet to delete it
        this.neighbours[x][y] = state ? this.neighbours[x][y] - 1 : this.neighbours[x][y] + 1;
    }

    private boolean isInside(int x, int y){
        boolean answer = x >= 0;
        answer = answer && y >= 0;
        answer = answer && x < xLength;
        answer = answer && y < yLength;
        return answer;
    }
}
