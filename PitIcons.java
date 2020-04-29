package classProject;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.Icon;

public class PitIcons implements Icon{
	public static int amount;
	public ArrayList<Ellipse2D.Double> possible;

	public PitIcons(int choice)
	{
		amount=choice;
		possible=new ArrayList<Ellipse2D.Double>();
		 int temp=0;
	        for(int i=0; temp<amount;i++)
	        {
	        	for(int k=0;k<4 && temp<amount;k++)
	        	{
	        		possible.add(new Ellipse2D.Double(25+(10*k),50+(15*i),10,10));
	    			temp++;
	        	}

	        } 
	        amount=possible.size();
		
	}

	@Override public void paintIcon(Component c1, Graphics g, int x1, int y1) {
		Graphics2D g2 = (Graphics2D)g;
        amount=possible.size();
		Color c = new Color(210,180,140);
		g2.setColor(c);
        g2.setStroke(new BasicStroke(3.0f));
        g2.draw(new Ellipse2D.Double(3,1,100,135));
        for(Ellipse2D.Double key: possible)
        {
    	   g2.draw(key);
        }
		
	}
	public void add()
	{
		amount=possible.size()+1;
		possible.removeAll(possible);
		int temp=0;
		for(int i=0;temp<amount;i++)
        {
        	for(int k=0;k<4 && temp<amount;k++)
        	{
        		possible.add(new Ellipse2D.Double(25+(10*k),50+(15*i),10,10));
    			temp++;
        	}

        } 
	}
	public void move()
	{
		amount=0;
		possible.removeAll(possible);
	}
	public int contains()
	{
		return amount;
	}

	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return 135;
	}

}
