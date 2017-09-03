package app.datatypes

import groovy.transform.ToString

//you can predefine default test data instantly in class definition
//if not, then 'null' will be as default

@ToString(includes = 'name')
class User {
    def name = 'Default User'
    def username = 'Default Username'
    def email
    def phone
    def website
    Company company = new Company()
    Address address = new Address()
}

class Company {
    def name = "Company Name"
    def catchPhrase
    def bs
}

class Address {
    def street
    def suite
    def city
    def zipcode
    Geo geo =new Geo()
}

class Geo {
    def lat = "0.0"
    def lng = "0.0"
}

