package seedu.medmoriser.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.function.Predicate;

import seedu.medmoriser.commons.core.Messages;
import seedu.medmoriser.logic.commands.exceptions.CommandException;
import seedu.medmoriser.model.Model;
import seedu.medmoriser.model.qanda.AnswerContainsKeywordsPredicate;
import seedu.medmoriser.model.qanda.QAndA;
import seedu.medmoriser.model.qanda.QAndAContainsKeywordsPredicate;
import seedu.medmoriser.model.qanda.QuestionContainsKeywordsPredicate;
import seedu.medmoriser.model.qanda.TagContainsKeywordsPredicate;

/**
 * Finds and lists all qAndAs in address book whose name contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class FindCommand extends Command {

    public static final String COMMAND_WORD = "find";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all QAndAs whose names contain any of "
            + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters (each separated by a comma): KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " alice, bob, charlie";

    private final Predicate<QAndA> predicate;

    public FindCommand(QuestionContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    public FindCommand(AnswerContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    public FindCommand(TagContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    public FindCommand(QAndAContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        for (int i = 0; i < model.getFilteredQAndAList().size(); i++) {
            model.getFilteredQAndAList().get(i).setNotQuiz();
        }

        if (QuizCommand.getIsQuiz()) {
            throw new CommandException(Messages.MESSAGE_ONGOING_QUIZ);
        } else {
            model.updateFilteredQAndAList(predicate);
            return new CommandResult(
                    String.format(Messages.MESSAGE_QANDA_LISTED_OVERVIEW,
                            model.getFilteredQAndAList().size()));
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FindCommand // instanceof handles nulls
                && predicate.equals(((FindCommand) other).predicate)); // state check
    }
}
