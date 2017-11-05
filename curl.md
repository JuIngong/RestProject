## Login
`curl -X POST "http://localhost:8081/restproject/api/login" -H "accept: application/json" -H "content-type: application/json" -d '{"username":"user","password":"user"}'`
* Si cela ne fonctionne pas utiliser Postman sur l'url `http://localhost:8081/restproject/api/login` et avec un body raw `{"username":"user","password":"user"}`
* body `{
            "username": "user",
            "roles": [
                "ROLE_USER"
            ],
            "access_token": "eyJhbGciOiJIUzI1NiJ9.eyJwcmluY2lwYWwiOiJINHNJQUFBQUFBQUFBSlZTc1U0Y01SQ2RQUTRCUWtvQUNTUUthQ0JkdENlRjhpcEFCeEphQWVLNEJxUkV2dDFoTVhqdHhmYkNYWU91Z29JQ1JJS0VsRFlsZndKTlBpQWlSVnJxdEJrdkhIdlFvTGl5eDhcL3Z2WG5qbXdmb054cm1ZczI0TUg0cXNwaEwzNlNheTloZ21HbHUyMzVtVUVkb2M4UnlEbXhRQlI2WFZ3SXZnQktQTEl3RmUreVFWUVNUY1dXdHVZZWhyYlkwZkZJNmZtTGMwU3pCSTZYM1wvV2Z1VUdsOElWQlFlejlLTUxBRm95d01WU2J0cXBLMVZzbzFSbHN3VXRRQ0ZlNjcwbmhJTnlndFo4TDBRZ2RRc3FiQUtJQmhsdGxkUmFvY2pZWDNqMll6eTBXbGpyWWF3R0RLakNGM3J6cXBXMmZkM1R1YmtqbzRnR01vdDFLUEZtWDN3VUY5eCtNdktpR29hNjZrbVczSVJFVjhoenR4NHU5TVhmNDhcLzk1cGxBQW9rNDl2dnlucWt3dlF1ZjM4ZHpvUDJnc3RUUFJZTDJEVlZrcHVSZ3ZtVFkxTytkZjErdGVyaDlQdFBsSjJpS1hcL244ZnNcL0ZOeTdVV1ZwRXd6cTNwbVJMUkhaYmNuOG9XM3lidFRhUHQxbnFRQzZVZEppOUd6UkVGTTdaYTFFdDI4TFF4dHJBVzFMNDE2YmNPZHlzNG1hYjdMVzNhejhnTkZrenI3YzNGM1BuTlA3MWVnXC81Q0pEQ254a1FLMG1pVk4xQ2MzVjFQRDMzNmY1ZjY3Zlwva2Y0ZElnSHc4REFBQT0iLCJzdWIiOiJ1c2VyIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImV4cCI6MTUwOTkyMzQ3MCwiaWF0IjoxNTA5OTE5ODcwfQ.s7JED_6CVt-hM1w-7b2V_qm6eC2z3ul0_kniwpQp8CU"
        }`
     * copier le access_token car il sera neccessaire pour toute les autres requetes
# Toujours remplacer le X-Auth-Token par celui générer ci dessus  
## Book
### GET /api/book/{id}
* `curl -X GET "http://localhost:8081/restproject/api/book/1" -H  "accept: application/json" -H  "X-Auth-Token: eyJhbGciOiJIUzI1NiJ9.eyJwcmluY2lwYWwiOiJINHNJQUFBQUFBQUFBSlZTc1U0Y01SQ2RQUTRCUWtvQUNTUUthQ0JkdENlRjhpcEFCeEphQWVLNEJxUkV2dDFoTVhqdHhmYkNYWU91Z29JQ1JJS0VsRFlsZndKTlBpQWlSVnJxdEJrdkhIdlFvTGl5eDhcL3Z2WG5qbXdmb054cm1ZczI0TUg0cXNwaEwzNlNheTloZ21HbHUyMzVtVUVkb2M4UnlEbXhRQlI2WFZ3SXZnQktQTEl3RmUreVFWUVNUY1dXdHVZZWhyYlkwZkZJNmZtTGMwU3pCSTZYM1wvV2Z1VUdsOElWQlFlejlLTUxBRm95d01WU2J0cXBLMVZzbzFSbHN3VXRRQ0ZlNjcwbmhJTnlndFo4TDBRZ2RRc3FiQUtJQmhsdGxkUmFvY2pZWDNqMll6eTBXbGpyWWF3R0RLakNGM3J6cXBXMmZkM1R1YmtqbzRnR01vdDFLUEZtWDN3VUY5eCtNdktpR29hNjZrbVczSVJFVjhoenR4NHU5TVhmNDhcLzk1cGxBQW9rNDl2dnlucWt3dlF1ZjM4ZHpvUDJnc3RUUFJZTDJEVlZrcHVSZ3ZtVFkxTytkZjErdGVyaDlQdFBsSjJpS1hcL244ZnNcL0ZOeTdVV1ZwRXd6cTNwbVJMUkhaYmNuOG9XM3lidFRhUHQxbnFRQzZVZEppOUd6UkVGTTdaYTFFdDI4TFF4dHJBVzFMNDE2YmNPZHlzNG1hYjdMVzNhejhnTkZrenI3YzNGM1BuTlA3MWVnXC81Q0pEQ254a1FLMG1pVk4xQ2MzVjFQRDMzNmY1ZjY3Zlwva2Y0ZElnSHc4REFBQT0iLCJzdWIiOiJ1c2VyIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImV4cCI6MTUwOTkyMTc2OCwiaWF0IjoxNTA5OTE4MTY4fQ.aHWAdIcvg5tstxidilFnYlOLf9Rl7FEIAXLmrTMW3zo"`
    * header ` x-application-context: application:development:8081  content-type: application/json;charset=UTF-8  transfer-encoding: chunked  date: Sun, 05 Nov 2017 21:45:47 GMT `
    * body `{
              "id": 1,
              "library": {
                "id": 1
              },
              "name": "Book 1",
              "releaseDate": "3912-11-16T23:00:00Z",
              "isbn": "978-2-10-063487-0",
              "author": "Jean"
            }` 
