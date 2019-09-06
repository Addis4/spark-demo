package com.knoldus

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

object testing {
  object StreamingFiles extends App {

    Logger.getLogger("org").setLevel(Level.OFF)

    val conf = new SparkConf().setMaster("local[2]").setAppName("StreamingFiles")
    val ssc = new SparkContext(conf)
    val read = ssc.textFile("build.sbt")
    read.first()

  }

}
