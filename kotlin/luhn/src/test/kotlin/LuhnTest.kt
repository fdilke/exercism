import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LuhnTest {

    @Test
    fun withoutSpacesRemovesSpaces() {
        assertEquals("felix", Luhn.withoutSpaces(" f eli x "))
    }

    @Test(expected = IllegalArgumentException::class)
    fun digitsOfThrowsError() {
        Luhn.digitsOf("123x4")
    }

    @Test
    fun digitsOfCorrect() {
        assertEquals(listOf(1,4,9), Luhn.digitsOf("149"))
    }

    @Test
    fun doubleAlternateCorrect() {
        assertEquals(listOf(1,8,9), Luhn.doubleAlternates(listOf(1,4,9)))
    }

    @Test
    fun doubleAlternateCorrectFromRight() {
        assertEquals(listOf(2,4,4,3), Luhn.doubleAlternates(listOf(1,4,2,3)))
    }

    @Test
    fun doubleAlternateCorrectWithCarry() {
        assertEquals(listOf(1,7,4,9,0), Luhn.doubleAlternates(listOf(1,8,4,9,0)))
    }

    @Test
    fun singleDigitStringsCannotBeValid() {
        assertFalse(Luhn.isValid("1"))
    }

    @Test
    fun singleZeroIsInvalid() {
        assertFalse(Luhn.isValid("0"))
    }

    @Test
    fun simpleValidSINThatRemainsValidIfReversed() {
        assertTrue(Luhn.isValid("059"))
    }

    @Test
    fun simpleValidSINThatBecomesInvalidIfReversed() {
        assertTrue(Luhn.isValid("59"))
    }

    @Test
    fun validCanadianSIN() {
        assertTrue(Luhn.isValid("055 444 285"))
    }

    @Test
    fun invalidCanadianSIN() {
        assertFalse(Luhn.isValid("055 444 286"))
    }

    @Test
    fun invalidCreditCard() {
        assertFalse(Luhn.isValid("8273 1232 7352 0569"))
    }

    @Test
    fun validStringsWithNonDigitIncludedBecomeInvalid() {
        assertFalse(Luhn.isValid("055a 444 285"))
    }

    @Test
    fun validStringsWithPunctuationIncludedBecomeInvalid() {
        assertFalse(Luhn.isValid("055-444-285"))
    }

    @Test
    fun validStringsWithSymbolsIncludedBecomeInvalid() {
        assertFalse(Luhn.isValid("055£ 444$ 285"))
    }

    @Test
    fun singleZeroWithSpaceIsInvalid() {
        assertFalse(Luhn.isValid(" 0"))
    }

    @Test
    fun moreThanSingleZeroIsValid() {
        assertTrue(Luhn.isValid("0000 0"))
    }

    @Test
    fun inputDigit9IsCorrectlyConvertedToOutputDigit9() {
        assertTrue(Luhn.isValid("091"))
    }
}
