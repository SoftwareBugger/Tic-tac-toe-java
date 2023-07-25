package tic_tac_toe;

import java.util.ArrayList;

import javax.swing.JButton;

public class AIplayer {
	AIplayer() {
		
	}
	public int checkWin(Game_Board board) {
		return 1;
	}
	public void move(Game_Board board) {
		int n = board.n;
		int[] r = new int[n];
		int[] c = new int[n];
		int[] d = {0,0};
		for (int i = 0;i<n;i++) {
			r[i]=c[i]=0;
		}
		for (int i = 0;i < n;i++) {
			for (int j = 0;j<n;j++) {
				if (board.chess[i][j]!=null) {
					if (board.chess[i][j].getText().equals("O")) {
						r[i]++;
						c[j]++;
						if (i==j) {
							d[0]++;
						}
						if (i==-j+n-1) {
							d[1]++;
						}
					}
				}
			}
		}
		for (int i = 0;i < n;i++) {
			for (int j = 0;j<n;j++) {
				if (board.chess[i][j].getText().equals("X")) {
					r[i]=0;
					c[j]=0;
					if (i==j) {
						d[0]=0;
					}
					if (i==-j+n-1) {
						d[1]=0;
					}
				}
		
			}
		}
		int[][] order = {{2,1,2},{1,3,1},{2,1,2}};
		for (int k = n-1;k>=0;k--) {
			ArrayList<int[]> list = new ArrayList<int[]>();
			for (int i = 0;i<n;i++) {
				for (int j = 0;j<n;j++) {
					if (board.chess[i][j].getText().equals("")) {
							if (r[i]==k||c[j]==k||(i==j&&d[0]==k)||(i==n-1-j&&d[1]==k)) {
								int[] cord = {i,j};
								list.add(cord);
							}
						}
					}
				}
			if (!list.isEmpty()) {
				int[] current = {list.get(0)[0],list.get(0)[1]};
				for (int[] i:list) {
					if (order[i[0]][i[1]]>=order[current[0]][current[1]]) {
						current[0] = i[0];
						current[1] = i[1];
					}
				}
				board.chess[current[0]][current[1]].setText("X");
				return;
			}
			else continue;
		}
	}

}
