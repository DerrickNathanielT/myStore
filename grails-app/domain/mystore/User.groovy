package mystore

class User {

    String name
    String email
    String password
    Role role
    String createdBy
    String updatedBy
    Date dateCreated
    Date lastUpdated
    static constraints = {
        name(maxSize: 255, nullable: true)
        createdBy(maxSize: 100, nullable: true)
        updatedBy(maxSize: 100, nullable: true)
        dateCreated(blank: true,nullable: true)
        lastUpdated(blank:true,nullable: true)
    }
}
