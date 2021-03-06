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
	
	//Comprobamos si al inicializar el bitset (con los dos contructores) el tama�o es el esperado.
	@Test
	public void testLength() {
		assertEquals(10, bitset1.length());
		assertEquals(10, bitset2.length());
	}
	
	//Comprobamos si al cambiar una posici�n del bitset a un '1' el cambio se hace efectivo. 
	@Test
	public void testSetBit() {
		bitset3.set(1,'1');
		assertEquals('1', bitset3.get(1));
	}
	//Comprobamos si al acceder fuera de los l�mites del array nos lanza una excepci�n tipo BinayStringException.  
	@Test(expected = BinaryStringException.class)
	public void testGetOutOfLimitBit()  {
		bitset4.get(56);
	}
	
	//Lo mismo que el apartado anterior pero esta vez utilizando el m�todo set().
	@Test(expected = BinaryStringException.class)
	public void testSetOutOfLimitBit() {
		bitset4.set(56, '0');
	}
	
	//Lo mismo que el apartado anterior pero utiliznado un try-catch en el mismo m�todo del test.
	@Test 
	public void testSetOutOfLimitBitV2() {
		try{
			bitset4.set(56, '0');
			fail("Se esperaba excepcion BinaryStringException");
		} catch (BinaryStringException e) {
			
		}
	}
	
	//Comprobamos si al intentar meter un char que no sea '1' o '0' lanza una excepci�n BinrayStringException.
	@Test (expected = BinaryStringException.class)
	public void tesInvalidBitValue() {
		bitset4.set(1, 'a');
	}
	
	//Comprobamos que al realizar toString el resultado es el esperado. 
	@Test
	public void testToString() {
		assertEquals(" 1111000", bitset5.toString());
	}
}
