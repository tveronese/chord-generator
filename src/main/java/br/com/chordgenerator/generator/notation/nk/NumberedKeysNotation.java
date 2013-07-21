package br.com.chordgenerator.generator.notation.nk;

import java.util.Set;
import java.util.TreeSet;

import br.com.chordgenerator.generator.chords.Chord;
import br.com.chordgenerator.generator.notation.PositionalNotation;

/**
 * Notation that uses numbered piano keys to represent a chord.
 * 
 * @author thiago
 */
public class NumberedKeysNotation extends PositionalNotation {

    private Set<KeyNumberAndNote> keys;

    public NumberedKeysNotation(Chord chord) {

        super(chord);
        this.keys = new TreeSet<KeyNumberAndNote>();
    }

    public Set<KeyNumberAndNote> getKeys() {

        return this.keys;
    }

    @Override
    public int compareTo(PositionalNotation o) {

        return 0;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + ((keys == null) ? 0 : keys.hashCode());
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
        if (!(obj instanceof NumberedKeysNotation)) {
            return false;
        }
        NumberedKeysNotation other = (NumberedKeysNotation) obj;
        if (keys == null) {
            if (other.keys != null) {
                return false;
            }
        }
        else if (!keys.equals(other.keys)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (KeyNumberAndNote knn : getKeys()) {
            sb.append(knn + "\n");
        }

        return sb.toString();
    }

}
