package com.knoldus

import java.lang

import org.apache.spark.sql.{Dataset, SparkSession}

object DemoSession extends App {
//  def main(args: Array[String]): Unit = {
//
//
//    val sparky: SparkSession = SparkSession.builder()
//      .appName("spark-demo")
//      .master("local")
//      .config("spark.executor.instances", "2")
//      .getOrCreate()
//
//    val data1: Dataset[lang.Long] = sparky.range(0, 10)
//    data1.show()
//  }
  def addition(a: Int,b: Int) = a + b

}