### PUT /api/book/{id}
* `curl -X PUT "http://localhost:8081/restproject/api/book/1" -H  "accept: application/json" -H  "X-Auth-Token: eyJhbGciOiJIUzI1NiJ9.eyJwcmluY2lwYWwiOiJINHNJQUFBQUFBQUFBSlZTc1U0Y01SQ2RQUTRCUWtvQUNTUUthQ0JkdENlRjhpcEFCeEphQWVLNEJxUkV2dDFoTVhqdHhmYkNYWU91Z29JQ1JJS0VsRFlsZndKTlBpQWlSVnJxdEJrdkhIdlFvTGl5eDhcL3Z2WG5qbXdmb054cm1ZczI0TUg0cXNwaEwzNlNheTloZ21HbHUyMzVtVUVkb2M4UnlEbXhRQlI2WFZ3SXZnQktQTEl3RmUreVFWUVNUY1dXdHVZZWhyYlkwZkZJNmZtTGMwU3pCSTZYM1wvV2Z1VUdsOElWQlFlejlLTUxBRm95d01WU2J0cXBLMVZzbzFSbHN3VXRRQ0ZlNjcwbmhJTnlndFo4TDBRZ2RRc3FiQUtJQmhsdGxkUmFvY2pZWDNqMll6eTBXbGpyWWF3R0RLakNGM3J6cXBXMmZkM1R1YmtqbzRnR01vdDFLUEZtWDN3VUY5eCtNdktpR29hNjZrbVczSVJFVjhoenR4NHU5TVhmNDhcLzk1cGxBQW9rNDl2dnlucWt3dlF1ZjM4ZHpvUDJnc3RUUFJZTDJEVlZrcHVSZ3ZtVFkxTytkZjErdGVyaDlQdFBsSjJpS1hcL244ZnNcL0ZOeTdVV1ZwRXd6cTNwbVJMUkhaYmNuOG9XM3lidFRhUHQxbnFRQzZVZEppOUd6UkVGTTdaYTFFdDI4TFF4dHJBVzFMNDE2YmNPZHlzNG1hYjdMVzNhejhnTkZrenI3YzNGM1BuTlA3MWVnXC81Q0pEQ254a1FLMG1pVk4xQ2MzVjFQRDMzNmY1ZjY3Zlwva2Y0ZElnSHc4REFBQT0iLCJzdWIiOiJ1c2VyIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImV4cCI6MTUwOTkyMTc2OCwiaWF0IjoxNTA5OTE4MTY4fQ.aHWAdIcvg5tstxidilFnYlOLf9Rl7FEIAXLmrTMW3zo" -H  "content-type: application/x-www-form-urlencoded" -d "name=Blabla"`
    * header ` x-application-context: application:development:8081  content-type: application/json;charset=UTF-8  transfer-encoding: chunked  date: Sun, 05 Nov 2017 21:52:35 GMT `
    * body `{
              "timestamp": 1509918755310,
              "status": 200,
              "error": "OK",
              "message": "Book updated",
              "path": "/restproject/api/book/1"
            }` 
### DELETE /api/book/{id}
* `curl -X DELETE "http://localhost:8081/restproject/api/book/1" -H  "accept: application/json" -H  "X-Auth-Token: eyJhbGciOiJIUzI1NiJ9.eyJwcmluY2lwYWwiOiJINHNJQUFBQUFBQUFBSlZTc1U0Y01SQ2RQUTRCUWtvQUNTUUthQ0JkdENlRjhpcEFCeEphQWVLNEJxUkV2dDFoTVhqdHhmYkNYWU91Z29JQ1JJS0VsRFlsZndKTlBpQWlSVnJxdEJrdkhIdlFvTGl5eDhcL3Z2WG5qbXdmb054cm1ZczI0TUg0cXNwaEwzNlNheTloZ21HbHUyMzVtVUVkb2M4UnlEbXhRQlI2WFZ3SXZnQktQTEl3RmUreVFWUVNUY1dXdHVZZWhyYlkwZkZJNmZtTGMwU3pCSTZYM1wvV2Z1VUdsOElWQlFlejlLTUxBRm95d01WU2J0cXBLMVZzbzFSbHN3VXRRQ0ZlNjcwbmhJTnlndFo4TDBRZ2RRc3FiQUtJQmhsdGxkUmFvY2pZWDNqMll6eTBXbGpyWWF3R0RLakNGM3J6cXBXMmZkM1R1YmtqbzRnR01vdDFLUEZtWDN3VUY5eCtNdktpR29hNjZrbVczSVJFVjhoenR4NHU5TVhmNDhcLzk1cGxBQW9rNDl2dnlucWt3dlF1ZjM4ZHpvUDJnc3RUUFJZTDJEVlZrcHVSZ3ZtVFkxTytkZjErdGVyaDlQdFBsSjJpS1hcL244ZnNcL0ZOeTdVV1ZwRXd6cTNwbVJMUkhaYmNuOG9XM3lidFRhUHQxbnFRQzZVZEppOUd6UkVGTTdaYTFFdDI4TFF4dHJBVzFMNDE2YmNPZHlzNG1hYjdMVzNhejhnTkZrenI3YzNGM1BuTlA3MWVnXC81Q0pEQ254a1FLMG1pVk4xQ2MzVjFQRDMzNmY1ZjY3Zlwva2Y0ZElnSHc4REFBQT0iLCJzdWIiOiJ1c2VyIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImV4cCI6MTUwOTkyMTc2OCwiaWF0IjoxNTA5OTE4MTY4fQ.aHWAdIcvg5tstxidilFnYlOLf9Rl7FEIAXLmrTMW3zo"`
    * header ` x-application-context: application:development:8081  content-type: application/json;charset=UTF-8  transfer-encoding: chunked  date: Sun, 05 Nov 2017 21:56:13 GMT  `
    * body `{
              "timestamp": 1509918973811,
              "status": 200,
              "error": "OK",
              "message": "Book deleted",
              "path": "/restproject/api/book/1"
            }`   
