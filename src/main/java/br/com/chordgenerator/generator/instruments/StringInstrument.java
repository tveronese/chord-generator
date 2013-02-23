package br.com.chordgenerator.generator.instruments;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.apache.batik.dom.svg.SAXSVGDocumentFactory;
import org.apache.batik.dom.svg.SVGDOMImplementation;
import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.util.XMLResourceDescriptor;
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;

import br.com.chordgenerator.generator.Note;
import br.com.chordgenerator.generator.chords.Chord;
import br.com.chordgenerator.generator.notation.PositionalNotation;
import br.com.chordgenerator.generator.notation.ffs.FFSNotation;
import br.com.chordgenerator.generator.notation.ffs.Finger;
import br.com.chordgenerator.generator.notation.ffs.FingerFretString;
import br.com.chordgenerator.logger.Logger;

public class StringInstrument implements Instrument {

	private List<Note> pitches;

	public StringInstrument() {

		this.pitches = new ArrayList<>();
		this.pitches.add(Note.E);
		this.pitches.add(Note.B);
		this.pitches.add(Note.G);
		this.pitches.add(Note.D);
		this.pitches.add(Note.A);
		this.pitches.add(Note.E);
	}

	@Override
	public String getType() {

		// TODO use an Enum...
		return "string";
	}

	@Override
	public PositionalNotation generatePositionalNotation(Chord chord) {

		List<FingerFretString> positions = new ArrayList<>();

		for (int string = 0; string < this.pitches.size(); string++) {

			Integer fret = getFretWithNote(string, chord.getNotes());

			if (fret != 0) {

				FingerFretString ffs = new FingerFretString();
				ffs.setFret(fret);
				ffs.setString(string);
				// TODO implement finger attribution algorithm
				ffs.setFinger(Finger.ONE);

				positions.add(ffs);
			}
		}

		FFSNotation ffsn = new FFSNotation(chord);
		ffsn.setPositions(positions);
		return ffsn;
	}

	private Integer getFretWithNote(Integer stringNumber, List<Note> notes) {

		Note currentNote = this.pitches.get(stringNumber);
		Integer fret = 0;

		while (!notes.contains(currentNote)) {

			currentNote = currentNote.getRespectiveNote(1);
			fret++;
		}

		return fret;
	}

	@Override
	public void generatePositionalNotationImage(PositionalNotation pn) {

		if (pn == null || pn.getClass() != FFSNotation.class) {
			return;
		}

		// Create class to handle SVG file operations (read, write, draw,...)
		SVGDocument svgDoc = readFretsSVGFile();
		if (svgDoc == null) {
			Logger.debug(this, "SVG file could not be read.");
			return;
		}

		FFSNotation ffsn = (FFSNotation) pn;
		List<FingerFretString> positions = ffsn.getPositions();
		for (FingerFretString ffs : positions) {
			drawFFSCircle(svgDoc, ffs);
		}

		showSVGDocumentOnCanvas(svgDoc);
	}

	private void drawFFSCircle(SVGDocument svgDoc, FingerFretString ffs) {

		Integer string = ffs.getString(); // X
		Integer fret = ffs.getFret() - 1; // Y

		Integer centerX = 40 + (5 - string) * 24; // initial: 40px inc: 24px last: 160px
		Integer centerY = 45 + fret * 40; // initial: 45px inc: 40px
		// Create the circle
		Element circle = svgDoc.createElementNS(SVGDOMImplementation.SVG_NAMESPACE_URI, "circle");
		circle.setAttributeNS(null, "cx", centerX.toString());
		circle.setAttributeNS(null, "cy", centerY.toString());
		circle.setAttributeNS(null, "r", "8");
		circle.setAttributeNS(null, "fill", "black");

		// Attach the circle to the root 'svg' element
		svgDoc.getDocumentElement().appendChild(circle);
	}

	private void showSVGDocumentOnCanvas(SVGDocument svgDoc) {

		JSVGCanvas canvas = new JSVGCanvas();
		canvas.setDocument(svgDoc);
		canvas.setSize(200, 200);

		JFrame frame = new JFrame("Frets");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(canvas);
		frame.setSize(200, 200);
		frame.setVisible(true);
	}

	private SVGDocument readFretsSVGFile() {

		String parser = XMLResourceDescriptor.getXMLParserClassName();
		SAXSVGDocumentFactory f = new SAXSVGDocumentFactory(parser);
		URL uri = getClass().getResource("/images/string-instrument-frets.svg");
		SVGDocument svgDoc = null;
		try {
			svgDoc = f.createSVGDocument(uri.toString());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return svgDoc;
	}
}
