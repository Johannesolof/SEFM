/**
 * This class represents a text box for numeric values.
 * Its content is represented as an array of single digits.
 * -----------------------
 * Your task is to add JML contracts for each method in this class
 * that reflect the informal descriptions in the Javadoc comments.
 * Also add JML invariants for the fields "cursorPosition" and "content" that make sure that
 * - the cursorPosition is always a valid value (see comment for cursorPosition).
 * - the content before the cursor contains only single digits
 * - the content at the cursor is EMPTY
 * Furthermore, think about which methods are pure and use the appropriate annotation.
 * Do NOT implement the methods!
 *
 * Hint: If you use variables for array indices in an assignable-clause,
 * 		 their values are evaluated in the pre-state.
 */
public class NumericTextBox
{
	public final int EMPTY = -1;

	/**
	 * The current cursor position, i.e. the position after the previously entered digit.
	 * If this is 0, then the cursor is placed at the very beginning of the text box.
	 * Note that the number of possible cursor positions is greater by one than
	 * the length of the text box.
	 */
	// the cursorPosition is always a valid value
	/* @ public static invariant
		 @ cursorPosition >= 0 && cursorPosition <= content.length;
		 @*/
	// the content at the cursor is EMPTY
	/* @ public static invariant
		 @ content[cursorPosition] == EMPTY;
		 @*/
	private /*@spec_public@*/ int cursorPosition;

	/**
	 * This array stores the contents of the text box. At every position
	 * before the cursor, there is a valid value (i.e. a single digit).
	 * Positions after the cursor must be EMPTY.
	 */
	// the content before the cursor contains only single digits
		/* @ public static invariant 
		 @ (\forall int x; x >= 0 && x < cursorPosition; isSingleDigit(content[x]));
		 @ (\forall int x; x >= cursorPosition && x < content.length; content[x] == EMPTY);
		 @*/
	private /*@spec_public@*/ int[] content;

	/**
	 * Holds the current TextBoxRenderer. This can be null, which means that there
	 * is no renderer assigned.
	 */
	private /*@spec_public@*/ TextBoxRenderer textBoxRenderer;

	/**
	 * Gets the currently assigned TextBoxRenderer.
	 */
	/* @ require textBoxRenderer != null;
		 @ ensures \result == textBoxRenderer;
		 @ assignable \nothing;
		 @
		 @ also
		 @
		 @ require textBoxRenderer == null;
		 @ ensure \result == textBoxRenderer;
		 @ assignable \nothing;
		 @ */
	public /*@ pure @*/ TextBoxRenderer getRenderer()
	{
		// ...
	}

	/**
	 * Sets the TextBoxRenderer used for rendering this text box.
	 * It can also be set to null, if the text box is not rendered.
	 */
	/* @
		 @ requires renderer != null;
		 @ ensures textBoxrenderer == renderer;
		 @ assignable textboxRenderer;
		 @
		 @ also
		 @ 
		 @ requires renderer == null;
		 @ ensures textBoxRenderer == null;
		 @ assignable textboxRenderer;
		 @ */
	public void setRenderer(TextBoxRenderer renderer)
	{
		// ...
	}

	/**
	 * Checks whether a given input is a single digit (i.e. between 0 and 9).
	 *
	 * @param input The input character.
	 * @return true if the input is a single digit, false otherwise.
	 */
	/* @
		 @ require (input >= 0 && input <= 9);
		 @ ensure \result == true;
		 @ assignable \nothing;
		 @
		 @ also
		 @ 
		 @ require (input < 0 || input > 9);
		 @ ensure \result == false;
		 @ assignable \nothing;
		 @ */
	public /*@ pure @*/ boolean isSingleDigit(int input)
	{
		// ...
	}

