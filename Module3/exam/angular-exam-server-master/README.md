# Install dependencies
```$ npm install```
# Running server
```$ node app.js```
- The server listens at port 3000
# APIs
#### Book model
    {
        id: 1,
        title: 'Clean Code',
        author: 'Robert C. Martin',
        description: 'Clean Code Book'
    }

#### Getting all books
```GET http://localhost:3000/books```
#### Getting a book by id
```GET http://localhost:3000/books/1```
#### Creating a book
```POST http://localhost:3000/books```
#### Deleting a book by id
```DELETE http://localhost:3000/books/1```
#### Updating a book by id
```PUT http://localhost:3000/books/1```
