package com.dproject.dnotifica.notification.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JWindow;
import javax.swing.border.EtchedBorder;

/**
 * <h1>dnotifica - NotificationWindow</h1>
 * <p>NotificationWindow class provides Notification box properties</p> 
 * @author deepan
 * @version 1.0
 *
 */
public class NotificationWindow extends JWindow
{
  private static final long serialVersionUID = 1L;
  private JLabel iconLabel = new JLabel();
  private JLabel closeLabel = new JLabel();
  private JTextArea messageBox = new JTextArea();
  
  int boxWidth;
  int boxHeight;
  Font font;
  Color borderColor;
  Color boxColor;
  Color messageColor;
  int boxMargin;
  Icon notificationIcon;
  String message;
  
  public NotificationWindow() {
	  initDefault();
	  initManager();
  }
  
  public void initDefault(){
	  boxWidth = 500;
	boxHeight = 200;
	font = new Font("Arial", 1, 16);
    borderColor = Color.GRAY;
    boxColor = Color.DARK_GRAY;
    messageColor = Color.WHITE;
    messageBox.setEditable(false);
  }
  
  private void initManager() {
		this.setOpacity(0.80f);
	    setSize(boxWidth, boxHeight);
	    this.messageBox.setFont(font);
	    JPanel externalPanel = new JPanel(new BorderLayout());
	    externalPanel.setBackground(getBoxColor());
	    JPanel innerPanel = new JPanel(new BorderLayout());    
	    innerPanel.setBackground(getBoxColor());
	    this.messageBox.setBackground(getBoxColor());
	    this.messageBox.setMargin(new Insets(10,10,10,10));
	    this.messageBox.setLineWrap(true);
	    this.messageBox.setWrapStyleWord(true);
	    EtchedBorder etchedBorder = (EtchedBorder)BorderFactory.createEtchedBorder();   
	    externalPanel.setBorder(etchedBorder);
	    externalPanel.add(innerPanel);
	    this.messageBox.setForeground(messageColor);
	    closeLabel.setSize(50, 50);
	    ImageIcon closeIcon = new ImageIcon(
	    		new ImageIcon(this.getClass().getClassLoader().getResource("images/close.png"))
	    		.getImage()
	    		.getScaledInstance(20, 20, Image.SCALE_DEFAULT));
	    closeLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 10));
	    closeLabel.setIcon(closeIcon);
	    iconLabel.setVerticalAlignment(JLabel.TOP);
	    iconLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 0));
	    innerPanel.add(iconLabel,BorderLayout.WEST);
	    
	    closeLabel.setHorizontalAlignment(JLabel.RIGHT);
	    
	    innerPanel.add(this.closeLabel, BorderLayout.NORTH);
	    innerPanel.add(this.messageBox, "Center");
	    getContentPane().add(externalPanel);
	    this.closeLabel.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	        	dispose();
	        }
	    });
  	}
	
	public void setIconLabel(Icon iconLabel) {
		this.iconLabel.setIcon(iconLabel);
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
		this.messageBox.setText(message);
	}
	
	public int getBoxWidth() {
		return boxWidth;
	}
	
	public void setBoxWidth(int boxWidth) {
		this.boxWidth = boxWidth;
	}
	
	public int getBoxHeight() {
		return boxHeight;
	}
	
	public void setBoxHeight(int boxHeight) {
		this.boxHeight = boxHeight;
	}
	
	public Font getFont() {
		return font;
	}
	
	public void setFont(Font font) {
		this.font = font;
	}
	
	public Color getBorderColor() {
		return borderColor;
	}
	
	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}
	
	public Color getBoxColor() {
		return boxColor;
	}
	
	public void setBoxColor(Color boxColor) {
		this.boxColor = boxColor;
	}
	
	public Color getMessageColor() {
		return messageColor;
	}
	
	public void setMessageColor(Color messageColor) {
		this.messageColor = messageColor;
	}
	
	public int getBoxMargin() {
		return boxMargin;
	}
	
	public void setBoxMargin(int boxMargin) {
		this.boxMargin = boxMargin;
	}
	
	public void setNotificationIcon(Icon messageIcon){
		this.iconLabel.setIcon(messageIcon);
	}
}