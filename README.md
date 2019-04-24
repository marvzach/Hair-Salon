# SOUTH SIDE HAIR SALON
This is a database-supported website that allows salon owners to manage stylists and clients. Users can add, update, delete and assign clients to stylists. Additionally, they can add, update and delete client information.

## Project Setup
* Clone this project at [Hair Salon]https://github.com/marvzach/Hair-Salon)
* On the terminal, navigate to the downloaded project directory and run the following commands to set up the database.
```
$ psql

user=# CREATE DATABASE hair_salon;

user=# \q

$ psql hair_salon < hair_salon.sql 

$ psql

user=# CREATE DATABASE hair_salon_test WITH TEMPLATE hair_salon;

user=# \q

```
* Go to the project directory on the terminal and run `gradle run` 
* Open your website on `localhost:4567` to view the website.

## BDD
* Users are able to add stylists and assign them clients.
* Users able to select a stylist, see their details, and see a list of all clients that belong to that stylist.
* Users can update a stylist's details and delete them.
* Users can update a client's details and delete them.

## Dependencies
1. Java
2. Gradle
3. Postgres

## Technologies Used
1. Java
2. HTML
3. CSS
4. Postgres(psql)
5. Material Design

## Author and Contact Information
Written by [Marvin Zachary](https://github.com/marvzach). Email: acerzach@gmail.com.

## Licence
Licenced under [The MIT Licence](https://github.com/angular/angular.js/blob/master/LICENSE) Copyright(c) 2019 Marvin Zachary.