### GET /api/books
* `curl -X GET "http://localhost:8081/restproject/api/books" -H  "accept: application/json" -H  "X-Auth-Token: eyJhbGciOiJIUzI1NiJ9.eyJwcmluY2lwYWwiOiJINHNJQUFBQUFBQUFBSlZTc1U0Y01SQ2RQUTRCUWtvQUNTUUthQ0JkdENlRjhpcEFCeEphQWVLNEJxUkV2dDFoTVhqdHhmYkNYWU91Z29JQ1JJS0VsRFlsZndKTlBpQWlSVnJxdEJrdkhIdlFvTGl5eDhcL3Z2WG5qbXdmb054cm1ZczI0TUg0cXNwaEwzNlNheTloZ21HbHUyMzVtVUVkb2M4UnlEbXhRQlI2WFZ3SXZnQktQTEl3RmUreVFWUVNUY1dXdHVZZWhyYlkwZkZJNmZtTGMwU3pCSTZYM1wvV2Z1VUdsOElWQlFlejlLTUxBRm95d01WU2J0cXBLMVZzbzFSbHN3VXRRQ0ZlNjcwbmhJTnlndFo4TDBRZ2RRc3FiQUtJQmhsdGxkUmFvY2pZWDNqMll6eTBXbGpyWWF3R0RLakNGM3J6cXBXMmZkM1R1YmtqbzRnR01vdDFLUEZtWDN3VUY5eCtNdktpR29hNjZrbVczSVJFVjhoenR4NHU5TVhmNDhcLzk1cGxBQW9rNDl2dnlucWt3dlF1ZjM4ZHpvUDJnc3RUUFJZTDJEVlZrcHVSZ3ZtVFkxTytkZjErdGVyaDlQdFBsSjJpS1hcL244ZnNcL0ZOeTdVV1ZwRXd6cTNwbVJMUkhaYmNuOG9XM3lidFRhUHQxbnFRQzZVZEppOUd6UkVGTTdaYTFFdDI4TFF4dHJBVzFMNDE2YmNPZHlzNG1hYjdMVzNhejhnTkZrenI3YzNGM1BuTlA3MWVnXC81Q0pEQ254a1FLMG1pVk4xQ2MzVjFQRDMzNmY1ZjY3Zlwva2Y0ZElnSHc4REFBQT0iLCJzdWIiOiJ1c2VyIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImV4cCI6MTUwOTkyMTc2OCwiaWF0IjoxNTA5OTE4MTY4fQ.aHWAdIcvg5tstxidilFnYlOLf9Rl7FEIAXLmrTMW3zo"`
    * header `  x-application-context: application:development:8081  content-type: application/json;charset=UTF-8  transfer-encoding: chunked  date: Sun, 05 Nov 2017 21:58:10 GMT  `
    * body `[
              {
                "id": 2,
                "library": {
                  "id": 1
                },
                "name": "Book 2",
                "releaseDate": "3915-09-30T22:00:00Z",
                "isbn": "978-2-10-054387-0",
                "author": "Pierre"
              },
              {
                "id": 3,
                "library": {
                  "id": 1
                },
                "name": "Book 3",
                "releaseDate": "3911-02-23T23:00:00Z",
                "isbn": "978-2-10-059657-0",
                "author": "Robert"
              }, ...
              ]`   
### POST /api/book
* `curl -X POST "http://localhost:8081/restproject/api/book" -H  "accept: application/json" -H  "X-Auth-Token: eyJhbGciOiJIUzI1NiJ9.eyJwcmluY2lwYWwiOiJINHNJQUFBQUFBQUFBSlZTc1U0Y01SQ2RQUTRCUWtvQUNTUUthQ0JkdENlRjhpcEFCeEphQWVLNEJxUkV2dDFoTVhqdHhmYkNYWU91Z29JQ1JJS0VsRFlsZndKTlBpQWlSVnJxdEJrdkhIdlFvTGl5eDhcL3Z2WG5qbXdmb054cm1ZczI0TUg0cXNwaEwzNlNheTloZ21HbHUyMzVtVUVkb2M4UnlEbXhRQlI2WFZ3SXZnQktQTEl3RmUreVFWUVNUY1dXdHVZZWhyYlkwZkZJNmZtTGMwU3pCSTZYM1wvV2Z1VUdsOElWQlFlejlLTUxBRm95d01WU2J0cXBLMVZzbzFSbHN3VXRRQ0ZlNjcwbmhJTnlndFo4TDBRZ2RRc3FiQUtJQmhsdGxkUmFvY2pZWDNqMll6eTBXbGpyWWF3R0RLakNGM3J6cXBXMmZkM1R1YmtqbzRnR01vdDFLUEZtWDN3VUY5eCtNdktpR29hNjZrbVczSVJFVjhoenR4NHU5TVhmNDhcLzk1cGxBQW9rNDl2dnlucWt3dlF1ZjM4ZHpvUDJnc3RUUFJZTDJEVlZrcHVSZ3ZtVFkxTytkZjErdGVyaDlQdFBsSjJpS1hcL244ZnNcL0ZOeTdVV1ZwRXd6cTNwbVJMUkhaYmNuOG9XM3lidFRhUHQxbnFRQzZVZEppOUd6UkVGTTdaYTFFdDI4TFF4dHJBVzFMNDE2YmNPZHlzNG1hYjdMVzNhejhnTkZrenI3YzNGM1BuTlA3MWVnXC81Q0pEQ254a1FLMG1pVk4xQ2MzVjFQRDMzNmY1ZjY3Zlwva2Y0ZElnSHc4REFBQT0iLCJzdWIiOiJ1c2VyIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImV4cCI6MTUwOTkyMTc2OCwiaWF0IjoxNTA5OTE4MTY4fQ.aHWAdIcvg5tstxidilFnYlOLf9Rl7FEIAXLmrTMW3zo" -H  "content-type: application/x-www-form-urlencoded" -d "name=test&releaseDate=3915-09-30T22%3A00%3A00Z&isbn=3131&author=test&library.id=2"`
    * header ` x-application-context: application:development:8081  content-type: application/json;charset=UTF-8  transfer-encoding: chunked  date: Sun, 05 Nov 2017 22:00:34 GMT `
    * body `{
              "timestamp": 1509919234740,
              "status": 201,
              "error": "Created",
              "message": "Book created",
              "path": "/restproject/api/book"
            }`   
