package com.knoldus

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession


object DemoOne {

  def main(args: Array[String]) {

    Logger.getLogger("org").setLevel(Level.OFF)


    val spark = SparkSession.builder.appName("Simple Application").master("local").config("spark.executor.instances","2").getOrCreate()
    val logFile = "build.sbt" // Should be some file on your system
    val logData = spark.read.textFile(logFile).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println(s"Lines with a: $numAs,\n Lines with b: $numBs")
    spark.stop()

  }


}
