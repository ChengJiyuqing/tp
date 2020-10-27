package seedu.medmoriser.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.medmoriser.logic.commands.exceptions.CommandException;
import seedu.medmoriser.model.Model;

/**
 * Receives the user's answer for a quiz.
 */
public class AnswerCommand extends Command {

    public static final String COMMAND_WORD = "answer";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": The answer that the user keys in for the quiz "
            + "question. \n"
            + "Example: " + COMMAND_WORD + " This is my answer";

    public static final String MESSAGE_USER_ANSWER = "Your answer: ";

    public static final String MESSAGE_NOT_QUIZ = "There is no ongoing quiz";

    private final String userAnswer;

    /**
     * Creates an AnswerCommand
     * @param userAnswer The user's input answer.
     */
    public AnswerCommand(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        if (!QuizCommand.getIsQuiz()) {
            throw new CommandException(MESSAGE_NOT_QUIZ);
        } else {
            model.getFilteredQAndAList().get(0).setQuizAnswer();
            return new CommandResult(MESSAGE_USER_ANSWER + userAnswer);
        }
    }
}
