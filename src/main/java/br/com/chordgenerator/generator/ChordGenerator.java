package br.com.chordgenerator.generator;

import static java.lang.String.format;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.chordgenerator.generator.chords.*;
import br.com.chordgenerator.generator.exception.ChordGenerationException;
import br.com.chordgenerator.generator.instruments.Instrument;
import br.com.chordgenerator.generator.notation.PositionalNotation;

import com.google.common.base.Preconditions;

public abstract class ChordGenerator<I extends Instrument> {

    private static final Pattern NOTE_PATTERN = Pattern.compile("([A-G][#,b]?)(m?)");

    private static final String MINOR_CHORD_MODIFIER = "m";

    I instrument;

    public ChordGenerator(I instrument) {

        this.instrument = instrument;
    }

    public Chord generateChord(String chordString) throws ChordGenerationException {

        Matcher matcher = NOTE_PATTERN.matcher(chordString);
        if (!matcher.matches()) {
            throw new ChordGenerationException(format("No chord generator implemented for: %s.", chordString));
        }

        Note root = Note.getNoteFromRepresentation(matcher.group(1));
        Preconditions.checkArgument(root != null, "Note not found for representation: %s.", matcher.group(1));

        String modifiers = matcher.group(2);

        if (modifiers == null || modifiers.isEmpty()) {
            return new MajorChord(root);
        }

        if (modifiers.equals(MINOR_CHORD_MODIFIER)) {
            return new MinorChord(root);
        }

        throw new ChordGenerationException(
                format("Chord generator NYI for: Note = %s; Modifiers = %s.", root.name(), modifiers));
    }

    public Set<PositionalNotation> generateAllPositionalNotations(String chordString) throws ChordGenerationException {

        return this.generateAllPositionalNotations(this.generateChord(chordString));
    }

    protected abstract Set<PositionalNotation> generateAllPositionalNotations(Chord chord);

}
