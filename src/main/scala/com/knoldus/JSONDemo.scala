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


//    val schemaString: StructType = new StructType()
//      .add("id", IntegerType)
//      .add("firstname", StringType)
//
//    val ds: DataFrame = dataF
//      .select(from_json(col("value"), schemaString).as("data"))
//      .select("data.*").where("id > 2")
//
//    val test  = dataF
//    ds.show()
//    ds.printSchema()
    case class User(id: Int, firstname: String)
    implicit val userWrites: Writes[User] = new Writes[User] {
      def writes(user: User): JsValue = Json.obj(
        "id" -> user.id,
        "firstname" -> user.firstname
      )
    }
    val json: Enumeratee[User, JsValue] = Json.toJson(userWrites)

    val lat = (json \ "user" \ "id" ).get

//    case class User(id: Int, firstname: String)
//    implicit val userReads: Reads[User] = (
//      (JsPath \ "id").read[Int] and
//        (JsPath \ "firstname").read[String]
//      )(User.apply _)
//    val json = { }
//
//    val userResult: JsResult[User] = json.validate[User]


  }

}
