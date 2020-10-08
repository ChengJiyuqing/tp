package seedu.medmoriser.model.questionset;

import static seedu.medmoriser.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import seedu.medmoriser.model.tag.Tag;

/**
 * Represents a QuestionSet in the Question bank.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class QuestionSet {

    // Identity fields
    private final Question question;
    private final Optional<Phone> phone;
    private final Optional<Email> email;

    // Data fields
    private final Answer answer;
    private final Optional<Set<Tag>> tags;

    /**
     * Every field must be present and not null.
     */
    public QuestionSet(Question question, Optional<Phone> phone, Optional<Email> email,
                       Answer answer, Optional<Set<Tag>> tags) {
        requireAllNonNull(question, phone, email, answer, tags);
        this.question = question;
        this.phone = phone;
        this.email = email;
        this.answer = answer;
        this.tags = tags;
        //this.tags.addAll(tags);
    }

    public Question getQuestion() {
        return question;
    }

    //TODO: refactor
    public Phone getPhone() {
        return phone.get();
    }

    //TODO: refactor
    public Email getEmail() {
        return email.get();
    }

    public Answer getAnswer() {
        return answer;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     * TODO: refactor
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags.get());
    }

    /**
     * Returns true if both QuestionSets of the same name have at least one other identity field that is the same.
     * This defines a weaker notion of equality between two QuestionSets.
     */
    public boolean isSameQuestionSet(QuestionSet otherQuestionSet) {
        if (otherQuestionSet == this) {
            return true;
        }

        return otherQuestionSet != null
                && otherQuestionSet.getQuestion().equals(getQuestion())
                && (otherQuestionSet.getPhone().equals(getPhone()) || otherQuestionSet.getEmail().equals(getEmail()));
    }

    /**
     * Returns true if both QuestionSets have the same identity and data fields.
     * This defines a stronger notion of equality between two QuestionSet.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof QuestionSet)) {
            return false;
        }

        QuestionSet otherQuestionSet = (QuestionSet) other;
        return otherQuestionSet.getQuestion().equals(getQuestion())
                && otherQuestionSet.getPhone().equals(getPhone())
                && otherQuestionSet.getEmail().equals(getEmail())
                && otherQuestionSet.getAnswer().equals(getAnswer())
                && otherQuestionSet.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(question, phone, email, answer, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getQuestion())
                .append(" Phone: ")
                .append(getPhone())
                .append(" Email: ")
                .append(getEmail())
                .append(" Answer: ")
                .append(getAnswer())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }

}
