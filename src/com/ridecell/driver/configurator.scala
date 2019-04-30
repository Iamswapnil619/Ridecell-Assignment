package com.ridecell.driver
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col,count,window,unix_timestamp}

object configurator {
  def main(args: Array[String]): Unit = {
    println("Hello from main of class")
    //creating ssample data set

    val spark = SparkSession
      .builder
      .appName("Spark-Kafka-Integration")
      .master("local")
      .config("spark.testing.memory","2147480000")
      .getOrCreate

    val data = spark.read.option("header", "false").csv("C:/kafka/kafka-data/Input/ridecell-data1.txt")

    //gateway service /api-calls
    val df = data.toDF("DateTime", "HTTP-METHODS", "GETWAY-SERVICE", "MICROSERVICE").withColumn("DateTime", unix_timestamp(col("DateTime"), "yyyy-MM-dd'T'HH:mm:ss.SSS").cast("timestamp"))

    //calling the window function to calculate aggregate count of API calls made to the gateway service per 5 minute
    val streaming_df1 = df
        .groupBy(col("GETWAY-SERVICE"), window(col("DateTime"), "5 minute"))
        .agg(count("GETWAY-SERVICE") as ("aggregate_count"))
        .select("GETWAY-SERVICE","window", "aggregate_count")
        .show(false)
      
    val streaming_df2 = df
      .groupBy(col("GETWAY-SERVICE"), window(col("DateTime"), "1 minute"))
      .agg(count("GETWAY-SERVICE") as ("aggregate_count"))
      .select("GETWAY-SERVICE", "window","aggregate_count")
      .show(false)

    //calling the window function to calculate aggregate count of HTTP-Methods made to the gateway service per 5 minute
    val streaming_df3 = df
      .groupBy(col("HTTP-METHODS"), window(col("DateTime"), "5 minute"))
      .agg(count("HTTP-METHODS") as ("aggregate_count"))
      .select("HTTP-METHODS","window", "aggregate_count")
      .show(false)
      

    val streaming_df4 = df
      .groupBy(col("HTTP-METHODS"), window(col("DateTime"), "1 minute"))
      .agg(count("HTTP-METHODS") as ("aggregate_count"))
      .select("HTTP-METHODS","window", "aggregate_count")
      .show(false)
  }
}


/*  
 *  System.setProperty("hadoop.home.dir", "C:/hadoop/hadoop_home")
     
     val spark = SparkSession
       .builder
       .appName("Spark-Kafka-Integration")
       .master("local")
       .getOrCreate
       
      val data = spark.read.option("header", "false").csv("C:\kafka\kafka-data\Input\ridecell-data1.txt")
      
      //gateway service /api-calls			   
      val df = data.toDF("DateTime","HTTP-METHODS","GETWAY-SERVICE","MICROSERVICE").withColumn("DateTime", to_timestamp($"DateTime", "yyyy-MM-dd'T'HH:mm:ss.SSS"))
      
      //calling the window function to calculate aggregate count of API calls made to the gateway service per 5 minute
      val streaming_df1 = df .groupBy(col("GETWAY-SERVICE"),window(col("DateTime"), "5 minute")).agg(count("GETWAY-SERVICE") as ( "aggregate_count")).select("GETWAY-SERVICE","aggregate_count")
      	.show()
      	
      val streaming_df2 = df
	      .groupBy(col("GETWAY-SERVICE"),window(col("DateTime"), "1 minute"))
	      .agg(count("GETWAY-SERVICE") as ( "aggregate_count"))
      	.select("GETWAY-SERVICE","aggregate_count")
      	
      //calling the window function to calculate aggregate count of HTTP-Methods made to the gateway service per 5 minute
     val streaming_df3 = df .groupBy(col("HTTP-METHODS"),window(col("DateTime"), "5 minute")).agg(count("HTTP-METHODS") as ( "aggregate_count")).select("HTTP-METHODS","aggregate_count")
	      .show()
	      
	   val streaming_df4 = df
	      .groupBy(col("HTTP-METHODS"),window(col("DateTime"), "1 minute"))
	      .agg(count("HTTP-METHODS") as ( "aggregate_count"))
	
 *  
 *  
 *  */
 