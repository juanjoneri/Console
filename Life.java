public class Life{

    public static void main(String[] args) throws Exception{

        int HEIGHT=10;int WIDTH=10;int INIT_ALIVE=20;int DAYS=20;

        try{
            WIDTH = Integer.parseInt(args[0]);
            HEIGHT = Integer.parseInt(args[1]);
            INIT_ALIVE = Integer.parseInt(args[2]);
            DAYS = Integer.parseInt(args[3]);
        }catch (Exception ex) {
            printInstructions();
        }

        Console console = new Console(WIDTH, HEIGHT);
        int today[][], tomorrow[][];
        today = initialState(INIT_ALIVE, WIDTH, HEIGHT);
        tomorrow = new int[WIDTH * HEIGHT][2]; //overkill size

        for(int day = 0; day < DAYS; day++){

            console.getMatrix().paintPixel(today);
            console.paintAndClear();

            int position = 0;
            for(int i = 0; i < console.getMatrix().getXLength(); i ++){
                for(int j = 0; j < console.getMatrix().getYLength(); j ++){
                    if(rules(console.getMatrix().getPixel(i, j), console.getMatrix().getNeighbours(i, j))){
                        tomorrow[position][0] = i;
                        tomorrow[position][1] = j;
                        position ++;
                    }
                }
            }
            console.getMatrix().deletePixel(today);
            today = tomorrow;
            tomorrow = new int[WIDTH * HEIGHT][2];
        }

    }

    private static int[][] initialState(int numOfPoints, int WIDTH, int HEIGHT){
        //might repeat and return less points!
        int[][] coords = new int[WIDTH * HEIGHT][2];

        for(int point = 0; point < numOfPoints; point ++){
            coords[point][0] = randBetween(0, WIDTH);
            coords[point][1] = randBetween(0, HEIGHT);
        }

        return coords;
    }

    private static int randBetween(int min, int max){
        return min + (int)(Math.random() * (max - min));
    }

    private static boolean rules(boolean state, int numOfNeighbours){
        boolean answer = false;
        if(state == true){
            answer = (numOfNeighbours == 2 || numOfNeighbours == 3) ? true : false;
        }else {
            answer = (numOfNeighbours == 3) ? true : false;
        }
        return answer;
    }

    private static void printInstructions(){
        System.out.println("                ## MANUAL ##\n"
        + "java Life <height> <width> <init_alive> <days>\n");
        try {
            Thread.sleep( 3000 );
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("            # Running Default #\n"
        + "       java Life <10> <10> <20> <20>\n");
    }

}
