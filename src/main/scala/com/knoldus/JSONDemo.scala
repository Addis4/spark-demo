package com.knoldus

import java.util.Base64.Encoder

import org.apache.spark.sql.functions._
import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.types._
import org.apache.spark.sql.{DataFrame, Dataset, Encoders, SparkSession}
import play.api.libs.functional.syntax._
import play.api.libs.iteratee.Enumeratee
import play.api.libs.json._
import play.api.libs.json._

import scala.util.parsing.json._

object JSONDemo {

  Logger.getLogger("org").setLevel(Level.OFF)

  def main(args: Array[String]): Unit = {

    val spark: SparkSession = SparkSession
      .builder()
      .appName("JSONDemo")
      .master("local")
      .getOrCreate()


    val dataF: Dataset[String] = spark.read.textFile("files/sampl.txt")

   dataF.printSchema()


    case class User(id: Int, firstname: String)
    implicit val userWrites: Writes[User] = new Writes[User] {
      def writes(user: User): JsValue = Json.obj(
        "id" -> user.id,
        "firstname" -> user.firstname
      )
    }
    val json: Enumeratee[User, JsValue] = Json.toJson(userWrites)

    val lat = (json \ "user" \ "id" ).get


  }

}
