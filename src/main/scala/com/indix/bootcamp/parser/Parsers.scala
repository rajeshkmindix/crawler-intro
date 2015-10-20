package com.indix.bootcamp.parser

import com.indix.bootcamp.models.{Product, Price, Result}
import org.jsoup.nodes.Document

class FlipkartParser extends Parser {
  override def parseProduct(document: Document, pageUrl: String): Product = {
    val title = document.select("h1[itemprop=name]").text()
    val description = document.select(".productSpecs").text()
    Product(title, description, pageUrl)
  }

  override def parsePrice(document: Document): Price = {
    val listPrice = document.select(".prices .price").text()
    val salePrice = document.select(".selling-price").text()
    Price(getPrice(listPrice), getPrice(salePrice))
  }
}

class JabongParser extends Parser {
  override def parseProduct(document: Document, pageUrl: String): Product = {
    val title = document.select(".product-title").text()
    val description = document.select(".prod-disc").text()
    Product(title, description, pageUrl)
  }

  override def parsePrice(document: Document): Price = {
    val listPrice = document.select(".standard-price").text()
    val salePrice = document.select(".actual-price").text()
    Price(getPrice(listPrice), getPrice(salePrice))
  }
}

class SnapdealParser extends Parser {
  override def parseProduct(document: Document, pageUrl: String): Product = {
    val title = document.select("#productNamePDP").attr("value")
    val description = document.select("#infoBlk").text()
    Product(title, description, pageUrl)
  }

  override def parsePrice(document: Document): Price = {
    val listPrice = document.select("#productMrpForFbt").attr("value")
    val salePrice = document.select("#productSellingPrice").attr("value")
    Price(getPrice(listPrice), getPrice(salePrice))
  }
}