## Library
### DELETE /api/library/{id}
* `curl -X DELETE "http://localhost:8081/restproject/api/library/1" -H  "accept: application/json" -H  "X-Auth-Token: eyJhbGciOiJIUzI1NiJ9.eyJwcmluY2lwYWwiOiJINHNJQUFBQUFBQUFBSlZTc1U0Y01SQ2RQUTRCUWtvQUNTUUthQ0JkdENlRjhpcEFCeEphQWVLNEJxUkV2dDFoTVhqdHhmYkNYWU91Z29JQ1JJS0VsRFlsZndKTlBpQWlSVnJxdEJrdkhIdlFvTGl5eDhcL3Z2WG5qbXdmb054cm1ZczI0TUg0cXNwaEwzNlNheTloZ21HbHUyMzVtVUVkb2M4UnlEbXhRQlI2WFZ3SXZnQktQTEl3RmUreVFWUVNUY1dXdHVZZWhyYlkwZkZJNmZtTGMwU3pCSTZYM1wvV2Z1VUdsOElWQlFlejlLTUxBRm95d01WU2J0cXBLMVZzbzFSbHN3VXRRQ0ZlNjcwbmhJTnlndFo4TDBRZ2RRc3FiQUtJQmhsdGxkUmFvY2pZWDNqMll6eTBXbGpyWWF3R0RLakNGM3J6cXBXMmZkM1R1YmtqbzRnR01vdDFLUEZtWDN3VUY5eCtNdktpR29hNjZrbVczSVJFVjhoenR4NHU5TVhmNDhcLzk1cGxBQW9rNDl2dnlucWt3dlF1ZjM4ZHpvUDJnc3RUUFJZTDJEVlZrcHVSZ3ZtVFkxTytkZjErdGVyaDlQdFBsSjJpS1hcL244ZnNcL0ZOeTdVV1ZwRXd6cTNwbVJMUkhaYmNuOG9XM3lidFRhUHQxbnFRQzZVZEppOUd6UkVGTTdaYTFFdDI4TFF4dHJBVzFMNDE2YmNPZHlzNG1hYjdMVzNhejhnTkZrenI3YzNGM1BuTlA3MWVnXC81Q0pEQ254a1FLMG1pVk4xQ2MzVjFQRDMzNmY1ZjY3Zlwva2Y0ZElnSHc4REFBQT0iLCJzdWIiOiJ1c2VyIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImV4cCI6MTUwOTkyMzQ3MCwiaWF0IjoxNTA5OTE5ODcwfQ.s7JED_6CVt-hM1w-7b2V_qm6eC2z3ul0_kniwpQp8CU"`
    * header ` x-application-context: application:development:8081  content-type: application/json;charset=UTF-8  transfer-encoding: chunked  date: Sun, 05 Nov 2017 22:17:15 GMT `
    * body `{
              "timestamp": 1509920235843,
              "status": 200,
              "error": "OK",
              "message": "Library deleted",
              "path": "/restproject/api/library/1"
            }` 
### PUT /api/library/{id}
* `curl -X PUT "http://localhost:8081/restproject/api/library/2" -H  "accept: application/json" -H  "X-Auth-Token: eyJhbGciOiJIUzI1NiJ9.eyJwcmluY2lwYWwiOiJINHNJQUFBQUFBQUFBSlZTc1U0Y01SQ2RQUTRCUWtvQUNTUUthQ0JkdENlRjhpcEFCeEphQWVLNEJxUkV2dDFoTVhqdHhmYkNYWU91Z29JQ1JJS0VsRFlsZndKTlBpQWlSVnJxdEJrdkhIdlFvTGl5eDhcL3Z2WG5qbXdmb054cm1ZczI0TUg0cXNwaEwzNlNheTloZ21HbHUyMzVtVUVkb2M4UnlEbXhRQlI2WFZ3SXZnQktQTEl3RmUreVFWUVNUY1dXdHVZZWhyYlkwZkZJNmZtTGMwU3pCSTZYM1wvV2Z1VUdsOElWQlFlejlLTUxBRm95d01WU2J0cXBLMVZzbzFSbHN3VXRRQ0ZlNjcwbmhJTnlndFo4TDBRZ2RRc3FiQUtJQmhsdGxkUmFvY2pZWDNqMll6eTBXbGpyWWF3R0RLakNGM3J6cXBXMmZkM1R1YmtqbzRnR01vdDFLUEZtWDN3VUY5eCtNdktpR29hNjZrbVczSVJFVjhoenR4NHU5TVhmNDhcLzk1cGxBQW9rNDl2dnlucWt3dlF1ZjM4ZHpvUDJnc3RUUFJZTDJEVlZrcHVSZ3ZtVFkxTytkZjErdGVyaDlQdFBsSjJpS1hcL244ZnNcL0ZOeTdVV1ZwRXd6cTNwbVJMUkhaYmNuOG9XM3lidFRhUHQxbnFRQzZVZEppOUd6UkVGTTdaYTFFdDI4TFF4dHJBVzFMNDE2YmNPZHlzNG1hYjdMVzNhejhnTkZrenI3YzNGM1BuTlA3MWVnXC81Q0pEQ254a1FLMG1pVk4xQ2MzVjFQRDMzNmY1ZjY3Zlwva2Y0ZElnSHc4REFBQT0iLCJzdWIiOiJ1c2VyIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImV4cCI6MTUwOTkyMzQ3MCwiaWF0IjoxNTA5OTE5ODcwfQ.s7JED_6CVt-hM1w-7b2V_qm6eC2z3ul0_kniwpQp8CU" -H  "content-type: application/x-www-form-urlencoded" -d "name=Ballslss&adresse=Plus%20la"`
    * header ` x-application-context: application:development:8081  content-type: application/json;charset=UTF-8  transfer-encoding: chunked  date: Sun, 05 Nov 2017 22:17:42 GMT `
    * body `{
              "timestamp": 1509920262384,
              "status": 200,
              "error": "OK",
              "message": "Library updated",
              "path": "/restproject/api/library/2"
            }` 
