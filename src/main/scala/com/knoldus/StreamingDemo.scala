package com.knoldus

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object StreamingDemo  {
  def main(args: Array[String]) {


    Logger.getLogger("org").setLevel(Level.OFF)

    // Create a local StreamingContext with two working thread and batch interval of 1 second.
    // The master requires 2 cores to prevent from a starvation scenario.

    val conf = new SparkConf().setMaster("local[4]").setAppName("StreamingDemo")
    val ssc = new StreamingContext(conf,Seconds(1))
    // Create a DStream that will connect to hostname:port, like localhost:9999
    val lines = ssc.socketTextStream("localhost", 9999)
    // val otherLine = ssc.fileStream[KeyClass, ValueClass, InputFormatClass](dataDirectory)
    // Split each line into words
    val words = lines.flatMap(_.split(" "))
    val pairs = words.map(word => (word, 1))
    val wordCounts = pairs.reduceByKey(_ + _)

    // Print the first ten elements of each RDD generated in this DStream to the console
    wordCounts.print()



    ssc.start() // Start the computation
    ssc.awaitTermination() // Wait for the computation to terminate

  }
}
