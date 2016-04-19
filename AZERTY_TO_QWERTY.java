package codeFoo6.ign.www;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
/**
 * Provides a text area where input from an AZERTY keyboard can be translated to the 
 * equivalent on a QWERTY keyboard
 * @author Giovanni
 *
 */
public class AZERTY_TO_QWERTY {
	
	public static void main(String[] args){
		JFrame frame = new JFrame("AzertyToQwerty");
		JTextArea qwerty = new JTextArea();
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		frame.add(qwerty); 
		frame.setLocation((int)(3*tk.getScreenSize().getWidth()/8),(int)(3*tk.getScreenSize().getHeight()/8));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
		
		qwerty.setTabSize(5);
		qwerty.setLineWrap(true);
		
		//Use a KeyListener in order to intercept input from an AZERTY keyboard 
		//and modify it to its equivalent on a QWERTY keyboard.
		qwerty.addKeyListener(new KeyListener(){

			boolean capL = false;
			boolean shift = false;
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				//Handle the use of shift or caps lock
				if(e.getKeyCode() == KeyEvent.VK_CAPS_LOCK && capL == false)
					capL = true;
				else if(e.getKeyCode() == KeyEvent.VK_CAPS_LOCK && capL == true)
					capL = false;
				if(e.getKeyCode() == KeyEvent.VK_SHIFT)
					shift = true;
				
				//Handle the sticky H key as it is pressed
				if(e.getKeyCode() == KeyEvent.VK_H){	
					if(shift == true && capL == false || capL == true && shift == false)
						qwerty.insert("H",qwerty.getCaretPosition());
					else
						qwerty.insert("h",qwerty.getCaretPosition());
					e.consume();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println(e.getKeyCode() +" " + e.getExtendedKeyCode() + " " + KeyEvent.VK_0);
				//Track if the Shift key has been released
				if(e.getKeyCode() == KeyEvent.VK_SHIFT)
					shift = false;
				//Handles the release of the H key
				if(e.getKeyCode() == KeyEvent.VK_H)
					e.consume();
				//Switch statement that handles all the differences between an AZERTY and
				//QWERTY keyboard. Adds the QWERTY translation to a JTextArea.
				switch(e.getKeyCode()){
					case (16777440):
						if(shift == true)
							qwerty.insert(")",qwerty.getCaretPosition());
						else
							qwerty.insert("0",qwerty.getCaretPosition());
						break;
					case (150):
						if(shift == true)
							qwerty.insert("!",qwerty.getCaretPosition());
						else
							qwerty.insert("1",qwerty.getCaretPosition());
						break;
					case (16777449):
						if(shift == true)
							qwerty.insert("@",qwerty.getCaretPosition());
						else
							qwerty.insert("2",qwerty.getCaretPosition());
						break;
					case (152):
						if(shift == true)
							qwerty.insert("#",qwerty.getCaretPosition());
						else
							qwerty.insert("3",qwerty.getCaretPosition());
						break;
					case (222):
						if(shift == true)
							qwerty.insert("$",qwerty.getCaretPosition());
						else
							qwerty.insert("4",qwerty.getCaretPosition());
						break;
					case (519):
						if(shift == true)
							qwerty.insert("%",qwerty.getCaretPosition());
						else
							qwerty.insert("5",qwerty.getCaretPosition());
						break;
					case (45):
						if(shift == true)
							qwerty.insert("^",qwerty.getCaretPosition());
						else
							qwerty.insert("6",qwerty.getCaretPosition());
						break;
					case (16777448):
						if(shift == true)
							qwerty.insert("&",qwerty.getCaretPosition());
						else
							qwerty.insert("7",qwerty.getCaretPosition());
						break;
					case (523):
						if(shift == true)
							qwerty.insert("*",qwerty.getCaretPosition());
						else
							qwerty.insert("8",qwerty.getCaretPosition());
						break;
					case (16777415):
						if(shift == true)
							qwerty.insert("(",qwerty.getCaretPosition());
						else
							qwerty.insert("9",qwerty.getCaretPosition());
						break;
					case (522):
						if(shift == true)
							qwerty.insert("_",qwerty.getCaretPosition());
						else
							qwerty.insert("-",qwerty.getCaretPosition());
						break;
					case (61):
						if(shift == true)
							qwerty.insert("+", qwerty.getCaretPosition());
						else
							qwerty.insert("=", qwerty.getCaretPosition());
						break;
					case (65):
						if(shift == true && capL == false || capL == true && shift == false)
							qwerty.insert("Q",qwerty.getCaretPosition());
						else
							qwerty.insert("q",qwerty.getCaretPosition());
						break;
					case (44):
						if(shift == true && capL == false || capL == true && shift == false)
							qwerty.insert("M",qwerty.getCaretPosition());
						else
							qwerty.insert("m",qwerty.getCaretPosition());
						break;
					case (90):
						if(shift == true && capL == false || capL == true && shift == false)
							qwerty.insert("W",qwerty.getCaretPosition());
						else
							qwerty.insert("w",qwerty.getCaretPosition());
						break;
					case (130):
						if(shift == true)
							qwerty.insert("{",qwerty.getCaretPosition());
						else
							qwerty.insert("[",qwerty.getCaretPosition());
						break;
					case (515):
						if(shift == true)
							qwerty.insert("}",qwerty.getCaretPosition());
						else
							qwerty.insert("]",qwerty.getCaretPosition());
						break;
					case (151):
						if(shift == true)
							qwerty.insert("|",qwerty.getCaretPosition());
						else
							qwerty.insert("\\",qwerty.getCaretPosition());
						break;
					case (81):
						if(shift == true && capL == false || capL == true && shift == false)
							qwerty.insert("A",qwerty.getCaretPosition());
						else
							qwerty.insert("a",qwerty.getCaretPosition());
						break;
					case (77):
						if(shift == true)
							qwerty.insert(":",qwerty.getCaretPosition());
						else
							qwerty.insert(";",qwerty.getCaretPosition());
						break;
					case (87):
						if(shift == true && capL == false || capL == true && shift == false)
							qwerty.insert("Z",qwerty.getCaretPosition());
						else
							qwerty.insert("z",qwerty.getCaretPosition());
						break;
					case (59):
						if(shift == true)
							qwerty.insert("<",qwerty.getCaretPosition());
						else
							qwerty.insert(",",qwerty.getCaretPosition());
						break;
					case (513):
						if(shift == true)
							qwerty.insert(">",qwerty.getCaretPosition());
						else
							qwerty.insert(".",qwerty.getCaretPosition());
						break;
					case (517):
						if(shift == true)
							qwerty.insert("?",qwerty.getCaretPosition());
						else
							qwerty.insert("/",qwerty.getCaretPosition());
						break;
					case (16777465):
						if(shift == true)
							qwerty.insert("\"",qwerty.getCaretPosition());
						else
							qwerty.insert("'",qwerty.getCaretPosition());
						break;
					case (16777394):
						if(shift == true)
							qwerty.insert("~",qwerty.getCaretPosition());
						else
							qwerty.insert("`",qwerty.getCaretPosition());
						break;
						
					//Prevents non alphabetical characters from printing
					//Allows for the use of a number pad
					default:
						//Add all other characters that have not changed position
						//Prevent any other keys from printing unwanted characters
						if(e.getKeyChar() >= 'A' && e.getKeyChar() <= 'Z' || e.getKeyChar() >= 'a' && e.getKeyChar() <= 'z'){
							if(e.getKeyChar() != 'H' && e.getKeyChar() != 'h')
								qwerty.insert(e.getKeyChar() + "", qwerty.getCaretPosition());
						}
						//NumberPad input
						else if(e.getKeyCode() == 32)
								qwerty.insert(" ", qwerty.getCaretPosition());
						else if(e.getKeyCode() >= 96 && e.getKeyCode()<=105)
							qwerty.insert((e.getKeyCode()-96) + "", qwerty.getCaretPosition());
						else if(e.getKeyCode() == 111)
							qwerty.insert("/",qwerty.getCaretPosition());
						else if(e.getKeyCode() == 106)
							qwerty.insert("*", qwerty.getCaretPosition());
						else if(e.getKeyCode() == 109)
							qwerty.insert("-",qwerty.getCaretPosition());
						else if(e.getKeyCode() == 107)
							qwerty.insert("+", qwerty.getCaretPosition());
						else if(e.getKeyCode() == 127)
							qwerty.insert(".", qwerty.getCaretPosition());
						break;
				}	
			}

			@Override
			public void keyTyped(KeyEvent e) {
				e.consume();
			}
			
		});
	
	}

}

