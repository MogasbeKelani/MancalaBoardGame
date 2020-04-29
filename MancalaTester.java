package classProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class MancalaTester {
	
	public static void main(String [] args)
	{
		
		JFrame first = new JFrame();
        first.setLayout(new FlowLayout());
        JTextField decider= new JTextField("How many pieces do you want to start the game with in each pit");
		first.add(decider,BorderLayout.NORTH);
		JButton three = new JButton("3");
		three.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				boardGame(Integer.valueOf(three.getText()));
				first.dispose();

			}
		});
		JButton four = new JButton("4");
		four.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				boardGame(Integer.valueOf(four.getText()));
				first.dispose();
			}
		});
		first.add(three);
		first.add(four);
		

		first.pack();
		first.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		first.setVisible(true);
	}
	public static void boardGame(int num)
	{
		JFrame frame = new JFrame();
		Board b= new Board();
		JLabel board= new JLabel(b);
		JLabel pits = new JLabel();
		pits.setLayout(new GridLayout(2,6));
		String pitNameTop="";
		String pitNameBottom="";
		ArrayList<Integer> scores= new ArrayList<Integer>();
		ArrayList<JLabel> labelList= new ArrayList<JLabel>();
		ArrayList<PitIcons> pitList= new ArrayList<PitIcons>();
		for(int i=0;i<6;i++)
		{
			pitNameTop+="B"+(i+1)+"                         ";
			pitNameBottom+="A"+(i+1)+"                         ";
		}
		JLabel pitPosTop= new JLabel(pitNameTop);
		pitPosTop.setFont(new Font("Serif", Font.BOLD, 15));
		pitPosTop.setBounds(240, 70, 1000, 20);
		frame.add(pitPosTop);
		
		JLabel pitPosBottom= new JLabel(pitNameBottom);
		pitPosBottom.setFont(new Font("Serif", Font.BOLD, 15));
		pitPosBottom.setBounds(240, 390, 1000, 20);
		frame.add(pitPosBottom);
		 for(int i=0;i<12;i++)
		 {
			PitIcons p= new PitIcons(num);
			scores.add(num);
			JLabel l = new JLabel(p);
			labelList.add(l);
			pits.add(labelList.get(i));
			pitList.add(p);
		 }
		 for(int i=0;i<12;i++)
		 {
			labelList.get(i).addMouseListener(new MoveListener(frame,i,pits,pitList,labelList,b,scores,board));
		 }
		 

		pits.setBounds(200, 90, 700, 320);
		frame.add(pits);
		frame.add(board);
		
		

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(3000, 3000);
        frame.setVisible(true);
        
	}

}
