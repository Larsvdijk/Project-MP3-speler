import java.io.IOException;
import java.io.RandomAccessFile;

public class SineTest {
	static int dreq = 83;
	static Gpio gpio = new Gpio();
	
	public static void main(String[] args) {
		
		try{
			byte[] init = { 0x02, 0x00, 0x08, 0x26 };
			byte[] volume = { 0x02, 0x0B, (byte) 0x00, 0x00 };
			byte[] testOn  = { 0x53, (byte) 0xEF, 0x6E, (byte) 0x50, 0x00, 0x00, 0x00, 0x00 };
		    byte[] testOff = { 0x45, 0x78, 0x69, 0x74, 0x00, 0x00, 0x00, 0x00 };

			
			RandomAccessFile sdi = new RandomAccessFile( "/dev/spidev1.1", "rw" );    // data interface
            RandomAccessFile sci = new RandomAccessFile( "/dev/spidev1.0", "rw" );    // control interface
            
            sci.write(init);
            System.out.println("Init..");
            sci.write(volume);
            System.out.println("Set volume to ");
            
            sdi.write(testOn);
            System.out.println("Play Sine Test..");
            Thread.sleep(10000);
            sdi.write(testOff);
            System.out.println("End..");
            
		}catch(Exception e){
			System.out.println("Error " + e);
		}
		
	}

}
