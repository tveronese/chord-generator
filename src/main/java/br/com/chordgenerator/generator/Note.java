package br.com.chordgenerator.generator;

public enum Note {

	C("C"),

	C_sharp("C#"),

	D("D"),

	D_sharp("D#"),

	E("E"),

	F("F"),

	F_sharp("F#"),

	G("G"),

	G_sharp("G#"),

	A("A"),

	A_sharp("A#"),

	B("B");

	private String representation;

	private Note(String representation) {

		this.representation = representation;
	}

	public String getRepresentation() {

		return representation;
	}

	public Note getRespectiveNote(int semitonesOffset) {

		Note[] values = Note.values();
		int newNotePosition = (this.ordinal() + semitonesOffset) % values.length;
		return values[newNotePosition];
	}
}
