package com.indix.bootcamp.parser

import com.indix.bootcamp.utils.TestUtils
import org.scalatest.{FunSuite, Matchers}

class JabongParserTest extends FunSuite with Matchers with TestUtils {

  test("should parse product page") {
    val document = readDocument("/jabong/jabong_1.html")
    val parser = new JabongParser
    val parsedProduct = parser.parseProduct(document, "http://www.jabong.com/Fossil-AM4514I-Brown-Cream-Analog-Watch-1655790.html?pos=10")
    parsedProduct.name should be("AM4514I Brown/Cream Analog Watch")
    parsedProduct.description should include("Complete your trendy look wearing this brown coloured watch from Fossil")
  }

  test("should parse prices from product page") {
    val document = readDocument("/jabong/jabong_1.html")
    val parser = new JabongParser
    val parsedPrice = parser.parsePrice(document)
    parsedPrice.listPrice should be(7495.0)
    parsedPrice.salePrice should be(3748.0)
  }
}
