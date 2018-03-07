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

package internals;

import internals.Category;
import internals.arithmetic.Boundry;
import internals.arithmetic.NumberType;
import internals.arithmetic.Operation;
import internals.question.Question;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * Class for representing quizzes
 * @author Ale
 *
 */
public class Session {
	public final String quizName;
	
	private Category category;
	private Set<Question> questions;
	private Set<Question> askedQuestions = new HashSet<>();
	
	public Session(String name, Category category) {
		this.quizName = name;
		this.category = category;
		this.questions = generateQuestions();
	}

    private Set<Question> generateQuestions() {
	    Set<Question> questions = new HashSet<>();
	    // TODO: CHANGE THIS...
        for (int i = 0; i < 10; i++) {
            questions.add(new Question(category));
        }

        return questions;
    }
	
	/**
	 * Gets the next question in the quiz
	 * @return The next question, or null if there aren't any left
	 */
	public Question nextQuestion() {
		Set<Question> remainingQuestions = new HashSet<>();
		remainingQuestions.addAll(questions);
		if (askedQuestions.size() > 0)
		    remainingQuestions.removeAll(askedQuestions);
		if (remainingQuestions.size() <= 0) {
			return null;
		}

		Question q = remainingQuestions.iterator().next();
		askedQuestions.add(q);
		return q;
	}

}