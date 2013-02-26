package br.com.chordgenerator.generator.notation.ffs;

public class FingerBarreFret extends FingerFretPosition {

	public FingerBarreFret(Integer finger, Integer fret) {

		super(finger, fret);
	}

	@Override
	public String toString() {

		return String.format("Finger: %d; Barre fret: %d", getFinger(), getFret());
	}

}
