package br.com.chordgenerator.generator.notation.nk;

import br.com.chordgenerator.generator.Note;

public class KeyNumberAndNote implements Comparable<KeyNumberAndNote> {

    private Integer keyNumber;

    private Note note;

    public KeyNumberAndNote(Integer keyNumber, Note note) {

        this.keyNumber = keyNumber;
        this.note = note;
    }

    public Integer getKeyNumber() {

        return keyNumber;
    }

    public Note getNote() {

        return note;
    }

    @Override
    public String toString() {

        return String.format("Key number: %d; Note: %s.", this.keyNumber, this.getNote().name());
    }

    @Override
    public int compareTo(KeyNumberAndNote o) {

        return this.getKeyNumber() - o.getKeyNumber();
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + ((keyNumber == null) ? 0 : keyNumber.hashCode());
        result = prime * result + ((note == null) ? 0 : note.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof KeyNumberAndNote)) {
            return false;
        }
        KeyNumberAndNote other = (KeyNumberAndNote) obj;
        if (keyNumber == null) {
            if (other.keyNumber != null) {
                return false;
            }
        }
        else if (!keyNumber.equals(other.keyNumber)) {
            return false;
        }
        if (note != other.note) {
            return false;
        }
        return true;
    }

}
