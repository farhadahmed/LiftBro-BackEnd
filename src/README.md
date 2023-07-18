# Lift Bro (Back-End)

## What it does
Lift Bro is a social networking app for gym goers. This project contains the following functionality:
* Access the MySql DB hosted via AWS RDS
  * This is accessed via config/DataSourceConfig which grabs Secrets stored in AWS Secrets. Environment variables
    are stored in application.yml (not visible through GitHub).
* API handles the following tasks
  * CRUD operations for users
  * CRUD operations for workout sessions
  * CRUD operations for workout locations
  * TO DO: Upload photos to a local URL and retrieve

## Requirements
* SDK: Amazon Corretto 17 
* Java 17


## How to run
* The YAML file containing key/secret for AWS Secrets is not available through GitHub. To receive the AWS access key and secret for this app, contact Farhad.
* To run the app, use: ./gradlew bootRun

## Build jar file
* ./gradlew clean build