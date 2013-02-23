package br.com.chordgenerator.facade;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.chordgenerator.generator.Note;
import br.com.chordgenerator.generator.chords.Chord;
import br.com.chordgenerator.generator.chords.MajorChord;
import br.com.chordgenerator.generator.instruments.AcousticGuitar;
import br.com.chordgenerator.generator.notation.ffs.FFSNotation;
import br.com.chordgenerator.generator.notation.ffs.Finger;
import br.com.chordgenerator.generator.notation.ffs.FingerFretString;

public class ChordGeneratorFacadeTest {

	@Test
	public void testGenerateChordA() {

		// A
		// Build model positional notation
		List<FingerFretString> positions = new ArrayList<>();
		positions.add(new FingerFretString(Finger.ONE, 2, 1));
		positions.add(new FingerFretString(Finger.ONE, 2, 2));
		positions.add(new FingerFretString(Finger.ONE, 2, 3));

		Chord chord = new MajorChord(Note.A);
		FFSNotation modelPn = new FFSNotation(chord);
		modelPn.setPositions(positions);

		// Call application method for positional notation generation
		FFSNotation pn = ChordGeneratorFacade.generateChordPositionalNotation(new AcousticGuitar(), "A");

		assertEquals(modelPn, pn);
	}

	@Test
	public void testGenerateChordC() {

		// C
		// Build model positional notation
		List<FingerFretString> positions = new ArrayList<>();
		positions.add(new FingerFretString(Finger.ONE, 1, 1));
		positions.add(new FingerFretString(Finger.ONE, 2, 3));
		positions.add(new FingerFretString(Finger.ONE, 3, 4));

		Chord chord = new MajorChord(Note.C);
		FFSNotation modelPn = new FFSNotation(chord);
		modelPn.setPositions(positions);

		// Call application method for positional notation generation
		FFSNotation pn = ChordGeneratorFacade.generateChordPositionalNotation(new AcousticGuitar(), "C");

		assertEquals(modelPn, pn);
	}

	@Test
	public void testGenerateChordE() {

		// E
		// Build model positional notation
		List<FingerFretString> positions = new ArrayList<>();
		positions.add(new FingerFretString(Finger.ONE, 1, 2));
		positions.add(new FingerFretString(Finger.ONE, 2, 3));
		positions.add(new FingerFretString(Finger.ONE, 2, 4));

		Chord chord = new MajorChord(Note.E);
		FFSNotation modelPn = new FFSNotation(chord);
		modelPn.setPositions(positions);

		// Call application method for positional notation generation
		FFSNotation pn = ChordGeneratorFacade.generateChordPositionalNotation(new AcousticGuitar(), "E");

		assertEquals(modelPn, pn);
	}

	@Test
	public void testGenerateChordAm() {

		// Am
		// Build model positional notation
		List<FingerFretString> positions = new ArrayList<>();
		positions.add(new FingerFretString(Finger.ONE, 1, 1));
		positions.add(new FingerFretString(Finger.ONE, 2, 2));
		positions.add(new FingerFretString(Finger.ONE, 2, 3));

		Chord chord = new MajorChord(Note.A);
		FFSNotation modelPn = new FFSNotation(chord);
		modelPn.setPositions(positions);

		// Call application method for positional notation generation
		FFSNotation pn = ChordGeneratorFacade.generateChordPositionalNotation(new AcousticGuitar(), "Am");

		assertEquals(modelPn, pn);
	}

	@Test
	public void testGenerateChordEm() {

		// Em
		// Build model positional notation
		List<FingerFretString> positions = new ArrayList<>();
		positions.add(new FingerFretString(Finger.ONE, 2, 3));
		positions.add(new FingerFretString(Finger.ONE, 2, 4));

		Chord chord = new MajorChord(Note.A);
		FFSNotation modelPn = new FFSNotation(chord);
		modelPn.setPositions(positions);

		// Call application method for positional notation generation
		FFSNotation pn = ChordGeneratorFacade.generateChordPositionalNotation(new AcousticGuitar(), "Em");

		assertEquals(modelPn, pn);
	}
}
