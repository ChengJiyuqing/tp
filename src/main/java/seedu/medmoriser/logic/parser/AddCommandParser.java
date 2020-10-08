package seedu.medmoriser.logic.parser;

import static seedu.medmoriser.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.medmoriser.logic.parser.CliSyntax.PREFIX_ANSWER;
import static seedu.medmoriser.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.medmoriser.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.medmoriser.logic.parser.CliSyntax.PREFIX_QUESTION;
import static seedu.medmoriser.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import seedu.medmoriser.logic.commands.AddCommand;
import seedu.medmoriser.logic.parser.exceptions.ParseException;
import seedu.medmoriser.model.questionset.Answer;
import seedu.medmoriser.model.questionset.Email;
import seedu.medmoriser.model.questionset.Phone;
import seedu.medmoriser.model.questionset.Question;
import seedu.medmoriser.model.questionset.QuestionSet;
import seedu.medmoriser.model.tag.Tag;

/**
 * Parses input arguments and creates a new AddCommand object
 */
public class AddCommandParser implements Parser<AddCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_QUESTION,
                PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ANSWER, PREFIX_TAG);
        //if input contains valid question and answer input
        if (!arePrefixesPresent(argMultimap, PREFIX_QUESTION, PREFIX_ANSWER)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
        }
        Question question = ParserUtil.parseQuestion(argMultimap.getValue(PREFIX_QUESTION).get());
        Answer answer = ParserUtil.parseAnswer(argMultimap.getValue(PREFIX_ANSWER).get());
        Optional<Phone> phone = Optional.empty();
        Optional<Email> email = Optional.empty();
        Optional<Set<Tag>> tagList = Optional.empty();

        //TODO: if input contains valid phone input
        if (arePrefixesPresent(argMultimap, PREFIX_PHONE)) {
            phone = Optional.of(ParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE).get()));

        }

        //TODO: if input contains valid email input
        if (!arePrefixesPresent(argMultimap, PREFIX_EMAIL)) {
            email = Optional.of(ParserUtil.parseEmail(argMultimap.getValue(PREFIX_EMAIL).get()));
        }

        //TODO: if input contains valid tag input
        if (!arePrefixesPresent(argMultimap, PREFIX_TAG)) {
            tagList = Optional.of(ParserUtil.parseTags(argMultimap.getAllValues(PREFIX_TAG)));
        }


        //TODO: modify this call to constructor
        QuestionSet questionSet = new QuestionSet(question, phone, email, answer, tagList);

        return new AddCommand(questionSet);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
