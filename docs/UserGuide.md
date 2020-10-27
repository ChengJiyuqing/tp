---
layout: page
title: User Guide
---

This guide aims to orientate you to the features of **Medmoriser**. If you're a medical student looking for a quiz
management system, this guide will give you all the information you need to get started with **Medmoriser**.

* Table of Contents
{:toc}

**Medmoriser** is a desktop app to help medical students memorise and revise their content. It is optimized for
 CLI users so that frequent revisions can be done faster by typing in commands.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add q/QUESTION`, `QUESTION` is a parameter which can be used as `add q/What is the heart responsible for?`.

* Items in square brackets are optional.<br>
  e.g. `q/QUESTION [t/TAG]` can be used as `q/What is the heart responsible for t/cardiology` or as `q/What is the heart responsible for`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/heart`, `t/heart t/cardiology` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `q/QUESTION a/ANSWER`, `a/ANSWER q/QUESTION` is also acceptable.

</div>

### Viewing help: `help`

If you need to view the help page, this command shows a message explaining how to access it.

Format: `help`

### Adding a qAndA: `add`

You can add a question and answer pair to the database.

Format: `add q/QUESTION a/ANSWER`

Examples:
* `add q/what organ system is the lungs part of? a/respiratory system?`
* `add q/what is the function of the heart? a/It's the muscle at the centre of your circulation system, pumping blood around your body as your heart beats. This blood sends oxygen and nutrients to all parts of your body, and carries away unwanted carbon dioxide and waste products.`

### Deleting a Q&A: `delete`

You can delete a specified Q&A from the database.

Format: `delete INDEX`

* This allows you to delete the Q&A at the specified `INDEX`.
* The index refers to the index number shown in the displayed question list.
* The index **must be a positive integer** 1, 2, 3, …

Examples:
* `list` followed by `delete 2` deletes the 2nd Q&A in the question book.
* `find disease` followed by `delete 1` deletes the 1st question in the results of the `find` command.

### Listing all Questions & Answers: `list` (by: Jonathan Foo)

This shows you the entire database of questions and answers.

Format: `list [questions]`

* Just typing list will list all questions and answers
* Adding the `questions` parameter will list only the questions (i.e. hide the answers) 

Examples:
* `list` will show all questions and answers
* `list questions` will only show all questions

### Editing a Q&A: `edit`

You can make changes to an existing Q&A with this command.

Format: `edit INDEX [q/QUESTION] [a/ANSWER] [t/TAG]…​`

* This allows you to edit the Q&A at the specified `INDEX`. The index refers to the index number shown in the displayed question list. The index **must be a positive integer** 1, 2, 3, …​
* You must provide at least one of the optional fields.
* Existing values will be updated to the input values.
* When you edit the tags, the existing tags of the Q&A will be removed i.e adding of tags is not cumulative.
* You can remove all the Q&A's tags by typing `t/` without specifying any tags after it.

Examples:
*  `edit 1 a/To pump blood` Edits the answer the 1st question to be `To pump blood`.
*  `edit 2 q/What is the heart t/` Edits the question of the 2nd Q&A to be `What is the heart` and clears all existing tags.

### Locating questions/answers/tags by keywords: `find` (by: Yong Ming Yang)

If you would like to search the database, you can do so in a few ways:

1. Find Q&A with **questions** containing any of the given keywords.

    Format: `find q/KEYWORD`, for 2 or more words: `find q/PHRASE 1, KEYWORD1`

2. Find Q&A with **answers** containing any of the given keywords.

    Format: `find a/KEYWORD`, for 2 or more words: `find q/PHRASE 1, KEYWORD1`

3. Find Q&A with **tags** containing any of the given keywords. 
    Keywords for tags can also have phrases, however this requires the text to have an exact match (case-insensitive).

    Format: `find a/KEYWORD`, for 2 or more words: `find q/KEYWORD1, KEYWORD2`

4. Find Q&A with **questions or answers** containing any of the given keywords.

    Format: `find a/KEYWORD`, for 2 or more words: `find q/KEYWORD1, KEYWORD2`

Examples:
* `find q/system, disease` - finds questions with the word "system" and/or "disease".
* `find a/vessels, chronic disease` - finds answers with the word vessels, and/or the phrase "chronic disease".
* `find t/anatomy, Nervous System` - finds question sets tagged with the word "anatomy" and/or "Nervous System" (can be both), requires exact match of words (case-insensitive).
* `find infection, nervous system` - finds question and/or answers with the word infection, and/or the phrase "nervous system"

### Clearing all entries: `clear`

If you want to reset the database, this command helps to clear all entries from the question book.

Format: `clear`

### Exiting the program: `exit`

If you're done with your work, this command allows you to exit the program.

Format: `exit`

### Saving the data

You don't need to worry about saving data manually, as Medmoriser data is automatically saved in the hard disk after any command that changes the data.

### Archiving data files [Coming Soon]

If you don't need certain questions anymore, you can archive them to declutter your workspace.

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous Medmoriser home folder.

--------------------------------------------------------------------------------------------------------------------


## Command summary

Action | Format, Examples
--------|------------------
**Add** | `add q/QUESTION a/ANSWER [t/TAG]…​` <br> e.g., `add q/What does the heart do a/Pump blood t/heart t/cardiology`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**List** | `list`
**Edit** | `edit INDEX [q/QUESTION] [a/ANSWER] [t/TAG]…​` <br> e.g., `edit a/Maintain blood pressure t/cardiology`
**Find** | `find KEYWORD or [q/QUESTION] or [a/ANSWER] or [t/TAG]` <br> e.g., `find system, or find a/answer1, answer 2`
**Clear** | `clear`
**Help** | `help`
**Exit** | `exit`

