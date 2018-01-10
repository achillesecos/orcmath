package simon;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonJi extends Button implements ButtonInterfaceAchilles{

	public ButtonJi(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, "", null);
		update();
	}
	/*
	public void drawButton(Graphics2D g, boolean hover){
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		drawShape(g, hover);
		g.setColor(getForeground());
		g.setFont(getFont());
		FontMetrics fm = g.getFontMetrics();
		
		if(getText()!= null){
			g.setColor(getForeground());
			String t = getText();
			//just in case text is too wide, cut off
			int cutoff = t.length();
			while(cutoff > 0 && fm.stringWidth(t) > getWidth()){
				cutoff --;
				t = t.substring(0,cutoff); 
			}
			g.drawString(t, (getWidth()-fm.stringWidth(t))/2, 
					(getHeight()+fm.getHeight()-fm.getDescent())/2);
		}
		update();
	}
	*/
	public void drawButton(Graphics2D g, boolean hover) {
		g.drawOval(50, 50, 50, 50);
		
		//update();
	}
	
	@Override
	public void setColor(Color color) {
		this.setBackground(color);
		update();
		
	}

	@Override
	public void highlight() {
		this.setBackground(Color.yellow);
		update();
	}

	@Override
	public void dim() {
		this.setBackground(this.darkgray);
		update();
		
	}

	@Override
	public void getButton() {
		// TODO Auto-generated method stub
		
	}

}
