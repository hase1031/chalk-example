package com.hase1031.topics

import chalk.topics.LDA
import java.io.File

class TopicsExample {

  def apply = {
    LDA.main(Array("--dir", getClass().getClassLoader().getResource("").getPath() + "com/hase1031/data/topics"))
//    val lda = LDA.Params(new File("com/hase1031/topics/training.txt"), 5)
//    println(lda)
  }
}
