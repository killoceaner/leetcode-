import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class TestForPat extends TimerTask {

	public static void main(String[] args) {
		AbstractMap< String, String> map = new HashMap<String, String>();
	    Timer timer = new Timer();
	    TestForPat test = new TestForPat();
	    
	    timer.schedule(test, 10, 10);
		}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("*****************************");
	}
	
	static{
		System.out.println("dfsdfiasfjdfs");
	}
	
}

