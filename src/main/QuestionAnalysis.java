package main;

import internals.question.Question;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Custom-drawn view for drawing graphs showing player responses
 * to questions
 * @author Ale
 *
 */
public class QuestionAnalysis extends JPanel {

	private static final long serialVersionUID = -4252183076285924502L;
	
	private Question question;
	private int answerCount[];
	
	/**
	 * Load new data to plot a new graph
	 * @param q Relevant question
	 * @param answers How many times each answer was chosen
	 */
	public void loadData(Question q, int[] answers) {
		question = q;
		answerCount = answers;
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		if (question == null) {
			return;
		}
		
		int maxCount = 1;
		for (int count : answerCount) {
			if (count > maxCount) {
				maxCount = count;
			}
		}
		
		g.setColor(Color.RED);
		g.fillRect(200, 120, 300 * answerCount[0] / maxCount, 15);
		
		g.setColor(Color.BLUE);
		g.fillRect(200, 140, 300 * answerCount[1] / maxCount, 15);
		
		g.setColor(Color.GREEN);
		g.fillRect(200, 160, 300 * answerCount[2] / maxCount, 15);
		
		g.setColor(Color.ORANGE);
		g.fillRect(200, 180, 300 * answerCount[3] / maxCount, 15);
		
		g.setColor(Color.BLACK);
		g.drawString(question.toString(), 25, 80);
		g.drawString("Answers", 40, 100);
		

	}

}
