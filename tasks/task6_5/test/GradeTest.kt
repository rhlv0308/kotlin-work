// Task 6.5: unit tests for grade()

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.withClue
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe


@Suppress("unused")
class GradeTest : FreeSpec({
    // Write your tests in here
    "Mark between 0 and 39 gives a Fail" {
        assertSoftly {
            withClue("Mark=0") { grade(0) shouldBe "Fail" }
            withClue("Mark=20") { grade(20) shouldBe "Fail" }
            withClue("Mark=39") { grade(39) shouldBe "Fail" }
        }
    }
    "Mark between 40 and 69 gives a Pass" {
        assertSoftly {
            withClue("Mark=40") { grade(40) shouldBe "Pass" }
            withClue("Mark=50") { grade(50) shouldBe "Pass" }
            withClue("Mark=69") { grade(69) shouldBe "Pass" }
        }
    }
    "Mark between 70 and 100 gives a Distinction" {
        
            withClue("Mark=70") { grade(70) shouldBe "Distinction" }
            withClue("Mark=85") { grade(85) shouldBe "Distinction" }
            withClue("Mark=100") { grade(100) shouldBe "Distinction" }
        
    }
    "Mark lower than 0 gives a ?" {
        assertSoftly {
            withClue("Mark=-1") { grade(-1) shouldBe "?" }
            withClue("Mark=-100") { grade(-100) shouldBe "?" }
        }
    }
    "Mark over 100 gives a ?" {
        assertSoftly {
            withClue("Mark=101") { grade(101) shouldBe "?" }
            withClue("Mark=200") { grade(200) shouldBe "?" }
        }
    }




/*
    "Mark of -50 gives a ？" {
        grade(-50) shouldBe "?"
    }
    "Mark of -1 gives a ？" {
        grade(-1) shouldBe "?"
    }
    "Mark of 0 gives a Fail" {
        grade(0) shouldBe "Fail"
    }
    "Mark of 30 gives a Fail" {
        grade(30) shouldBe "Fail"
    }
    "Mark of 39 gives a Fail" {
        grade(39) shouldBe "Fail"
    }
    "Mark of 40 gives a Pass" {
        grade(40) shouldBe "Pass"
    }
    "Mark of 55 gives a Pass" {
        grade(55) shouldBe "Pass"
    }
    "Mark of 69 gives a Pass" {
        grade(69) shouldBe "Pass"
    }
    "Mark of 70 gives a Distinction "{
        grade(70) shouldBe "Distinction"
    }
    "Mark of 80 gives a Distinction "{
        grade(80) shouldBe "Distinction"
    }
    
    "Mark of 100 gives a Distinction" {
        grade(100) shouldBe "Distinction"
    }
    "Mark of 101 gives a ?" {
        grade(101) shouldBe "?"
    }
    "Mark of 200 gives a ?" {
        grade(200) shouldBe "?"
    }
    */
})
