
package com.dproject.dnotifica.notification.manager;

import java.net.URL;

import com.dproject.dnotifica.notification.animation.SliderAnimation;
import com.dproject.dnotifica.notification.utils.IconUtills;
import com.dproject.dnotifica.notification.utils.TimerUtils;
import com.dproject.dnotifica.notification.window.NotificationWindow;

/**
 * <h1>dnotifica - Desktop Notification</h1>
 * <p>NotificationManager</p>
 * <p>It is a manager class which initilize NotificationWindow and Animation</p>
 * 
 * @author deepan
 * @version 1.0
 * 
 */

public class NotificationManager {
	NotificationWindow notificationWindow;
	TimerUtils timerUtils;
	IconUtills iconUtills;
	public NotificationManager(){
	    initWindow();
	    initTimer();
	    initIconUtils();
	}

	private void initIconUtils() {		
		iconUtills = new IconUtills();
	}

	private void initWindow() {
		notificationWindow=new NotificationWindow();
	}
	
	private void initTimer(){
		timerUtils = new TimerUtils();
	}
	
	public void setShowTime(int showTime){
		timerUtils.setShowTime(showTime);
	}
	
	public void showNotification(String message){
		this.notificationWindow.setMessage(message);
	    animate();
	}
	
	public void showNotification(URL iconURL,String message){
		this.notificationWindow.setNotificationIcon(iconUtills.prepareImageIcon(iconURL));
		this.notificationWindow.setMessage(message);
		animate();
	}
	
	public void showNotification(String iconPath,String message){
		this.notificationWindow.setNotificationIcon(iconUtills.prepareImageIcon(iconPath));
		this.notificationWindow.setMessage(message);
		animate();
	}
	
	// Call Notification
	public void showCallNotification(String contactName, String contactNumber){
		URL callIcon=this.getClass().getClassLoader().getResource("images/call.png");
		this.notificationWindow.setNotificationIcon(iconUtills.prepareImageIcon(callIcon));
		this.notificationWindow.setMessage(contactName + " \n " + contactNumber);
		animate();
	}
	
	public void showCallNotification(String iconPath, String contactName, String contactNumber){
		this.notificationWindow.setNotificationIcon(iconUtills.prepareImageIcon(iconPath));
		this.notificationWindow.setMessage(contactName + " \n " + contactNumber);
		animate();
	}
	
	public void showCallNotification(URL iconURL, String contactName, String contactNumber){
		this.notificationWindow.setNotificationIcon(iconUtills.prepareImageIcon(iconURL));
		this.notificationWindow.setMessage(contactName + " \n " + contactNumber);
		animate();
	}
	
	// Message Notification
	public void showMessageNotification(String contactName, String contactNumber, String message){
		URL callIcon=this.getClass().getClassLoader().getResource("images/message.png");
		this.notificationWindow.setNotificationIcon(iconUtills.prepareImageIcon(callIcon));
		this.notificationWindow.setMessage(contactName + " \n " + contactNumber);
		animate();
	}
	
	public void showMessageNotification(String iconString, String contactName, String contactNumber,String message){		
		this.notificationWindow.setNotificationIcon(iconUtills.prepareImageIcon(iconString));
		this.notificationWindow.setMessage(contactName + " \n " + contactNumber);
		animate();
	}
	
	public void showMessageNotification(URL iconURL, String contactName, String contactNumber,String message){
		this.notificationWindow.setNotificationIcon(iconUtills.prepareImageIcon(iconURL));
		this.notificationWindow.setMessage(contactName + " \n " + contactNumber);
		animate();
	}
	
	// Alert Notification
	public void showAlertNotification(String alertTitle, String alertMessage, String alertPriority){
		URL callIcon;
		if ( alertPriority.equals("critical")){
			callIcon=this.getClass().getClassLoader().getResource("images/critical.png");
			this.notificationWindow.setNotificationIcon(iconUtills.prepareImageIcon(callIcon));
			this.notificationWindow.setMessage(alertTitle + " \n " + alertMessage);
			animate();			
		}else if (alertPriority.equals("warning")){
			callIcon=this.getClass().getClassLoader().getResource("images/warning.png");
			this.notificationWindow.setNotificationIcon(iconUtills.prepareImageIcon(callIcon));
			this.notificationWindow.setMessage(alertTitle + " \n " + alertMessage);
			animate();
		}else if (alertPriority.equals("info")){
			callIcon=this.getClass().getClassLoader().getResource("images/info.png");
			this.notificationWindow.setNotificationIcon(iconUtills.prepareImageIcon(callIcon));
			this.notificationWindow.setMessage(alertTitle + " \n" + alertMessage);
			animate();
		}else {
			// Add Exception
		}
	}
	
	public void animate() {
		  //new Animation(this, this.notificationProperties).start();
		  new SliderAnimation(this.notificationWindow,this.timerUtils).run();
		  //this.notificationWindow.setVisible(true);
		  //this.notificationWindow.setLocation(200, 200);
	  }
}

