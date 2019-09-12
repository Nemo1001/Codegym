const express = require("express");
const app = express();
var cors = require('cors');
app.use(cors());
app.use(express.json());
app.listen(3000, () => {
    console.log("Server running on port 3000");
});

const books = [
    {
        id: 1,
        title: 'Clean Code',
        author: 'Robert C. Martin',
        description: 'Even bad code can function. But if code isn’t clean, it can bring a development organization to its knees. Every year, countless hours and significant resources are lost because of poorly written code. But it doesn’t have to be that way.'
    },
    {
        id: 2,
        title: 'The Pragmatic Programmer',
        author: 'Andrew Hunt',
        description: 'Written as a series of self-contained sections and filled with entertaining anecdotes, thoughtful examples and interesting analogies, The Pragmatic Programmer illustrates the best practices and major pitfalls of many different aspects of software development. Whether you\'re a new coder, an experienced programmer or a manager responsible for software projects, use these lessons daily and you\'ll quickly see improvements in personal productivity, accuracy and job satisfaction. You\'ll learn skills and develop habits and attitudes that form the foundation for long-term success in your career. You\'ll become a Pragmatic Programmer.'
    },
    {
        id: 3,
        title: 'Design Patterns',
        author: 'Erich Gamma',
        description: 'The authors begin by describing what patterns are and how they can help you design object-oriented software. They then go on to systematically name, explain, evaluate and catalog recurring designs in object-oriented systems. With Design Patterns as your guide, you will learn how these important patterns fit into the software development process and how you can leverage them to solve your own design problems most efficiently.'
    }
];

app.get("/books", (req, res, next) => {
    res.json(books);
});
app.get("/books/:id", (req, res, next) => {
    const id = +req.params.id;
    const index = findBookIndex(id);
    if(index !== -1) {
        res.json(books[index]);
    } else {
        res.status(404).json({message: 'Not found'});
    }
});
app.post("/books", (req, res, next) => {
    const book = {
        id: (new Date()).getTime(),
        title: req.body.title,
        author: req.body.author,
        description: req.body.description
    };
    books.push(book);
    res.json(book);
});
app.delete("/books/:id", (req, res, next) => {
    const id = +req.params.id;
    const index = findBookIndex(id);
    if(index !== -1) {
        books.splice(index, 1);
        res.json({message: 'Book deleted', id: id});
    } else {
        res.status(404).json({message: 'Not found'});
    }
});

app.put("/books/:id", (req, res, next) => {
    const id = +req.params.id;
    const index = findBookIndex(id);
    if(index !== -1) {
        const book = books[index];
        book.title = req.body.title;
        book.author = req.body.author;
        book.description = req.body.description;
        res.json(book);
    } else {
        res.status(404).json({message: 'Not found'});
    }
});

function findBookIndex(id) {
    for(let i = 0; i < books.length; i++) {
        if(books[i].id === id) {
            return i;
        }
    }
    return -1;
}
