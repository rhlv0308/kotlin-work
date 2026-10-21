// COMP2850 Portfolio: Week 3
// Tests for median()

import io.kotest.core.spec.style.FreeSpec
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.matchers.floats.plusOrMinus

const val tolerance = 0.000001f

@Suppress("Unused")
class MedianTest : FreeSpec({
    "Exception when size=0" {
        shouldThrow<IllegalArgumentException> {
            median(listOf())
        }
    }
    "Median of one input" {
        median(listOf(2.0f)) shouldBe (2.0f plusOrMinus tolerance)                         // the simplest one check calculation
    }

    "Median of two inputs" {
        median(listOf(2.0f,-5.0f)) shouldBe (-1.5f plusOrMinus tolerance)                  // check how to deal with negative inputs and negative result
    }

    "Median of three inputs" {
        median(listOf(61.0f,3.0f,31.0f)) shouldBe (31.0f plusOrMinus tolerance)              // check if code used sorted() and odd number of inputs
    }

    "Median of four inputs" {
        median(listOf(12.0f,4.0f,8.0f,7.0f)) shouldBe (7.5f plusOrMinus tolerance)             // check how deal with even number of inputs
    }

    // Write four more tests here
})
