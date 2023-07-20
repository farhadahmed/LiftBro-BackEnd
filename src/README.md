# Lift Bro (Back-End)

## What it does
Lift Bro is a social networking app for gym goers. Our goal is to promote a healthy lifestyle and 
motivate users to work out. We will do this by creating an app that allows users to find other 
people to work out with based on their workout goals, location, and relative fitness level. This 
microservice contains the API for our front end mobile app (and later website) to interact with
our database.

## How it works
* Accessing the DB
  * Credentials to our MySql DB, hosted via AWS RDS, are stored in AWS Secrets.
  * Secrets are accessed using config/DataSourceConfig.java which uses variables to refer to the
    access key and secret key. These values are stored in application.yml (not visible in GitHub).
* API handles the following tasks
  * CRUD operations for users
  * CRUD operations for workout sessions
  * CRUD operations for workout locations
  * CRUD operations for workout session attendees
    * Updates to attendees are only for changing their admin status for that event.
  * CRD operations for user photos (models/FileData) 
    * We will not have users update photos. If they need to update, they should just delete and
      add a new photo.
    * TODO: At some point this should be changed to "photos" instead of 

## Features to add to API
* Allow users to invite others to attend a session
* Users should be able to search for other users and add them as friends
* Track user workout progress so they can compete with friends
  * Max weight for a given workout
  * Allow them to set a goal for workout days in the week, and track what percent they actually
    met their weekly gym attendance goal

## Requirements
* SDK: Amazon Corretto 17 
* Java 17


## How to run
* The YAML file containing key/secret for AWS Secrets is not available through GitHub. To receive the AWS access key and secret for this app, contact Farhad.
* To run the app, use: ./gradlew bootRun

## Build jar file
* ./gradlew clean build