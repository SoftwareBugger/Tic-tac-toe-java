package tic_tac_toe;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Game_Board extends JFrame implements ActionListener{
	JButton[][] chess;
	AIplayer cmptr = new AIplayer();
	int n;
	Game_Board(int m){
		n = m;
		chess = new JButton[n][n];
		this.setSize(1000,1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(n,n));
		for(int i = 0;i<n;i++) {
			for (int j = 0;j<n;j++) {
				chess[i][j] = new JButton();
				chess[i][j].setFont(new Font("",Font.BOLD,30));
				chess[i][j].addActionListener(this);
				this.add(chess[i][j]);
			}
		}
		this.setVisible(true);
		//cmptr.move(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i = 0;i<n;i++) {
			for (int j = 0;j<n;j++) {
				if (e.getSource()==chess[i][j]) {
					if (chess[i][j].getText()=="") {
						chess[i][j].setText("O");
						cmptr.move(this);
					}
					else return;
				}
			}
		}
	}
}
