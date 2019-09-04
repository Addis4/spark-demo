package com.knoldus

import org.scalatest.FlatSpec

class DemoSessionSpec extends FlatSpec{
  "addition" should "return sum of nos." in {
    assert(DemoSession.addition(3, 4) == 7)
  }
   it should "throws an exception" in {
    assertThrows[Exception] {
      DemoSession.addition(2,4) == 6
    }
  }
  //assert(DemoSession.addition(2,5)== 3,"It should not happen")

}
