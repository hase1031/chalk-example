package com.hase1031.text

import chalk.text.segment.JavaSentenceSegmenter
import java.util.Locale
import chalk.text.tokenize._
import chalk.text.tokenize.RegexSearchTokenizer
import chalk.text.tokenize.RegexSplitTokenizer
import chalk.text.analyze.{PorterStemmer, EnglishWordClassGenerator}
import chalk.text.transform.MinimumLengthFilter

class TextExample {
  def apply = {
    //segment
    val englishSegmenter = new JavaSentenceSegmenter(Locale.ENGLISH).apply("Hello, World. I'm Takayuki Hasegawa")
    for (sentence <- englishSegmenter) {
      println(sentence)
    }
    println("--")

    val japaneseSegmenter = new JavaSentenceSegmenter(Locale.JAPANESE).apply("こんにちわ。私の名前は長谷川です。")
    for (sentence <- japaneseSegmenter) {
      println(sentence)
    }
    println("--")

    //tokenize
    val englishTokenizer = new JavaWordTokenizer(Locale.ENGLISH).apply("Hello, World. I'm Takayuki Hasegawa")
    for (sentence <- englishTokenizer) {
      println(sentence)
    }
    println("--")

    val japaneseTokenizer = new JavaWordTokenizer(Locale.JAPANESE).apply("こんにちわ。私の名前は長谷川です。")
    for (sentence <- japaneseTokenizer) {
      println(sentence)
    }
    println("--")

    val regex = RegexSearchTokenizer(" (.*) ")("Hello, World. I'm Takayuki Hasegawa")
    for (r <- regex) {
      println(r)
    }
    println("--")

    val split = RegexSplitTokenizer(" (.*) ")("Hello, World. I'm Takayuki Hasegawa")
    for (s <- split) {
      println(s)
    }
    println("--")

    val tokenizerV0 = new SimpleEnglishTokenizer.V0
    for (t <- tokenizerV0.apply("Hello, World. I'm Takayuki Hasegawa")) {
      println(t)
    }
    println("--")

    val tokenizerV1 = new SimpleEnglishTokenizer.V1
    for (t <- tokenizerV1.apply("Hello, World. I'm Takayuki Hasegawa")) {
      println(t)
    }
    println("--")

    val white = WhitespaceTokenizer("Hello, World. I'm Takayuki Hasegawa")
    for (w <- white) {
      println(w)
    }
    println("--")

    //analyze
    val generator = EnglishWordClassGenerator("studied")
    println(generator)
    println("--")

    val stemmer = PorterStemmer("university")
    println(stemmer)
    println("--")

    //transform
    val minimum = MinimumLengthFilter(4)(new JavaWordTokenizer(Locale.ENGLISH).apply("Hello, World. I'm Takayuki Hasegawa"))
    for (m <- minimum) {
      println(m)
    }
    println("--")
  }
}
