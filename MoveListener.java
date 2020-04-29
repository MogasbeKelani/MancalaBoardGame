package classProject;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class MoveListener extends MouseAdapter{
	private int pos;
	private JLabel pits;
	private ArrayList<PitIcons> pitList;
	private ArrayList<JLabel> labelList;
	private ArrayList<Integer> scores;
	private Board board;
	private boolean player;
	private JLabel container;
	private JFrame main;
	public MoveListener(JFrame m, int p,JLabel l,ArrayList<PitIcons>pl,ArrayList<JLabel>ll,Board b,ArrayList<Integer>sc,JLabel lb)
	{
		pos=p;
		pits=l;
		pitList=pl;
		board=b;
		labelList=ll;
		scores=sc;
		player=true;
		container=lb;
		main=m;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int po=0;
		
		if(pos<=5)
		{
			player=false;
		}
		int i=pos+1;
		int amount= scores.get(pos);
		boolean t= true;
		if(pos==0)
		{
			i=6;
			if(player==false)
			{
				amount--;
				if(amount>0)
				{
					board.add1();
					container.setIcon(board);
					container.repaint();
				}
				
			}
		}
		else if(pos==11)
		{
			i=5;
			t=false;
			if(player==true)
			{
				amount--;
				if(amount>0)
				{
					board.add2();
					container.setIcon(board);
					container.repaint();
				}
			}
		}
		else if(pos<=5)
		{
			t=false;
			i=pos-1;
		}
		this.move(pos);
		while(amount>0)
		{
			 pitList.get(i).add();
			 labelList.get(i).setIcon(pitList.get(i));
		     pits.add(labelList.get(i));
		     labelList.get(i).repaint();
		     scores.set(i,scores.get(i)+1);
		     
			if(i==11)
			{
				i=6;
				t=false;
				if(player==true)
				{
					amount--;
					if(amount>0)
					{
						board.add2();
						container.setIcon(board);
						container.repaint();
					}
				}
			}
			else if(i==0)
			{
				i=5;
				t=true;
				if(player==false)
				{
					amount--;
					if(amount>0)
					{
						board.add1();
						container.setIcon(board);
						container.repaint();
					}
				}
			}
			if(t==true)
			{
				i++;
			}
			else
			{
				i--;
			}
			amount--;
		}
		for(int  f=0;f<12;f++)
		{
			if(scores.get(f)==0)
			{
				po++;
			}
			if(po==12)
			{
				if(board.possible.size()>board.possible2.size())
				{
					JFrame pop = new JFrame();
					pop.add(new JTextField("Player B WON!!!!!"));
					pop.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			        pop.pack();
			        pop.setVisible(true);
			        main.setBackground(Color.GREEN);
			        return;
				}
				else
				{
					JFrame pop = new JFrame();
					pop.add(new JTextField("Player A WON!!!!!"));
					pop.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			        pop.pack();
			        pop.setVisible(true);
			        main.setBackground(Color.red);
			        return;
				}
			}
		}
		
		
		
	}


	public void move(int p)
	{
		 pitList.get(p).move();
		 labelList.get(p).setIcon(pitList.get(p));
	     pits.add(labelList.get(p));
	     labelList.get(p).repaint();
	     scores.set(p,0);
	}

	

	
}
