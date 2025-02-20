package dat102.stud.hvl.no;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Parentestester {

	@Test
	public void testGyldigParentes() {
		assertTrue(ParantesSjekker.sjekkParanteser("{[()]}"));
	}

	@Test
	public void testUGyldigParentes() {
		assertFalse(ParantesSjekker.sjekkParanteser("{[(])}"));
	}

	@Test
	public void testTomString() {
		assertTrue(ParantesSjekker.sjekkParanteser(""));
	}

	@Test
	public void testStartParantes() {
		assertFalse(ParantesSjekker.sjekkParanteser("{[("));
	}

	@Test
	public void testSluttParantes() {
		assertFalse(ParantesSjekker.sjekkParanteser(")]}"));
	}

}
