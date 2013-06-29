package br.com.chordgenerator.generator;

public enum Note {

    C("C", null),

    C_SHARP("C#", "Db"),

    D("D", null),

    D_SHARP("D#", "Eb"),

    E("E", "Fb"),

    F("F", null),

    F_SHARP("F#", "Gb"),

    G("G", null),

    G_SHARP("G#", "Ab"),

    A("A", null),

    A_SHARP("A#", "Bb"),

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

    public int getSemitonesOffset(Note other) {

        if (this == other) {
            return 0;
        }

        int offset = other.ordinal() - this.ordinal();
        if (offset < 0) {
            offset += Note.values().length;
        }

        return offset;
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