### GET /api/library/{id}
* `curl -X GET "http://localhost:8081/restproject/api/library/2" -H  "accept: application/json" -H  "X-Auth-Token: eyJhbGciOiJIUzI1NiJ9.eyJwcmluY2lwYWwiOiJINHNJQUFBQUFBQUFBSlZTc1U0Y01SQ2RQUTRCUWtvQUNTUUthQ0JkdENlRjhpcEFCeEphQWVLNEJxUkV2dDFoTVhqdHhmYkNYWU91Z29JQ1JJS0VsRFlsZndKTlBpQWlSVnJxdEJrdkhIdlFvTGl5eDhcL3Z2WG5qbXdmb054cm1ZczI0TUg0cXNwaEwzNlNheTloZ21HbHUyMzVtVUVkb2M4UnlEbXhRQlI2WFZ3SXZnQktQTEl3RmUreVFWUVNUY1dXdHVZZWhyYlkwZkZJNmZtTGMwU3pCSTZYM1wvV2Z1VUdsOElWQlFlejlLTUxBRm95d01WU2J0cXBLMVZzbzFSbHN3VXRRQ0ZlNjcwbmhJTnlndFo4TDBRZ2RRc3FiQUtJQmhsdGxkUmFvY2pZWDNqMll6eTBXbGpyWWF3R0RLakNGM3J6cXBXMmZkM1R1YmtqbzRnR01vdDFLUEZtWDN3VUY5eCtNdktpR29hNjZrbVczSVJFVjhoenR4NHU5TVhmNDhcLzk1cGxBQW9rNDl2dnlucWt3dlF1ZjM4ZHpvUDJnc3RUUFJZTDJEVlZrcHVSZ3ZtVFkxTytkZjErdGVyaDlQdFBsSjJpS1hcL244ZnNcL0ZOeTdVV1ZwRXd6cTNwbVJMUkhaYmNuOG9XM3lidFRhUHQxbnFRQzZVZEppOUd6UkVGTTdaYTFFdDI4TFF4dHJBVzFMNDE2YmNPZHlzNG1hYjdMVzNhejhnTkZrenI3YzNGM1BuTlA3MWVnXC81Q0pEQ254a1FLMG1pVk4xQ2MzVjFQRDMzNmY1ZjY3Zlwva2Y0ZElnSHc4REFBQT0iLCJzdWIiOiJ1c2VyIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImV4cCI6MTUwOTkyMzQ3MCwiaWF0IjoxNTA5OTE5ODcwfQ.s7JED_6CVt-hM1w-7b2V_qm6eC2z3ul0_kniwpQp8CU"`
    * header ` x-application-context: application:development:8081  content-type: application/json;charset=UTF-8  transfer-encoding: chunked  date: Sun, 05 Nov 2017 22:17:56 GMT `
    * body `{
              "id": 2,
              "books": [
                {
                  "id": 6
                },
                {
                  "id": 7
                },
                {
                  "id": 10
                },
                {
                  "id": 8
                },
                {
                  "id": 9
                },
                {
                  "id": 17
                },
                {
                  "id": 16
                }
              ],
              "name": "Ballslss",
              "yearCreated": 2017,
              "adresse": "Plus la"
            }` 
### POST /api/library
* `curl -X POST "http://localhost:8081/restproject/api/library" -H  "accept: application/json" -H  "X-Auth-Token: eyJhbGciOiJIUzI1NiJ9.eyJwcmluY2lwYWwiOiJINHNJQUFBQUFBQUFBSlZTc1U0Y01SQ2RQUTRCUWtvQUNTUUthQ0JkdENlRjhpcEFCeEphQWVLNEJxUkV2dDFoTVhqdHhmYkNYWU91Z29JQ1JJS0VsRFlsZndKTlBpQWlSVnJxdEJrdkhIdlFvTGl5eDhcL3Z2WG5qbXdmb054cm1ZczI0TUg0cXNwaEwzNlNheTloZ21HbHUyMzVtVUVkb2M4UnlEbXhRQlI2WFZ3SXZnQktQTEl3RmUreVFWUVNUY1dXdHVZZWhyYlkwZkZJNmZtTGMwU3pCSTZYM1wvV2Z1VUdsOElWQlFlejlLTUxBRm95d01WU2J0cXBLMVZzbzFSbHN3VXRRQ0ZlNjcwbmhJTnlndFo4TDBRZ2RRc3FiQUtJQmhsdGxkUmFvY2pZWDNqMll6eTBXbGpyWWF3R0RLakNGM3J6cXBXMmZkM1R1YmtqbzRnR01vdDFLUEZtWDN3VUY5eCtNdktpR29hNjZrbVczSVJFVjhoenR4NHU5TVhmNDhcLzk1cGxBQW9rNDl2dnlucWt3dlF1ZjM4ZHpvUDJnc3RUUFJZTDJEVlZrcHVSZ3ZtVFkxTytkZjErdGVyaDlQdFBsSjJpS1hcL244ZnNcL0ZOeTdVV1ZwRXd6cTNwbVJMUkhaYmNuOG9XM3lidFRhUHQxbnFRQzZVZEppOUd6UkVGTTdaYTFFdDI4TFF4dHJBVzFMNDE2YmNPZHlzNG1hYjdMVzNhejhnTkZrenI3YzNGM1BuTlA3MWVnXC81Q0pEQ254a1FLMG1pVk4xQ2MzVjFQRDMzNmY1ZjY3Zlwva2Y0ZElnSHc4REFBQT0iLCJzdWIiOiJ1c2VyIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImV4cCI6MTUwOTkyMzQ3MCwiaWF0IjoxNTA5OTE5ODcwfQ.s7JED_6CVt-hM1w-7b2V_qm6eC2z3ul0_kniwpQp8CU" -H  "content-type: application/x-www-form-urlencoded" -d "name=Boum&adresse=Ici&yearCreated=1992"`
    * header ` x-application-context: application:development:8081  content-type: application/json;charset=UTF-8  transfer-encoding: chunked  date: Sun, 05 Nov 2017 22:18:20 GMT `
    * body `{
              "timestamp": 1509920300750,
              "status": 201,
              "error": "Created",
              "message": "Library created",
              "path": "/restproject/api/library"
            }` 
