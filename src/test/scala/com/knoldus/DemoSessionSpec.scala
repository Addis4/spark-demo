package com.knoldus

import org.scalatest.FlatSpec

class DemoSessionSpec extends FlatSpec{
  "addition" should "return sum of nos." in {
    assert(DemoSession.addition(3, 4) == 7)
  }
}
