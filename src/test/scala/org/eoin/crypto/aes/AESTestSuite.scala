package org.eoin.crypto.aes

import org.junit.Test
import org.scalatest.Matchers._
import org.scalatest.junit.JUnitSuite
import org.scalatest.prop.GeneratorDrivenPropertyChecks

/**
  * Created by eoin.parker on 11/16/16.
  */
class AESTestSuite extends JUnitSuite with GeneratorDrivenPropertyChecks {

  @Test def basicTest1 : Unit = {

    forAll (minSuccessful(1000)) {(plaintext: Array[Byte]) =>
      val cipherText = AES.encrypt(plaintext)
      val roundTrip = AES.decrypt(plaintext)
      roundTrip shouldEqual plaintext  //TODO check array equality
      cipherText shouldNot equal(plaintext)
    }
  }
}
