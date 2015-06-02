package prBinaryString;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Prueba1 {

	private BinaryString bitset1, bitset2, bitset3, bitset4, bitset5;
	private String pruebaString2 = "1010101010", pruebaString3 = "100101", pruebaString4 = "0110101", pruebaString5 = "1111000";
	
	//Para cada Test inicializamos antes su correspondiente bitset con su String asociado.
	@Before
	public void antesDelTest() {
		bitset1 = new BinaryString(10);
		bitset2 = new BinaryString(pruebaString2);	
		bitset3 = new BinaryString(pruebaString3);
		bitset4 = new BinaryString(pruebaString4);
		bitset5 = new BinaryString(pruebaString5);
	}
	
	//Comprobamos si al inicializar el bitset (con los dos contructores) el tamaño es el esperado.
	@Test
	public void testLength() {
		assertEquals(10, bitset1.length());
		assertEquals(10, bitset2.length());
	}
	
	//Comprobamos si al cambiar una posición del bitset a un '1' el cambio se hace efectivo. 
	@Test
	public void testSetBit() {
		bitset3.set(1,'1');
		assertEquals('1', bitset3.get(1));
	}
	//Comprobamos si al acceder fuera de los límites del array nos lanza una excepción tipo BinayStringException.  
	@Test(expected = BinaryStringException.class)
	public void testGetOutOfLimitBit()  {
		bitset4.get(56);
	}
	
	//Lo mismo que el apartado anterior pero esta vez utilizando el método set().
	@Test(expected = BinaryStringException.class)
	public void testSetOutOfLimitBit() {
		bitset4.set(56, '0');
	}
	
	//Lo mismo que el apartado anterior pero utiliznado un try-catch en el mismo método del test.
	@Test 
	public void testSetOutOfLimitBitV2() {
		try{
			bitset4.set(56, '0');
			fail("Se esperaba excepcion BinaryStringException");
		} catch (BinaryStringException e) {
			
		}
	}
}
