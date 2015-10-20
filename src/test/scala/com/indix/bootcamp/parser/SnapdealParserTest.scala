package com.indix.bootcamp.parser

import com.indix.bootcamp.utils.TestUtils
import org.scalatest.{FunSuite, Matchers}

class SnapdealParserTest extends FunSuite with Matchers with TestUtils {

  test("should parse product page") {
    val document = readDocument("/snapdeal/snapdeal_1.html")
    val parser = new SnapdealParser
    val parsedProduct = parser.parseProduct(document, "http://www.snapdeal.com/product/samsung-40hu7000-40-inches-4k/1502724382#bcrumbLabelId:64")
    parsedProduct.name should be("Samsung 40HU7000 101.6 cm (40) 4K Smart (Ultra HD) LED Television")
    parsedProduct.description should include("TV Unit, Remote, User Manual, Warranty Card, Power Cable, Battery for Remote, Samsung Smart Touch Control (Included), IR Extender Cable (Included)")
  }

  test("should parse prices from product page") {
    val document = readDocument("/snapdeal/snapdeal_1.html")
    val parser = new SnapdealParser
    val parsedPrice = parser.parsePrice(document)
    parsedPrice.listPrice should be(89900.0)
    parsedPrice.salePrice should be(69885.0)
  }
}
