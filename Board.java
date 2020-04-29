package classProject;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;
import javax.swing.JComponent;

public class Board implements Icon{

	int contains;
	int contains2;
	ArrayList<Ellipse2D.Double> possible;
	ArrayList<Ellipse2D.Double> possible2;

	public Board()
	{
		possible= new ArrayList<Ellipse2D.Double>();
		possible2= new ArrayList<Ellipse2D.Double>();
		contains=0;
		contains2=0;
	}

	@Override public void paintIcon(Component t, Graphics g, int z, int n) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D)g;
		Color c = new Color(210,180,140);
		g2.setColor(c);
        g2.setStroke(new BasicStroke(3.0f));
        double x = 50;
        double y = 50;
        g2.draw(new RoundRectangle2D.Double(x, y, 1000, 400, 50, 50));
        g2.draw(new RoundRectangle2D.Double(x+20, y+24, 100, 350, 80, 80));
        g2.draw(new RoundRectangle2D.Double(1000-74, y+24, 100, 350, 80, 80));
        for(Ellipse2D.Double key: possible)
        {
    	   g2.draw(key);
        }
        for(Ellipse2D.Double key: possible2)
        {
    	   g2.draw(key);
        }
       
	}
	public void add1()
	{
		contains++;
		possible.removeAll(possible);
		int temp=0;
		for(int i=0;temp<contains;i++)
        {
        	for(int k=0;k<4 && temp<contains;k++)
        	{
        		possible.add(new Ellipse2D.Double(100+(10*k),100+(15*i),10,10));
    			temp++;
        	}

        } 
	}
	public void add2()
	{
		contains2++;
		possible2.removeAll(possible2);
		int temp=0;
		for(int i=0;temp<contains2;i++)
        {
        	for(int k=0;k<4 && temp<contains2;k++)
        	{
        		possible2.add(new Ellipse2D.Double(957+(10*k),100+(15*i),10,10));
    			temp++;
        	}

        } 
	}
	@Override
	public int getIconWidth() {
		return 1200;
	}

	@Override
	public int getIconHeight() {
		return 600;
	}
}
