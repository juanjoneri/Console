public class DibujaAlgo{

    public static void main(String[] args) throws Exception{
        
        Console console = new Console(10,20);
        console.getMatrix().paintPixel(2,5);
        console.paintScreen();
        console.clearScreen();
        console.getMatrix().paintPixel(3,8);
        console.paintScreen();  
        console.clearScreen();
        console.getMatrix().paintPixel(9,8);
        console.paintScreen();  
        console.clearScreen();
        console.getMatrix().paintPixel(4,6);
        console.paintScreen();  
        console.clearScreen();
        console.getMatrix().paintPixel(0,18);
        console.paintScreen();  
        console.clearScreen();
        console.getMatrix().paintPixel(8,8);
        console.paintScreen();          
    
    }

}