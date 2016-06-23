public class Console{
//This class uses a matrix to paint and adds functionality to paint it in cmd

    //CLASS LEVEL VARIABLES ------------
    private TheMatrix matrix;
    private static final int SLEEP_TIME = 500; //milliseconds

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
        //Prepares the screen for re painting (actual state of matrix does not change)
        for (int i=1; i<= this.matrix.getXLength(); i++){
            System.out.print(String.format("\033[%dA",1)); // Move up
            System.out.print("\033[2K"); // Erase line content
        }
    }

    public void paintAndClear(){
        paintScreen();
        try {
            Thread.sleep( SLEEP_TIME );
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        clearScreen();
    }

    public TheMatrix getMatrix(){
        //Use this object to edit configuration of matrix
        return this.matrix;
    }
}
