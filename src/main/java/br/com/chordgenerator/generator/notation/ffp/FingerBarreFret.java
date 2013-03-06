package br.com.chordgenerator.generator.notation.ffp;

import java.util.ArrayList;
import java.util.List;

public class FingerBarreFret extends FingerFretPosition {

	private List<FingerFretString> replaced;

	public FingerBarreFret(Integer finger, Integer fret) {

		super(finger, fret);
		this.replaced = new ArrayList<FingerFretString>();
	}

	@Override
	public String toString() {

		return String.format("Finger: %d; Barre fret: %d", getFinger(), getFret());
	}

	public List<FingerFretString> getReplaced() {

		return replaced;
	}

	public void addReplacedFret(FingerFretString ffs) {

		this.replaced.add(ffs);
	}

}
