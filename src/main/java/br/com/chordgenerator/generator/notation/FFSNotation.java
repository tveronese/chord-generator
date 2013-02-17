package br.com.chordgenerator.generator.notation;

import java.util.ArrayList;
import java.util.List;

public class FFSNotation {

	private List<FingerFretString> positions;

	public FFSNotation() {

		this.positions = new ArrayList<>();
	}

	public List<FingerFretString> getPositions() {

		return positions;
	}

	public void setPositions(List<FingerFretString> positions) {

		this.positions = positions;
	}

}
