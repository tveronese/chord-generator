package br.com.chordgenerator.generator;

public enum Note {

	C("C", null),

	C_sharp("C#", "Db"),

	D("D", null),

	D_sharp("D#", "Eb"),

	E("E", "Fb"),

	F("F", null),

	F_sharp("F#", "Gb"),

	G("G", null),

	G_sharp("G#", "Ab"),

	A("A", null),

	A_sharp("A#", "Bb"),

	B("B", "Cb");

	private String representation;

	private String alternateRepresentation;

	private Note(String representation, String alternateRepresentation) {

		this.representation = representation;
		this.alternateRepresentation = alternateRepresentation;
	}

	public String getRepresentation() {

		return representation;
	}

	public String getAlternateRepresentation() {

		return alternateRepresentation;
	}

	public Note getRespectiveNote(int semitonesOffset) {

		Note[] values = Note.values();
		int newNotePosition = (this.ordinal() + semitonesOffset) % values.length;
		return values[newNotePosition];
	}

	public static Note getNoteFromRepresentation(String representation) {

		for (Note note : Note.values()) {
			if (note.getRepresentation().equals(representation)) {
				return note;
			}
			else if (note.getAlternateRepresentation() != null
					&& note.getAlternateRepresentation().equals(representation)) {
				return note;
			}
		}

		return null;
	}
}
