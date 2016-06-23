public class DibujaAlgo{

    private static final int WIDTH = 40;
    private static final int HEIGHT = 20;


    public static void main(String[] args) throws Exception{

        Console console = new Console(HEIGHT, WIDTH);
        int coords[][];
        
        for(int i = 0; i < 50; i++){
            coords = initialState(15);
            console.getMatrix().paintPixel(coords);
            console.paintAndClear();
            console.getMatrix().deletePixel(coords);
        }

    }

    private static int[][] initialState(int numOfPoints){
        int[][] coords = new int[numOfPoints][2];

        for(int pixel = 0; pixel < numOfPoints; pixel ++){
            coords[pixel][0] = randBetween(0, HEIGHT);
            coords[pixel][1] = randBetween(0, WIDTH);
        }

        return coords;
    }

    private static int randBetween(int min, int max){
        return min + (int)(Math.random() * (max - min));
    }

}
