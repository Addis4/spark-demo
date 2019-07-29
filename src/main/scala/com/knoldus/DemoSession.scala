package com.knoldus

import java.lang

import org.apache.spark.sql.{Dataset, SparkSession}

object DemoSession {
  def main(args: Array[String]): Unit = {

  }
  println("hhhh")

  val sparky: SparkSession = SparkSession.builder()
    .appName("spark-demo")
    .master("local")
    .config("spark.executor.instances","2")
    .getOrCreate()

  val data1: Dataset[lang.Long] = sparky.range(0,10)
  data1.show()


}
