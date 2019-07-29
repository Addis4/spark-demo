package com.knoldus

import org.apache.spark.{SparkConf, SparkContext}

object DemoOne {
  def main(args: Array[String]) {
    println("Something Atleast1")
    val conf = new SparkConf().setMaster("local").setAppName("SparkWordCount")
    println("Something Atleast2")
    val sc = new SparkContext(conf)
    println("Something Atleast3")
    val rdd1 = sc.makeRDD(Array(1,2,3,4,5,6,7))

    println("Something Atleast4")
    rdd1.collect().foreach(println)
    println("Something Atleast5")
    println("Something Atleast6")
  }


}
