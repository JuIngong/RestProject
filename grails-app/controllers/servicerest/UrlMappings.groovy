package servicerest

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view: "/index")
        "500"(view: '/error')
        "/api/library/$id"(controller: "library") {
            action = [GET: "getLibrary", PUT: "editLibrary", DELETE:"delLibrary"]
        }
        "/api/libraries"(controller: "library") {
            action = [GET: "getLibraries"]
        }
        "/api/library"(controller: "library") {
            action = [POST: "addLibrary"]
        }
        "/api/library/$id/books"(controller: "library") {
            action = [GET: "getBooks"]
        }
        "/api/library/$lId/book/$id"(controller: "library") {
            action = [GET: "getBook", PUT: "editBook", DELETE: "delBook"]
        }
        "/api/library/$lId/book"(controller: "library") {
            action = [POST: "addBook"]
        }
        "/api/book/$id"(controller: "book") {
            action = [GET: "getBook", PUT: "editBook", DELETE:"delBook"]
        }
        "/api/books"(controller: "book") {
            action = [GET: "getBooks"]
        }
        "/api/book"(controller: "book") {
            action = [POST: "addBook"]
        }
    }
}
