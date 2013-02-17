package br.com.chordgenerator.generator;

public enum Note {

	/**
	 * C note representation.
	 */
	C("C"),

	/**
	 * C# note representation.
	 */
	C_sharp("C#"),

	/**
	 * D note representation.
	 */
	D("D"),

	/**
	 * D# note representation.
	 */
	D_sharp("D#"),

	/**
	 * E note representation.
	 */
	E("E"),

	/**
	 * F note representation.
	 */
	F("F"),

	/**
	 * F# note representation.
	 */
	F_sharp("F#"),

	/**
	 * G note representation.
	 */
	G("G"),

	/**
	 * G# note representation.
	 */
	G_sharp("G#"),

	/**
	 * A note representation.
	 */
	A("A"),

	/**
	 * A# note representation.
	 */
	A_sharp("A#"),

	/**
	 * B note representation.
	 */
	B("B");

	/**
	 * The note written representation.
	 */
	private String representation;

	private Note(String representation) {

		this.representation = representation;
	}

	public String getRepresentation() {

		return representation;
	}

	public Note getRespectiveNote(int halfToneOffset) {

		Note[] values = Note.values();
		int newNotePosition = (this.ordinal() + halfToneOffset) % values.length;
		return values[newNotePosition];
	}
}
