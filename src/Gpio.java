                    
class Gpio {
  /* Native methods declaration */
  public native int ioinit();
  public native int iowrite(int a, int v);
  public native int ioread(int a);
  public native int iodeinit();

  static Gpio io = new Gpio();
  // Use static intializer 
  static {
    System.loadLibrary("Gpio");
  }

  // Main function calls native method 
  public static void main(String[] args) {
   

    io.ioinit(); 			// Initialize GPIO line PB16
    
    System.out.println("PB19: " + io.ioread(83));
    
    for (int i = 0; i < 2000; i++) {
      io.iowrite(80, 1); 		// Make output PB16 high
      io.iowrite(80, 0); 		// Make output PB16 low
    }
    
    io.iodeinit(); 
  }
  
  public int ReadPin(int pin){
	 return io.ioread(pin);
  }
}

