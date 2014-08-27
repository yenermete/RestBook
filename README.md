RestBook
========
This project is done with Jersey 2.11, Jackson 2.4.0, JAX-RS 2.0, PostgreSQL 9.3, Spring 4.0.5 with Spring jdbcTemplate and Java 1.8. I made my tests with SoapUi, but any rest testing client can be used.

The proejct is about a simple database where there is just one table, namely REST.BOOK. The table has an id column as primary key, and a json column holding details of the book. A few sample books can be inserted with the script at com.rest.db.scripts.sql. It can be used to create the table and the sequence too. The following ways can be used to make various tests.

/services/rest/books/get/book/title?name=Dune
/services/rest/books/get/book/title?name=The%20silMarillion
/services/rest/books/get/book/1
/services/rest/books/insert/book with the following json {"title":"Dune", "publishDate":652191558923, "isbn10":"0441172717", "isbn13":"978-0441172719"}

I tried Spring's JDBCTemplate in this project for transaction handling. While it's a great extension for JDBC, I would still use the way I did in the movies project for all database access.

I used JodaTime for date fields just to show the capabilities of Jackson with its JodaModule. There are some parts which can be changed according to the needs. This is just a starter.