### GET /api/libraries
* `curl -X GET "http://localhost:8081/restproject/api/libraries" -H  "accept: application/json" -H  "X-Auth-Token: eyJhbGciOiJIUzI1NiJ9.eyJwcmluY2lwYWwiOiJINHNJQUFBQUFBQUFBSlZTc1U0Y01SQ2RQUTRCUWtvQUNTUUthQ0JkdENlRjhpcEFCeEphQWVLNEJxUkV2dDFoTVhqdHhmYkNYWU91Z29JQ1JJS0VsRFlsZndKTlBpQWlSVnJxdEJrdkhIdlFvTGl5eDhcL3Z2WG5qbXdmb054cm1ZczI0TUg0cXNwaEwzNlNheTloZ21HbHUyMzVtVUVkb2M4UnlEbXhRQlI2WFZ3SXZnQktQTEl3RmUreVFWUVNUY1dXdHVZZWhyYlkwZkZJNmZtTGMwU3pCSTZYM1wvV2Z1VUdsOElWQlFlejlLTUxBRm95d01WU2J0cXBLMVZzbzFSbHN3VXRRQ0ZlNjcwbmhJTnlndFo4TDBRZ2RRc3FiQUtJQmhsdGxkUmFvY2pZWDNqMll6eTBXbGpyWWF3R0RLakNGM3J6cXBXMmZkM1R1YmtqbzRnR01vdDFLUEZtWDN3VUY5eCtNdktpR29hNjZrbVczSVJFVjhoenR4NHU5TVhmNDhcLzk1cGxBQW9rNDl2dnlucWt3dlF1ZjM4ZHpvUDJnc3RUUFJZTDJEVlZrcHVSZ3ZtVFkxTytkZjErdGVyaDlQdFBsSjJpS1hcL244ZnNcL0ZOeTdVV1ZwRXd6cTNwbVJMUkhaYmNuOG9XM3lidFRhUHQxbnFRQzZVZEppOUd6UkVGTTdaYTFFdDI4TFF4dHJBVzFMNDE2YmNPZHlzNG1hYjdMVzNhejhnTkZrenI3YzNGM1BuTlA3MWVnXC81Q0pEQ254a1FLMG1pVk4xQ2MzVjFQRDMzNmY1ZjY3Zlwva2Y0ZElnSHc4REFBQT0iLCJzdWIiOiJ1c2VyIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImV4cCI6MTUwOTkyMzQ3MCwiaWF0IjoxNTA5OTE5ODcwfQ.s7JED_6CVt-hM1w-7b2V_qm6eC2z3ul0_kniwpQp8CU"`
    * header ` x-application-context: application:development:8081  content-type: application/json;charset=UTF-8  transfer-encoding: chunked  date: Sun, 05 Nov 2017 22:18:35 GMT `
    * body `[
              {
                "id": 2,
                "books": [
                  {
                    "id": 8
                  },
                  {
                    "id": 17
                  },
                  {
                    "id": 6
                  },
                  {
                    "id": 7
                  },
                  {
                    "id": 16
                  },
                  {
                    "id": 9
                  },
                  {
                    "id": 10
                  }
                ],
                "name": "Ballslss",
                "yearCreated": 2017,
                "adresse": "Plus la"
              },
              {
                "id": 3,
                "books": [
                  {
                    "id": 13
                  },
                  {
                    "id": 14
                  },
                  {
                    "id": 11
                  },
                  {
                    "id": 12
                  },
                  {
                    "id": 15
                  }
                ],
                "name": "Lib 3",
                "yearCreated": 2017,
                "adresse": "Ici"
              },
              {
                "id": 4,
                "books": [],
                "name": "Boum",
                "yearCreated": 1992,
                "adresse": "Ici"
              }
            ]` 
### POST /api/library/{id}/book
* `curl -X POST "http://localhost:8081/restproject/api/library/3/book" -H  "accept: application/json" -H  "X-Auth-Token: eyJhbGciOiJIUzI1NiJ9.eyJwcmluY2lwYWwiOiJINHNJQUFBQUFBQUFBSlZTc1U0Y01SQ2RQUTRCUWtvQUNTUUthQ0JkdENlRjhpcEFCeEphQWVLNEJxUkV2dDFoTVhqdHhmYkNYWU91Z29JQ1JJS0VsRFlsZndKTlBpQWlSVnJxdEJrdkhIdlFvTGl5eDhcL3Z2WG5qbXdmb054cm1ZczI0TUg0cXNwaEwzNlNheTloZ21HbHUyMzVtVUVkb2M4UnlEbXhRQlI2WFZ3SXZnQktQTEl3RmUreVFWUVNUY1dXdHVZZWhyYlkwZkZJNmZtTGMwU3pCSTZYM1wvV2Z1VUdsOElWQlFlejlLTUxBRm95d01WU2J0cXBLMVZzbzFSbHN3VXRRQ0ZlNjcwbmhJTnlndFo4TDBRZ2RRc3FiQUtJQmhsdGxkUmFvY2pZWDNqMll6eTBXbGpyWWF3R0RLakNGM3J6cXBXMmZkM1R1YmtqbzRnR01vdDFLUEZtWDN3VUY5eCtNdktpR29hNjZrbVczSVJFVjhoenR4NHU5TVhmNDhcLzk1cGxBQW9rNDl2dnlucWt3dlF1ZjM4ZHpvUDJnc3RUUFJZTDJEVlZrcHVSZ3ZtVFkxTytkZjErdGVyaDlQdFBsSjJpS1hcL244ZnNcL0ZOeTdVV1ZwRXd6cTNwbVJMUkhaYmNuOG9XM3lidFRhUHQxbnFRQzZVZEppOUd6UkVGTTdaYTFFdDI4TFF4dHJBVzFMNDE2YmNPZHlzNG1hYjdMVzNhejhnTkZrenI3YzNGM1BuTlA3MWVnXC81Q0pEQ254a1FLMG1pVk4xQ2MzVjFQRDMzNmY1ZjY3Zlwva2Y0ZElnSHc4REFBQT0iLCJzdWIiOiJ1c2VyIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImV4cCI6MTUwOTkyMzQ3MCwiaWF0IjoxNTA5OTE5ODcwfQ.s7JED_6CVt-hM1w-7b2V_qm6eC2z3ul0_kniwpQp8CU" -H  "content-type: application/x-www-form-urlencoded" -d "name=Boia&releaseDate=3912-11-16T23%3A00%3A00Z&isbn=P2O323232&author=moi"`
    * header ` x-application-context: application:development:8081  content-type: application/json;charset=UTF-8  transfer-encoding: chunked  date: Sun, 05 Nov 2017 22:26:45 GMT `
    * body `{
              "timestamp": 1509920805686,
              "status": 201,
              "error": "Created",
              "message": "Book created",
              "path": "/restproject/api/library/3/book"
            }` 
