package internals.question;

import internals.Category;
import internals.arithmetic.Argument;
import internals.arithmetic.Operation;
import internals.arithmetic.ValuedOperation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class Question implements Serializable {
    Category category;
    List<Operation> operations;
    ValuedOperation rootOperation;

    /**
     * Create a question for a given category.
     *
     * @param category The category to create a question for.
     */
    public Question(Category category) {
        this.category = category;
        this.operations = generateOperations();

        generateRoot();
    }

    private void generateRoot() {
        Random random = new Random();
        // Note: we always have one more argument to generate a valid question
        int opCount = category.argumentCount - 1;

        Argument firstArg = new Argument(category.getNumber());
        Argument secondArg = new Argument(category.getNumber());

        ValuedOperation valuedOperation = null;

        for (int i = 0; i < opCount; i++) {
            valuedOperation = new ValuedOperation(operations.get(i), firstArg, secondArg);

            // Left or right append
            if (random.nextBoolean()) {
                firstArg = new Argument(valuedOperation);
                secondArg = new Argument(category.getNumber());
            } else {
                firstArg = new Argument(category.getNumber());
                secondArg = new Argument(valuedOperation);
            }
        }

        rootOperation = valuedOperation;
    }

    private List<Operation> generateOperations() {
        List<Operation> operationList = new ArrayList<>(category.opTypes);

        return new Random().ints(category.argumentCount - 1, 0, operationList.size())
                .mapToObj(i -> operationList.get(i))
                .collect(Collectors.toList());
    }

    /**
     * Compute the answer for this question.
     * @return Arithmetic answer.
     */
    public double getAnswer() {
        return rootOperation.getResult();
    }

    @Override
    public String toString() {
        return rootOperation.toString();
    }

    public boolean acceptAnswer(double answer) {
        return answer == getAnswer();
    }

    public int getPoints() {
        return 100;
    }

    public int getTimeLimit() {
        return 30;
    }
}
