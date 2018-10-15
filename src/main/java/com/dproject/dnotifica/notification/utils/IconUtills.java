package com.dproject.dnotifica.notification.utils;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
/**
 * <h1>dnotifica - IconUtills</h1>
 * <p>IconUtills class provides icon utility methods, which is user to convert image URL or image path to image icon</p>
 * 
 * @author deepan
 * @version 1.0
 * 
 */
public class IconUtills {
	int imageMaxHeight;
	int ImageMaxWidth;
	ImageIcon closeIcon;
	ImageIcon userIcon;
	ImageIcon callIcon;
	ImageIcon messageIcon;
	ImageIcon warningAlertIcon;
	ImageIcon infoAlertIcon;
	ImageIcon criticalAlertIcon;
	ImageIcon customIcon;
	
	public ImageIcon prepareImageIcon(String imagePath){
		ImageIcon icon = new ImageIcon(
        		new ImageIcon(imagePath)
        		.getImage()
        		.getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		return icon;
	}
	
	public ImageIcon prepareImageIcon(URL iconURL){
		ImageIcon icon = new ImageIcon(
        		new ImageIcon(iconURL)
        		.getImage()
        		.getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		return icon;
	}

}
