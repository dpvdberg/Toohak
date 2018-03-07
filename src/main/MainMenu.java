//Written by Alessandro Vinciguerra <alesvinciguerra@gmail.com>
//Copyright (C) 2017  Arc676/Alessandro Vinciguerra

//This program is free software: you can redistribute it and/or modify
//it under the terms of the GNU General Public License as published by
//the Free Software Foundation (version 3).

//This program is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//GNU General Public License for more details.

//You should have received a copy of the GNU General Public License
//along with this program.  If not, see <http://www.gnu.org/licenses/>.
//See README.txt and LICENSE.txt for more details

package main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import internals.Session;
import backend.View;

/**
 * Main window in the program with buttons
 * to access all other views
 * @author Ale
 *
 */
public class MainMenu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 4074500268726614700L;
	
	private JButton btnQuizEditor;
	private JButton btnHostGame;
	private JButton btnJoinGame;
	private JButton btnShowAbout;
	private JButton btnQuit;

	private Main main;

	private Session chosenSession;

	public MainMenu(Main main) {
		this.main = main;

		setTitle("Toohak");
		setBounds(100, 100, 300, 250);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));

		btnQuizEditor = new JButton("Session Editor");
		btnQuizEditor.addActionListener(this);
		getContentPane().add(btnQuizEditor);

		btnHostGame = new JButton("Host Game");
		btnHostGame.addActionListener(this);
		getContentPane().add(btnHostGame);

		btnJoinGame = new JButton("Join Game");
		btnJoinGame.addActionListener(this);
		getContentPane().add(btnJoinGame);
		
		btnShowAbout = new JButton("About Toohak");
		btnShowAbout.addActionListener(this);
		getContentPane().add(btnShowAbout);
		
		btnQuit = new JButton("Quit");
		btnQuit.addActionListener(this);
		getContentPane().add(btnQuit);
	}

	public Session getQuiz() {
		return chosenSession;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnQuizEditor) {
			main.showView(View.QUIZ_EDITOR);
		} else if (e.getSource() == btnHostGame) {
			main.showView(View.SERVER_MODE);
		} else if (e.getSource() == btnJoinGame) {
			main.showView(View.CLIENT_MODE);
		} else if (e.getSource() == btnShowAbout) {
			main.showView(View.ABOUT_WINDOW);
		} else if (e.getSource() == btnQuit) {
			System.exit(0);
		}
	}

}