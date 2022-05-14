import org.junit.Test

import org.junit.Assert.*

class ComissionCalcKtTest {

    @Test
    fun commissionCalcTestCalculateCorrectVKType() {
        val cardType = VKPAY
        val monthTransferSum = 0
        val transferSum = 10_000
        val expectedCommission = 0

        val actualCommission = commissionCalc(cardType, monthTransferSum, transferSum)

        assertEquals(/* expected = */ expectedCommission, /* actual = */ actualCommission)
    }

    @Test
    fun commissionCalcTestCalculateCorrectMIRTypeMinSum() {
        val cardType = MIR
        val monthTransferSum = 0
        val transferSum = 500_000
        val expectedCommission = 3750

        val actualCommission = commissionCalc(cardType, monthTransferSum, transferSum)

        assertEquals(/* expected = */ expectedCommission, /* actual = */ actualCommission)
    }

    @Test
    fun commissionCalcTestCalculateCorrectMIRTypePercent() {
        val cardType = MIR
        val monthTransferSum = 0
        val transferSum = 10_000
        val expectedCommission = 3500

        val actualCommission = commissionCalc(cardType, monthTransferSum, transferSum)

        assertEquals(/* expected = */ expectedCommission, /* actual = */ actualCommission)
    }

    @Test
    fun commissionCalcTestCalculateCorrectVisaTypeMinSum() {
        val cardType = VISA
        val monthTransferSum = 0
        val transferSum = 10_000
        val expectedCommission = 3_500

        val actualCommission = commissionCalc(cardType, monthTransferSum, transferSum)

        assertEquals(/* expected = */ expectedCommission, /* actual = */ actualCommission)
    }

    @Test
    fun commissionCalcTestCalculateCorrectVisaTypePercent() {
        val cardType = VISA
        val monthTransferSum = 0
        val transferSum = 1_000_000
        val expectedCommission = 7_500

        val actualCommission = commissionCalc(cardType, monthTransferSum, transferSum)

        assertEquals(/* expected = */ expectedCommission, /* actual = */ actualCommission)
    }

    @Test
    fun commissionCalcTestCalculateCorrectMaestroTypeMinSumOf() {
        val cardType = MAESTRO
        val monthTransferSum = 0
        val transferSum = 10_000
        val expectedCommission = 0

        val actualCommission = commissionCalc(cardType, monthTransferSum, transferSum)

        assertEquals(/* expected = */ expectedCommission, /* actual = */ actualCommission)
    }

    @Test
    fun commissionCalcTestCalculateCorrectMaestroTypeWithCommission() {
        val cardType = MAESTRO
        val monthTransferSum = 7_500_001
        val transferSum = 1_000_000
        val expectedCommission = 8_000

        val actualCommission = commissionCalc(cardType, monthTransferSum, transferSum)

        assertEquals(/* expected = */ expectedCommission, /* actual = */ actualCommission)
    }

    @Test
    fun commissionCalcTestCalculateCorrectMaestroTypeBigSumOfTransfer() {
        val cardType = MAESTRO
        val monthTransferSum = 7_500_000
        val transferSum = 10_000_000
        val expectedCommission = 62_000

        val actualCommission = commissionCalc(cardType, monthTransferSum, transferSum)

        assertEquals(/* expected = */ expectedCommission, /* actual = */ actualCommission)
    }

    @Test
    fun commissionCalcTestCalculateCorrectMastercardTypeMinSumOf() {
        val cardType = MASTERCARD
        val monthTransferSum = 0
        val transferSum = 17_000
        val expectedCommission = 0

        val actualCommission = commissionCalc(cardType, monthTransferSum, transferSum)

        assertEquals(/* expected = */ expectedCommission, /* actual = */ actualCommission)
    }

    @Test
    fun commissionCalcTestCalculateCorrectMastercardTypeWithCommission() {
        val cardType = MASTERCARD
        val monthTransferSum = 7_500_001
        val transferSum = 1_000_000
        val expectedCommission = 8_000

        val actualCommission = commissionCalc(cardType, monthTransferSum, transferSum)

        assertEquals(/* expected = */ expectedCommission, /* actual = */ actualCommission)
    }

    @Test
    fun commissionCalcTestCalculateCorrectMastercardTypeBigSumOfTransfer() {
        val cardType = MASTERCARD
        val monthTransferSum = 7_500_000
        val transferSum = 10_000_000
        val expectedCommission = 62_000

        val actualCommission = commissionCalc(cardType, monthTransferSum, transferSum)

        assertEquals(/* expected = */ expectedCommission, /* actual = */ actualCommission)
    }

    @Test
    fun commissionCalcTestCalculateCorrectTypeDefault() {
        val expectedCommission = 0

        val actualCommission = commissionCalc( monthTransferSum = 0, transferSum = 10_000)

        assertEquals(/* expected = */ expectedCommission, /* actual = */ actualCommission)
    }

    @Test
    fun commissionCalcTestCalculateCorrectTypeMasterCardSumDefault() {

        val expectedCommission = 0

        val actualCommission = commissionCalc(cardType=MASTERCARD, transferSum=17_000 )

        assertEquals(/* expected = */ expectedCommission, /* actual = */ actualCommission)

    }

    @Test
    fun commissionCalcTestCalculateCorrectTypeMaestroCardSumDefault() {

        val expectedCommission = 0

        val actualCommission = commissionCalc(cardType=MAESTRO, transferSum=17_000 )

        assertEquals(/* expected = */ expectedCommission, /* actual = */ actualCommission)

    }

    @Test
    fun commissionCalcTestCalculateCorrectTypeMaestroBigSumDefault() {

        val expectedCommission = 62_000

        val actualCommission = commissionCalc(cardType=MAESTRO, transferSum=10_000_000 )

        assertEquals(/* expected = */ expectedCommission, /* actual = */ actualCommission)

    }

    @Test
    fun commissionCalcTestCalculateCorrectTypeMastercardBigSumDefault() {

        val expectedCommission = 62_000

        val actualCommission = commissionCalc(cardType=MASTERCARD, transferSum=10_000_000 )

        assertEquals(/* expected = */ expectedCommission, /* actual = */ actualCommission)

    }
}