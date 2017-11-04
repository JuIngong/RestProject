package servicerest

class Library {

    String name
    String adresse
    Integer yearCreated

    static hasMany = [books: Book]

    static constraints = {
        name        blank: false
        adresse     blank: false
        yearCreated nullable: false
    }
}
