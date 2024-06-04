# Lab - Single Origin Chocolate

Now you can have some practise annotating and building routes for your own API!

Take some time to have a look at the start code and familiarise yourself with what it there.

`chocolate_start_point` contains partial code for an API which records single origin chocolates and links them to the estates their cocoa came from. The relationship is One to Many.

## MVP: INDEX routes for chocolates and estates

- Using Hibernate + JPA annotations, annotate the `Chocolate` and `Estate` models to define how the classes are mapped to the database. Remember this is a One-To-Many relationship.

- Read `application.properties` and create a database locally with the correct name. (in Terminal: `createdb <database_name>`).

- Create a package called `services` and two classes: `ChocolateService` and `EstateService`. Use these classes to create methods to handle saving `Chocolate` and `Estate` objects to the database. This is your service layer and will handle all interactions with the repositories.

- Create a `Dataloader` to seed the database and run your application to check all is working. You may wish to connect to Postico to view the tables in your database. You should see a table for `estates` and `chocolates`.

- Create a package for your controllers. Create a `ChocolateController` and an `Estate Controller`. Annotate them correctly and create a `GET` request in each to display all chocolates and all estates on routes `localhost:8080/chocolates` and `localhost:8080/estates` respectively.

## Extensions: SHOW & POST routes

- Create a `Show` route to display an indiviual `Chocolate` and `Estate`.

- Create a simple derived query to list all Chocolate with 60% (you can choose the number) or higher cocoa content. You should create a test to ensure this query works. 
> Tip: you should write the derived query in the `ChocolateRespository`, but call the derived query in `ChocolateService` (just as you have done with your other methods).

- Connect this query to your controller. You will need to consider how to merge both `GET /chocolates` and `GET /chocolates?cocoaPercentage=60` into the one controller.

- Create a `Post` route that allows you to create a new `Chocolate` and `Estate` and save them to the database. Use Postman to check these routes work.

> Tip: you will need to create a `ChocolateDTO` class to handle the post request. This is because the request body that accompanies your post request will likely look something like this:

```JSON
    {
    "name" : "Bounty",
    "cocoaPercentage" : 30,
    "estateId" : 1
    }
```
Saving a chocolate will include finding the right estate first before creating a new `Chocolate` object.

