package br.com.chordgenerator.facade;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.chordgenerator.generator.Note;
import br.com.chordgenerator.generator.chords.Chord;
import br.com.chordgenerator.generator.chords.MajorChord;
import br.com.chordgenerator.generator.exception.ChordGenerationException;
import br.com.chordgenerator.generator.instruments.StringInstrument;
import br.com.chordgenerator.generator.notation.PositionalNotation;
import br.com.chordgenerator.generator.notation.ffs.FFSNotation;
import br.com.chordgenerator.generator.notation.ffs.Finger;
import br.com.chordgenerator.generator.notation.ffs.FingerFretString;

public class ChordGeneratorFacadeTest {

	@Test
	public void testGenerateChordA() throws ChordGenerationException {

		// A
		// Build model positional notation
		List<FingerFretString> positions = new ArrayList<FingerFretString>();
		positions.add(new FingerFretString(Finger.ONE, 2, 1));
		positions.add(new FingerFretString(Finger.ONE, 2, 2));
		positions.add(new FingerFretString(Finger.ONE, 2, 3));

		Chord chord = new MajorChord(Note.A);
		FFSNotation modelPn = new FFSNotation(chord);
		modelPn.setPositions(positions);

		// Call application method for positional notation generation
		PositionalNotation pn = ChordGeneratorFacade.generateChordPositionalNotation(new StringInstrument(), "A");

		assertEquals(modelPn, pn);
	}

	@Test
	public void testGenerateChordC() throws ChordGenerationException {

		// C
		// Build model positional notation
		List<FingerFretString> positions = new ArrayList<FingerFretString>();
		positions.add(new FingerFretString(Finger.ONE, 1, 1));
		positions.add(new FingerFretString(Finger.ONE, 2, 3));
		positions.add(new FingerFretString(Finger.ONE, 3, 4));

		Chord chord = new MajorChord(Note.C);
		FFSNotation modelPn = new FFSNotation(chord);
		modelPn.setPositions(positions);

		// Call application method for positional notation generation
		PositionalNotation pn = ChordGeneratorFacade.generateChordPositionalNotation(new StringInstrument(), "C");

		assertEquals(modelPn, pn);
	}

	@Test
	public void testGenerateChordE() throws ChordGenerationException {

		// E
		// Build model positional notation
		List<FingerFretString> positions = new ArrayList<FingerFretString>();
		positions.add(new FingerFretString(Finger.ONE, 1, 2));
		positions.add(new FingerFretString(Finger.ONE, 2, 3));
		positions.add(new FingerFretString(Finger.ONE, 2, 4));

		Chord chord = new MajorChord(Note.E);
		FFSNotation modelPn = new FFSNotation(chord);
		modelPn.setPositions(positions);

		// Call application method for positional notation generation
		PositionalNotation pn = ChordGeneratorFacade.generateChordPositionalNotation(new StringInstrument(), "E");

		assertEquals(modelPn, pn);
	}

	@Test
	public void testGenerateChordAm() throws ChordGenerationException {

		// Am
		// Build model positional notation
		List<FingerFretString> positions = new ArrayList<FingerFretString>();
		positions.add(new FingerFretString(Finger.ONE, 1, 1));
		positions.add(new FingerFretString(Finger.ONE, 2, 2));
		positions.add(new FingerFretString(Finger.ONE, 2, 3));

		Chord chord = new MajorChord(Note.A);
		FFSNotation modelPn = new FFSNotation(chord);
		modelPn.setPositions(positions);

		// Call application method for positional notation generation
		PositionalNotation pn = ChordGeneratorFacade.generateChordPositionalNotation(new StringInstrument(), "Am");

		assertEquals(modelPn, pn);
	}

	@Test
	public void testGenerateChordEm() throws ChordGenerationException {

		// Em
		// Build model positional notation
		List<FingerFretString> positions = new ArrayList<FingerFretString>();
		positions.add(new FingerFretString(Finger.ONE, 2, 3));
		positions.add(new FingerFretString(Finger.ONE, 2, 4));

		Chord chord = new MajorChord(Note.A);
		FFSNotation modelPn = new FFSNotation(chord);
		modelPn.setPositions(positions);

		// Call application method for positional notation generation
		PositionalNotation pn = ChordGeneratorFacade.generateChordPositionalNotation(new StringInstrument(), "Em");

		assertEquals(modelPn, pn);
	}
}
