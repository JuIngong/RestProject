package servicerest

class BootStrap {

    def init = { servletContext ->

        if (Library.count == 0) {
            (1..3).each {
                new Library(name: "Lib "+it, adresse: "Ici", yearCreated: 2017)
                        .addToBooks(new Book(name: "Book 1", author: "Jean", isbn: "978-2-10-063487-0", releaseDate: new Date(2012, 10, 17)))
                        .addToBooks(new Book(name: "Book 2", author: "Pierre", isbn: "978-2-10-054387-0", releaseDate: new Date(2015, 9, 1)))
                        .addToBooks(new Book(name: "Book 3", author: "Robert", isbn: "978-2-10-059657-0", releaseDate: new Date(2011, 1, 24)))
                        .addToBooks(new Book(name: "Book 4", author: "Jacques", isbn: "978-2-10-053287-0", releaseDate: new Date(2000, 5, 20)))
                        .addToBooks(new Book(name: "Book 5", author: "Paul", isbn: "978-2-10-059017-0", releaseDate: new Date(2010, 11, 11)))
                        .save(flush: true, failOnError: true)
            }
        }
    }
    def destroy = {
    }
}
