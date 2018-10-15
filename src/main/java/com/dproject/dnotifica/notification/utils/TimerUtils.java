package com.dproject.dnotifica.notification.utils;
/**
 * <h1>dnotifica - TimerUtils</h1>
 * <p>TimerUtils class provides timer utility methods, which is used to set notification show time and animation delay time</p>
 * 
 * @author deepan
 * @version 1.0
 * 
 */
public class TimerUtils {
	protected int moveSpeedTime;
	protected int moveDelayTime;
	protected int showTime;
	protected boolean infinityTime;	
	
	public boolean isInfinityTime() {
		return infinityTime;
	}
	public void setInfinityTime(boolean infinityTime) {
		this.infinityTime = infinityTime;
	}
	public int getMoveSpeedTime() {
		return moveSpeedTime;
	}
	public void setMoveSpeedTime(int moveSpeedTime) {
		this.moveSpeedTime = moveSpeedTime;
	}
	public int getMoveDelayTime() {
		return moveDelayTime;
	}
	public void setMoveDelayTime(int moveDelayTime) {
		this.moveDelayTime = moveDelayTime;
	}
	public int getShowTime() {
		return showTime;
	}
	public void setShowTime(int showTime) {
		this.showTime = showTime;
	}

	public TimerUtils(){
		this.showTime=3000;
		this.moveDelayTime=20;
		this.moveSpeedTime=20;
		this.infinityTime=false;
	}
	
	public double milliSec2Sec(int milliSec){
		return (milliSec * 1000);
	}

}
