package app.datatypes

import groovy.transform.ToString

@ToString(includes = 'name')
class User {
    def name
    def username
    def email
    def phone
    def website
    Company company = new Company()
    Address address = new Address()
}

class Company {
    def name
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
    def lat
    def lng
}