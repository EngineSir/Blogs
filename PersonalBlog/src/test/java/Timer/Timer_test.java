package Timer;

import java.util.Timer;
import java.util.TimerTask;



public class Timer_test
{

	public static void main(String[] args)
	{
		tt t=new tt();

	}

}
class Timer_Timertask extends TimerTask{
	private int num;

	@Override
	public void run()
	{
		System.out.println(num++);
		
	}
	
}
class tt{
	Timer timer;
	public tt()
	{
		timer=new Timer();
		timer.schedule(new Timer_Timertask(), 0,2000);
	}
	
}