### GET /api/library/{id}/books
* `curl -X GET "http://localhost:8081/restproject/api/library/3/books" -H  "accept: application/json" -H  "X-Auth-Token: eyJhbGciOiJIUzI1NiJ9.eyJwcmluY2lwYWwiOiJINHNJQUFBQUFBQUFBSlZTc1U0Y01SQ2RQUTRCUWtvQUNTUUthQ0JkdENlRjhpcEFCeEphQWVLNEJxUkV2dDFoTVhqdHhmYkNYWU91Z29JQ1JJS0VsRFlsZndKTlBpQWlSVnJxdEJrdkhIdlFvTGl5eDhcL3Z2WG5qbXdmb054cm1ZczI0TUg0cXNwaEwzNlNheTloZ21HbHUyMzVtVUVkb2M4UnlEbXhRQlI2WFZ3SXZnQktQTEl3RmUreVFWUVNUY1dXdHVZZWhyYlkwZkZJNmZtTGMwU3pCSTZYM1wvV2Z1VUdsOElWQlFlejlLTUxBRm95d01WU2J0cXBLMVZzbzFSbHN3VXRRQ0ZlNjcwbmhJTnlndFo4TDBRZ2RRc3FiQUtJQmhsdGxkUmFvY2pZWDNqMll6eTBXbGpyWWF3R0RLakNGM3J6cXBXMmZkM1R1YmtqbzRnR01vdDFLUEZtWDN3VUY5eCtNdktpR29hNjZrbVczSVJFVjhoenR4NHU5TVhmNDhcLzk1cGxBQW9rNDl2dnlucWt3dlF1ZjM4ZHpvUDJnc3RUUFJZTDJEVlZrcHVSZ3ZtVFkxTytkZjErdGVyaDlQdFBsSjJpS1hcL244ZnNcL0ZOeTdVV1ZwRXd6cTNwbVJMUkhaYmNuOG9XM3lidFRhUHQxbnFRQzZVZEppOUd6UkVGTTdaYTFFdDI4TFF4dHJBVzFMNDE2YmNPZHlzNG1hYjdMVzNhejhnTkZrenI3YzNGM1BuTlA3MWVnXC81Q0pEQ254a1FLMG1pVk4xQ2MzVjFQRDMzNmY1ZjY3Zlwva2Y0ZElnSHc4REFBQT0iLCJzdWIiOiJ1c2VyIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImV4cCI6MTUwOTkyMzQ3MCwiaWF0IjoxNTA5OTE5ODcwfQ.s7JED_6CVt-hM1w-7b2V_qm6eC2z3ul0_kniwpQp8CU"`
    * header ` x-application-context: application:development:8081  content-type: application/json;charset=UTF-8  transfer-encoding: chunked  date: Sun, 05 Nov 2017 22:27:02 GMT `
    * body `[
              {
                "id": 13,
                "library": {
                  "id": 3
                },
                "name": "Book 3",
                "releaseDate": "3911-02-23T23:00:00Z",
                "isbn": "978-2-10-059657-0",
                "author": "Robert"
              },
              {
                "id": 18,
                "library": {
                  "id": 3
                },
                "name": "Boia",
                "releaseDate": "3912-11-16T22:00:00Z",
                "isbn": "P2O323232",
                "author": "moi"
              },
              {
                "id": 12,
                "library": {
                  "id": 3
                },
                "name": "Book 2",
                "releaseDate": "3915-09-30T22:00:00Z",
                "isbn": "978-2-10-054387-0",
                "author": "Pierre"
              }, ...
            ]` 
### DELETE /api/library/{lId}/book/{id}
* `curl -X DELETE "http://localhost:8081/restproject/api/library/3/book/13" -H  "accept: application/json" -H  "X-Auth-Token: eyJhbGciOiJIUzI1NiJ9.eyJwcmluY2lwYWwiOiJINHNJQUFBQUFBQUFBSlZTc1U0Y01SQ2RQUTRCUWtvQUNTUUthQ0JkdENlRjhpcEFCeEphQWVLNEJxUkV2dDFoTVhqdHhmYkNYWU91Z29JQ1JJS0VsRFlsZndKTlBpQWlSVnJxdEJrdkhIdlFvTGl5eDhcL3Z2WG5qbXdmb054cm1ZczI0TUg0cXNwaEwzNlNheTloZ21HbHUyMzVtVUVkb2M4UnlEbXhRQlI2WFZ3SXZnQktQTEl3RmUreVFWUVNUY1dXdHVZZWhyYlkwZkZJNmZtTGMwU3pCSTZYM1wvV2Z1VUdsOElWQlFlejlLTUxBRm95d01WU2J0cXBLMVZzbzFSbHN3VXRRQ0ZlNjcwbmhJTnlndFo4TDBRZ2RRc3FiQUtJQmhsdGxkUmFvY2pZWDNqMll6eTBXbGpyWWF3R0RLakNGM3J6cXBXMmZkM1R1YmtqbzRnR01vdDFLUEZtWDN3VUY5eCtNdktpR29hNjZrbVczSVJFVjhoenR4NHU5TVhmNDhcLzk1cGxBQW9rNDl2dnlucWt3dlF1ZjM4ZHpvUDJnc3RUUFJZTDJEVlZrcHVSZ3ZtVFkxTytkZjErdGVyaDlQdFBsSjJpS1hcL244ZnNcL0ZOeTdVV1ZwRXd6cTNwbVJMUkhaYmNuOG9XM3lidFRhUHQxbnFRQzZVZEppOUd6UkVGTTdaYTFFdDI4TFF4dHJBVzFMNDE2YmNPZHlzNG1hYjdMVzNhejhnTkZrenI3YzNGM1BuTlA3MWVnXC81Q0pEQ254a1FLMG1pVk4xQ2MzVjFQRDMzNmY1ZjY3Zlwva2Y0ZElnSHc4REFBQT0iLCJzdWIiOiJ1c2VyIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImV4cCI6MTUwOTkyMzQ3MCwiaWF0IjoxNTA5OTE5ODcwfQ.s7JED_6CVt-hM1w-7b2V_qm6eC2z3ul0_kniwpQp8CU"`
    * header `x-application-context: application:development:8081  content-type: application/json;charset=UTF-8  transfer-encoding: chunked  date: Sun, 05 Nov 2017 22:27:34 GMT `
    * body `{
              "timestamp": 1509920854514,
              "status": 200,
              "error": "OK",
              "message": "Book deleted",
              "path": "/restproject/api/library/3/book/13"
            }` 
