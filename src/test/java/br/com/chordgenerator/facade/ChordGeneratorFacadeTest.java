package br.com.chordgenerator.facade;

import org.junit.Test;

import br.com.chordgenerator.generator.exception.ChordGenerationException;

public class ChordGeneratorFacadeTest {

	@Test
	public void testGenerateChordA() throws ChordGenerationException {

		/*
		 * // A // Build model positional notation Set<FingerFretPosition> positions = new
		 * TreeSet<FingerFretPosition>(); positions.add(new FingerFretString(1, 2, 1));
		 * positions.add(new FingerFretString(1, 2, 2)); positions.add(new FingerFretString(1, 2,
		 * 3));
		 * 
		 * Chord chord = new MajorChord(Note.A); FFSNotation modelPn = new FFSNotation(chord);
		 * modelPn.setPositions(positions);
		 * 
		 * // Call application method for positional notation generation PositionalNotation pn =
		 * ChordGeneratorFacade.generateChordPositionalNotations(new StringInstrument(), "A");
		 * 
		 * assertEquals(modelPn, pn);
		 */
	}

	@Test
	public void testGenerateChordC() throws ChordGenerationException {

		/*
		 * // C // Build model positional notation Set<FingerFretPosition> positions = new
		 * TreeSet<FingerFretPosition>(); positions.add(new FingerFretString(1, 1, 1));
		 * positions.add(new FingerFretString(1, 2, 3)); positions.add(new FingerFretString(1, 3,
		 * 4));
		 * 
		 * Chord chord = new MajorChord(Note.C); FFSNotation modelPn = new FFSNotation(chord);
		 * modelPn.setPositions(positions);
		 * 
		 * // Call application method for positional notation generation PositionalNotation pn =
		 * ChordGeneratorFacade.generateChordPositionalNotations(new StringInstrument(), "C");
		 * 
		 * assertEquals(modelPn, pn);
		 */}

	@Test
	public void testGenerateChordE() throws ChordGenerationException {

		/*
		 * // E // Build model positional notation Set<FingerFretPosition> positions = new
		 * TreeSet<FingerFretPosition>(); positions.add(new FingerFretString(1, 1, 2));
		 * positions.add(new FingerFretString(1, 2, 3)); positions.add(new FingerFretString(1, 2,
		 * 4));
		 * 
		 * Chord chord = new MajorChord(Note.E); FFSNotation modelPn = new FFSNotation(chord);
		 * modelPn.setPositions(positions);
		 * 
		 * // Call application method for positional notation generation PositionalNotation pn =
		 * ChordGeneratorFacade.generateChordPositionalNotations(new StringInstrument(), "E");
		 * 
		 * assertEquals(modelPn, pn);
		 */}

	@Test
	public void testGenerateChordAm() throws ChordGenerationException {

		/*
		 * // Am // Build model positional notation Set<FingerFretPosition> positions = new
		 * TreeSet<FingerFretPosition>(); positions.add(new FingerFretString(1, 1, 1));
		 * positions.add(new FingerFretString(1, 2, 2)); positions.add(new FingerFretString(1, 2,
		 * 3));
		 * 
		 * Chord chord = new MajorChord(Note.A); FFSNotation modelPn = new FFSNotation(chord);
		 * modelPn.setPositions(positions);
		 * 
		 * // Call application method for positional notation generation PositionalNotation pn =
		 * ChordGeneratorFacade.generateChordPositionalNotations(new StringInstrument(), "Am");
		 * 
		 * assertEquals(modelPn, pn);
		 */}

	@Test
	public void testGenerateChordEm() throws ChordGenerationException {

		/*
		 * // Em // Build model positional notation Set<FingerFretPosition> positions = new
		 * TreeSet<FingerFretPosition>(); positions.add(new FingerFretString(1, 2, 3));
		 * positions.add(new FingerFretString(1, 2, 4));
		 * 
		 * Chord chord = new MajorChord(Note.A); FFSNotation modelPn = new FFSNotation(chord);
		 * modelPn.setPositions(positions);
		 * 
		 * // Call application method for positional notation generation PositionalNotation pn =
		 * ChordGeneratorFacade.generateChordPositionalNotations(new StringInstrument(), "Em");
		 * 
		 * assertEquals(modelPn, pn);
		 */}
}
