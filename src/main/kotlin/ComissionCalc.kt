const val monthLimitMastercardMaestro: Int = 7_500_000
const val commissionMin: Int = 3_500
const val commissionRateMastercard = 0.6
const val commissionRateVisaMir = 0.75
const val MASTERCARD = "Mastercard"
const val MAESTRO = "Maestro"
const val VISA = "VISA"
const val MIR = "MIR"
const val VKPAY = "VKPay"


fun main() {
    println(commissionCalc(VKPAY, 0, 10_000))
    println(commissionCalc(MIR, 0, 10_000_000))
    println(commissionCalc(VISA, 0, 10_000))
    println(commissionCalc(MASTERCARD, 7_500_001, 10_000))
    println(commissionCalc(MAESTRO, 7_400_000, 10_000))
    println(commissionCalc(MAESTRO, 0, 10_000_000))
}

fun commissionCalc(cardType: String = VKPAY, monthTransferSum: Int = 0, transferSum: Int): Int {

    return when (cardType) {
        MASTERCARD, MAESTRO -> {
            if (monthTransferSum > monthLimitMastercardMaestro || transferSum > monthLimitMastercardMaestro) {
                (transferSum * (commissionRateMastercard / 100) + 2_000).toInt()
            } else {
                0
            }
        }
        VISA, MIR -> {
            val preCommission = (transferSum * (commissionRateVisaMir / 100)).toInt()
            if (preCommission > commissionMin) {
                preCommission
            } else {
                commissionMin
            }
        }
        else -> {
            0
        }
    }
}


