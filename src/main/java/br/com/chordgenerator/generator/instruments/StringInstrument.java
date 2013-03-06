package br.com.chordgenerator.generator.instruments;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.chordgenerator.generator.Note;
import br.com.chordgenerator.generator.chords.Chord;
import br.com.chordgenerator.generator.notation.PositionalNotation;
import br.com.chordgenerator.generator.notation.ffp.FFSNotation;
import br.com.chordgenerator.generator.notation.ffp.FingerBarreFret;
import br.com.chordgenerator.generator.notation.ffp.FingerFretPosition;
import br.com.chordgenerator.generator.notation.ffp.FingerFretString;
import br.com.chordgenerator.logger.Logger;

public class StringInstrument implements Instrument {

	private List<Note> pitches;

	public StringInstrument() {

		this.pitches = new ArrayList<Note>();
		this.pitches.add(Note.E);
		this.pitches.add(Note.B);
		this.pitches.add(Note.G);
		this.pitches.add(Note.D);
		this.pitches.add(Note.A);
		this.pitches.add(Note.E);
	}

	@Override
	public PositionalNotation generatePositionalNotation(Chord chord) {

		List<FingerFretPosition> positions = new ArrayList<FingerFretPosition>();

		for (int string = 0; string < this.pitches.size(); string++) {

			Integer fret = getFretWithNote(0, string, chord.getNotes());

			FingerFretString ffs = new FingerFretString();
			ffs.setFret(fret);
			ffs.setString(string);
			// TODO implement finger attribution algorithm
			ffs.setFinger(1);

			positions.add(ffs);
		}

		replacePositionsWithBarreIfNeeded(positions, chord.getNotes());

		FFSNotation ffsn = new FFSNotation(chord);
		ffsn.setPositions(positions);
		return ffsn;
	}

	private Integer getFretWithNote(Integer initialFret, Integer stringNumber, List<Note> notes) {

		Note currentNote = this.pitches.get(stringNumber);
		currentNote = currentNote.getRespectiveNote(initialFret);

		while (!notes.contains(currentNote)) {

			currentNote = currentNote.getRespectiveNote(1);
			initialFret++;
		}

		return initialFret;
	}

	private void replacePositionsWithBarreIfNeeded(List<FingerFretPosition> positions, List<Note> notes) {

		int fingers = 0;
		for (FingerFretPosition ffp : positions) {

			Integer fret = ffp.getFret();
			if (fret != 0) {
				fingers++;
			}
		}

		// TODO need a better way to detect barre need
		if (fingers < 4) {
			return;
		}

		Integer barreFret = positions.get(0).getFret();
		Integer lastStringFret = positions.get(this.pitches.size() - 1).getFret();
		if (!barreFret.equals(lastStringFret)) {
			Logger.warn(this, "Barred fret with fret not defined from initial search?");
			return;
		}

		FingerBarreFret barre = new FingerBarreFret(1, barreFret);
		for (Iterator<FingerFretPosition> iterator = positions.iterator(); iterator.hasNext();) {

			FingerFretPosition ffp = iterator.next();

			if (!(ffp instanceof FingerFretString)) {
				Logger.warn(this, "Found instance different from FingerFretString while building barre fret.");
				continue;
			}

			FingerFretString ffs = (FingerFretString) ffp;
			if (ffs.getFret() < barreFret) {
				ffs.setFret(getFretWithNote(barreFret, ffs.getString(), notes));
			}

			if (ffs.getFret().equals(barreFret)) {
				barre.addReplacedFret(ffs);
				iterator.remove();
			}
		}

		positions.add(0, barre);
	}

}
