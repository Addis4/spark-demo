package com.knoldus
import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object StreamingFiles {

  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.OFF)

    val conf = new SparkConf().setMaster("local[2]").setAppName("StreamingFiles")
    val ssc = new StreamingContext(conf,Seconds(1))
    val read = ssc.textFileStream("readingFiles/ab.txt")
    read.print()
    ssc.start()
    ssc.awaitTermination()
  }

}