	/**
	 * Clears the text box and resets the cursor to the start.
	 * Also sets the contentChanged flag of the current TextBoxRenderer, if any.
	 */
	/* @
		 @ require textBoxRenderer != null;
		 @ ensure (\forall int x; x >= 0 && x < content.length; content[x] == EMPTY);
		 @ ensure cursorPosition == 0;
		 @ ensure textBoxRenderer.contentChanged == true;
		 @ assignable content[*], textBoxRenderer, cursorPosition;
		 @
		 @ also
		 @
		 @ require textBoxRenderer == null;
		 @ ensure (\forall int x; x >= 0 && x < content.length; content[x] == EMPTY);
		 @ ensure cursorPosition == 0;
		 @ assignable content[*], cursorPosition;
		 @ */

	public void clear()
	{
		// ...
	}

	/**
	 * Enters a given input character into the text box and moves the cursor forward.
	 * If the input can be processed, the contentChanged flag of the current TextBoxRenderer (if any) is set.
	 * If an exception occurs, the TextBoxRenderer's showError flag is set instead.
	 *
	 * @param input the input character.
	 *
	 * @throws IllegalArgumentException if the input was not a single digit.
	 *
	 * @throws RuntimeException if the input was valid, but the cursor is at the end
	 * 							of the text box and no further input can be accepted.
	 */
	/* @
		 @ require isSingleDigit(input);
		 @ require cursorPosition < content.length
		 @ ensure \old(cursorPosition)+1 == cursorPosition;
		 @ ensure content[\old(cursorPosition)] != EMPTY;
		 @ ensure textBoxRenderer != null ==> textBoxRenderer.contentChanged;
		 @
		 @ also
		 @ 
		 @ require !isSingleDigit(input);
		 @ ensure textBoxRenderer != null ==> textBoxRenderer.showError;
		 @ signals_only IllegalArgumentException;
		 @
		 @ also
		 @ 
		 @ require isSingleDigit(input);
		 @ require cursorPosition >= content.length;
		 @ ensure textBoxRenderer != null ==> textBoxRenderer.showError;
		 @ signals_only RuntimeException;
		 @ */
	public void enterCharacter(int input)
	{
		// ...
	}

	/**
	 * Deletes the most recently entered character and moves the cursor back one position.
	 * Also sets the current TextBoxRenderer's contentChanged flag (if any).
	 *
	 * @throws RuntimeException if the cursor is at the very beginning. In this case
	 * 							the showError flag of the TextBoxRenderer is set
	 * 							before the exception is thrown.
	 */
	/* @
		 @ require textBoxRenderer != null;
		 @ require cursorPosition > 0;
		 @ ensure \old(cursorPosition)-1 == cursorPosition;
		 @ ensure content[\old(cursorPosition)] == input;
		 @ ensure textBoxRenderer.contentChanged;
		 @ assignable content[\old(cursorPosition)], cursorPosition;
		 @
		 @ also
		 @
		 @ require textBoxRenderer == null;
		 @ require cursorPosition > 0;
		 @ ensure \old(cursorPosition)-1 == cursorPosition;
		 @ ensure content[\old(cursorPosition)] == input;
		 @ assignable content[\old(cursorPosition)], cursorPosition;
		 @
		 @ also
		 @ 
		 @ require textBoxRenderer != null;
		 @ require cursorPosition <= 0;
		 @ ensure textBoxRenderer.showError;
		 @ signals_only RuntimeException;
		 @
		 @ also
		 @ 
		 @ require textBoxRenderer == null;
		 @ require cursorPosition <= 0;
		 @ signals_only RuntimeException;
	   @ */
	public void backspace()
	{
		// ...
	}
}

/**
 * This class represents a renderer that is responsible for displaying the
 * text box to the user in some way.
 * -----------------------
 * You don't need to change, annotate or implement anything in this class!
 */
class TextBoxRenderer
{
	/**
	 * Whether the content was changed (so the rendered text box needs a refresh).
	 */
	public boolean contentChanged = false;

	/**
	 * Whether an exception occured (which should be represented in the rendered text box).
	 */
	public boolean showError = false;
}
