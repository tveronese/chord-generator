package br.com.chordgenerator.generator.notation.ffs;

import java.util.ArrayList;
import java.util.List;

import br.com.chordgenerator.generator.Chord;
import br.com.chordgenerator.generator.notation.PositionalNotation;

public class FFSNotation extends PositionalNotation {

	private List<FingerFretString> positions;

	public FFSNotation(Chord chord) {

		super(chord);
		this.positions = new ArrayList<>();
	}

	public List<FingerFretString> getPositions() {

		return positions;
	}

	public void setPositions(List<FingerFretString> positions) {

		this.positions = positions;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		for (FingerFretString ffs : getPositions()) {
			sb.append(ffs + "\n");
		}

		return sb.toString();
	}

}
