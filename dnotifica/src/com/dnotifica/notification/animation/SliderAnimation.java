package com.dnotifica.notification.animation;

import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import com.dnotifica.notification.notificationwindow.NotificationWindow;
import com.dnotifica.notification.utils.TimerUtils;
/**
 * <h1>dnotifica - SliderAnimation</h1>
 * <p>SliderAnimation class provides slider style animation </p> 
 * @author deepan
 * @version 1.0
 *
 */
public class SliderAnimation implements Runnable {
	
	public NotificationWindow notificationWindow;
	TimerUtils timerUtils;

	public SliderAnimation(NotificationWindow notificationWindow, TimerUtils timerUtils ){
		this.notificationWindow = notificationWindow;
		this.timerUtils=timerUtils;
	}
	
	public void run() {
		try
	    {
		System.out.println("RUN");
	      boolean animateFromBottom = false;
	      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	      Rectangle screenRect = ge.getMaximumWindowBounds();
	      int screenHeight = screenRect.height;
	      if (screenRect.y > 0) {
	        animateFromBottom = false;
	      }
	     
	      int posx = screenRect.width - this.notificationWindow.getBoxWidth() - 1;
	      //1200-30-1=1169 
	      this.notificationWindow.setLocation(posx, screenHeight); //1169,800
	      System.out.println(screenHeight);
	      this.notificationWindow.setVisible(true);
	      
	      this.notificationWindow.setAlwaysOnTop(true);
	      int startYPosition;
	      int stopYPosition;
	      if (animateFromBottom)
	      {
	        startYPosition = screenHeight; //800
	        stopYPosition = startYPosition - this.notificationWindow.getBoxHeight() - 1;//800-20-1=779	       
	      }
	      else
	      {
	        startYPosition = screenRect.y - this.notificationWindow.getBoxHeight();
	        stopYPosition = screenRect.y + 200;	       
	      }
	      animateVertically(posx, startYPosition, stopYPosition);	     
	      Thread.sleep(timerUtils.getShowTime());
	      animateVertically(posx, stopYPosition, startYPosition);
	      
	      this.notificationWindow.setVisible(false);
	      this.notificationWindow.dispose();
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	    }
	}
	
	protected void animateVertically(int posx, int fromY, int toY)
		    throws InterruptedException
		  { 
		    this.notificationWindow.setLocation(posx, fromY);
		    if (toY < fromY) {
		      for (int i = fromY; i > toY; i -= this.timerUtils.getMoveSpeedTime())
		      {
		        this.notificationWindow.setLocation(posx, i);
		        Thread.sleep(this.timerUtils.getMoveDelayTime());
		      }
		    } else {
		      for (int i = fromY; i < toY; i += this.timerUtils.getMoveSpeedTime())
		      {
		        this.notificationWindow.setLocation(posx, i);
		        Thread.sleep(this.timerUtils.getMoveDelayTime());
		      }
		    }
		    this.notificationWindow.setLocation(posx, toY);
		  }
	
}