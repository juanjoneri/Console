public class Foo {
  public static void main(String[] args) throws Exception {
      
      String text;
      
      for (int i=0; i<50; i++){
          text = "\r";
          System.out.print("         ");
          
          for(int j=0; j<i%10; j++){
              text += "X";
          }
        
        System.out.print(text);
        Thread.sleep(500);
      }
  }
}