### GET /api/library/{lId}/book/{id}
* `curl -X GET "http://localhost:8081/restproject/api/library/3/book/12" -H  "accept: application/json" -H  "X-Auth-Token: eyJhbGciOiJIUzI1NiJ9.eyJwcmluY2lwYWwiOiJINHNJQUFBQUFBQUFBSlZTc1U0Y01SQ2RQUTRCUWtvQUNTUUthQ0JkdENlRjhpcEFCeEphQWVLNEJxUkV2dDFoTVhqdHhmYkNYWU91Z29JQ1JJS0VsRFlsZndKTlBpQWlSVnJxdEJrdkhIdlFvTGl5eDhcL3Z2WG5qbXdmb054cm1ZczI0TUg0cXNwaEwzNlNheTloZ21HbHUyMzVtVUVkb2M4UnlEbXhRQlI2WFZ3SXZnQktQTEl3RmUreVFWUVNUY1dXdHVZZWhyYlkwZkZJNmZtTGMwU3pCSTZYM1wvV2Z1VUdsOElWQlFlejlLTUxBRm95d01WU2J0cXBLMVZzbzFSbHN3VXRRQ0ZlNjcwbmhJTnlndFo4TDBRZ2RRc3FiQUtJQmhsdGxkUmFvY2pZWDNqMll6eTBXbGpyWWF3R0RLakNGM3J6cXBXMmZkM1R1YmtqbzRnR01vdDFLUEZtWDN3VUY5eCtNdktpR29hNjZrbVczSVJFVjhoenR4NHU5TVhmNDhcLzk1cGxBQW9rNDl2dnlucWt3dlF1ZjM4ZHpvUDJnc3RUUFJZTDJEVlZrcHVSZ3ZtVFkxTytkZjErdGVyaDlQdFBsSjJpS1hcL244ZnNcL0ZOeTdVV1ZwRXd6cTNwbVJMUkhaYmNuOG9XM3lidFRhUHQxbnFRQzZVZEppOUd6UkVGTTdaYTFFdDI4TFF4dHJBVzFMNDE2YmNPZHlzNG1hYjdMVzNhejhnTkZrenI3YzNGM1BuTlA3MWVnXC81Q0pEQ254a1FLMG1pVk4xQ2MzVjFQRDMzNmY1ZjY3Zlwva2Y0ZElnSHc4REFBQT0iLCJzdWIiOiJ1c2VyIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImV4cCI6MTUwOTkyMzQ3MCwiaWF0IjoxNTA5OTE5ODcwfQ.s7JED_6CVt-hM1w-7b2V_qm6eC2z3ul0_kniwpQp8CU"`
    * header ` x-application-context: application:development:8081  content-type: application/json;charset=UTF-8  transfer-encoding: chunked  date: Sun, 05 Nov 2017 22:36:22 GMT `
    * body `{
              "id": 12,
              "library": {
                "id": 3
              },
              "name": "Book 2",
              "releaseDate": "3915-09-30T22:00:00Z",
              "isbn": "978-2-10-054387-0",
              "author": "Pierre"
            }` 
### PUT /api/library/{lId}/book/{id}
* `curl -X PUT "http://localhost:8081/restproject/api/library/3/book/8" -H  "accept: application/json" -H  "X-Auth-Token: eyJhbGciOiJIUzI1NiJ9.eyJwcmluY2lwYWwiOiJINHNJQUFBQUFBQUFBSlZTc1U0Y01SQ2RQUTRCUWtvQUNTUUthQ0JkdENlRjhpcEFCeEphQWVLNEJxUkV2dDFoTVhqdHhmYkNYWU91Z29JQ1JJS0VsRFlsZndKTlBpQWlSVnJxdEJrdkhIdlFvTGl5eDhcL3Z2WG5qbXdmb054cm1ZczI0TUg0cXNwaEwzNlNheTloZ21HbHUyMzVtVUVkb2M4UnlEbXhRQlI2WFZ3SXZnQktQTEl3RmUreVFWUVNUY1dXdHVZZWhyYlkwZkZJNmZtTGMwU3pCSTZYM1wvV2Z1VUdsOElWQlFlejlLTUxBRm95d01WU2J0cXBLMVZzbzFSbHN3VXRRQ0ZlNjcwbmhJTnlndFo4TDBRZ2RRc3FiQUtJQmhsdGxkUmFvY2pZWDNqMll6eTBXbGpyWWF3R0RLakNGM3J6cXBXMmZkM1R1YmtqbzRnR01vdDFLUEZtWDN3VUY5eCtNdktpR29hNjZrbVczSVJFVjhoenR4NHU5TVhmNDhcLzk1cGxBQW9rNDl2dnlucWt3dlF1ZjM4ZHpvUDJnc3RUUFJZTDJEVlZrcHVSZ3ZtVFkxTytkZjErdGVyaDlQdFBsSjJpS1hcL244ZnNcL0ZOeTdVV1ZwRXd6cTNwbVJMUkhaYmNuOG9XM3lidFRhUHQxbnFRQzZVZEppOUd6UkVGTTdaYTFFdDI4TFF4dHJBVzFMNDE2YmNPZHlzNG1hYjdMVzNhejhnTkZrenI3YzNGM1BuTlA3MWVnXC81Q0pEQ254a1FLMG1pVk4xQ2MzVjFQRDMzNmY1ZjY3Zlwva2Y0ZElnSHc4REFBQT0iLCJzdWIiOiJ1c2VyIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImV4cCI6MTUwOTkyMzQ3MCwiaWF0IjoxNTA5OTE5ODcwfQ.s7JED_6CVt-hM1w-7b2V_qm6eC2z3ul0_kniwpQp8CU" -H  "content-type: application/x-www-form-urlencoded" -d "name=move"`
    * header ` x-application-context: application:development:8081  content-type: application/json;charset=UTF-8  transfer-encoding: chunked  date: Sun, 05 Nov 2017 22:45:35 GMT `
    * body `{
              "timestamp": 1509921935311,
              "status": 200,
              "error": "OK",
              "message": "Book updated",
              "path": "/restproject/api/library/3/book/8"
            }` 
